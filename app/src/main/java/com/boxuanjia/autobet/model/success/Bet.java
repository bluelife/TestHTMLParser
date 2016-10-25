
package com.boxuanjia.autobet.model.success;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bet {

    @SerializedName("BetID")
    @Expose
    private Integer betID;
    @SerializedName("BetName")
    @Expose
    private Object betName;
    @SerializedName("BetTypeID")
    @Expose
    private Integer betTypeID;
    @SerializedName("ComboSize")
    @Expose
    private Integer comboSize;
    @SerializedName("FreeBetID")
    @Expose
    private Integer freeBetID;
    @SerializedName("FreeBetStake")
    @Expose
    private Integer freeBetStake;
    @SerializedName("Gain")
    @Expose
    private Double gain;
    @SerializedName("IsLive")
    @Expose
    private Integer isLive;
    @SerializedName("Mappings")
    @Expose
    private List<Mapping> mappings = new ArrayList<Mapping>();
    @SerializedName("MaxBet")
    @Expose
    private Integer maxBet;
    @SerializedName("NumberOfBets")
    @Expose
    private Integer numberOfBets;
    @SerializedName("Odds")
    @Expose
    private Integer odds;
    @SerializedName("Stake")
    @Expose
    private Integer stake;

    /**
     * 
     * @return
     *     The betID
     */
    public Integer getBetID() {
        return betID;
    }

    /**
     * 
     * @param betID
     *     The BetID
     */
    public void setBetID(Integer betID) {
        this.betID = betID;
    }

    /**
     * 
     * @return
     *     The betName
     */
    public Object getBetName() {
        return betName;
    }

    /**
     * 
     * @param betName
     *     The BetName
     */
    public void setBetName(Object betName) {
        this.betName = betName;
    }

    /**
     * 
     * @return
     *     The betTypeID
     */
    public Integer getBetTypeID() {
        return betTypeID;
    }

    /**
     * 
     * @param betTypeID
     *     The BetTypeID
     */
    public void setBetTypeID(Integer betTypeID) {
        this.betTypeID = betTypeID;
    }

    /**
     * 
     * @return
     *     The comboSize
     */
    public Integer getComboSize() {
        return comboSize;
    }

    /**
     * 
     * @param comboSize
     *     The ComboSize
     */
    public void setComboSize(Integer comboSize) {
        this.comboSize = comboSize;
    }

    /**
     * 
     * @return
     *     The freeBetID
     */
    public Integer getFreeBetID() {
        return freeBetID;
    }

    /**
     * 
     * @param freeBetID
     *     The FreeBetID
     */
    public void setFreeBetID(Integer freeBetID) {
        this.freeBetID = freeBetID;
    }

    /**
     * 
     * @return
     *     The freeBetStake
     */
    public Integer getFreeBetStake() {
        return freeBetStake;
    }

    /**
     * 
     * @param freeBetStake
     *     The FreeBetStake
     */
    public void setFreeBetStake(Integer freeBetStake) {
        this.freeBetStake = freeBetStake;
    }

    /**
     * 
     * @return
     *     The gain
     */
    public Double getGain() {
        return gain;
    }

    /**
     * 
     * @param gain
     *     The Gain
     */
    public void setGain(Double gain) {
        this.gain = gain;
    }

    /**
     * 
     * @return
     *     The isLive
     */
    public Integer getIsLive() {
        return isLive;
    }

    /**
     * 
     * @param isLive
     *     The IsLive
     */
    public void setIsLive(Integer isLive) {
        this.isLive = isLive;
    }

    /**
     * 
     * @return
     *     The mappings
     */
    public List<Mapping> getMappings() {
        return mappings;
    }

    /**
     * 
     * @param mappings
     *     The Mappings
     */
    public void setMappings(List<Mapping> mappings) {
        this.mappings = mappings;
    }

    /**
     * 
     * @return
     *     The maxBet
     */
    public Integer getMaxBet() {
        return maxBet;
    }

    /**
     * 
     * @param maxBet
     *     The MaxBet
     */
    public void setMaxBet(Integer maxBet) {
        this.maxBet = maxBet;
    }

    /**
     * 
     * @return
     *     The numberOfBets
     */
    public Integer getNumberOfBets() {
        return numberOfBets;
    }

    /**
     * 
     * @param numberOfBets
     *     The NumberOfBets
     */
    public void setNumberOfBets(Integer numberOfBets) {
        this.numberOfBets = numberOfBets;
    }

    /**
     * 
     * @return
     *     The odds
     */
    public Integer getOdds() {
        return odds;
    }

    /**
     * 
     * @param odds
     *     The Odds
     */
    public void setOdds(Integer odds) {
        this.odds = odds;
    }

    /**
     * 
     * @return
     *     The stake
     */
    public Integer getStake() {
        return stake;
    }

    /**
     * 
     * @param stake
     *     The Stake
     */
    public void setStake(Integer stake) {
        this.stake = stake;
    }

}
