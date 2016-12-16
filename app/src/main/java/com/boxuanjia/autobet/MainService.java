package com.boxuanjia.autobet;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import com.boxuanjia.autobet.event.EmptyOddsEvent;
import com.boxuanjia.autobet.event.LiveIdEvent;
import com.boxuanjia.autobet.event.OddsEndUpdateEvent;
import com.boxuanjia.autobet.event.OddsQuardUpdateEvent;
import com.boxuanjia.autobet.http.AutoBetClient;
import com.boxuanjia.autobet.model.failure.Failures;
import com.boxuanjia.autobet.model.history.BettingHistory;
import com.boxuanjia.autobet.model.login.Login;
import com.boxuanjia.autobet.model.purchase.Purchase;
import com.boxuanjia.autobet.model.purchase.Purchases;
import com.boxuanjia.autobet.model.purchase.PurchasesInfo;
import com.boxuanjia.autobet.model.purchase.RegularCartItem;
import com.boxuanjia.autobet.model.purchase.RegularRequest;
import com.boxuanjia.autobet.model.purchase.RegularRequestQuar;
import com.boxuanjia.autobet.model.user.AccountInfo;
import com.boxuanjia.autobet.model.user.BetSetting;
import com.boxuanjia.autobet.model.user.Record;
import com.boxuanjia.autobet.model.userinfo.UserInfo;
import com.boxuanjia.autobet.service.ApiCaller;
import com.boxuanjia.autobet.service.LiveMaster;
import com.boxuanjia.autobet.service.LiveMatch;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by boxuanjia on 16/7/27.
 */
public class MainService extends Service {

    // 足球1 篮球2 美式橄榄球3 网球6 棒球7 冰上曲棍球8 特别9
    private static final int TYPE = 2;

    public static final String PRE_USER_INFO = "PRE_USER_INFO";

    public static final String USER_INFO = "USER_INFO";

    public static final String URL_LOGIN = "http://m.10bet100.com/pagemethods.aspx/Login";

    public static final String PARAMS_ACCOUNT = "__userName";

    public static final String PARAMS_PASSWORD = "password";

    private static final String GET_FULL_USER_INFO = "http://m.10bet100.com/methods/userinfo.ashx/getFullUserInfo";

    private static final String GET_BETTING_HISTORY = "http://m.10bet100.com/methods/bettinghistory.ashx/getUserOpenBets";

    private static final String POST_BRANCH_DATA = "http://m.10bet100.com/pagemethods.aspx/GetBranchDataForMobile";

    private static final String POST_LEAGUE_CONTENT = "http://m.10bet100.com/pagemethods.aspx/GetLeagueContentForMobile";

    private static final String GET_LIVE_MASTER_EVENT = "http://m.10bet100.com/methods/masterevents.ashx/getLiveMasterEvent";

    private static final String POST_UPDATE_LIVE_EVENTS = "http://m.10bet100.com/pagemethods.aspx/updateLiveEvents";

    private static final String POST_REGULAR_CART_ITEMS = "http://m.10bet100.com/methods/betting.ashx/getRegularCartItems";

    private static final String POST_MULTI_PURCHASE = "http://m.10bet100.com/methods/betting.ashx/placeMultiPurchase";

    private static final String PATTERN_BETTING_HISTORY = "\\{.*\\}";

    private static final String PATTERN_LEAGUEID = "\\[[0-9]{5},\"(.[^,]*?)\",[0-9]{1,},[0-9]{1,},[0-9]{1,},[0-9]{1,},[0-9]{1,},[0-9]{1,},1,[0-9]{1,},[0-9]{1,},\"(.[^,]*?)\"\\]";

    private static final String PATTERN_MASTEREVENTID = "\\[[0-9]{7},\".*?\",\".*?\",[0-9]{1,},";

    private static final String PATTERN_MASTEREVENTID_FIX = "\\[[0-9]{7},\".*?\",\".*?\",[0-9]{1},";

    private static final String PATTERN_REGULAR_CART_ITEMS = ":\\{.*?\\}";

    private static final String PATTERN_LINEID = "\\[[0-9]{9},.*?\\]";

    private static final String PATTERN_SOURCE = "],.*?,.*?,";

    private static final String PATTERN_UPDATE = "\"updated\":\".*?\"";

