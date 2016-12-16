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
    private static final String[] ODDS_IDES=new String[]{"665","666","667","668","669"};
    private static final String ODDS_END_ID="669";
    private final String PATTERN_FIND_ODDS="\\[\\d{8},";
    private final String PATTERN_FIND_ODDS_QUARTER="\\[\\d{8},(665|666|667|668)";
    private final String PATTERN_FIND_UPDATE="\\[[0-9]{9},.*?\\]";
    private final String PATTERN_FIND_UPDATE_DATE="\"updated\":\".*?\"";
    private final String PATTERN_FIND_SCORE="\\d{1,4},\\d{1,4},";
    private final String PATTERN_FIND_HAS_ODDS="\\[[0-9]{8,9},66\\d{1},\\[\\[\\d{7,10},-111,.*?,,,,";
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
                String requeset=getUpdateRequest(responseString);
                if(!requeset.equals("")){
                    //subEventId=matcher.group().substring(1,matcher.group().indexOf(","));
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
                    updateLiveEventEnd(requeset);

                }
                else{
                    EventBus.getDefault().post(new EmptyOddsEvent());
                }

            }
        });
    }
    private String getUpdateRequest(String content){
        String request="";

        for (int i = 0; i < ODDS_IDES.length; i++) {
            Pattern pattern = Pattern.compile(PATTERN_FIND_ODDS+ODDS_IDES[i]);
            Matcher matcher = pattern.matcher(content);
            if(matcher.find()){
                String childId=matcher.group().substring(1,matcher.group().indexOf(","));
                request+=childId+"#"+ODDS_IDES[i];
                request+=i<ODDS_IDES.length-1?"@":"";
            }
        }
        return request;
    }
    private void updateLiveEventEnd(String request){
        RequestParams params = new RequestParams();
        params.put("requestString", request);
        Log.d("request",request);
        client.post(WebApi.UPDATE_LIVE_EVENTS, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                EventBus.getDefault().post(new EmptyOddsEvent());

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Pattern getOddsPattern=Pattern.compile(PATTERN_FIND_HAS_ODDS);
                Matcher oddsMatcher=getOddsPattern.matcher(responseString);
                Log.w("updatelive",responseString);
                while (oddsMatcher.find()){
                    String oddsId=oddsMatcher.group().split(",")[1];
                    Log.w("findodds",oddsId);
                    Pattern pattern = Pattern.compile(PATTERN_FIND_UPDATE);
                    Matcher matcher = pattern.matcher(oddsMatcher.group());
                    List<OddsEndData> oddsEndDataList=new ArrayList<OddsEndData>();
                    while (matcher.find()){
                        String[] data=matcher.group().substring(1,matcher.group().length()-1).split(",");
                        OddsEndData oddsEndData=new OddsEndData();
                        oddsEndData.data=data;
                        oddsEndData.eventId=eventId;
                        oddsEndData.subEventId=oddsId;
                        oddsEndData.isEnd=oddsId.equals("669");
                        Log.w("updateLiveEventEnd",matcher.group().substring(1,matcher.group().length()-1)+",eventid "+oddsId);
                        oddsEndDataList.add(oddsEndData);
                    }
                }

                //EventBus.getDefault().post(new OddsEndUpdateEvent(oddsEndDataList));
            }
        });
    }
    private void updateLiveEventQuart(String id){

    }
}
