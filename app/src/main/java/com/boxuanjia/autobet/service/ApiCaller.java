package com.boxuanjia.autobet.service;

import android.util.Log;

import com.boxuanjia.autobet.model.user.AccountInfo;
import com.boxuanjia.autobet.model.user.Balance;
import com.boxuanjia.autobet.model.user.BetSetting;
import com.boxuanjia.autobet.model.user.PauseItem;
import com.boxuanjia.autobet.model.user.Record;
import com.boxuanjia.autobet.model.user.UserManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by slomka.jin on 2016/12/14.
 */

public class ApiCaller {
    private static ApiCaller apiCaller;
    private GaoService gaoService;
    private ApiCaller(){
        gaoService=ServiceManager.instance().getApi();
    }
    public static ApiCaller getInstance(){
        if(null==apiCaller)
            apiCaller=new ApiCaller();
        return apiCaller;
    }
    public void setBalance(float count,Callback<Record> callback){
        Balance balance=new Balance();
        balance.count=count;
        Call<Record> call=gaoService.setBalance(UserManager.instance().getId(),balance);
        call.enqueue(callback);
    }
    public void setPause(String isPause,Callback<Record> callback){
        PauseItem pauseItem=new PauseItem();
        pauseItem.pause=isPause;
        Call<Record> call=gaoService.setPause(UserManager.instance().getId(),pauseItem);
        call.enqueue(callback);
    }
    public void getUserInfo(Callback<AccountInfo> callback) {
        Call<AccountInfo> call=gaoService.getUserInfo(UserManager.instance().getId());
        call.enqueue(callback);
    }
    public void getBetSetting(Callback<BetSetting> callback){
        Call<BetSetting> call=gaoService.getBetSetting(UserManager.instance().getId());
        call.enqueue(callback);
    }
}
