package com.boxuanjia.autobet.model.purchase;

/**
 * Created by slomka.jin on 2016/10/26.
 */

public class RegularRequest {
    public String eventId;
    public String lineId;
    public RegularRequest(String eventId,String lineId){
        this.eventId=eventId;
        this.lineId=lineId;
    }
}
