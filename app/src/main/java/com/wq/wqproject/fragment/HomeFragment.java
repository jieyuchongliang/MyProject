package com.wq.wqproject.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wq.wqproject.R;
import com.wq.wqproject.activity.AnimeActivity;
import com.wq.wqproject.adapter.HomeRVAdapter;
import com.wq.wqproject.utils.LogUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 860617010 on 2018/6/26.
 */

public class HomeFragment extends Fragment implements HomeRVAdapter.OnItemClickListener {

    private View view;
    private List<String> list = new ArrayList<>();
    private String[] mFunctionName = new String[]{"动画合集"};

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        LogUtils.i("--------", getClass().getSimpleName() + "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.i("--------", getClass().getSimpleName() + "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogUtils.i("--------", getClass().getSimpleName() + "onCreateView");
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initData();
        initView(view);
        return view;
    }

    private void initData() {
        list = Arrays.asList(mFunctionName);
    }

    private void initView(View view) {

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtils.i("--------", getClass().getSimpleName() + "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.i("--------", getClass().getSimpleName() + "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.i("--------", getClass().getSimpleName() + "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.i("--------", getClass().getSimpleName() + "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtils.i("--------", getClass().getSimpleName() + "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtils.i("--------", getClass().getSimpleName() + "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.i("--------", getClass().getSimpleName() + "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtils.i("--------", getClass().getSimpleName() + "onDetach");
    }

    /**
     * 首页条目点击事件
     * @param position
     */
    @Override
    public void itemClickListener(int position) {
        switch (position) {
            case 0:
                startActivity(new Intent(getContext(), AnimeActivity.class));
                break;
            default:
                break;
        }
    }
}
