package com.boxuanjia.autobet.task;

import android.util.Log;

import com.boxuanjia.autobet.event.LiveList;
import com.boxuanjia.autobet.http.WebApi;
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
 * Created by HiWin10 on 2016/10/25.
 */

public class LiveMatch extends BaseTask {

    private final String REG_FIND="\\[\\d{5,8},\".{2,20}\",\".{2,20}\",2,";

    public LiveMatch(AsyncHttpClient client) {
        super(client);
    }

    @Override
    public void load(){
        client.get(WebApi.LIVE_ALL,new TextHttpResponseHandler(){

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Document doc = Jsoup.parse(responseString);
                Log.d("getMasterEventForMobile", doc.toString());

                Pattern pattern = Pattern.compile(REG_FIND);
                Matcher matcher = pattern.matcher(doc.body().text());
                List<String> masterIdList=new ArrayList<String>();
                while (matcher.find()){
                    String id=matcher.group().substring(1,matcher.group().indexOf(","));
                    masterIdList.add(id);
                }
                EventBus.getDefault().post(new LiveList(masterIdList));

            }
        });
    }
}
