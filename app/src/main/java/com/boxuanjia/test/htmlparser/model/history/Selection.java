
package com.boxuanjia.test.htmlparser.model.history;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Selection {

    @SerializedName("HalfTimeScore")
    @Expose
    private String halfTimeScore;
    @SerializedName("Link")
    @Expose
    private String link;
    @SerializedName("Odds")
    @Expose
    private Integer odds;
    @SerializedName("Points")
    @Expose
    private Integer points;
    @SerializedName("Result")
    @Expose
    private String result;
    @SerializedName("Rule4PercDeduction")
    @Expose
    private Integer rule4PercDeduction;
    @SerializedName("SelectionID")
    @Expose
    private Integer selectionID;
    @SerializedName("StatusID")
    @Expose
    private Integer statusID;

    /**
     * 
     * @return
     *     The halfTimeScore
     */
    public String getHalfTimeScore() {
        return halfTimeScore;
    }

    /**
     * 
     * @param halfTimeScore
     *     The HalfTimeScore
     */
    public void setHalfTimeScore(String halfTimeScore) {
        this.halfTimeScore = halfTimeScore;
    }

    /**
     * 
     * @return
     *     The link
     */
    public String getLink() {
        return link;
    }

    /**
     * 
     * @param link
     *     The Link
     */
    public void setLink(String link) {
        this.link = link;
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
     *     The points
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * 
     * @param points
     *     The Points
     */
    public void setPoints(Integer points) {
        this.points = points;
    }

    /**
     * 
     * @return
     *     The result
     */
    public String getResult() {
        return result;
    }

    /**
     * 
     * @param result
     *     The Result
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * 
     * @return
     *     The rule4PercDeduction
     */
    public Integer getRule4PercDeduction() {
        return rule4PercDeduction;
    }

    /**
     * 
     * @param rule4PercDeduction
     *     The Rule4PercDeduction
     */
    public void setRule4PercDeduction(Integer rule4PercDeduction) {
        this.rule4PercDeduction = rule4PercDeduction;
    }

    /**
     * 
     * @return
     *     The selectionID
     */
    public Integer getSelectionID() {
        return selectionID;
    }

    /**
     * 
     * @param selectionID
     *     The SelectionID
     */
    public void setSelectionID(Integer selectionID) {
        this.selectionID = selectionID;
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

}
