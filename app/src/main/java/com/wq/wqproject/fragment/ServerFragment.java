package com.wq.wqproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wq.wqproject.utils.LogUtils;

/**
 * Created by 860617010 on 2018/6/26.
 */

public class ServerFragment extends Fragment {
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
        TextView textView = new TextView(getContext());
        textView.setText(this.getClass().getSimpleName());
        textView.setGravity(Gravity.CENTER);
        return textView;
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
}
