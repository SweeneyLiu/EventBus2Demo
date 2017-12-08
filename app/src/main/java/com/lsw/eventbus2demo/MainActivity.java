package com.lsw.eventbus2demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {

    Button btn_skip;
    TextView tv_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        int priority = 1;
//        EventBus.getDefault().register(this, priority);

//        EventBus.getDefault().registerSticky(this);

//        EventBus.getDefault().register(this);

        btn_skip = (Button) findViewById(R.id.btn_skip);

        tv_message = (TextView) findViewById(R.id.tv_message);

        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });


    }


/*    public void onEventMainThread(FirstEvent event) {
        tv_message.setText("收到的消息是：" + event.getMsg());
        Log.i("lsw", "onEventMainThread:" + Thread.currentThread().getName());
    }


    public void onEventPostThread(FirstEvent event){
        tv_message.setText("收到的消息是：" + event.getMsg());
        Log.i("lsw", "onEventMainThread:" + Thread.currentThread().getName());
    }*/

    public void onEvent(FirstEvent event){
        tv_message.setText("收到的消息是：" + event.getMsg());
        Log.i("lsw", "onEventMainThread:" + Thread.currentThread().getName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
