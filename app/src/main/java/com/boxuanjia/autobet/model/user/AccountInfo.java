package com.boxuanjia.autobet.model.user;

import com.squareup.moshi.Json;

/**
 * Created by slomka.jin on 2016/11/22.
 */

public class AccountInfo {
    public int status;
    public String info;
    public Data data;

    public static class Data{
        public String name;
        public String groupName;
        public String state;
        @Json(name = "app_version")
        public String appVersion;
    }
}
