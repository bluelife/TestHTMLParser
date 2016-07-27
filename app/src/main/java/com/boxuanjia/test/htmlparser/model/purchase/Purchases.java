package com.boxuanjia.test.htmlparser.model.purchase;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by boxuanjia on 16/7/21.
 */
public class Purchases {

    @SerializedName("purchasesInfo")
    @Expose
    private ArrayList<PurchasesInfo> mPurchasesInfos = new ArrayList<>();

    public ArrayList<PurchasesInfo> getPurchasesInfos() {
        return mPurchasesInfos;
    }

    public void setPurchasesInfos(ArrayList<PurchasesInfo> purchasesInfos) {
        mPurchasesInfos = purchasesInfos;
    }
}
