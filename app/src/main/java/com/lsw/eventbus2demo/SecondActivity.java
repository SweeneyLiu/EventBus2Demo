package com.lsw.eventbus2demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import de.greenrobot.event.EventBus;


public class SecondActivity extends AppCompatActivity {
    private Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn_send = (Button) findViewById(R.id.btn_send);


        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送消息
                EventBus.getDefault().post(new FirstEvent("eventbus2.0测试"));
            }
        });
    }
}
