package com.example.viewpagerfragment.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @description: ViewPager adapter
 * @author: zhukai
 * @date: 2019/4/1 11:24
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public MyPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    public MyPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> fragments) {
        super(fm, behavior);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }
}
