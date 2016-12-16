package com.boxuanjia.autobet.model.user;

import com.boxuanjia.autobet.model.BaseResult;
import com.squareup.moshi.Json;

import java.util.List;

/**
 * Created by slomka.jin on 2016/11/22.
 */

public class BetSetting extends BaseResult{
    @Json(name = "goal_day")
    public String goalDay;
    @Json(name = "interval_check_result")
    public int checkResult;
    @Json(name = "interval_check_pause")
    public int checkPause;
    public Data data;
    public static class Data{
        public String state;
        public String option;
        @Json(name = "max_level")
        public int maxLevel;
        @Json(name="thread_count")
        public int threadCount;
        @Json(name = "acc_bal")
        public float totalBalance;
        @Json(name = "out_bal")
        public float remindBalance;
        public String team;
        public String type;
        @Json(name = "levels_money")
        public List<String> levels;
    }
}
