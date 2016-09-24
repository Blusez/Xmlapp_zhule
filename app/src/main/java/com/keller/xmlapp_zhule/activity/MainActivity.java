package com.keller.xmlapp_zhule.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.keller.xmlapp_zhule.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.main_tv_title)
    TextView mainTvTitle;

    @InjectView(R.id.main_viewpager)
    ViewPager mainViewpager;

    @InjectView(R.id.main_bottom)
    LinearLayout mainBottom;

    //xutil viewutil注解方式查找控件
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initData();
    }

    private void initData() {
        
    }

}
