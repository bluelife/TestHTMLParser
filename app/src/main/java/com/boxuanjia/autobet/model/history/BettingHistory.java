
package com.boxuanjia.autobet.model.history;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BettingHistory {

    @SerializedName("OpenBets")
    @Expose
    private List<String> openBets = new ArrayList<String>();
    @SerializedName("SPBets")
    @Expose
    private List<SPBet> sPBets = new ArrayList<SPBet>();

    /**
     * 
     * @return
     *     The openBets
     */
    public List<String> getOpenBets() {
        return openBets;
    }

    /**
     * 
     * @param openBets
     *     The OpenBets
     */
    public void setOpenBets(List<String> openBets) {
        this.openBets = openBets;
    }

    /**
     * 
     * @return
     *     The sPBets
     */
    public List<SPBet> getSPBets() {
        return sPBets;
    }

    /**
     * 
     * @param sPBets
     *     The SPBets
     */
    public void setSPBets(List<SPBet> sPBets) {
        this.sPBets = sPBets;
    }

}
