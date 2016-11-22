package com.boxuanjia.autobet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.boxuanjia.autobet.model.login.LoginItem;
import com.boxuanjia.autobet.model.login.ResultItem;
import com.boxuanjia.autobet.model.update.ApkItem;
import com.boxuanjia.autobet.model.user.AccountInfo;
import com.boxuanjia.autobet.model.user.Balance;
import com.boxuanjia.autobet.model.user.BetSetting;
import com.boxuanjia.autobet.model.user.PurchaseItem;
import com.boxuanjia.autobet.model.user.Record;
import com.boxuanjia.autobet.model.user.RecordSend;
import com.boxuanjia.autobet.model.user.StateItem;
import com.boxuanjia.autobet.service.GaoService;
import com.boxuanjia.autobet.service.ServiceManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by slomka.jin on 2016/11/22.
 */

public class TestActivity extends AppCompatActivity {

    private GaoService gaoService;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_act);
        Button loginBtn=(Button)findViewById(R.id.loginBtn);
        Button apkBtn=(Button)findViewById(R.id.getZipBtn);
        Button runBtn=(Button)findViewById(R.id.runBtn);
        runBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPurchase();
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });
        apkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getApkPath();
            }
        });
        gaoService=ServiceManager.instance().getApi();
    }

    private void setPurchase(){
        PurchaseItem purchaseItem=new PurchaseItem();
        purchaseItem.count=600.09f;
        Call<Record> call=gaoService.setPurchase("1",purchaseItem);
        call.enqueue(new Callback<Record>() {
            @Override
            public void onResponse(Call<Record> call, Response<Record> response) {
                Log.d("purchase",response.body().data.saved+"");
            }

            @Override
            public void onFailure(Call<Record> call, Throwable t) {

            }
        });
    }
    private void setBalance(){
        Balance balance=new Balance();
        balance.count=300;
        Call<Record> call=gaoService.setBalance("1",balance);
        call.enqueue(new Callback<Record>() {
            @Override
            public void onResponse(Call<Record> call, Response<Record> response) {
                Log.d("setbalance",response.body().data.saved+"");
            }

            @Override
            public void onFailure(Call<Record> call, Throwable t) {

            }
        });
    }
    private void setUserState(){
        StateItem stateItem=new StateItem();
        stateItem.state="1";
        Call<Record> call=gaoService.setUserState("1",stateItem);
        call.enqueue(new Callback<Record>() {
            @Override
            public void onResponse(Call<Record> call, Response<Record> response) {
                Log.d("setuser",response.body().data.saved+"");
            }

            @Override
            public void onFailure(Call<Record> call, Throwable t) {

            }
        });
    }
    private void setRecord(){
        RecordSend recordSend=new RecordSend();
        recordSend.info="testinfo1";
        Call<Record> call=gaoService.setRecord("1",recordSend);
        call.enqueue(new Callback<Record>() {
            @Override
            public void onResponse(Call<Record> call, Response<Record> response) {
                Log.d("setrecord",response.body().data.saved+"");
            }

            @Override
            public void onFailure(Call<Record> call, Throwable t) {

            }
        });
    }
    private void getBetSetting(){
        Call<BetSetting> call=gaoService.getBetSetting("1");
        call.enqueue(new Callback<BetSetting>() {
            @Override
            public void onResponse(Call<BetSetting> call, Response<BetSetting> response) {
                Log.d("betsetting",response.body().data.levels.toString());
            }

            @Override
            public void onFailure(Call<BetSetting> call, Throwable t) {

            }
        });
    }
    private void getUserInfo() {
        Call<AccountInfo> call=gaoService.getUserInfo("1");
        call.enqueue(new Callback<AccountInfo>() {
            @Override
            public void onResponse(Call<AccountInfo> call, Response<AccountInfo> response) {
                Log.d("getuserinfo",response.body().data.groupName+"");
            }

            @Override
            public void onFailure(Call<AccountInfo> call, Throwable t) {

            }
        });
    }

    private void getApkPath() {
        Call<ApkItem> call=gaoService.getApkInfo();
        call.enqueue(new Callback<ApkItem>() {
            @Override
            public void onResponse(Call<ApkItem> call, Response<ApkItem> response) {
                Log.d("apk",response.body().data.path+"");
            }

            @Override
            public void onFailure(Call<ApkItem> call, Throwable t) {

            }
        });
    }

    private void doLogin() {
        LoginItem loginItem=new LoginItem();
        loginItem.login="admin@admin.com";
        loginItem.password="9488598";
        Call<ResultItem> call=gaoService.login(loginItem);
        call.enqueue(new Callback<ResultItem>() {
            @Override
            public void onResponse(Call<ResultItem> call, Response<ResultItem> response) {
                ResultItem resultItem=response.body();
                Log.d("login",resultItem.data.name);
            }

            @Override
            public void onFailure(Call<ResultItem> call, Throwable t) {
                Log.d("login","t"+t);
            }
        });
    }
}
