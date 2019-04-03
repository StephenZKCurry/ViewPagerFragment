package com.example.viewpagerfragment.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewpagerfragment.R;
import com.example.viewpagerfragment.adapter.ListAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @description: 首页
 * @author: zhukai
 * @date: 2019/3/31 20:37
 */
public class HomeFragment extends LazyFragment {

    private RecyclerView mRecyclerView;
    private ListAdapter mAdapter;
    private List<String> mData;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("TAG", "HomeFragment onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("TAG", "HomeFragment onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("TAG", "HomeFragment onCreateView()");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_home;
    }

    /**
     * 初始化视图
     *
     * @param view
     */
    @Override
    protected void initView(View view) {
        super.initView(view);
        mRecyclerView = view.findViewById(R.id.rv_home);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        super.initData();
    }

    /**
     * 初始化事件
     */
    @Override
    protected void initEvent() {
        super.initEvent();
    }

    /**
     * 懒加载
     */
    @Override
    protected void onLazyLoad() {
        super.onLazyLoad();
        mData = new ArrayList<>();
        showProgressDialog("请稍后");
        // 模拟数据的延迟加载
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        for (int i = 0; i < 20; i++) {
                            mData.add("首页文章" + (i + 1));
                        }
                        mAdapter = new ListAdapter(getActivity(), mData);
                        mRecyclerView.setAdapter(mAdapter);
                        hideProgressDialog();
                    }
                });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("TAG", "HomeFragment onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("TAG", "HomeFragment onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("TAG", "HomeFragment onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("TAG", "HomeFragment onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("TAG", "HomeFragment onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("TAG", "HomeFragment onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "HomeFragment onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("TAG", "HomeFragment onDetach()");
    }
}
