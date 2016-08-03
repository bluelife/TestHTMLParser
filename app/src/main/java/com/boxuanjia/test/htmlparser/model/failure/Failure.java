
package com.boxuanjia.test.htmlparser.model.failure;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Failure {

    @SerializedName("AlternateLineFractOdds")
    @Expose
    private String alternateLineFractOdds;
    @SerializedName("AlternateLineID")
    @Expose
    private Integer alternateLineID;
    @SerializedName("AlternateLineOdds")
    @Expose
    private Integer alternateLineOdds;
    @SerializedName("AlternateLineTypeID")
    @Expose
    private Integer alternateLineTypeID;
    @SerializedName("BetSide")
    @Expose
    private Integer betSide;
    @SerializedName("BetTypeID")
    @Expose
    private Integer betTypeID;
    @SerializedName("BranchID")
    @Expose
    private Integer branchID;
    @SerializedName("BranchName")
    @Expose
    private String branchName;
    @SerializedName("BuyPoints")
    @Expose
    private List<Object> buyPoints = new ArrayList<Object>();
    @SerializedName("ComboBetIsEnabled")
    @Expose
    private Integer comboBetIsEnabled;
    @SerializedName("comboRate")
    @Expose
    private Integer comboRate;
    @SerializedName("EachWayIncluded")
    @Expose
    private Integer eachWayIncluded;
    @SerializedName("EachWayTermsID")
    @Expose
    private Integer eachWayTermsID;
    @SerializedName("ErrorMessage")
    @Expose
    private String errorMessage;
    @SerializedName("ErrorText")
    @Expose
    private String errorText;
    @SerializedName("EventID")
    @Expose
    private Integer eventID;
    @SerializedName("EventName")
    @Expose
    private String eventName;
    @SerializedName("EventTypeID")
    @Expose
    private Integer eventTypeID;
    @SerializedName("EventTypeName")
    @Expose
    private String eventTypeName;
    @SerializedName("FractionalOdds")
    @Expose
    private String fractionalOdds;
    @SerializedName("FractOddsDividend")
    @Expose
    private Integer fractOddsDividend;
    @SerializedName("FractOddsDivisor")
    @Expose
    private Integer fractOddsDivisor;
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("IsEachWaySelection")
    @Expose
    private Integer isEachWaySelection;
    @SerializedName("IsSameEventInComboAllowed")
    @Expose
    private Integer isSameEventInComboAllowed;
    @SerializedName("IsTeamSwapEnabled")
    @Expose
    private Integer isTeamSwapEnabled;
    @SerializedName("LeagueID")
    @Expose
    private Integer leagueID;
    @SerializedName("LeagueName")
    @Expose
    private String leagueName;
    @SerializedName("LineGroupID")
    @Expose
    private Integer lineGroupID;
    @SerializedName("LineID")
    @Expose
    private Integer lineID;
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
    @SerializedName("MasterEventID")
    @Expose
    private Integer masterEventID;
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
    @SerializedName("MaxRisk")
    @Expose
    private Integer maxRisk;
    @SerializedName("MaxRiskCombo")
    @Expose
    private Integer maxRiskCombo;
    @SerializedName("MaxRiskComboEachWay")
    @Expose
    private Integer maxRiskComboEachWay;
    @SerializedName("MaxRiskSystem")
    @Expose
    private Integer maxRiskSystem;
    @SerializedName("MaxRiskTeaser")
    @Expose
    private Integer maxRiskTeaser;
    @SerializedName("MaxStakeComboEachWay")
    @Expose
    private Integer maxStakeComboEachWay;
    @SerializedName("maxWin")
    @Expose
    private Integer maxWin;
    @SerializedName("minBet")
    @Expose
    private Double minBet;
    @SerializedName("Odds")
    @Expose
    private Integer odds;
    @SerializedName("OddsTermsID")
    @Expose
    private Integer oddsTermsID;
    @SerializedName("PlaceTermsID")
    @Expose
    private Integer placeTermsID;
    @SerializedName("Points")
    @Expose
    private Object points;
    @SerializedName("PreLiveGroupID")
    @Expose
    private Integer preLiveGroupID;
    @SerializedName("QAParameter1")
    @Expose
    private Integer qAParameter1;
    @SerializedName("QAParameter2")
    @Expose
    private Integer qAParameter2;
    @SerializedName("ReleatedToID")
    @Expose
    private Integer releatedToID;
    @SerializedName("RowTypeID")
    @Expose
    private Integer rowTypeID;
    @SerializedName("SingleBetIsEnabled")
    @Expose
    private Integer singleBetIsEnabled;
    @SerializedName("SingleSelectionRisk")
    @Expose
    private Integer singleSelectionRisk;
    @SerializedName("SplitTypeID")
    @Expose
    private Integer splitTypeID;
    @SerializedName("Status")
    @Expose
    private Integer status;
    @SerializedName("SystemBetIsEnabled")
    @Expose
    private Integer systemBetIsEnabled;
    @SerializedName("Team1Name")
    @Expose
    private String team1Name;
    @SerializedName("Team2Name")
    @Expose
    private String team2Name;
    @SerializedName("TeamMappingID")
    @Expose
    private Integer teamMappingID;
    @SerializedName("TeaserBetIsEnabled")
    @Expose
    private Integer teaserBetIsEnabled;
    @SerializedName("userCurrency")
    @Expose
    private String userCurrency;
    @SerializedName("ViewKey")
    @Expose
    private Integer viewKey;
    @SerializedName("waitingAllowed")
    @Expose
    private Integer waitingAllowed;

    /**
     * 
     * @return
     *     The alternateLineFractOdds
     */
    public String getAlternateLineFractOdds() {
        return alternateLineFractOdds;
    }

    /**
     * 
     * @param alternateLineFractOdds
     *     The AlternateLineFractOdds
     */
    public void setAlternateLineFractOdds(String alternateLineFractOdds) {
        this.alternateLineFractOdds = alternateLineFractOdds;
    }

    /**
     * 
     * @return
     *     The alternateLineID
     */
    public Integer getAlternateLineID() {
        return alternateLineID;
    }

    /**
     * 
     * @param alternateLineID
     *     The AlternateLineID
     */
    public void setAlternateLineID(Integer alternateLineID) {
        this.alternateLineID = alternateLineID;
    }

    /**
     * 
     * @return
     *     The alternateLineOdds
     */
    public Integer getAlternateLineOdds() {
        return alternateLineOdds;
    }

    /**
     * 
     * @param alternateLineOdds
     *     The AlternateLineOdds
     */
    public void setAlternateLineOdds(Integer alternateLineOdds) {
        this.alternateLineOdds = alternateLineOdds;
    }

    /**
     * 
     * @return
     *     The alternateLineTypeID
     */
    public Integer getAlternateLineTypeID() {
        return alternateLineTypeID;
    }

    /**
     * 
     * @param alternateLineTypeID
     *     The AlternateLineTypeID
     */
    public void setAlternateLineTypeID(Integer alternateLineTypeID) {
        this.alternateLineTypeID = alternateLineTypeID;
    }

    /**
     * 
     * @return
     *     The betSide
     */
    public Integer getBetSide() {
        return betSide;
    }

    /**
     * 
     * @param betSide
     *     The BetSide
     */
    public void setBetSide(Integer betSide) {
        this.betSide = betSide;
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
     *     The buyPoints
     */
    public List<Object> getBuyPoints() {
        return buyPoints;
    }

    /**
     * 
     * @param buyPoints
     *     The BuyPoints
     */
    public void setBuyPoints(List<Object> buyPoints) {
        this.buyPoints = buyPoints;
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
     *     The eachWayIncluded
     */
    public Integer getEachWayIncluded() {
        return eachWayIncluded;
    }

    /**
     * 
     * @param eachWayIncluded
     *     The EachWayIncluded
     */
    public void setEachWayIncluded(Integer eachWayIncluded) {
        this.eachWayIncluded = eachWayIncluded;
    }

    /**
     * 
     * @return
     *     The eachWayTermsID
     */
    public Integer getEachWayTermsID() {
        return eachWayTermsID;
    }

    /**
     * 
     * @param eachWayTermsID
     *     The EachWayTermsID
     */
    public void setEachWayTermsID(Integer eachWayTermsID) {
        this.eachWayTermsID = eachWayTermsID;
    }

    /**
     * 
     * @return
     *     The errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * 
     * @param errorMessage
     *     The ErrorMessage
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * 
     * @return
     *     The errorText
     */
    public String getErrorText() {
        return errorText;
    }

    /**
     * 
     * @param errorText
     *     The ErrorText
     */
    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    /**
     * 
     * @return
     *     The eventID
     */
    public Integer getEventID() {
        return eventID;
    }

    /**
     * 
     * @param eventID
     *     The EventID
     */
    public void setEventID(Integer eventID) {
        this.eventID = eventID;
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
     *     The fractionalOdds
     */
    public String getFractionalOdds() {
        return fractionalOdds;
    }

    /**
     * 
     * @param fractionalOdds
     *     The FractionalOdds
     */
    public void setFractionalOdds(String fractionalOdds) {
        this.fractionalOdds = fractionalOdds;
    }

    /**
     * 
     * @return
     *     The fractOddsDividend
     */
    public Integer getFractOddsDividend() {
        return fractOddsDividend;
    }

    /**
     * 
     * @param fractOddsDividend
     *     The FractOddsDividend
     */
    public void setFractOddsDividend(Integer fractOddsDividend) {
        this.fractOddsDividend = fractOddsDividend;
    }

    /**
     * 
     * @return
     *     The fractOddsDivisor
     */
    public Integer getFractOddsDivisor() {
        return fractOddsDivisor;
    }

    /**
     * 
     * @param fractOddsDivisor
     *     The FractOddsDivisor
     */
    public void setFractOddsDivisor(Integer fractOddsDivisor) {
        this.fractOddsDivisor = fractOddsDivisor;
    }

    /**
     * 
     * @return
     *     The iD
     */
    public Integer getID() {
        return iD;
    }

    /**
     * 
     * @param iD
     *     The ID
     */
    public void setID(Integer iD) {
        this.iD = iD;
    }

    /**
     * 
     * @return
     *     The isEachWaySelection
     */
    public Integer getIsEachWaySelection() {
        return isEachWaySelection;
    }

    /**
     * 
     * @param isEachWaySelection
     *     The IsEachWaySelection
     */
    public void setIsEachWaySelection(Integer isEachWaySelection) {
        this.isEachWaySelection = isEachWaySelection;
    }

    /**
     * 
     * @return
     *     The isSameEventInComboAllowed
     */
    public Integer getIsSameEventInComboAllowed() {
        return isSameEventInComboAllowed;
    }

    /**
     * 
     * @param isSameEventInComboAllowed
     *     The IsSameEventInComboAllowed
     */
    public void setIsSameEventInComboAllowed(Integer isSameEventInComboAllowed) {
        this.isSameEventInComboAllowed = isSameEventInComboAllowed;
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
     *     The lineGroupID
     */
    public Integer getLineGroupID() {
        return lineGroupID;
    }

    /**
     * 
     * @param lineGroupID
     *     The LineGroupID
     */
    public void setLineGroupID(Integer lineGroupID) {
        this.lineGroupID = lineGroupID;
    }

    /**
     * 
     * @return
     *     The lineID
     */
    public Integer getLineID() {
        return lineID;
    }

    /**
     * 
     * @param lineID
     *     The LineID
     */
    public void setLineID(Integer lineID) {
        this.lineID = lineID;
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
     *     The masterEventID
     */
    public Integer getMasterEventID() {
        return masterEventID;
    }

    /**
     * 
     * @param masterEventID
     *     The MasterEventID
     */
    public void setMasterEventID(Integer masterEventID) {
        this.masterEventID = masterEventID;
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
     *     The maxRisk
     */
    public Integer getMaxRisk() {
        return maxRisk;
    }

    /**
     * 
     * @param maxRisk
     *     The MaxRisk
     */
    public void setMaxRisk(Integer maxRisk) {
        this.maxRisk = maxRisk;
    }

    /**
     * 
     * @return
     *     The maxRiskCombo
     */
    public Integer getMaxRiskCombo() {
        return maxRiskCombo;
    }

    /**
     * 
     * @param maxRiskCombo
     *     The MaxRiskCombo
     */
    public void setMaxRiskCombo(Integer maxRiskCombo) {
        this.maxRiskCombo = maxRiskCombo;
    }

    /**
     * 
     * @return
     *     The maxRiskComboEachWay
     */
    public Integer getMaxRiskComboEachWay() {
        return maxRiskComboEachWay;
    }

    /**
     * 
     * @param maxRiskComboEachWay
     *     The MaxRiskComboEachWay
     */
    public void setMaxRiskComboEachWay(Integer maxRiskComboEachWay) {
        this.maxRiskComboEachWay = maxRiskComboEachWay;
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
     *     The maxStakeComboEachWay
     */
    public Integer getMaxStakeComboEachWay() {
        return maxStakeComboEachWay;
    }

    /**
     * 
     * @param maxStakeComboEachWay
     *     The MaxStakeComboEachWay
     */
    public void setMaxStakeComboEachWay(Integer maxStakeComboEachWay) {
        this.maxStakeComboEachWay = maxStakeComboEachWay;
    }

    /**
     * 
     * @return
     *     The maxWin
     */
    public Integer getMaxWin() {
        return maxWin;
    }

    /**
     * 
     * @param maxWin
     *     The maxWin
     */
    public void setMaxWin(Integer maxWin) {
        this.maxWin = maxWin;
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
     *     The oddsTermsID
     */
    public Integer getOddsTermsID() {
        return oddsTermsID;
    }

    /**
     * 
     * @param oddsTermsID
     *     The OddsTermsID
     */
    public void setOddsTermsID(Integer oddsTermsID) {
        this.oddsTermsID = oddsTermsID;
    }

    /**
     * 
     * @return
     *     The placeTermsID
     */
    public Integer getPlaceTermsID() {
        return placeTermsID;
    }

    /**
     * 
     * @param placeTermsID
     *     The PlaceTermsID
     */
    public void setPlaceTermsID(Integer placeTermsID) {
        this.placeTermsID = placeTermsID;
    }

    /**
     * 
     * @return
     *     The points
     */
    public Object getPoints() {
        return points;
    }

    /**
     * 
     * @param points
     *     The Points
     */
    public void setPoints(Object points) {
        this.points = points;
    }

    /**
     * 
     * @return
     *     The preLiveGroupID
     */
    public Integer getPreLiveGroupID() {
        return preLiveGroupID;
    }

    /**
     * 
     * @param preLiveGroupID
     *     The PreLiveGroupID
     */
    public void setPreLiveGroupID(Integer preLiveGroupID) {
        this.preLiveGroupID = preLiveGroupID;
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
     *     The releatedToID
     */
    public Integer getReleatedToID() {
        return releatedToID;
    }

    /**
     * 
     * @param releatedToID
     *     The ReleatedToID
     */
    public void setReleatedToID(Integer releatedToID) {
        this.releatedToID = releatedToID;
    }

    /**
     * 
     * @return
     *     The rowTypeID
     */
    public Integer getRowTypeID() {
        return rowTypeID;
    }

    /**
     * 
     * @param rowTypeID
     *     The RowTypeID
     */
    public void setRowTypeID(Integer rowTypeID) {
        this.rowTypeID = rowTypeID;
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
     *     The singleSelectionRisk
     */
    public Integer getSingleSelectionRisk() {
        return singleSelectionRisk;
    }

    /**
     * 
     * @param singleSelectionRisk
     *     The SingleSelectionRisk
     */
    public void setSingleSelectionRisk(Integer singleSelectionRisk) {
        this.singleSelectionRisk = singleSelectionRisk;
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
     *     The teamMappingID
     */
    public Integer getTeamMappingID() {
        return teamMappingID;
    }

    /**
     * 
     * @param teamMappingID
     *     The TeamMappingID
     */
    public void setTeamMappingID(Integer teamMappingID) {
        this.teamMappingID = teamMappingID;
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
     *     The userCurrency
     */
    public String getUserCurrency() {
        return userCurrency;
    }

    /**
     * 
     * @param userCurrency
     *     The userCurrency
     */
    public void setUserCurrency(String userCurrency) {
        this.userCurrency = userCurrency;
    }

    /**
     * 
     * @return
     *     The viewKey
     */
    public Integer getViewKey() {
        return viewKey;
    }

    /**
     * 
     * @param viewKey
     *     The ViewKey
     */
    public void setViewKey(Integer viewKey) {
        this.viewKey = viewKey;
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
