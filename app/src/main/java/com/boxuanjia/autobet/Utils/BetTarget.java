package com.boxuanjia.autobet.Utils;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by slomka.jin on 2016/10/26.
 */
@StringDef({BetTarget.END,BetTarget.QUART,BetTarget.QUART_FIRST})
@Retention(RetentionPolicy.SOURCE)
public @interface BetTarget {
    String QUART="quart";
    String END="end";
    String QUART_FIRST="quart_first";
}