    private static final String PATTERN_EVENTID = "\\[[0-9]{8},662\\]";

    private static final long TIME = 3 * 60 * 1000;

    private static final long TIME_INIT = 15 * 1000;

    private static final int STEP_INIT = 0;
    private static final int STEP_CHECK_PAUSE = 1;

    private AsyncHttpClient client;

    private ArrayList<String> leagueList = new ArrayList<>();

    private ArrayList<String> mastereventList = new ArrayList<>();

    private int indexLeague;

    private int masterEventId;

    private int[] source = new int[2];

    private String update;

    private int eventId;

    private int lineId;

    private boolean start;

    private String message;

    private ExecutorService mSingleThreadExecutor = Executors.newSingleThreadExecutor();

    private MainHandler mHandler = new MainHandler(this);
    private Float currentBalance;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!start) {
            Log.d("onStartCommand", "onStartCommand");
            start = true;
            message = "";
            client = AutoBetClient.INSTANCE.getClient();
            EventBus.getDefault().register(this);
            init();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy", "onDestroy");
        start = false;
        message = "";
        EventBus.getDefault().unregister(this);
        mSingleThreadExecutor.shutdownNow();
        client.cancelAllRequests(true);
        stopSelf();
    }

    public void handleMessage(Message msg) {
        switch (msg.arg1) {
            case STEP_INIT:
                init();
                break;
            case STEP_CHECK_PAUSE:
                checkUserBalance();
                break;
        }
    }

    private void init() {
        leagueList.clear();
        mastereventList.clear();
        indexLeague = 0;
        masterEventId = 0;
        source[0] = 0;
        source[1] = 0;
        update = "";
        eventId = 0;
        lineId = 0;

        requestLogin();
    }

    private void requestLogin() {
        SharedPreferences sharedPreferences = getSharedPreferences(PRE_USER_INFO, MODE_PRIVATE);
        String userInfo = sharedPreferences.getString(USER_INFO, "");
        Gson gson = new Gson();
        Login login = gson.fromJson(userInfo, Login.class);
        RequestParams params = new RequestParams();
        params.put(PARAMS_ACCOUNT, login.getAccount());
        params.put(PARAMS_PASSWORD, login.getPassword());
        client.post(URL_LOGIN, params, new TextHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("getUserInfo", "onSuccess");
                Document doc = Jsoup.parse(responseString);
                Log.d("getUserInfo", doc.outerHtml());
                setGetFullUserInfo();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("getUserInfo", "onFailure");
                if (!TextUtils.isEmpty(responseString)) {
                    Document doc = Jsoup.parse(responseString);
                    Log.d("getUserInfo", doc.outerHtml());
                }
            }

        });
    }

    private void setGetFullUserInfo() {
        client.get(GET_FULL_USER_INFO, new TextHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("setGetFullUserInfo", "onSuccess");
                Document doc = Jsoup.parse(responseString);
                Log.d("setGetFullUserInfo", doc.body().text());
                Gson gson = new Gson();
                UserInfo userInfo = gson.fromJson(responseString, UserInfo.class);
                message = String.format("%s\n%s\n%s", message, getSystemTime(), "账户余额:" + userInfo.getBalance());
                currentBalance=userInfo.getBalance();
                EventBus.getDefault().post(message);
                //getBettingHistory();
                getLiveMatch();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("setGetFullUserInfo", "onFailure");
                if (!TextUtils.isEmpty(responseString)) {
                    Document doc = Jsoup.parse(responseString);
                    Log.d("setGetFullUserInfo", doc.outerHtml());
                }
            }
        });
    }

    private void getBettingHistory() {
        client.get(GET_BETTING_HISTORY, new TextHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("getBettingHistory", "onSuccess");
                Document doc = Jsoup.parse(responseString);
                Log.d("getBettingHistory", doc.body().text());
                Pattern r = Pattern.compile(PATTERN_BETTING_HISTORY);
                Matcher m = r.matcher(doc.body().text());
                if (m.find()) {
                    Gson gson = new Gson();
                    BettingHistory bettingHistory = gson.fromJson(m.group(), BettingHistory.class);
                    if (bettingHistory.getSPBets() != null && bettingHistory.getSPBets().size() > 0) {
                        message = String.format("%s\n%s\n%s", message, getSystemTime(), "有尚未结算的投注,3分种后重试.");
                        EventBus.getDefault().post(message);
                        if (mSingleThreadExecutor.isShutdown()) {
                            return;
                        }
                        mSingleThreadExecutor.execute(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(TIME);
                                    Message message = mHandler.obtainMessage();
                                    message.arg1 = STEP_INIT;
                                    mHandler.sendMessage(message);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    } else {
                        //getBranchDataForMobile();
                        currentBalance=0f;
                        ApiCaller.getInstance().setBalance(currentBalance, new Callback<Record>() {
                            @Override
                            public void onResponse(Call<Record> call, Response<Record> response) {
                                if(response.body().data.saved){
                                    if(currentBalance>0){
                                        checkBetState();
                                    }
                                    else{
                                        pauseBetOperate();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<Record> call, Throwable t) {
                                Log.d("updateBalance",t.getMessage());
                            }
                        });

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

    private void pauseBetOperate(){
        ApiCaller.getInstance().setPause("0", new Callback<Record>() {
            @Override
            public void onResponse(Call<Record> call, Response<Record> response) {
                if(response.body().data.saved){
                    delayedCheckBalance();
                }
            }

            @Override
            public void onFailure(Call<Record> call, Throwable t) {
                Log.d("pausebetoperate",t.getMessage());
            }
        });
    }
    private void delayedCheckBalance(){
        Log.d("delay check","checkbalance");
        if (mSingleThreadExecutor.isShutdown()) {
            return;
        }
        mSingleThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(TIME);
                    Message message = mHandler.obtainMessage();
                    message.arg1 = STEP_CHECK_PAUSE;
                    mHandler.sendMessage(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void checkUserBalance(){
        //TODO 检查账户余额，并检查投注状态
        ApiCaller.getInstance().getBetSetting(new Callback<BetSetting>() {
            @Override
            public void onResponse(Call<BetSetting> call, Response<BetSetting> response) {
                BetSetting betSetting=response.body();
                if(betSetting.data.totalBalance>0){
                    checkBetState();
                }
                else{
                    delayedCheckBalance();
                }
            }

            @Override
            public void onFailure(Call<BetSetting> call, Throwable t) {

            }
        });
    }

    private void checkBetState(){
        ApiCaller.getInstance().getUserInfo(new Callback<AccountInfo>() {
            @Override
            public void onResponse(Call<AccountInfo> call, Response<AccountInfo> response) {
                if(response.body().data.state.equals("0")){
                    delayedCheckBalance();
                }
                else if(response.body().data.state.equals("1")){
                    getLiveMatch();
                }
            }

            @Override
            public void onFailure(Call<AccountInfo> call, Throwable t) {

            }
        });
    }
    private void getLiveMatch(){
        LiveMatch liveMatch=new LiveMatch(client);
        liveMatch.load();
    }
    List<RegularRequest> regularRequests;

    List<String> liveIds;
    @Subscribe
    public void onLiveMatchEvent(LiveIdEvent liveIdEvent){
        Log.w("onLiveMatchEvent",liveIdEvent.ids.size()+"");
        liveIds=liveIdEvent.ids;
        oddsEndUpdateEvents.clear();
        oddsQuardUpdateEvents.clear();
        if(liveIds.size()>0){
            regularRequests=new ArrayList<>();
            LiveMaster liveMaster=new LiveMaster(client,liveIdEvent.ids.get(0));
            liveMaster.load();

        }
        else{
            message = String.format("%s\n%s\n%s", message, getSystemTime(), "无滚球,3分种后重试.");
            EventBus.getDefault().post(message);
            if (mSingleThreadExecutor.isShutdown()) {
                return;
            }
            mSingleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(TIME);
                        Message message = mHandler.obtainMessage();
                        message.arg1 = STEP_INIT;
                        mHandler.sendMessage(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    List<OddsEndUpdateEvent> oddsEndUpdateEvents=new ArrayList<>();
    List<OddsQuardUpdateEvent> oddsQuardUpdateEvents=new ArrayList<>();
    @Subscribe
    public void onGetOddsEndBet(OddsEndUpdateEvent updateEvent){
        oddsEndUpdateEvents.add(updateEvent);
        checkLiveIdsTask();
    }

    @Subscribe
    public void onGetEmptyOdds(EmptyOddsEvent emptyOddsEvent){
        checkLiveIdsTask();
    }
    private void checkLiveIdsTask(){
        liveIds.remove(0);
        if(liveIds.size()>0){
            LiveMaster liveMaster=new LiveMaster(client,liveIds.get(0));
            liveMaster.load();
        }
        else{

        }
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
                Pattern r = Pattern.compile("(\\[.*?\\d\\])");
                Matcher m = r.matcher(doc.body().text());
                leagueList.clear();
                indexLeague = 0;
                while (m.find()) {
                    //Log.d("getBranchDataForMobile", m.group());
                    leagueList.add(m.group());
                }
                //first item is useless.
                leagueList.remove(0);
                if (leagueList.size() > 0) {
                    getLeagueContentForMobile(leagueList.get(0).substring(1, 6));
                } else {

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
                    Random random = new Random();
                    int index = random.nextInt(mastereventList.size());
                    getMasterEventForMobile(mastereventList.get(index).substring(1, 8));
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

    //(\d{3},"第.节单.{9}) 获取比赛竞猜为单节单双
    //(\d{3},"单方球队单.{12})
    //[{"Bets":[{"BetID":0,"BetName":null,"BetTypeID":7,"ComboSize":0,"Dividend":0,"Divisor":0,"FreeBetID":0,"FreeBetStake":0,"Gain":9.54,"IsLive":0,"Mappings":[{"SelectionID":0,"ViewKey":0}],"MaxBet":10000,"NumberOfBets":1,"Odds":-110,"Stake":5}],"ComboBonuses":{},"Deposit":5,"NumberOfBets":1,"OddStyleID":1,"PurchaseID":"345705800","Selections":[{"LineID":273505872,"Odds":-110,"Points":null,"QAParameter1":0,"QAParameter2":11,"ViewKey":0}],"Status":1}]
    private void getMasterEventForMobile(String masterEventID) {
        masterEventId = Integer.valueOf(masterEventID);
        RequestParams params = new RequestParams();
        params.put("mastereventid", masterEventID);
        String url = AsyncHttpClient.getUrlWithQueryString(false, GET_LIVE_MASTER_EVENT, params);
        client.get(url, new TextHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("getMasterEventForMobile", "onSuccess");
                Document doc = Jsoup.parse(responseString);
                Log.d("getMasterEventForMobile", doc.toString());

                Pattern r1 = Pattern.compile(PATTERN_SOURCE);
                Matcher m1 = r1.matcher(doc.body().text());
                if (m1.find()) {
                    Log.d("getMasterEventForMobile", m1.group());

                    String s0 = m1.group().substring(m1.group().indexOf(",") + 1, m1.group().indexOf(",", m1.group().indexOf(",") + 1));
                    Log.d("getMasterEventForMobile", "s0=" + s0);
                    String s1 = m1.group().substring(m1.group().indexOf(",", m1.group().indexOf(",") + 1) + 1, m1.group().lastIndexOf(","));
                    Log.d("getMasterEventForMobile", "s1=" + s1);
                    source[0] = Integer.valueOf(s0);
                    source[1] = Integer.valueOf(s1);
                }

                Pattern r2 = Pattern.compile(PATTERN_UPDATE);
                Matcher m2 = r2.matcher(doc.body().text());
                if (m2.find()) {
                    update = m2.group().substring(11, m2.group().length() - 1);
                    Log.d("getMasterEventForMobile", update);
                }
                Pattern r = Pattern.compile(PATTERN_EVENTID);
                Matcher m = r.matcher(doc.body().text());
                if (m.find()) {
                    Log.d("getMasterEventForMobile", m.group());
                    updateLiveEvents(m.group().substring(1, 9));
                } else {
                    message = String.format("%s\n%s\n%s", message, getSystemTime(), "无单双可以下注");
                    EventBus.getDefault().post(message);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("getMasterEventForMobile", "onFailure");
                Document doc = Jsoup.parse(responseString);
                Log.d("getMasterEventForMobile", doc.outerHtml());
            }

        });
    }

    private void updateLiveEvents(final String eventID) {
        eventId = Integer.valueOf(eventID);
        RequestParams params = new RequestParams();
        params.put("requestString", eventID + "#" + 662);
        client.post(POST_UPDATE_LIVE_EVENTS, params, new TextHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("updateLiveEvents", "onSuccess");
                Document doc = Jsoup.parse(responseString);
                Log.d("updateLiveEvents", doc.outerHtml());
                Pattern r = Pattern.compile(PATTERN_LINEID);
                Matcher m = r.matcher(doc.body().text());
                int index = 0;
                String[] oddOrEven = new String[2];
                while (m.find()) {
                    Log.d("updateLiveEvents", m.group());
                    oddOrEven[index] = m.group().substring(1, 10);
                    index++;
                }
                Random random = new Random();
                int num = random.nextInt(2);
                getRegularCartItems(oddOrEven[num]);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("updateLiveEvents", "onFailure");
                Document doc = Jsoup.parse(responseString);
                Log.d("updateLiveEvents", doc.outerHtml());
            }

        });
    }

    private void getRegularCartItems(final String lineID) {
        lineId = Integer.valueOf(lineID);
        RequestParams params = new RequestParams();
        params.put("items", "false,1," + eventId + "," + "," + lineId + "," + "1.9,0,0");
        Log.d("getRegularCartItems", "false,1," + eventId + "," + "," + lineId + "," + "1.9,0,0");
        client.post(POST_REGULAR_CART_ITEMS, params, new TextHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("getRegularCartItems", "onSuccess");
                Document doc = Jsoup.parse(responseString);
                Log.d("getRegularCartItems", doc.outerHtml());
                Pattern r = Pattern.compile(PATTERN_REGULAR_CART_ITEMS);
                Matcher m = r.matcher(doc.body().text());
                if (m.find()) {
                    Log.d("getregular",m.group());
                    /*try {
                        String json = m.group().substring(1);
                        Gson gson = new Gson();
                        placeMultiPurchase(gson.fromJson(json, RegularCartItem.class));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }*/
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("getRegularCartItems", "onFailure");
                Document doc = Jsoup.parse(responseString);
                Log.d("getRegularCartItems", doc.outerHtml());
            }

        });
    }

    private void placeMultiPurchase(RegularCartItem item) throws UnsupportedEncodingException {
        Purchases purchases = new Purchases();
        ArrayList<PurchasesInfo> purchasesInfos = new ArrayList<>();
        PurchasesInfo purchasesInfo = new PurchasesInfo();
        ArrayList<Purchase> items = new ArrayList<>();
        Purchase purchase = new Purchase();

        purchase.setMasterEventID(masterEventId);
        purchase.setEventID(eventId);
        purchase.setLineID(lineId);
        purchase.setValid(true);
        purchase.set_final(false);
        purchase.setMinBet(0.442358238950334);
        purchase.setUpdated(false);
        purchase.setCountable(true);
        purchase.setStatusUpdate(update);
        purchase.setFreeBet(null);
        purchase.setDeleteTimeSet("1970-01-01T00:00:00.000Z");
        purchase.setFirstCall(false);
        purchase.setInitialized(true);
        purchase.setLiveGroupID(item.getLiveGroupID());
        purchase.setComboRate(item.getComboRate());
        purchase.setCombinatorGroup(null);
        purchase.setType(item.getEventTypeID());
        purchase.setOdds(item.getOdds());
        purchase.setInCombo(false);
        // todo
        purchase.setBetType(7);
        purchase.setEachWayIncluded(false);
        purchase.setEachWayEnabled(false);
        purchase.setEachWaySelection(false);
        purchase.setEachWaySingleIncluded(false);
        purchase.setEachWayMultiplesIncluded(false);
        purchase.setReleatedToID(-1);
        purchase.setPlaceTermsID(-1);
        purchase.setOddsTermsID(-1);
        purchase.setEachWayTermsID(-1);
        purchase.seteWOdds(-1);
        purchase.seteWDeposit(-1);
        purchase.seteWGain(-1);
        purchase.setTeamID(-1);
        purchase.setqAParameter1(item.getQAParameter1());
        purchase.setqAParameter2(item.getQAParameter2());
        purchase.setCastSelection(false);
        purchase.setPosition(0);
        purchase.setVisibleCastSelection(false);
        purchase.setSwapped(false);
        purchase.setScore1(source[0]);
        purchase.setScore2(source[1]);
        purchase.setLive(true);
        // todo
        purchase.setViewKey(1);
        purchase.setHasGameStarted(item.getHasGameStarted() == 1);
        purchase.setDanger(false);
        purchase.setBranchID(item.getBranchID());
        purchase.setBranchName(URLEncoder.encode(item.getBranchName(), "UTF-8"));
        purchase.setLeagueID(item.getLeagueID());
        purchase.setLeagueName(URLEncoder.encode(item.getLeagueName(), "UTF-8"));
        purchase.setEventTypeID(item.getEventTypeID());
        purchase.setEventTypeName(URLEncoder.encode(item.getEventTypeName(), "UTF-8"));
        purchase.setTeam1Name(URLEncoder.encode(item.getTeam1Name(), "UTF-8"));
        purchase.setTeam2Name(URLEncoder.encode(item.getTeam2Name(), "UTF-8"));
        purchase.setMaxBet(item.getMaxBet());
        purchase.setWaitingAllowed(item.getWaitingAllowed());
        purchase.setMaxBetCombo(item.getMaxBetCombo());
        purchase.setMaxBetSystem(item.getMaxBetSystem());
        purchase.setMaxBetTeaser(item.getMaxBetTeaser());
        purchase.setComboBetIsEnabled(item.getComboBetIsEnabled());
        purchase.setSystemBetIsEnabled(item.getSystemBetIsEnabled());
        purchase.setLineTypeName(URLEncoder.encode(item.getLineTypeName(), "UTF-8"));
        purchase.setEventDate(item.getEventDate());
        purchase.setBetTypeID(item.getLineTypeID());
        purchase.setLineTypeID(item.getLineTypeID());
        purchase.setUseEventName(item.getUseEventName());
        purchase.setEventName(URLEncoder.encode(item.getEventName(), "UTF-8"));
        purchase.setLineName(URLEncoder.encode(item.getLineName(), "UTF-8"));
        purchase.setAsianLineName(URLEncoder.encode(item.getLineName(), "UTF-8"));
        purchase.setMappedLineTypeID(item.getMappedLineTypeID());
        purchase.setSplitType(item.getSplitTypeID());
        purchase.setUpdatedOdds(false);
        purchase.setPreviousOdds(1.9);
        purchase.setUpdatedScore(false);
        purchase.setStakeUpdatedByUser(true);
        purchase.setClientOdds("1.90");
        purchase.setYourBet("{$LineName}");
        purchase.setEnableAsianStyleMinMax(false);

        items.add(purchase);
        purchasesInfo.setPurchases(items);
        purchasesInfos.add(purchasesInfo);
        purchases.setPurchasesInfos(purchasesInfos);
        Gson gson = new GsonBuilder().serializeNulls().create();
        StringEntity stringEntity = null;
        try {
            String value = gson.toJson(purchases);
            Log.d("placeMultiPurchase", "" + value);
            stringEntity = new StringEntity(value);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        client.post(this, POST_MULTI_PURCHASE, stringEntity, "application/json; charset=utf-8", new TextHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("placeMultiPurchase", "onSuccess");
                Document doc = Jsoup.parse(responseString);
                Log.d("placeMultiPurchase", doc.outerHtml());

                // 去掉[]
                String temp = responseString.substring(1, responseString.length() - 1);
                Gson gson = new Gson();
                if (temp.charAt(2) == 'B') {// 成功
                    message = String.format("%s\n%s\n%s", message, getSystemTime(), "投注成功");
                    EventBus.getDefault().post(message);
                } else if (temp.charAt(2) == 'S') {// 失败
                    Failures selections = gson.fromJson(temp, Failures.class);
                    if (!TextUtils.isEmpty(selections.getSelections().get(0).getErrorMessage())) {
                        message = String.format("%s\n%s\n%s", message, getSystemTime(), "投注失败原因:" + selections.getSelections().get(0).getErrorMessage());
                        EventBus.getDefault().post(message);
                    }
                }
                if (mSingleThreadExecutor.isShutdown()) {
                    return;
                }
                mSingleThreadExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(TIME_INIT);
                            Message message = mHandler.obtainMessage();
                            message.arg1 = STEP_INIT;
                            mHandler.sendMessage(message);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("placeMultiPurchase", "onFailure");
                Document doc = Jsoup.parse(responseString);
                Log.d("placeMultiPurchase", doc.outerHtml());
            }

        });
    }

    private String getSystemTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss", Locale.getDefault());
        return format.format(new Date(System.currentTimeMillis()));
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
