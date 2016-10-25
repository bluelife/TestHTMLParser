
package com.boxuanjia.autobet.model.success;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mapping {

    @SerializedName("SelectionID")
    @Expose
    private Integer selectionID;
    @SerializedName("ViewKey")
    @Expose
    private Integer viewKey;

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
