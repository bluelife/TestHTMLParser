package com.boxuanjia.autobet.service;

import com.boxuanjia.autobet.model.login.LoginItem;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by HiWin10 on 2016/11/21.
 */

public interface GaoService {
    @POST("index.php?app=bet&mod=Account&act=login")
    Call<LoginItem> login(@Body LoginItem loginItem);
}
