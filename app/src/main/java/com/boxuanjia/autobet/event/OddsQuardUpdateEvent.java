package com.boxuanjia.autobet.event;

import java.util.List;

/**
 * Created by slomka.jin on 2016/10/26.
 */

public class OddsQuardUpdateEvent {
    public List<OddsQuardUpdateEvent> oddsQuardUpdateEvents;
    public OddsQuardUpdateEvent(List<OddsQuardUpdateEvent> updateEvents){
        oddsQuardUpdateEvents=updateEvents;
    }
}
