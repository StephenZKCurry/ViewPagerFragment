package com.example.viewpagerfragment.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @description: 懒加载Fragment
 * @author: zhukai
 * @date: 2019/4/2 8:58
 */
public abstract class LazyFragment extends Fragment {

    private Context mContext;
    private boolean hasViewCreated; // 视图是否已加载
    private boolean isFirstLoad; // 是否首次加载

    private ProgressDialog mProgressDialog; // 加载进度对话框

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        hasViewCreated = true;
        isFirstLoad = true;
        View view = LayoutInflater.from(mContext).inflate(getContentViewId(), null);
        initView(view);
        initData();
        initEvent();
        lazyLoad();
        return view;
    }

    /**
     * 设置布局资源id
     *
     * @return
     */
    protected abstract int getContentViewId();

    /**
     * 初始化视图
     *
     * @param view
     */
    protected void initView(View view) {

    }

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 初始化事件
     */
    protected void initEvent() {

    }

    /**
     * 懒加载
     */
    protected void onLazyLoad() {

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            lazyLoad();
        }
    }

    private void lazyLoad() {
        if (!hasViewCreated || !isFirstLoad || !getUserVisibleHint()) {
            return;
        }
        isFirstLoad = false;
        onLazyLoad();
    }

    /**
     * 显示提示框
     *
     * @param msg 等待消息字符串
     */
    protected void showProgressDialog(String msg) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(mContext);
        }
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
        mProgressDialog.setMessage(msg);
        mProgressDialog.show();
    }

    /**
     * 隐藏提示框
     */
    protected void hideProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }
}
