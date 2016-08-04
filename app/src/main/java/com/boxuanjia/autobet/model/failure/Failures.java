
package com.boxuanjia.autobet.model.failure;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Failures {

    @SerializedName("Selections")
    @Expose
    private List<Failure> selections = new ArrayList<Failure>();
    @SerializedName("Status")
    @Expose
    private Integer status;

    /**
     * 
     * @return
     *     The selections
     */
    public List<Failure> getSelections() {
        return selections;
    }

    /**
     * 
     * @param selections
     *     The Failures
     */
    public void setSelections(List<Failure> selections) {
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

}
