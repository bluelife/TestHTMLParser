package com.boxuanjia.test.htmlparser;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.boxuanjia.test.htmlparser.model.Purchase;
import com.boxuanjia.test.htmlparser.model.Purchases;
import com.boxuanjia.test.htmlparser.model.PurchasesInfo;
import com.boxuanjia.test.htmlparser.model.RegularCartItem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

@SuppressLint("LongLogTag")
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    // 足球1 篮球2 美式橄榄球3 网球6 棒球7 冰上曲棍球8 特别9
    private static final int TYPE = 2;

    private static final String POST_LOGIN = "http://m.10bo1010.com/pagemethods.aspx/Login";

    private static final String POST_BRANCH_DATA_FOR_MOBILE = "http://m.10bo1010.com/pagemethods.aspx/GetBranchDataForMobile";

    private static final String POST_LEAGUE_CONTENT_FOR_MOBILE = "http://m.10bo1010.com/pagemethods.aspx/GetLeagueContentForMobile";

    private static final String GET_LIVE_MASTER_EVENT = "http://m.10bo1010.com/methods/masterevents.ashx/getLiveMasterEvent";

    private static final String POST_UPDATE_LIVE_EVENTS = "http://m.10bo1010.com/pagemethods.aspx/updateLiveEvents";

    private static final String POST_REGULAR_CART_ITEMS = "http://m.10bo1010.com/methods/betting.ashx/getRegularCartItems";

    private static final String POST_MULTI_PURCHASE = "http://m.10bo1010.com/methods/betting.ashx/placeMultiPurchase";

    /*PATTERN*/

    private final String PATTERN_LEAGUEID = "\\[[0-9]{5},\"(.[^,]*?)\",[0-9]{1,},[0-9]{1,},[0-9]{1,},[0-9]{1,},[0-9]{1,},[0-9]{1,},1,[0-9]{1,},[0-9]{1,},\"(.[^,]*?)\"\\]";

    private final String PATTERN_MASTEREVENTID = "\\[[0-9]{7},\".*?\",\".*?\",[0-9]{1,},";

    private final String PATTERN_MASTEREVENTID_FIX = "\\[[0-9]{7},\".*?\",\".*?\",[0-9]{1},";

    private final String PATTERN_EVENTID = "\\[[0-9]{8},662\\]";

    private final String PATTERN_UPDATE = "\"updated\":\".*?\"";

    private final String PATTERN_SOURCE = "],.*?,.*?,";

    private final String PATTERN_LINEID = "\\[[0-9]{9},.*?\\]";

    private final String PATTERN_REGULAR_CART_ITEMS = ":\\{.*?\\}";

    private final String ACCOUNT = "cheersgo";

    private final String PASSWORD = "9488598";

    private ArrayList<String> leagueList = new ArrayList<>();

    private ArrayList<String> mastereventList = new ArrayList<>();

    private int indexLeague = 0;

    private int indexMaster = 0;

    private String update;

    private int masterEventId;

    private int[] source = new int[2];

    private int eventId;

    private int lineId;

    private AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化
        init();
        // 请求登录
        getUserInfo();
    }

    private void init() {
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

    private void getUserInfo() {
        RequestParams params = new RequestParams();
        params.put("__userName", ACCOUNT);
        params.put("password", PASSWORD);
        client.post(POST_LOGIN, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("getUserInfo", "onFailure");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("getUserInfo", "onSuccess");
                Document doc = Jsoup.parse(responseString);
                Log.d("getUserInfo", doc.outerHtml());
                getBranchDataForMobile();
            }
        });
    }

    private void getBranchDataForMobile() {
        RequestParams params = new RequestParams();
        params.put("branchId", TYPE);
        client.post(POST_BRANCH_DATA_FOR_MOBILE, params, new TextHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("getBranchDataForMobile", "onSuccess");
                Document doc = Jsoup.parse(responseString);
                Log.d("getBranchDataForMobile", doc.body().text());
                Pattern r = Pattern.compile(PATTERN_LEAGUEID);
                Matcher m = r.matcher(doc.body().text());
                leagueList.clear();
                indexLeague = 0;
                while (m.find()) {
                    Log.d("getBranchDataForMobile", m.group());
                    leagueList.add(m.group().substring(1, 6));
                }
                if (leagueList.size() > 0) {
                    Log.d("getBranchDataForMobile", leagueList.get(0));
                    getLeagueContentForMobile(leagueList.get(0));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("getBranchDataForMobile", "onFailure");
                Document doc = Jsoup.parse(responseString);
                Log.d("getBranchDataForMobile", doc.outerHtml());
            }

        });
    }

    private void getLeagueContentForMobile(String leagueId) {
        RequestParams params = new RequestParams();
        params.put("leagueId", leagueId);
        client.post(POST_LEAGUE_CONTENT_FOR_MOBILE, params, new TextHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("getLeagueContentForMobile", "onSuccess");
                Document doc = Jsoup.parse(responseString);
                Log.d("getLeagueContentForMobile", doc.body().text());
                Pattern p = Pattern.compile(PATTERN_MASTEREVENTID);
                Matcher m = p.matcher(doc.body().text());
                mastereventList.clear();
                indexMaster = 0;
                while (m.find()) {
                    Pattern pFix = Pattern.compile(PATTERN_MASTEREVENTID_FIX);
                    Matcher mFix = pFix.matcher(m.group());
                    while (mFix.find()) {
                        Log.d("getLeagueContentForMobile", mFix.group());
                        mastereventList.add(mFix.group().substring(1, 8));
                    }
                }
                if (mastereventList.size() > 0) {
                    Log.d("getLeagueContentForMobile", mastereventList.get(0));
                    getMasterEventForMobile(mastereventList.get(0));
                } else {
                    indexLeague++;
                    if (indexLeague < leagueList.size()) {
                        getLeagueContentForMobile(leagueList.get(indexLeague));
                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("getLeagueContentForMobile", "onFailure");
                Document doc = Jsoup.parse(responseString);
                Log.d("getLeagueContentForMobile", doc.outerHtml());
            }

        });
    }

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
                    Log.d("updateLiveEvents", m1.group());

                    String s0 = m1.group().substring(m1.group().indexOf(",") + 1, m1.group().indexOf(",", m1.group().indexOf(",") + 1));
                    Log.d("updateLiveEvents", "s0=" + s0);
                    String s1 = m1.group().substring(m1.group().indexOf(",", m1.group().indexOf(",") + 1) + 1, m1.group().lastIndexOf(","));
                    Log.d("updateLiveEvents", "s1=" + s1);
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
                boolean find = false;
                while (m.find()) {
                    find = true;
                    Log.d("getMasterEventForMobile", m.group());
                    updateLiveEvents(m.group().substring(1, 9));
                }
                if (!find) {
                    indexMaster++;
                    if (indexMaster < mastereventList.size()) {
                        getMasterEventForMobile(mastereventList.get(indexMaster));
                    } else {
                        indexLeague++;
                        if (indexLeague < leagueList.size()) {
                            getLeagueContentForMobile(leagueList.get(indexLeague));
                        }
                    }
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
                boolean isOdd = true;
                int index = 0;
                String oddOrEven[] = new String[2];
                while (m.find()) {
                    Log.d("updateLiveEvents", m.group());
                    oddOrEven[index] = m.group().substring(1, 10);
                    index++;
                }
                if (isOdd) {
                    getRegularCartItems(oddOrEven[0]);
                } else {
                    getRegularCartItems(oddOrEven[1]);
                }
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
                    try {
                        String json = m.group().substring(1);
                        Gson gson = new Gson();
                        placeMultiPurchase(gson.fromJson(json, RegularCartItem.class));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
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
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("placeMultiPurchase", "onFailure");
                Document doc = Jsoup.parse(responseString);
                Log.d("placeMultiPurchase", doc.outerHtml());
            }

        });
    }

}
