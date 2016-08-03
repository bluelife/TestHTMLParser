
package com.boxuanjia.test.htmlparser.model.success;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Selection {

    @SerializedName("LineID")
    @Expose
    private Integer lineID;
    @SerializedName("Odds")
    @Expose
    private Integer odds;
    @SerializedName("Points")
    @Expose
    private Object points;
    @SerializedName("QAParameter1")
    @Expose
    private Integer qAParameter1;
    @SerializedName("QAParameter2")
    @Expose
    private Integer qAParameter2;
    @SerializedName("ViewKey")
    @Expose
    private Integer viewKey;

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

}
