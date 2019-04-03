package com.example.viewpagerfragment.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.viewpagerfragment.R;
import com.example.viewpagerfragment.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 顶部导航页面
 * @author: zhukai
 * @date: 2019/4/1 10:47
 */
public class TabActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private HomeFragment homefragment;
    private KnowledgeSystemFragment knowledgeSystemFragment;
    private ProjectFragment projectFragment;
    private List<Fragment> mFragments;
    private MyPagerAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        initView();
        initData();
        initEvent();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        mTabLayout = findViewById(R.id.tl_tabs);
        mViewPager = findViewById(R.id.vp_tabs);

        mTabLayout.addTab(mTabLayout.newTab().setText("首页"));
        mTabLayout.addTab(mTabLayout.newTab().setText("知识体系"));
        mTabLayout.addTab(mTabLayout.newTab().setText("项目"));
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mFragments = new ArrayList<>();
        homefragment = new HomeFragment();
        knowledgeSystemFragment = new KnowledgeSystemFragment();
        projectFragment = new ProjectFragment();
        mFragments.add(homefragment);
        mFragments.add(knowledgeSystemFragment);
        mFragments.add(projectFragment);

        mAdapter = new MyPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);
//        mViewPager.setOffscreenPageLimit(mFragments.size());
        // 关联ViewPager
        mTabLayout.setupWithViewPager(mViewPager);
        // mTabLayout.setupWithViewPager方法内部会remove所有的tabs，这里重新设置一遍tabs的text，否则tabs的text不显示
        mTabLayout.getTabAt(0).setText("首页");
        mTabLayout.getTabAt(1).setText("知识体系");
        mTabLayout.getTabAt(2).setText("项目");
    }

    /**
     * 初始化事件
     */
    private void initEvent() {

    }
}
