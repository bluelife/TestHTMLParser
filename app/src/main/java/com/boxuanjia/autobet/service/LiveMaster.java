package com.boxuanjia.autobet.service;

import android.util.Log;

import com.boxuanjia.autobet.event.EmptyOddsEvent;
import com.boxuanjia.autobet.event.OddsEndUpdateEvent;
import com.boxuanjia.autobet.model.purchase.OddsEndData;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cz.msebera.android.httpclient.Header;

/**
 * Created by slomka.jin on 2016/10/26.
 */

public class LiveMaster extends BaseTask {
    //3q:667 4q:668 2q:666 1q:665
    private String eventId;
    private String subEventId;
    private String update;
    private String score1;
    private String score2;
    private static final String ODDS_END_ID="669";
    private final String PATTERN_FIND_ODDS_END="\\[\\d{8},"+ODDS_END_ID;
    private final String PATTERN_FIND_ODDS_QUARTER="\\[\\d{8},(665|666|667|668)";
    private final String PATTERN_FIND_UPDATE="\\[[0-9]{9},.*?\\]";
    private final String PATTERN_FIND_UPDATE_DATE="\"updated\":\".*?\"";
    private final String PATTERN_FIND_SCORE="\\d{1,4},\\d{1,4},";
    public LiveMaster(AsyncHttpClient client,String id) {
        super(client);
        eventId=id;
    }

    @Override
    public void load() {
        RequestParams params = new RequestParams();
        params.put("mastereventid", eventId);
        String url = AsyncHttpClient.getUrlWithQueryString(false, WebApi.LIVE_MASTER_EVENT, params);
        client.get(url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                EventBus.getDefault().post(new EmptyOddsEvent());
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Pattern pattern = Pattern.compile(PATTERN_FIND_ODDS_END);
                Matcher matcher = pattern.matcher(responseString);
                if(matcher.find()){
                    subEventId=matcher.group().substring(1,matcher.group().indexOf(","));
                    Pattern p2=Pattern.compile(PATTERN_FIND_UPDATE_DATE);
                    Matcher m2=p2.matcher(responseString);
                    if(m2.find()){
                        update = m2.group().substring(11, m2.group().length() - 1);
                    }
                    p2=Pattern.compile(PATTERN_FIND_SCORE);
                    m2=p2.matcher(responseString);
                    if(m2.find()){
                        String[] scores=m2.group().split(",");
                        if(scores.length>1) {
                            score1 = scores[0];
                            score2 = scores[1];
                        }
                    }
                    updateLiveEventEnd(subEventId);

                }
                else{
                    EventBus.getDefault().post(new EmptyOddsEvent());
                }
            }
        });
    }
    private void updateLiveEventEnd(String id){
        RequestParams params = new RequestParams();
        params.put("requestString", id + "#" + ODDS_END_ID);
        client.post(WebApi.UPDATE_LIVE_EVENTS, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                EventBus.getDefault().post(new EmptyOddsEvent());
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Pattern pattern = Pattern.compile(PATTERN_FIND_UPDATE);
                Matcher matcher = pattern.matcher(responseString);
                List<OddsEndData> oddsEndDataList=new ArrayList<OddsEndData>();
                while (matcher.find()){
                    String[] data=matcher.group().substring(1,matcher.group().length()-1).split(",");
                    OddsEndData oddsEndData=new OddsEndData();
                    oddsEndData.data=data;
                    oddsEndData.eventId=eventId;
                    oddsEndData.subEventId=subEventId;
                    Log.w("updateLiveEventEnd",matcher.group().substring(1,matcher.group().length()-1)+",eventid "+subEventId);
                    oddsEndDataList.add(oddsEndData);
                }
                EventBus.getDefault().post(new OddsEndUpdateEvent(oddsEndDataList));
            }
        });
    }
    private void updateLiveEventQuart(String id){

    }
}
