package com.example.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;
/**
* viewpager 适配器 展示两个fragment
* @auther  ln
* created at 2019/2/18 10:30
*/



public class MyAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;

    public MyAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
