package com.keller.xmlapp_zhule.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.keller.xmlapp_zhule.R;
import com.keller.xmlapp_zhule.fragement.ContactsFragment;
import com.keller.xmlapp_zhule.fragement.SessionFragment;
import com.keller.xmlapp_zhule.util.ToolBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {
    //xutil viewutil注解方式查找控件
    //
    @InjectView(R.id.main_tv_title)
    TextView mainTvTitle;

    @InjectView(R.id.main_viewpager)
    ViewPager mainViewpager;

    @InjectView(R.id.main_bottom)
    LinearLayout mainBottom;

    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initData();
    }

    private void initData() {
        //viewPager->view->PagerAdapter
        //viewPager->fragement->fragementPagerAdapter
        //viewPager->view

        mFragments.add(new SessionFragment());
        mFragments.add(new ContactsFragment());
        mainViewpager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        //底部
        ToolBarUtil toolBarUtil = new ToolBarUtil();
        toolBarUtil.createToolBar(mainBottom);
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}
