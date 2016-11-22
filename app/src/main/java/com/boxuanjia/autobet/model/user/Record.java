package com.boxuanjia.autobet.model.user;

import com.boxuanjia.autobet.model.BaseResult;

/**
 * Created by slomka.jin on 2016/11/22.
 */

public class Record extends BaseResult {

    public Data data;
    public static class Data{
        public boolean saved;
    }
}
