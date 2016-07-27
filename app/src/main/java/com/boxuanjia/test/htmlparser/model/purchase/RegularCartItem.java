
package com.boxuanjia.test.htmlparser.model.purchase;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RegularCartItem {

    @SerializedName("BranchID")
    @Expose
    private Integer branchID;
    @SerializedName("BranchName")
    @Expose
    private String branchName;
    @SerializedName("ComboBetIsEnabled")
    @Expose
    private Integer comboBetIsEnabled;
    @SerializedName("comboRate")
    @Expose
    private Integer comboRate;
    @SerializedName("EventDate")
    @Expose
    private String eventDate;
    @SerializedName("EventName")
    @Expose
    private String eventName;
    @SerializedName("EventTypeID")
    @Expose
    private Integer eventTypeID;
    @SerializedName("EventTypeName")
    @Expose
    private String eventTypeName;
    @SerializedName("HasGameStarted")
    @Expose
    private Integer hasGameStarted;
    @SerializedName("IsTeamSwapEnabled")
    @Expose
    private Integer isTeamSwapEnabled;
    @SerializedName("LeagueID")
    @Expose
    private Integer leagueID;
    @SerializedName("LeagueName")
    @Expose
    private String leagueName;
    @SerializedName("LineName")
    @Expose
    private String lineName;
    @SerializedName("LineTypeID")
    @Expose
    private Integer lineTypeID;
    @SerializedName("LineTypeName")
    @Expose
    private String lineTypeName;
    @SerializedName("LiveGroupID")
    @Expose
    private Integer liveGroupID;
    @SerializedName("MappedLineTypeID")
    @Expose
    private Integer mappedLineTypeID;
    @SerializedName("maxBet")
    @Expose
    private Integer maxBet;
    @SerializedName("MaxBetCombo")
    @Expose
    private Integer maxBetCombo;
    @SerializedName("MaxBetSystem")
    @Expose
    private Double maxBetSystem;
    @SerializedName("MaxBetTeaser")
    @Expose
    private Double maxBetTeaser;
    @SerializedName("MaxGainCashier")
    @Expose
    private Integer maxGainCashier;
    @SerializedName("MaxRiskSystem")
    @Expose
    private Integer maxRiskSystem;
    @SerializedName("MaxRiskTeaser")
    @Expose
    private Integer maxRiskTeaser;
    @SerializedName("minBet")
    @Expose
    private Double minBet;
    @SerializedName("MinComboInPermutation")
    @Expose
    private Integer minComboInPermutation;
    @SerializedName("Odds")
    @Expose
    private Integer odds;
    @SerializedName("QAParameter1")
    @Expose
    private Integer qAParameter1;
    @SerializedName("QAParameter2")
    @Expose
    private Integer qAParameter2;
    @SerializedName("ScoreChanged")
    @Expose
    private List<Integer> scoreChanged = new ArrayList<Integer>();
    @SerializedName("SingleBetIsEnabled")
    @Expose
    private Integer singleBetIsEnabled;
    @SerializedName("SplitTypeID")
    @Expose
    private Integer splitTypeID;
    @SerializedName("SystemBetIsEnabled")
    @Expose
    private Integer systemBetIsEnabled;
    @SerializedName("Team1Name")
    @Expose
    private String team1Name;
    @SerializedName("Team2Name")
    @Expose
    private String team2Name;
    @SerializedName("TeaserBetIsEnabled")
    @Expose
    private Integer teaserBetIsEnabled;
    @SerializedName("UseEventName")
    @Expose
    private Integer useEventName;
    @SerializedName("waitingAllowed")
    @Expose
    private Integer waitingAllowed;

    /**
     *
     * @return
     *     The branchID
     */
    public Integer getBranchID() {
        return branchID;
    }

    /**
     *
     * @param branchID
     *     The BranchID
     */
    public void setBranchID(Integer branchID) {
        this.branchID = branchID;
    }

    /**
     *
     * @return
     *     The branchName
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     *
     * @param branchName
     *     The BranchName
     */
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    /**
     *
     * @return
     *     The comboBetIsEnabled
     */
    public Integer getComboBetIsEnabled() {
        return comboBetIsEnabled;
    }

    /**
     *
     * @param comboBetIsEnabled
     *     The ComboBetIsEnabled
     */
    public void setComboBetIsEnabled(Integer comboBetIsEnabled) {
        this.comboBetIsEnabled = comboBetIsEnabled;
    }

    /**
     *
     * @return
     *     The comboRate
     */
    public Integer getComboRate() {
        return comboRate;
    }

    /**
     *
     * @param comboRate
     *     The comboRate
     */
    public void setComboRate(Integer comboRate) {
        this.comboRate = comboRate;
    }

    /**
     *
     * @return
     *     The eventDate
     */
    public String getEventDate() {
        return eventDate;
    }

    /**
     *
     * @param eventDate
     *     The EventDate
     */
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    /**
     *
     * @return
     *     The eventName
     */
    public String getEventName() {
        return eventName;
    }

    /**
     *
     * @param eventName
     *     The EventName
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     *
     * @return
     *     The eventTypeID
     */
    public Integer getEventTypeID() {
        return eventTypeID;
    }

    /**
     *
     * @param eventTypeID
     *     The EventTypeID
     */
    public void setEventTypeID(Integer eventTypeID) {
        this.eventTypeID = eventTypeID;
    }

    /**
     *
     * @return
     *     The eventTypeName
     */
    public String getEventTypeName() {
        return eventTypeName;
    }

    /**
     *
     * @param eventTypeName
     *     The EventTypeName
     */
    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    /**
     *
     * @return
     *     The hasGameStarted
     */
    public Integer getHasGameStarted() {
        return hasGameStarted;
    }

    /**
     *
     * @param hasGameStarted
     *     The HasGameStarted
     */
    public void setHasGameStarted(Integer hasGameStarted) {
        this.hasGameStarted = hasGameStarted;
    }

    /**
     *
     * @return
     *     The isTeamSwapEnabled
     */
    public Integer getIsTeamSwapEnabled() {
        return isTeamSwapEnabled;
    }

    /**
     *
     * @param isTeamSwapEnabled
     *     The IsTeamSwapEnabled
     */
    public void setIsTeamSwapEnabled(Integer isTeamSwapEnabled) {
        this.isTeamSwapEnabled = isTeamSwapEnabled;
    }

    /**
     *
     * @return
     *     The leagueID
     */
    public Integer getLeagueID() {
        return leagueID;
    }

    /**
     *
     * @param leagueID
     *     The LeagueID
     */
    public void setLeagueID(Integer leagueID) {
        this.leagueID = leagueID;
    }

    /**
     *
     * @return
     *     The leagueName
     */
    public String getLeagueName() {
        return leagueName;
    }

    /**
     *
     * @param leagueName
     *     The LeagueName
     */
    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    /**
     *
     * @return
     *     The lineName
     */
    public String getLineName() {
        return lineName;
    }

    /**
     *
     * @param lineName
     *     The LineName
     */
    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    /**
     *
     * @return
     *     The lineTypeID
     */
    public Integer getLineTypeID() {
        return lineTypeID;
    }

    /**
     *
     * @param lineTypeID
     *     The LineTypeID
     */
    public void setLineTypeID(Integer lineTypeID) {
        this.lineTypeID = lineTypeID;
    }

    /**
     *
     * @return
     *     The lineTypeName
     */
    public String getLineTypeName() {
        return lineTypeName;
    }

    /**
     *
     * @param lineTypeName
     *     The LineTypeName
     */
    public void setLineTypeName(String lineTypeName) {
        this.lineTypeName = lineTypeName;
    }

    /**
     *
     * @return
     *     The liveGroupID
     */
    public Integer getLiveGroupID() {
        return liveGroupID;
    }

    /**
     *
     * @param liveGroupID
     *     The LiveGroupID
     */
    public void setLiveGroupID(Integer liveGroupID) {
        this.liveGroupID = liveGroupID;
    }

    /**
     *
     * @return
     *     The mappedLineTypeID
     */
    public Integer getMappedLineTypeID() {
        return mappedLineTypeID;
    }

    /**
     *
     * @param mappedLineTypeID
     *     The MappedLineTypeID
     */
    public void setMappedLineTypeID(Integer mappedLineTypeID) {
        this.mappedLineTypeID = mappedLineTypeID;
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
     *     The maxBet
     */
    public void setMaxBet(Integer maxBet) {
        this.maxBet = maxBet;
    }

    /**
     *
     * @return
     *     The maxBetCombo
     */
    public Integer getMaxBetCombo() {
        return maxBetCombo;
    }

    /**
     *
     * @param maxBetCombo
     *     The MaxBetCombo
     */
    public void setMaxBetCombo(Integer maxBetCombo) {
        this.maxBetCombo = maxBetCombo;
    }

    /**
     *
     * @return
     *     The maxBetSystem
     */
    public Double getMaxBetSystem() {
        return maxBetSystem;
    }

    /**
     *
     * @param maxBetSystem
     *     The MaxBetSystem
     */
    public void setMaxBetSystem(Double maxBetSystem) {
        this.maxBetSystem = maxBetSystem;
    }

    /**
     *
     * @return
     *     The maxBetTeaser
     */
    public Double getMaxBetTeaser() {
        return maxBetTeaser;
    }

    /**
     *
     * @param maxBetTeaser
     *     The MaxBetTeaser
     */
    public void setMaxBetTeaser(Double maxBetTeaser) {
        this.maxBetTeaser = maxBetTeaser;
    }

    /**
     *
     * @return
     *     The maxGainCashier
     */
    public Integer getMaxGainCashier() {
        return maxGainCashier;
    }

    /**
     *
     * @param maxGainCashier
     *     The MaxGainCashier
     */
    public void setMaxGainCashier(Integer maxGainCashier) {
        this.maxGainCashier = maxGainCashier;
    }

    /**
     *
     * @return
     *     The maxRiskSystem
     */
    public Integer getMaxRiskSystem() {
        return maxRiskSystem;
    }

    /**
     *
     * @param maxRiskSystem
     *     The MaxRiskSystem
     */
    public void setMaxRiskSystem(Integer maxRiskSystem) {
        this.maxRiskSystem = maxRiskSystem;
    }

    /**
     *
     * @return
     *     The maxRiskTeaser
     */
    public Integer getMaxRiskTeaser() {
        return maxRiskTeaser;
    }

    /**
     *
     * @param maxRiskTeaser
     *     The MaxRiskTeaser
     */
    public void setMaxRiskTeaser(Integer maxRiskTeaser) {
        this.maxRiskTeaser = maxRiskTeaser;
    }

    /**
     *
     * @return
     *     The minBet
     */
    public Double getMinBet() {
        return minBet;
    }

    /**
     *
     * @param minBet
     *     The minBet
     */
    public void setMinBet(Double minBet) {
        this.minBet = minBet;
    }

    /**
     *
     * @return
     *     The minComboInPermutation
     */
    public Integer getMinComboInPermutation() {
        return minComboInPermutation;
    }

    /**
     *
     * @param minComboInPermutation
     *     The MinComboInPermutation
     */
    public void setMinComboInPermutation(Integer minComboInPermutation) {
        this.minComboInPermutation = minComboInPermutation;
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
     *     The qAParameter1
     */
    public Integer getQAParameter1() {
        return qAParameter1;
    }

    /**
     *
     * @param qAParameter1
     *     The QAParameter1
     */
    public void setQAParameter1(Integer qAParameter1) {
        this.qAParameter1 = qAParameter1;
    }

    /**
     *
     * @return
     *     The qAParameter2
     */
    public Integer getQAParameter2() {
        return qAParameter2;
    }

    /**
     *
     * @param qAParameter2
     *     The QAParameter2
     */
    public void setQAParameter2(Integer qAParameter2) {
        this.qAParameter2 = qAParameter2;
    }

    /**
     *
     * @return
     *     The scoreChanged
     */
    public List<Integer> getScoreChanged() {
        return scoreChanged;
    }

    /**
     *
     * @param scoreChanged
     *     The ScoreChanged
     */
    public void setScoreChanged(List<Integer> scoreChanged) {
        this.scoreChanged = scoreChanged;
    }

    /**
     *
     * @return
     *     The singleBetIsEnabled
     */
    public Integer getSingleBetIsEnabled() {
        return singleBetIsEnabled;
    }

    /**
     *
     * @param singleBetIsEnabled
     *     The SingleBetIsEnabled
     */
    public void setSingleBetIsEnabled(Integer singleBetIsEnabled) {
        this.singleBetIsEnabled = singleBetIsEnabled;
    }

    /**
     *
     * @return
     *     The splitTypeID
     */
    public Integer getSplitTypeID() {
        return splitTypeID;
    }

    /**
     *
     * @param splitTypeID
     *     The SplitTypeID
     */
    public void setSplitTypeID(Integer splitTypeID) {
        this.splitTypeID = splitTypeID;
    }

    /**
     *
     * @return
     *     The systemBetIsEnabled
     */
    public Integer getSystemBetIsEnabled() {
        return systemBetIsEnabled;
    }

    /**
     *
     * @param systemBetIsEnabled
     *     The SystemBetIsEnabled
     */
    public void setSystemBetIsEnabled(Integer systemBetIsEnabled) {
        this.systemBetIsEnabled = systemBetIsEnabled;
    }

    /**
     *
     * @return
     *     The team1Name
     */
    public String getTeam1Name() {
        return team1Name;
    }

    /**
     *
     * @param team1Name
     *     The Team1Name
     */
    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    /**
     *
     * @return
     *     The team2Name
     */
    public String getTeam2Name() {
        return team2Name;
    }

    /**
     *
     * @param team2Name
     *     The Team2Name
     */
    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }

    /**
     *
     * @return
     *     The teaserBetIsEnabled
     */
    public Integer getTeaserBetIsEnabled() {
        return teaserBetIsEnabled;
    }

    /**
     *
     * @param teaserBetIsEnabled
     *     The TeaserBetIsEnabled
     */
    public void setTeaserBetIsEnabled(Integer teaserBetIsEnabled) {
        this.teaserBetIsEnabled = teaserBetIsEnabled;
    }

    /**
     *
     * @return
     *     The useEventName
     */
    public Integer getUseEventName() {
        return useEventName;
    }

    /**
     *
     * @param useEventName
     *     The UseEventName
     */
    public void setUseEventName(Integer useEventName) {
        this.useEventName = useEventName;
    }

    /**
     *
     * @return
     *     The waitingAllowed
     */
    public Integer getWaitingAllowed() {
        return waitingAllowed;
    }

    /**
     *
     * @param waitingAllowed
     *     The waitingAllowed
     */
    public void setWaitingAllowed(Integer waitingAllowed) {
        this.waitingAllowed = waitingAllowed;
    }

}
