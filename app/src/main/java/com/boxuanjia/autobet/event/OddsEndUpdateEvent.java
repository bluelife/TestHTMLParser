package com.boxuanjia.autobet.event;

import com.boxuanjia.autobet.model.purchase.OddsEndData;

import java.util.List;

/**
 * Created by slomka.jin on 2016/10/26.
 */

public class OddsEndUpdateEvent {
    public List<OddsEndData> datas;

    public OddsEndUpdateEvent(List<OddsEndData> datas){
        datas=datas;
    }
}
