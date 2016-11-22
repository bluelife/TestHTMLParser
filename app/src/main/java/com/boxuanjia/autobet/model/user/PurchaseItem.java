package com.boxuanjia.autobet.model.user;

import com.squareup.moshi.Json;

/**
 * Created by slomka.jin on 2016/11/22.
 */

public class PurchaseItem {
    @Json(name = "purchase_count")
    public float count;
}
