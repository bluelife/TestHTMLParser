package com.boxuanjia.autobet.Utils;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by slomka.jin on 2016/11/24.
 */

public class ExtrackZipTask extends Thread{
    private String zipFile;
    private int percent=0;
    private int progress=0;
    private int total=0;
    private Handler handler;
    private String zipFolder;
    public static final int UNZIPPERCENT=2;
    public static final int UNZIPDONE=3;
    static final int BUFFER = 4096;
    public ExtrackZipTask(String file,String zipPath, Handler handler){
        zipFile=file;
        zipFolder=zipPath;
        this.handler=handler;
    }
    private void count(){
        percent++;
        progress=100*percent/total;
        Message msg = Message.obtain();
        msg.what = UNZIPPERCENT;
        msg.getData()
                .putInt("size", progress);
        handler.sendMessage(msg);
    }
    @Override
    public void run() {
        try {
            Log.w("unzip",zipFile);
            InputStream is=new FileInputStream(zipFile);
            java.util.zip.ZipFile zipFile1=new java.util.zip.ZipFile(zipFile);
            total=zipFile1.size();

            BufferedOutputStream dest = null;
            //String unzipLocation = Environment.getEnvironment.DIRECTORY_DOWNLOADS;
            ZipInputStream zis = new ZipInputStream(new BufferedInputStream(is));
            ZipEntry entry;
            String fileName=null;
            while ((entry = zis.getNextEntry()) != null) {

                File file = new File(zipFolder + entry.getName());
                Log.w("path",zipFolder+entry.getName());

                if(fileName==null){
                    fileName=file.getAbsolutePath();
                }
                Log.w("ssss",entry.getName());
                if (entry.isDirectory()) {
                    if (!file.exists())
                        file.mkdirs();

                    count();
                    continue;
                }

                int count;
                byte data[] = new byte[BUFFER];

                FileOutputStream fos = new FileOutputStream(file);
                dest = new BufferedOutputStream(fos, BUFFER);
                while ((count = zis.read(data, 0, BUFFER)) != -1) {
                    dest.write(data, 0, count);
                }
                count();
                dest.flush();
                dest.close();
            }
            zis.close();
            Message msg = Message.obtain();
            msg.what = UNZIPDONE;
            msg.getData()
                    .putString("file", fileName);
            handler.sendMessage(msg);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            Log.w("unzip",e);

        }
    }
}
