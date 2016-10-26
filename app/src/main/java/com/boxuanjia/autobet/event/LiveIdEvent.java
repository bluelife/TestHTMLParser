package com.boxuanjia.autobet.event;

import java.util.List;

/**
 * Created by slomka.jin on 2016/10/26.
 */

public class LiveIdEvent {
    public List<String> ids;
    public LiveIdEvent(List<String> idList){
        ids=idList;
    }
}
