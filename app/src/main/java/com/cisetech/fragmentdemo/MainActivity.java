package com.cisetech.fragmentdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTab;
    private ViewPager mPager;
    private List<Fragment> fragments;
    private String[]titles={"page1","page2","page3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTab= (TabLayout) findViewById(R.id.id_tab);
        mPager= (ViewPager) findViewById(R.id.id_viewpager);
        mPager.setOffscreenPageLimit(2);
        initDatas();
    }
    private void initDatas() {
        fragments=new ArrayList<>(3);
        fragments.add(MyFragment.newInstance(1));
        fragments.add(MyFragment.newInstance(2));
        fragments.add(MyFragment.newInstance(3));
        mPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
        mTab.setTabMode(TabLayout.MODE_FIXED);
        mTab.setupWithViewPager(mPager);
        mTab.setTabTextColors(Color.GRAY,Color.RED);
    }
}
