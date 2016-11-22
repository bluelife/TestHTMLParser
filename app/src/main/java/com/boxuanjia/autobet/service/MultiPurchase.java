package com.boxuanjia.autobet.service;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.boxuanjia.autobet.Utils.BetTarget;
import com.boxuanjia.autobet.Utils.Config;
import com.boxuanjia.autobet.event.OddsEndUpdateEvent;
import com.boxuanjia.autobet.event.OddsQuardUpdateEvent;
import com.boxuanjia.autobet.model.failure.Failures;
import com.boxuanjia.autobet.model.purchase.Purchase;
import com.boxuanjia.autobet.model.purchase.Purchases;
import com.boxuanjia.autobet.model.purchase.PurchasesInfo;
import com.boxuanjia.autobet.model.purchase.RegularCartItem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.greenrobot.eventbus.EventBus;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

import static com.boxuanjia.autobet.service.WebApi.POST_MULTI_PURCHASE;
import static com.boxuanjia.autobet.service.WebApi.POST_REGULAR_CART_ITEMS;

/**
 * Created by slomka.jin on 2016/10/26.
 */

public class MultiPurchase extends BaseTask {
    private static final String PATTERN_REGULAR_CART_ITEMS = ":\\{.*?\\}";
    List<OddsEndUpdateEvent> oddsEndUpdateEvents;
    List<OddsQuardUpdateEvent> oddsQuardUpdateEvents;
    private int[] source;
    private String update;
    private Context context;
    public MultiPurchase(Context context, AsyncHttpClient client, List<OddsEndUpdateEvent> oddsEndUpdateEvents
            , List<OddsQuardUpdateEvent> oddsQuardUpdateEvents,int[] source,String update) {
        super(client);
        this.context=context;
        this.update=update;
        this.source=source;
        this.oddsEndUpdateEvents=oddsEndUpdateEvents;
        this.oddsQuardUpdateEvents=oddsQuardUpdateEvents;
    }

    @Override
    public void load() {
        if(Config.betTarget== BetTarget.END){
            if(oddsEndUpdateEvents.size()>0){
                if(Config.currentLevel>=Config.MAX_LEVEL){

                }
                else{
                    int count=Math.min(Config.betCount,oddsEndUpdateEvents.size());
                    for (int i = 0; i < count; i++) {

                    }
                }
            }
            else{

            }
        }
        else if(Config.betTarget==BetTarget.QUART){
            if(oddsQuardUpdateEvents.size()>0){

            }
            else{

            }
        }
        else if(Config.betTarget==BetTarget.QUART_FIRST){
            if(oddsQuardUpdateEvents.size()>0){

            }
            else if(oddsEndUpdateEvents.size()>0){

            }
            else{

            }
        }

    }

    private void getCartItem(String eventId,String lineId){
        RequestParams params = new RequestParams();
        params.put("items", "false,1," + eventId + "," + "," + lineId + "," + "1.9,0,0");
        Log.d("getRegularCartItems", "false,1," + eventId + "," + "," + lineId + "," + "1.9,0,0");
        client.post(POST_REGULAR_CART_ITEMS, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Pattern r = Pattern.compile(PATTERN_REGULAR_CART_ITEMS);
                Matcher m = r.matcher(responseString);
                if (m.find()) {
                    Log.d("getregular",m.group());
                    try {
                        String json = m.group().substring(1);
                        Gson gson = new Gson();
                        placeMultiPurchase(gson.fromJson(json, RegularCartItem.class));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void placeMultiPurchase(RegularCartItem item) throws UnsupportedEncodingException {
        Purchases purchases = new Purchases();
        ArrayList<PurchasesInfo> purchasesInfos = new ArrayList<>();
        PurchasesInfo purchasesInfo = new PurchasesInfo();
        ArrayList<Purchase> items = new ArrayList<>();
        Purchase purchase = new Purchase();

        //purchase.setMasterEventID(masterEventId);
        //purchase.setEventID(eventId);
        //purchase.setLineID(lineId);
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
        client.post(context, POST_MULTI_PURCHASE, stringEntity, "application/json; charset=utf-8", new TextHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("placeMultiPurchase", "onSuccess");
                Document doc = Jsoup.parse(responseString);
                Log.d("placeMultiPurchase", doc.outerHtml());

                // 去掉[]
                String temp = responseString.substring(1, responseString.length() - 1);
                Gson gson = new Gson();
                if (temp.charAt(2) == 'B') {// 成功

                } else if (temp.charAt(2) == 'S') {// 失败
                    Failures selections = gson.fromJson(temp, Failures.class);

                }

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
