package com.boxuanjia.autobet.Utils;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import com.boxuanjia.autobet.LaunchActivity;
import com.boxuanjia.autobet.LoginActivity;
import com.boxuanjia.autobet.R;
import com.boxuanjia.autobet.model.update.ApkItem;
import com.boxuanjia.autobet.model.user.AccountInfo;
import com.boxuanjia.autobet.model.user.UserManager;
import com.boxuanjia.autobet.service.GaoService;
import com.boxuanjia.autobet.service.ServiceManager;

import java.io.File;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.os.Environment.DIRECTORY_DOWNLOADS;


/**
 * Created by slomka.jin on 2016/11/24.
 */

public class CheckVersionActivity extends AppCompatActivity {
    private static final String KEY_DOWNLOAD_ID="download_id";
    private SharedPreferences sharedPreferences;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case ExtrackZipTask.UNZIPDONE:
                    String fileName=msg.getData().getString("file");
                    install(fileName);
                    break;
                case ExtrackZipTask.UNZIPPERCENT:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_version);
        sharedPreferences=getSharedPreferences("bet_setting",MODE_PRIVATE);
        getUserInfo();
    }

    private void install(String fileName){
        MimeTypeMap map = MimeTypeMap.getSingleton();
        String ext = MimeTypeMap.getFileExtensionFromUrl((fileName));
        String type = map.getMimeTypeFromExtension(ext);

        Intent install = new Intent(Intent.ACTION_VIEW);
        //Log.d(TAG, "openFile Trying to open file: " + Uri.fromFile(new File(fileName)));
        install.setDataAndType(Uri.fromFile(new File(fileName)), type);
        try {
            startActivity(install);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    private void getUserInfo() {
        Call<AccountInfo> call= ServiceManager.instance().getApi().getUserInfo("1");
        call.enqueue(new Callback<AccountInfo>() {
            @Override
            public void onResponse(Call<AccountInfo> call, Response<AccountInfo> response) {
                UserManager.instance().setAccountInfo(response.body());
                checkVersion();
            }

            @Override
            public void onFailure(Call<AccountInfo> call, Throwable t) {

            }
        });
    }
    private void checkVersion(){
        int lastVersion=Integer.valueOf(UserManager.instance().getAccountInfo().data.appVersion);
        Log.w("checkv",lastVersion+" "+getVersionCode());
        if(getVersionCode()<lastVersion){
            getApkPath();
        }
        else{
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
    private void downloadZipFile(String path){
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(path));
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setTitle(getString(R.string.download_title));
        request.setDescription(getString(R.string.zip_downloading));
        request.setAllowedOverRoaming(false);
        request.setDestinationInExternalFilesDir(this, DIRECTORY_DOWNLOADS, "autobet_update.zip");
        DownloadManager downManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
        long id= downManager.enqueue(request);
        saveTaskId(id);
    }
    private void saveTaskId(long id){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putLong(KEY_DOWNLOAD_ID,id);
        editor.commit();
    }
    BroadcastReceiver downloadReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, 0));
            DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
            Cursor cursor = manager.query(query);
            if (cursor.moveToFirst()) {
                if (cursor.getCount() > 0) {
                    int status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS));
                    if (status == DownloadManager.STATUS_SUCCESSFUL) {
                        String file = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
                        // So something here on success
                        Uri uri=Uri.parse(file);

                        String folder= CheckVersionActivity.this.getExternalFilesDir(DIRECTORY_DOWNLOADS).getAbsolutePath()+ File.separator;

                        new ExtrackZipTask(uri.getPath(),folder,handler).start();
                    } else {
                        int message = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_REASON));
                        // So something here on failed.
                        showDownloadError();
                    }
                }
            }
        }
    };

    private void showDownloadError() {
        Toast.makeText(this,"download apk error occured",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(downloadReceiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter=new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
        registerReceiver(downloadReceiver,intentFilter);
    }

    private void getApkPath() {
        Call<ApkItem> call=ServiceManager.instance().getApi().getApkInfo();
        call.enqueue(new Callback<ApkItem>() {
            @Override
            public void onResponse(Call<ApkItem> call, Response<ApkItem> response) {
                Log.d("apk",response.body().data.path+"");
                downloadZipFile(response.body().data.path);
            }

            @Override
            public void onFailure(Call<ApkItem> call, Throwable t) {

            }
        });
    }
    public int getVersionCode(){
        PackageInfo packageInfo = null;
        int versionCode=0;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            String versionName = packageInfo.versionName;
             versionCode= packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }
}
