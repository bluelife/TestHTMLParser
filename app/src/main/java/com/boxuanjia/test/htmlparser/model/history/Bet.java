
package com.boxuanjia.test.htmlparser.model.history;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bet {

    @SerializedName("BetID")
    @Expose
    private String betID;
    @SerializedName("Commission")
    @Expose
    private Integer commission;
    @SerializedName("CurrentBalance")
    @Expose
    private Integer currentBalance;
    @SerializedName("DeadHeatDeposit")
    @Expose
    private Integer deadHeatDeposit;
    @SerializedName("GeneratedID")
    @Expose
    private Integer generatedID;
    @SerializedName("ProfitLoss")
    @Expose
    private Integer profitLoss;
    @SerializedName("StatusID")
    @Expose
    private Integer statusID;
    @SerializedName("TaxAmount")
    @Expose
    private Integer taxAmount;
    @SerializedName("TaxPercent")
    @Expose
    private Integer taxPercent;

    /**
     * 
     * @return
     *     The betID
     */
    public String getBetID() {
        return betID;
    }

    /**
     * 
     * @param betID
     *     The BetID
     */
    public void setBetID(String betID) {
        this.betID = betID;
    }

    /**
     *
     * @return
     *     The commission
     */
    public Integer getCommission() {
        return commission;
    }

    /**
     *
     * @param commission
     *     The Commission
     */
    public void setCommission(Integer commission) {
        this.commission = commission;
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
     *     The deadHeatDeposit
     */
    public Integer getDeadHeatDeposit() {
        return deadHeatDeposit;
    }

    /**
     *
     * @param deadHeatDeposit
     *     The DeadHeatDeposit
     */
    public void setDeadHeatDeposit(Integer deadHeatDeposit) {
        this.deadHeatDeposit = deadHeatDeposit;
    }

    /**
     *
     * @return
     *     The generatedID
     */
    public Integer getGeneratedID() {
        return generatedID;
    }

    /**
     *
     * @param generatedID
     *     The GeneratedID
     */
    public void setGeneratedID(Integer generatedID) {
        this.generatedID = generatedID;
    }

    /**
     *
     * @return
     *     The profitLoss
     */
    public Integer getProfitLoss() {
        return profitLoss;
    }

    /**
     *
     * @param profitLoss
     *     The ProfitLoss
     */
    public void setProfitLoss(Integer profitLoss) {
        this.profitLoss = profitLoss;
    }

    /**
     *
     * @return
     *     The statusID
     */
    public Integer getStatusID() {
        return statusID;
    }

    /**
     *
     * @param statusID
     *     The StatusID
     */
    public void setStatusID(Integer statusID) {
        this.statusID = statusID;
    }

    /**
     *
     * @return
     *     The taxAmount
     */
    public Integer getTaxAmount() {
        return taxAmount;
    }

    /**
     *
     * @param taxAmount
     *     The TaxAmount
     */
    public void setTaxAmount(Integer taxAmount) {
        this.taxAmount = taxAmount;
    }

    /**
     *
     * @return
     *     The taxPercent
     */
    public Integer getTaxPercent() {
        return taxPercent;
    }

    /**
     *
     * @param taxPercent
     *     The TaxPercent
     */
    public void setTaxPercent(Integer taxPercent) {
        this.taxPercent = taxPercent;
    }

}
