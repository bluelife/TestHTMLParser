package com.boxuanjia.autobet.event;

import com.boxuanjia.autobet.model.purchase.OddsQuartData;

import java.util.List;

/**
 * Created by slomka.jin on 2016/10/26.
 */

public class OddsQuardUpdateEvent {
    public List<OddsQuartData> oddsQuardUpdateEvents;
    public OddsQuardUpdateEvent(List<OddsQuartData> updateEvents){
        oddsQuardUpdateEvents=updateEvents;
    }
}
