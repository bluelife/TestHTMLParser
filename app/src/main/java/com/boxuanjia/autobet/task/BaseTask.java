package com.boxuanjia.autobet.task;

import com.loopj.android.http.AsyncHttpClient;

/**
 * Created by HiWin10 on 2016/10/25.
 */

public abstract class BaseTask {
    protected AsyncHttpClient client;
    public BaseTask(AsyncHttpClient client){
        this.client=client;
    }

    public abstract void load();

}
