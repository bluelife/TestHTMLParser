package com.boxuanjia.autobet.model.purchase;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by boxuanjia on 16/7/21.
 */
public class Purchase {

    @SerializedName("MasterEventID")
    @Expose
    private Integer masterEventID;
    @SerializedName("EventID")
    @Expose
    private Integer eventID;
    @SerializedName("LineID")
    @Expose
    private Integer lineID;
    @SerializedName("Valid")
    @Expose
    private Boolean valid;
    @SerializedName("Final")
    @Expose
    private Boolean _final;
    @SerializedName("minBet")
    @Expose
    private Double minBet;
    @SerializedName("Updated")
    @Expose
    private Boolean updated;
    @SerializedName("Countable")
    @Expose
    private Boolean countable;
    @SerializedName("StatusUpdate")
    @Expose
    private String statusUpdate;
    @SerializedName("FreeBet")
    @Expose
    private String freeBet;
    @SerializedName("DeleteTimeSet")
    @Expose
    private String deleteTimeSet;
    @SerializedName("FirstCall")
    @Expose
    private Boolean firstCall;
    @SerializedName("Initialized")
    @Expose
    private Boolean initialized;
    @SerializedName("LiveGroupID")
    @Expose
    private Integer liveGroupID;
    @SerializedName("ComboRate")
    @Expose
    private Integer comboRate;
    @SerializedName("CombinatorGroup")
    @Expose
    private String combinatorGroup;
    @SerializedName("Type")
    @Expose
    private Integer type;
    @SerializedName("Odds")
    @Expose
    private Integer odds;
    @SerializedName("InCombo")
    @Expose
    private Boolean inCombo;
    @SerializedName("BetType")
    @Expose
    private Integer betType;
    @SerializedName("EachWayIncluded")
    @Expose
    private Boolean eachWayIncluded;
    @SerializedName("IsEachWayEnabled")
    @Expose
    private Boolean isEachWayEnabled;
    @SerializedName("IsEachWaySelection")
    @Expose
    private Boolean isEachWaySelection;
    @SerializedName("EachWaySingleIncluded")
    @Expose
    private Boolean eachWaySingleIncluded;
    @SerializedName("EachWayMultiplesIncluded")
    @Expose
    private Boolean eachWayMultiplesIncluded;
    @SerializedName("ReleatedToID")
    @Expose
    private Integer releatedToID;
    @SerializedName("PlaceTermsID")
    @Expose
    private Integer placeTermsID;
    @SerializedName("OddsTermsID")
    @Expose
    private Integer oddsTermsID;
    @SerializedName("EachWayTermsID")
    @Expose
    private Integer eachWayTermsID;
    @SerializedName("EWOdds")
    @Expose
    private Integer eWOdds;
    @SerializedName("EWDeposit")
    @Expose
    private Integer eWDeposit;
    @SerializedName("EWGain")
    @Expose
    private Integer eWGain;
    @SerializedName("TeamID")
    @Expose
    private Integer teamID;
    @SerializedName("QAParameter1")
    @Expose
    private Integer qAParameter1;
    @SerializedName("QAParameter2")
    @Expose
    private Integer qAParameter2;
    @SerializedName("CastSelection")
    @Expose
    private Boolean castSelection;
    @SerializedName("Position")
    @Expose
    private Integer position;
    @SerializedName("VisibleCastSelection")
    @Expose
    private Boolean visibleCastSelection;
    @SerializedName("Swapped")
    @Expose
    private Boolean swapped;
    @SerializedName("Score1")
    @Expose
    private Integer score1;
    @SerializedName("Score2")
    @Expose
    private Integer score2;
    @SerializedName("Live")
    @Expose
    private Boolean live;
    @SerializedName("ViewKey")
    @Expose
    private Integer viewKey;
    @SerializedName("HasGameStarted")
    @Expose
    private Boolean hasGameStarted;
    @SerializedName("Danger")
    @Expose
    private Boolean danger;
    @SerializedName("BranchID")
    @Expose
    private Integer branchID;
    @SerializedName("BranchName")
    @Expose
    private String branchName;
    @SerializedName("LeagueID")
    @Expose
    private Integer leagueID;
    @SerializedName("LeagueName")
    @Expose
    private String leagueName;
    @SerializedName("EventTypeID")
    @Expose
    private Integer eventTypeID;
    @SerializedName("EventTypeName")
    @Expose
    private String eventTypeName;
    @SerializedName("Team1Name")
    @Expose
    private String team1Name;
    @SerializedName("Team2Name")
    @Expose
    private String team2Name;
    @SerializedName("maxBet")
    @Expose
    private Integer maxBet;
    @SerializedName("waitingAllowed")
    @Expose
    private Integer waitingAllowed;
    @SerializedName("MaxBetCombo")
    @Expose
    private Integer maxBetCombo;
    @SerializedName("MaxBetSystem")
    @Expose
    private Double maxBetSystem;
    @SerializedName("MaxBetTeaser")
    @Expose
    private Double maxBetTeaser;
    @SerializedName("ComboBetIsEnabled")
    @Expose
    private Integer comboBetIsEnabled;
    @SerializedName("SystemBetIsEnabled")
    @Expose
    private Integer systemBetIsEnabled;
    @SerializedName("LineTypeName")
    @Expose
    private String lineTypeName;
    @SerializedName("EventDate")
    @Expose
    private String eventDate;
    @SerializedName("BetTypeID")
    @Expose
    private Integer betTypeID;
    @SerializedName("LineTypeID")
    @Expose
    private Integer lineTypeID;
    @SerializedName("UseEventName")
    @Expose
    private Integer useEventName;
    @SerializedName("EventName")
    @Expose
    private String eventName;
    @SerializedName("LineName")
    @Expose
    private String lineName;
    @SerializedName("AsianLineName")
    @Expose
    private String asianLineName;
    @SerializedName("MappedLineTypeID")
    @Expose
    private Integer mappedLineTypeID;
    @SerializedName("SplitType")
    @Expose
    private Integer splitType;
    @SerializedName("UpdatedOdds")
    @Expose
    private Boolean updatedOdds;
    @SerializedName("PreviousOdds")
    @Expose
    private Double previousOdds;
    @SerializedName("UpdatedScore")
    @Expose
    private Boolean updatedScore;
    @SerializedName("StakeUpdatedByUser")
    @Expose
    private Boolean stakeUpdatedByUser;
    @SerializedName("ClientOdds")
    @Expose
    private String clientOdds;
    @SerializedName("YourBet")
    @Expose
    private String yourBet;
    @SerializedName("EnableAsianStyleMinMax")
    @Expose
    private Boolean enableAsianStyleMinMax;

