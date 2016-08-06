package com.boxuanjia.autobet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@SuppressLint("LongLogTag")
public class MainActivity extends BaseActivity {

    private TextView mTextContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_main);
        mTextContent = (TextView) findViewById(R.id.text_content);
        Button btnExit = (Button) findViewById(R.id.btn_exit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainService.class);
                stopService(intent);
                finish();
            }
        });
        // 启动服务
        Intent intent = new Intent(MainActivity.this, MainService.class);
        startService(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void eventBusMessage(String message) {
        mTextContent.setText(message);
    }

}
