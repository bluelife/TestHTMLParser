
package com.boxuanjia.autobet.model.success;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Success {

    @SerializedName("Bets")
    @Expose
    private List<Bet> bets = new ArrayList<Bet>();
    @SerializedName("ComboBonuses")
    @Expose
    private ComboBonuses comboBonuses;
    @SerializedName("PurchaseID")
    @Expose
    private String purchaseID;
    @SerializedName("Selections")
    @Expose
    private List<Selection> selections = new ArrayList<Selection>();
    @SerializedName("Status")
    @Expose
    private Integer status;
    @SerializedName("WBID")
    @Expose
    private String wBID;

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

    /**
     * 
     * @return
     *     The status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The Status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The wBID
     */
    public String getWBID() {
        return wBID;
    }

    /**
     * 
     * @param wBID
     *     The WBID
     */
    public void setWBID(String wBID) {
        this.wBID = wBID;
    }

}
