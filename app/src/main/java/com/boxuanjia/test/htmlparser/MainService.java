package com.boxuanjia.test.htmlparser;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import com.boxuanjia.test.htmlparser.model.history.BettingHistory;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.greenrobot.eventbus.EventBus;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cz.msebera.android.httpclient.Header;

/**
 * Created by boxuanjia on 16/7/27.
 */
public class MainService extends Service {

    // 足球1 篮球2 美式橄榄球3 网球6 棒球7 冰上曲棍球8 特别9
    private static final int TYPE = 2;

    private static final String GET_BETTING_HISTORY = "http://m.10bo1010.com/methods/bettinghistory.ashx/getUserOpenBets";

    private static final String POST_BRANCH_DATA = "http://m.10bo1010.com/pagemethods.aspx/GetBranchDataForMobile";

    private static final String POST_LEAGUE_CONTENT = "http://m.10bo1010.com/pagemethods.aspx/GetLeagueContentForMobile";

    private static final String PATTERN_BETTING_HISTORY = "\\{.*\\}";

    private static final String PATTERN_LEAGUEID = "\\[[0-9]{5},\"(.[^,]*?)\",[0-9]{1,},[0-9]{1,},[0-9]{1,},[0-9]{1,},[0-9]{1,},[0-9]{1,},1,[0-9]{1,},[0-9]{1,},\"(.[^,]*?)\"\\]";

    private static final String PATTERN_MASTEREVENTID = "\\[[0-9]{7},\".*?\",\".*?\",[0-9]{1,},";

    private static final String PATTERN_MASTEREVENTID_FIX = "\\[[0-9]{7},\".*?\",\".*?\",[0-9]{1},";

    private static final long TIME = 3 * 60 * 1000;

    private static final int STEP_0 = 0;

    private static final int STEP_1 = 1;

    private static final int STEP_2 = 2;

    private AsyncHttpClient client;

    private ArrayList<String> leagueList = new ArrayList<>();

    private ArrayList<String> mastereventList = new ArrayList<>();

    private int indexLeague;

    private ExecutorService mSingleThreadExecutor = Executors.newSingleThreadExecutor();

    private MainHandler mHandler = new MainHandler(this);

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        client = ((MyApplication) getApplication()).getClient();
        getBettingHistory();
        return super.onStartCommand(intent, flags, startId);
    }

    private void getBettingHistory() {
        client.get(GET_BETTING_HISTORY, new TextHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("getBettingHistory", "onSuccess");
                Document doc = Jsoup.parse(responseString);
                Log.d("getBettingHistory", doc.body().text());
                EventBus.getDefault().post(doc.body().text());
                Pattern r = Pattern.compile(PATTERN_BETTING_HISTORY);
                Matcher m = r.matcher(doc.body().text());
                if (m.find()) {
                    Gson gson = new Gson();
                    BettingHistory bettingHistory = gson.fromJson(m.group(), BettingHistory.class);
                    if (bettingHistory.getSPBets() != null && bettingHistory.getSPBets().size() > 0) {
                        EventBus.getDefault().post("有尚未结算的投注,3分种后重试.");
                        mSingleThreadExecutor.execute(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(TIME);
                                    Message message = mHandler.obtainMessage();
                                    message.arg1 = STEP_0;
                                    mHandler.sendMessage(message);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    } else {
                        getBranchDataForMobile();
                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("getBettingHistory", "onFailure");
                if (!TextUtils.isEmpty(responseString)) {
                    Document doc = Jsoup.parse(responseString);
                    Log.d("getBettingHistory", doc.outerHtml());
                }
            }

        });
    }

    private void getBranchDataForMobile() {
        RequestParams params = new RequestParams();
        params.put("branchId", TYPE);
        client.post(POST_BRANCH_DATA, params, new TextHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("getBranchDataForMobile", "onSuccess");
                Document doc = Jsoup.parse(responseString);
                Log.d("getBranchDataForMobile", doc.body().text());
                EventBus.getDefault().post(doc.body().text());
                Pattern r = Pattern.compile(PATTERN_LEAGUEID);
                Matcher m = r.matcher(doc.body().text());
                leagueList.clear();
                indexLeague = 0;
                while (m.find()) {
                    Log.d("getBranchDataForMobile", m.group());
                    leagueList.add(m.group());
                }
                if (leagueList.size() > 0) {
                    getLeagueContentForMobile(leagueList.get(0).substring(1, 6));
                } else {
                    EventBus.getDefault().post("无滚球,3分种后重试.");
                    mSingleThreadExecutor.execute(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(TIME);
                                Message message = mHandler.obtainMessage();
                                message.arg1 = STEP_1;
                                mHandler.sendMessage(message);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("getBranchDataForMobile", "onFailure");
                if (!TextUtils.isEmpty(responseString)) {
                    Document doc = Jsoup.parse(responseString);
                    Log.d("getBranchDataForMobile", doc.outerHtml());
                }
            }

        });
    }

    private void getLeagueContentForMobile(String leagueId) {
        RequestParams params = new RequestParams();
        params.put("leagueId", leagueId);
        client.post(POST_LEAGUE_CONTENT, params, new TextHttpResponseHandler() {

            @SuppressLint("LongLogTag")
            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("getLeagueContentForMobile", "onSuccess");
                Document doc = Jsoup.parse(responseString);
                Log.d("getLeagueContentForMobile", doc.body().text());
                EventBus.getDefault().post(doc.body().text());
                Pattern p = Pattern.compile(PATTERN_MASTEREVENTID);
                Matcher m = p.matcher(doc.body().text());
                while (m.find()) {
                    Pattern pFix = Pattern.compile(PATTERN_MASTEREVENTID_FIX);
                    Matcher mFix = pFix.matcher(m.group());
                    while (mFix.find()) {
                        Log.d("getLeagueContentForMobile", mFix.group());
                        mastereventList.add(mFix.group());
                    }
                }
                indexLeague++;
                if (indexLeague < leagueList.size()) {
                    getLeagueContentForMobile(leagueList.get(indexLeague).substring(1, 6));
                } else {
                    EventBus.getDefault().post(mastereventList);
                }
            }

            @SuppressLint("LongLogTag")
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("getLeagueContentForMobile", "onFailure");
                if (!TextUtils.isEmpty(responseString)) {
                    Document doc = Jsoup.parse(responseString);
                    Log.d("getLeagueContentForMobile", doc.outerHtml());
                }
            }

        });
    }

    public void handleMessage(Message msg) {
        switch (msg.arg1) {
            case STEP_0:
                getBettingHistory();
                break;
            case STEP_1:
                getBranchDataForMobile();
                break;
            case STEP_2:
                break;
        }
    }

    private static class MainHandler extends Handler {

        private MainService mMainService;

        public MainHandler(MainService service) {
            mMainService = service;
        }

        @Override
        public void handleMessage(Message msg) {
            mMainService.handleMessage(msg);
        }
    }
}
