package com.boxuanjia.test.htmlparser.model.purchase;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by boxuanjia on 16/7/21.
 */
public class PurchasesInfo {

    @SerializedName("selections")
    @Expose
    private ArrayList<Purchase> mPurchases = new ArrayList<>();
    @SerializedName("deposits")
    @Expose
    private Deposits deposits = new Deposits();
    @SerializedName("oddStyleIDFromClient")
    @Expose
    private Integer oddStyleIDFromClient = 1;
    @SerializedName("eachWayData")
    @Expose
    private String eachWayData = null;
    @SerializedName("teaserType")
    @Expose
    private String teaserType = null;
    @SerializedName("systemKey")
    @Expose
    private String systemKey = null;
    @SerializedName("multiLineData")
    @Expose
    private String multiLineData = null;
    @SerializedName("PurchaseTypeID")
    @Expose
    private Integer purchaseTypeID = 1;
    @SerializedName("FreeBets")
    @Expose
    private List<String> freeBets = new ArrayList<>();
    @SerializedName("BetNames")
    @Expose
    private List<String> betNames = new ArrayList<>();
    @SerializedName("SystemBetNames")
    @Expose
    private String systemBetNames = null;
    @SerializedName("ComboFreeBets")
    @Expose
    private String comboFreeBets = null;
    @SerializedName("TeaserFreeBet")
    @Expose
    private String teaserFreeBet = null;
    @SerializedName("eachWaySystemUKData")
    @Expose
    private String eachWaySystemUKData = null;
    @SerializedName("ComboBonuses")
    @Expose
    private ComboBonuses comboBonuses;

    public ArrayList<Purchase> getPurchases() {
        return mPurchases;
    }

    public void setPurchases(ArrayList<Purchase> purchases) {
        mPurchases = purchases;
    }

    public Deposits getDeposits() {
        return deposits;
    }

    public void setDeposits(Deposits deposits) {
        this.deposits = deposits;
    }

    public Integer getOddStyleIDFromClient() {
        return oddStyleIDFromClient;
    }

    public void setOddStyleIDFromClient(Integer oddStyleIDFromClient) {
        this.oddStyleIDFromClient = oddStyleIDFromClient;
    }

    public String getEachWayData() {
        return eachWayData;
    }

    public void setEachWayData(String eachWayData) {
        this.eachWayData = eachWayData;
    }

    public String getTeaserType() {
        return teaserType;
    }

    public void setTeaserType(String teaserType) {
        this.teaserType = teaserType;
    }

    public String getSystemKey() {
        return systemKey;
    }

    public void setSystemKey(String systemKey) {
        this.systemKey = systemKey;
    }

    public String getMultiLineData() {
        return multiLineData;
    }

    public void setMultiLineData(String multiLineData) {
        this.multiLineData = multiLineData;
    }

    public Integer getPurchaseTypeID() {
        return purchaseTypeID;
    }

    public void setPurchaseTypeID(Integer purchaseTypeID) {
        this.purchaseTypeID = purchaseTypeID;
    }

    public List<String> getFreeBets() {
        return freeBets;
    }

    public void setFreeBets(List<String> freeBets) {
        this.freeBets = freeBets;
    }

    public List<String> getBetNames() {
        return betNames;
    }

    public void setBetNames(List<String> betNames) {
        this.betNames = betNames;
    }

    public String getSystemBetNames() {
        return systemBetNames;
    }

    public void setSystemBetNames(String systemBetNames) {
        this.systemBetNames = systemBetNames;
    }

    public String getComboFreeBets() {
        return comboFreeBets;
    }

    public void setComboFreeBets(String comboFreeBets) {
        this.comboFreeBets = comboFreeBets;
    }

    public String getTeaserFreeBet() {
        return teaserFreeBet;
    }

    public void setTeaserFreeBet(String teaserFreeBet) {
        this.teaserFreeBet = teaserFreeBet;
    }

    public String getEachWaySystemUKData() {
        return eachWaySystemUKData;
    }

    public void setEachWaySystemUKData(String eachWaySystemUKData) {
        this.eachWaySystemUKData = eachWaySystemUKData;
    }

    public ComboBonuses getComboBonuses() {
        return comboBonuses;
    }

    public void setComboBonuses(ComboBonuses comboBonuses) {
        this.comboBonuses = comboBonuses;
    }
}
