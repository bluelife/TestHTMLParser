package com.boxuanjia.autobet.service;

import com.boxuanjia.autobet.model.login.LoginItem;
import com.boxuanjia.autobet.model.login.ResultItem;
import com.boxuanjia.autobet.model.update.ApkItem;
import com.boxuanjia.autobet.model.user.AccountInfo;
import com.boxuanjia.autobet.model.user.Balance;
import com.boxuanjia.autobet.model.user.BetSetting;
import com.boxuanjia.autobet.model.user.PauseItem;
import com.boxuanjia.autobet.model.user.PurchaseItem;
import com.boxuanjia.autobet.model.user.Record;
import com.boxuanjia.autobet.model.user.RecordSend;
import com.boxuanjia.autobet.model.user.StateItem;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by HiWin10 on 2016/11/21.
 */

public interface GaoService {
    @POST("index.php?app=bet&mod=Account&act=login")
    Call<ResultItem> login(@Body LoginItem loginItem);
    @GET("index.php?app=bet&mod=Account&act=appupdate")
    Call<ApkItem> getApkInfo();
    @GET("index.php?app=bet&mod=Account&act=index")
    Call<AccountInfo> getUserInfo(@Query("user_id") String id);
    @GET("index.php?app=bet&mod=Account&act=bet_setting")
    Call<BetSetting> getBetSetting(@Query("user_id") String id);
    @POST("index.php?app=bet&mod=Account&act=bet_operation")
    Call<Record> setRecord(@Query("user_id") String id, @Body RecordSend send);
    @POST("index.php?app=bet&mod=Account&act=bet_banlance")
    Call<Record> setBalance(@Query("user_id") String id, @Body Balance send);
    @POST("index.php?app=bet&mod=Account&act=bet_purchase")
    Call<Record> setPurchase(@Query("user_id") String id, @Body PurchaseItem send);
    @POST("index.php?app=bet&mod=Account&act=bet_state")
    Call<Record> setPause(@Query("user_id") String id, @Body PauseItem send);
    @POST("index.php?app=bet&mod=Account&act=user_state")
    Call<Record> setUserState(@Query("user_id") String id, @Body StateItem send);

}
