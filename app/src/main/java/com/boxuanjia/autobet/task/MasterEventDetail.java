package com.boxuanjia.autobet.task;

import com.boxuanjia.autobet.http.WebApi;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * Created by HiWin10 on 2016/10/25.
 */

public class MasterEventDetail extends BaseTask {
    private String eventId;
    public MasterEventDetail(AsyncHttpClient client) {
        super(client);
    }

    @Override
    public void load() {
        RequestParams params = new RequestParams();
        params.put("mastereventid", eventId);
        String url = AsyncHttpClient.getUrlWithQueryString(false, WebApi.LIVE_MASTER_EVENT, params);
        client.get(url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {

            }
        });
    }
}
