package com.boxuanjia.autobet.model.login;

import com.squareup.moshi.Json;

/**
 * Created by HiWin10 on 2016/11/21.
 */

public class Data {
    public boolean success;
    @Json(name = "user_id")
    public String userId;
    @Json(name = "user_name")
    public String name;
}
