
package com.boxuanjia.autobet.model.history;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SPBet {

    @SerializedName("Bets")
    @Expose
    private List<Bet> bets = new ArrayList<Bet>();
    @SerializedName("ComboBonuses")
    @Expose
    private ComboBonuses comboBonuses;
    @SerializedName("CurrencyCode")
    @Expose
    private String currencyCode;
    @SerializedName("CurrentBalance")
    @Expose
    private Integer currentBalance;
    @SerializedName("CustomerID")
    @Expose
    private Integer customerID;
    @SerializedName("ExternalTicketID")
    @Expose
    private Object externalTicketID;
    @SerializedName("IsPurchase")
    @Expose
    private Integer isPurchase;
    @SerializedName("JSONProperties")
    @Expose
    private String jSONProperties;
    @SerializedName("OddStyleID")
    @Expose
    private Integer oddStyleID;
    @SerializedName("PurchaseDate")
    @Expose
    private String purchaseDate;
    @SerializedName("PurchaseID")
    @Expose
    private String purchaseID;
    @SerializedName("PurchaseStatus")
    @Expose
    private Integer purchaseStatus;
    @SerializedName("Selections")
    @Expose
    private List<Selection> selections = new ArrayList<Selection>();

    /**
     * 
     * @return
     *     The bets
     */
    public List<Bet> getBets() {
        return bets;
    }

    /**
     * 
     * @param bets
     *     The Bets
     */
    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    /**
     * 
     * @return
     *     The comboBonuses
     */
    public ComboBonuses getComboBonuses() {
        return comboBonuses;
    }

    /**
     * 
     * @param comboBonuses
     *     The ComboBonuses
     */
    public void setComboBonuses(ComboBonuses comboBonuses) {
        this.comboBonuses = comboBonuses;
    }

    /**
     * 
     * @return
     *     The currencyCode
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * 
     * @param currencyCode
     *     The CurrencyCode
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * 
     * @return
     *     The currentBalance
     */
    public Integer getCurrentBalance() {
        return currentBalance;
    }

    /**
     * 
     * @param currentBalance
     *     The CurrentBalance
     */
    public void setCurrentBalance(Integer currentBalance) {
        this.currentBalance = currentBalance;
    }

    /**
     * 
     * @return
     *     The customerID
     */
    public Integer getCustomerID() {
        return customerID;
    }

    /**
     * 
     * @param customerID
     *     The CustomerID
     */
    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    /**
     * 
     * @return
     *     The externalTicketID
     */
    public Object getExternalTicketID() {
        return externalTicketID;
    }

    /**
     * 
     * @param externalTicketID
     *     The ExternalTicketID
     */
    public void setExternalTicketID(Object externalTicketID) {
        this.externalTicketID = externalTicketID;
    }

    /**
     * 
     * @return
     *     The isPurchase
     */
    public Integer getIsPurchase() {
        return isPurchase;
    }

    /**
     * 
     * @param isPurchase
     *     The IsPurchase
     */
    public void setIsPurchase(Integer isPurchase) {
        this.isPurchase = isPurchase;
    }

    /**
     * 
     * @return
     *     The jSONProperties
     */
    public String getJSONProperties() {
        return jSONProperties;
    }

    /**
     * 
     * @param jSONProperties
     *     The JSONProperties
     */
    public void setJSONProperties(String jSONProperties) {
        this.jSONProperties = jSONProperties;
    }

    /**
     * 
     * @return
     *     The oddStyleID
     */
    public Integer getOddStyleID() {
        return oddStyleID;
    }

    /**
     * 
     * @param oddStyleID
     *     The OddStyleID
     */
    public void setOddStyleID(Integer oddStyleID) {
        this.oddStyleID = oddStyleID;
    }

    /**
     * 
     * @return
     *     The purchaseDate
     */
    public String getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * 
     * @param purchaseDate
     *     The PurchaseDate
     */
    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    /**
     * 
     * @return
     *     The purchaseID
     */
    public String getPurchaseID() {
        return purchaseID;
    }

    /**
     * 
     * @param purchaseID
     *     The PurchaseID
     */
    public void setPurchaseID(String purchaseID) {
        this.purchaseID = purchaseID;
    }

    /**
     * 
     * @return
     *     The purchaseStatus
     */
    public Integer getPurchaseStatus() {
        return purchaseStatus;
    }

    /**
     * 
     * @param purchaseStatus
     *     The PurchaseStatus
     */
    public void setPurchaseStatus(Integer purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    /**
     * 
     * @return
     *     The selections
     */
    public List<Selection> getSelections() {
        return selections;
    }

    /**
     * 
     * @param selections
     *     The Failures
     */
    public void setSelections(List<Selection> selections) {
        this.selections = selections;
    }

}
