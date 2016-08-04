package com.boxuanjia.autobet;

import android.support.v7.app.AppCompatActivity;

import com.umeng.analytics.MobclickAgent;

/**
 * Created by boxuanjia on 16/8/4.
 */
public abstract class BaseActivity extends AppCompatActivity {

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

}
