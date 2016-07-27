package com.boxuanjia.test.htmlparser;

import android.app.Application;

import com.loopj.android.http.AsyncHttpClient;

/**
 * Created by boxuanjia on 16/7/8.
 */
public class MyApplication extends Application {

    private AsyncHttpClient client;

    @Override
    public void onCreate() {
        super.onCreate();
        setupClient();
    }

    private void setupClient() {
        client = new AsyncHttpClient();
        client.setEnableRedirects(false);
        client.addHeader("RequestTarget", "AJAXService");
        client.addHeader("Origin", "http://m.10bo1010.com");
        client.addHeader("User-Agent", "Mozilla/5.0 (Linux; Android 6.0.1; Nexus 5X Build/MTC19V) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.81 Mobile Safari/537.36");
        client.addHeader("Accept", "*/*");
        client.addHeader("Referer", "http://m.10bo1010.com");
        client.addHeader("Accept-Encoding", "gzip, deflate");
        client.addHeader("Accept-Language", "en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4");
        client.addHeader("Connection", "keep-alive");
    }

    public AsyncHttpClient getClient() {
        return client;
    }
}
