package com.example.viewpagerfragment.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @description: 懒加载Fragment的新实现方式
 * @author: zhukai
 * @date: 2019/10/12 13:23
 */
public abstract class NewLazyFragment extends Fragment {

    private Context mContext;
    private boolean isFirstLoad = true; // 是否第一次加载

    private ProgressDialog mProgressDialog; // 加载进度对话框

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(mContext).inflate(getContentViewId(), null);
        initView(view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isFirstLoad = true;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isFirstLoad) {
            initData();
            initEvent();
            isFirstLoad = false;
        }
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
