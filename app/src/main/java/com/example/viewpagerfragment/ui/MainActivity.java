package com.example.viewpagerfragment.ui;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;

import com.example.viewpagerfragment.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;

    private HomeFragment homefragment;
    private KnowledgeSystemFragment knowledgeSystemFragment;
    private ProjectFragment projectFragment;
    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_KNOWLEDGESYSTEM = 1;
    private static final int FRAGMENT_PROJECT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initEvent();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        mBottomNavigationView = findViewById(R.id.bnv_bar);
        // 显示首页
        showFragment(FRAGMENT_HOME);
    }

    /**
     * 初始化数据
     */
    private void initData() {

    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView
                .OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_item_home:
                        showFragment(FRAGMENT_HOME);
                        break;
                    case R.id.menu_item_knowledgesystem:
                        showFragment(FRAGMENT_KNOWLEDGESYSTEM);
                        break;
                    case R.id.menu_item_project:
                        showFragment(FRAGMENT_PROJECT);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    /**
     * 显示当前Fragment
     *
     * @param index
     */
    private void showFragment(int index) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        hideFragment(ft);
        switch (index) {
            case FRAGMENT_HOME:
                /**
                 * 如果Fragment为空，就新建一个实例
                 * 如果不为空，就将它从栈中显示出来
                 */
                if (homefragment == null) {
                    homefragment = new HomeFragment();
                    ft.add(R.id.fl_container, homefragment, HomeFragment.class.getName());
                } else {
                    ft.show(homefragment);
                }
                break;
            case FRAGMENT_KNOWLEDGESYSTEM:
                if (knowledgeSystemFragment == null) {
                    knowledgeSystemFragment = new KnowledgeSystemFragment();
                    ft.add(R.id.fl_container, knowledgeSystemFragment, KnowledgeSystemFragment.class.getName());
                } else {
                    ft.show(knowledgeSystemFragment);
                }
                break;
            case FRAGMENT_PROJECT:
                if (projectFragment == null) {
                    projectFragment = new ProjectFragment();
                    ft.add(R.id.fl_container, projectFragment, ProjectFragment.class.getName());
                } else {
                    ft.show(projectFragment);
                }
                break;
            default:
                break;
        }
        ft.commit();
    }

    /**
     * 隐藏全部Fragment
     *
     * @param ft
     */
    private void hideFragment(FragmentTransaction ft) {
        // 如果不为空，就先隐藏起来
        if (homefragment != null) {
            ft.hide(homefragment);
        }
        if (knowledgeSystemFragment != null) {
            ft.hide(knowledgeSystemFragment);
        }
        if (projectFragment != null) {
            ft.hide(projectFragment);
        }
    }
}
