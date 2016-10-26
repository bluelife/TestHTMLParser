package com.boxuanjia.autobet.service;

import com.loopj.android.http.AsyncHttpClient;

/**
 * Created by slomka.jin on 2016/10/26.
 */

public abstract class BaseTask {
    protected AsyncHttpClient client;
    public BaseTask(AsyncHttpClient client){
        this.client=client;
    }

    public abstract void load();
}
