package com.keller.xmlapp_zhule;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

import com.keller.xmlapp_zhule.activity.LoginActivity;
import com.keller.xmlapp_zhule.util.ThreadUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //停留三秒到登陆界面
        ThreadUtils.runInThread(new Runnable() {
            @Override
            public void run() {
                //停留三秒
                SystemClock.sleep(3000);
                //进入登陆界面
                Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
