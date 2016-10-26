package com.boxuanjia.autobet.service;

import android.util.Log;

import com.boxuanjia.autobet.event.LiveIdEvent;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import org.greenrobot.eventbus.EventBus;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cz.msebera.android.httpclient.Header;

/**
 * Created by slomka.jin on 2016/10/26.
 */

public class LiveMatch extends BaseTask {
    private final String PATTERN_LIVE_BASKTBALL="\\[\\d{5,9},\".{2,40}\",\".{2,40},2,";
    public LiveMatch(AsyncHttpClient client) {
        super(client);
    }

    @Override
    public void load() {
        client.get(WebApi.LIVE_ALL, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Document doc = Jsoup.parse(responseString);
                Pattern pattern = Pattern.compile(PATTERN_LIVE_BASKTBALL);
                Matcher matcher = pattern.matcher(doc.body().text());
                List<String> ids=new ArrayList<String>();
                while (matcher.find()){
                    String id=matcher.group().substring(1,matcher.group().indexOf(","));
                    ids.add(id);
                }
                EventBus.getDefault().post(new LiveIdEvent(ids));
            }
        });
    }
}
