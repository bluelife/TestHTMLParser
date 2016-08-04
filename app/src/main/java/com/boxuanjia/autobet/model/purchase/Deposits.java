package com.boxuanjia.autobet.model.purchase;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by boxuanjia on 16/7/21.
 */
public class Deposits {

    @SerializedName("single")
    @Expose
    private ArrayList<Integer> single = new ArrayList<>();
    @SerializedName("combo")
    @Expose
    private String combo = null;
    @SerializedName("teaser")
    @Expose
    private String teaser = null;
    @SerializedName("system")
    @Expose
    private String system = null;

    public Deposits() {
        single.add(1);
    }

    public ArrayList<Integer> getSingle() {
        return single;
    }

    public void setSingle(ArrayList<Integer> single) {
        this.single = single;
    }

    public String getCombo() {
        return combo;
    }

    public void setCombo(String combo) {
        this.combo = combo;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }
}