    public Integer getMasterEventID() {
        return masterEventID;
    }

    public void setMasterEventID(Integer masterEventID) {
        this.masterEventID = masterEventID;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public Integer getLineID() {
        return lineID;
    }

    public void setLineID(Integer lineID) {
        this.lineID = lineID;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Boolean get_final() {
        return _final;
    }

    public void set_final(Boolean _final) {
        this._final = _final;
    }

    public Double getMinBet() {
        return minBet;
    }

    public void setMinBet(Double minBet) {
        this.minBet = minBet;
    }

    public Boolean getUpdated() {
        return updated;
    }

    public void setUpdated(Boolean updated) {
        this.updated = updated;
    }

    public Boolean getCountable() {
        return countable;
    }

    public void setCountable(Boolean countable) {
        this.countable = countable;
    }

    public String getStatusUpdate() {
        return statusUpdate;
    }

    public void setStatusUpdate(String statusUpdate) {
        this.statusUpdate = statusUpdate;
    }

    public String getFreeBet() {
        return freeBet;
    }

    public void setFreeBet(String freeBet) {
        this.freeBet = freeBet;
    }

    public String getDeleteTimeSet() {
        return deleteTimeSet;
    }

    public void setDeleteTimeSet(String deleteTimeSet) {
        this.deleteTimeSet = deleteTimeSet;
    }

    public Boolean getFirstCall() {
        return firstCall;
    }

    public void setFirstCall(Boolean firstCall) {
        this.firstCall = firstCall;
    }

    public Boolean getInitialized() {
        return initialized;
    }

    public void setInitialized(Boolean initialized) {
        this.initialized = initialized;
    }

    public Integer getLiveGroupID() {
        return liveGroupID;
    }

    public void setLiveGroupID(Integer liveGroupID) {
        this.liveGroupID = liveGroupID;
    }

    public Integer getComboRate() {
        return comboRate;
    }

    public void setComboRate(Integer comboRate) {
        this.comboRate = comboRate;
    }

    public String getCombinatorGroup() {
        return combinatorGroup;
    }

    public void setCombinatorGroup(String combinatorGroup) {
        this.combinatorGroup = combinatorGroup;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOdds() {
        return odds;
    }

    public void setOdds(Integer odds) {
        this.odds = odds;
    }

    public Boolean getInCombo() {
        return inCombo;
    }

    public void setInCombo(Boolean inCombo) {
        this.inCombo = inCombo;
    }

    public Integer getBetType() {
        return betType;
    }

    public void setBetType(Integer betType) {
        this.betType = betType;
    }

    public Boolean getEachWayIncluded() {
        return eachWayIncluded;
    }

    public void setEachWayIncluded(Boolean eachWayIncluded) {
        this.eachWayIncluded = eachWayIncluded;
    }

    public Boolean getEachWayEnabled() {
        return isEachWayEnabled;
    }

    public void setEachWayEnabled(Boolean eachWayEnabled) {
        isEachWayEnabled = eachWayEnabled;
    }

    public Boolean getEachWaySelection() {
        return isEachWaySelection;
    }

    public void setEachWaySelection(Boolean eachWaySelection) {
        isEachWaySelection = eachWaySelection;
    }

    public Boolean getEachWaySingleIncluded() {
        return eachWaySingleIncluded;
    }

    public void setEachWaySingleIncluded(Boolean eachWaySingleIncluded) {
        this.eachWaySingleIncluded = eachWaySingleIncluded;
    }

    public Boolean getEachWayMultiplesIncluded() {
        return eachWayMultiplesIncluded;
    }

    public void setEachWayMultiplesIncluded(Boolean eachWayMultiplesIncluded) {
        this.eachWayMultiplesIncluded = eachWayMultiplesIncluded;
    }

    public Integer getReleatedToID() {
        return releatedToID;
    }

    public void setReleatedToID(Integer releatedToID) {
        this.releatedToID = releatedToID;
    }

    public Integer getPlaceTermsID() {
        return placeTermsID;
    }

    public void setPlaceTermsID(Integer placeTermsID) {
        this.placeTermsID = placeTermsID;
    }

    public Integer getOddsTermsID() {
        return oddsTermsID;
    }

    public void setOddsTermsID(Integer oddsTermsID) {
        this.oddsTermsID = oddsTermsID;
    }

    public Integer getEachWayTermsID() {
        return eachWayTermsID;
    }

    public void setEachWayTermsID(Integer eachWayTermsID) {
        this.eachWayTermsID = eachWayTermsID;
    }

    public Integer geteWOdds() {
        return eWOdds;
    }

    public void seteWOdds(Integer eWOdds) {
        this.eWOdds = eWOdds;
    }

    public Integer geteWDeposit() {
        return eWDeposit;
    }

    public void seteWDeposit(Integer eWDeposit) {
        this.eWDeposit = eWDeposit;
    }

    public Integer geteWGain() {
        return eWGain;
    }

    public void seteWGain(Integer eWGain) {
        this.eWGain = eWGain;
    }

    public Integer getTeamID() {
        return teamID;
    }

    public void setTeamID(Integer teamID) {
        this.teamID = teamID;
    }

    public Integer getqAParameter1() {
        return qAParameter1;
    }

    public void setqAParameter1(Integer qAParameter1) {
        this.qAParameter1 = qAParameter1;
    }

    public Integer getqAParameter2() {
        return qAParameter2;
    }

    public void setqAParameter2(Integer qAParameter2) {
        this.qAParameter2 = qAParameter2;
    }

    public Boolean getCastSelection() {
        return castSelection;
    }

    public void setCastSelection(Boolean castSelection) {
        this.castSelection = castSelection;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Boolean getVisibleCastSelection() {
        return visibleCastSelection;
    }

    public void setVisibleCastSelection(Boolean visibleCastSelection) {
        this.visibleCastSelection = visibleCastSelection;
    }

    public Boolean getSwapped() {
        return swapped;
    }

    public void setSwapped(Boolean swapped) {
        this.swapped = swapped;
    }

    public Integer getScore1() {
        return score1;
    }

    public void setScore1(Integer score1) {
        this.score1 = score1;
    }

    public Integer getScore2() {
        return score2;
    }

    public void setScore2(Integer score2) {
        this.score2 = score2;
    }

    public Boolean getLive() {
        return live;
    }

    public void setLive(Boolean live) {
        this.live = live;
    }

    public Integer getViewKey() {
        return viewKey;
    }

    public void setViewKey(Integer viewKey) {
        this.viewKey = viewKey;
    }

    public Boolean getHasGameStarted() {
        return hasGameStarted;
    }

    public void setHasGameStarted(Boolean hasGameStarted) {
        this.hasGameStarted = hasGameStarted;
    }

    public Boolean getDanger() {
        return danger;
    }

    public void setDanger(Boolean danger) {
        this.danger = danger;
    }

    public Integer getBranchID() {
        return branchID;
    }

    public void setBranchID(Integer branchID) {
        this.branchID = branchID;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Integer getLeagueID() {
        return leagueID;
    }

    public void setLeagueID(Integer leagueID) {
        this.leagueID = leagueID;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public Integer getEventTypeID() {
        return eventTypeID;
    }

    public void setEventTypeID(Integer eventTypeID) {
        this.eventTypeID = eventTypeID;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public String getTeam1Name() {
        return team1Name;
    }

    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }

    public Integer getMaxBet() {
        return maxBet;
    }

    public void setMaxBet(Integer maxBet) {
        this.maxBet = maxBet;
    }

    public Integer getWaitingAllowed() {
        return waitingAllowed;
    }

    public void setWaitingAllowed(Integer waitingAllowed) {
        this.waitingAllowed = waitingAllowed;
    }

    public Integer getMaxBetCombo() {
        return maxBetCombo;
    }

    public void setMaxBetCombo(Integer maxBetCombo) {
        this.maxBetCombo = maxBetCombo;
    }

    public Double getMaxBetSystem() {
        return maxBetSystem;
    }

    public void setMaxBetSystem(Double maxBetSystem) {
        this.maxBetSystem = maxBetSystem;
    }

    public Double getMaxBetTeaser() {
        return maxBetTeaser;
    }

    public void setMaxBetTeaser(Double maxBetTeaser) {
        this.maxBetTeaser = maxBetTeaser;
    }

    public Integer getComboBetIsEnabled() {
        return comboBetIsEnabled;
    }

    public void setComboBetIsEnabled(Integer comboBetIsEnabled) {
        this.comboBetIsEnabled = comboBetIsEnabled;
    }

    public Integer getSystemBetIsEnabled() {
        return systemBetIsEnabled;
    }

    public void setSystemBetIsEnabled(Integer systemBetIsEnabled) {
        this.systemBetIsEnabled = systemBetIsEnabled;
    }

    public String getLineTypeName() {
        return lineTypeName;
    }

    public void setLineTypeName(String lineTypeName) {
        this.lineTypeName = lineTypeName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getBetTypeID() {
        return betTypeID;
    }

    public void setBetTypeID(Integer betTypeID) {
        this.betTypeID = betTypeID;
    }

    public Integer getLineTypeID() {
        return lineTypeID;
    }

    public void setLineTypeID(Integer lineTypeID) {
        this.lineTypeID = lineTypeID;
    }

    public Integer getUseEventName() {
        return useEventName;
    }

    public void setUseEventName(Integer useEventName) {
        this.useEventName = useEventName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getAsianLineName() {
        return asianLineName;
    }

    public void setAsianLineName(String asianLineName) {
        this.asianLineName = asianLineName;
    }

    public Integer getMappedLineTypeID() {
        return mappedLineTypeID;
    }

    public void setMappedLineTypeID(Integer mappedLineTypeID) {
        this.mappedLineTypeID = mappedLineTypeID;
    }

    public Integer getSplitType() {
        return splitType;
    }

    public void setSplitType(Integer splitType) {
        this.splitType = splitType;
    }

    public Boolean getUpdatedOdds() {
        return updatedOdds;
    }

    public void setUpdatedOdds(Boolean updatedOdds) {
        this.updatedOdds = updatedOdds;
    }

    public Double getPreviousOdds() {
        return previousOdds;
    }

    public void setPreviousOdds(Double previousOdds) {
        this.previousOdds = previousOdds;
    }

    public Boolean getUpdatedScore() {
        return updatedScore;
    }

    public void setUpdatedScore(Boolean updatedScore) {
        this.updatedScore = updatedScore;
    }

    public Boolean getStakeUpdatedByUser() {
        return stakeUpdatedByUser;
    }

    public void setStakeUpdatedByUser(Boolean stakeUpdatedByUser) {
        this.stakeUpdatedByUser = stakeUpdatedByUser;
    }

    public String getClientOdds() {
        return clientOdds;
    }

    public void setClientOdds(String clientOdds) {
        this.clientOdds = clientOdds;
    }

    public String getYourBet() {
        return yourBet;
    }

    public void setYourBet(String yourBet) {
        this.yourBet = yourBet;
    }

    public Boolean getEnableAsianStyleMinMax() {
        return enableAsianStyleMinMax;
    }

    public void setEnableAsianStyleMinMax(Boolean enableAsianStyleMinMax) {
        this.enableAsianStyleMinMax = enableAsianStyleMinMax;
    }
}
