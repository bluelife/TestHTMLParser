package com.boxuanjia.autobet.Utils;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by slomka.jin on 2016/10/26.
 */
@StringDef({BetTeam.TEAM_A,BetTeam.TEAM_B,BetTeam.TEAM_BOTH})
@Retention(RetentionPolicy.RUNTIME)
public @interface BetTeam {
    String TEAM_A="team_a";
    String TEAM_B="team_b";
    String TEAM_BOTH="team_both";
}
