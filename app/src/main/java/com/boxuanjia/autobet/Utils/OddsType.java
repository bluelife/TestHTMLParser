package com.boxuanjia.autobet.Utils;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by slomka.jin on 2016/10/26.
 */

@IntDef({OddsType.ODDS, OddsType.EVEN, OddsType.RANDOM})
@Retention(RetentionPolicy.SOURCE)
@interface OddsType {
    int ODDS = 0;
    int EVEN = 1;
    int RANDOM = 2;
}
