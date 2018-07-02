package com.wq.wqproject;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wq.wqproject.fragment.DownloadFragment;
import com.wq.wqproject.fragment.HomeFragment;
import com.wq.wqproject.fragment.MeFragment;
import com.wq.wqproject.fragment.ServerFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 使用FragmentManager加replace方法的形式做切换页功能。
 *  每一次点击非当前页按钮，对应的fragment将会重建，生命周期方法也会重新走。
 */
public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.iv_bottom_home)
    ImageView ivBottomHome;
    @BindView(R.id.tv_bottom_home)
    TextView tvBottomHome;
    @BindView(R.id.ll_bottom_home)
    LinearLayout llBottomHome;
    @BindView(R.id.iv_bottom_search)
    ImageView ivBottomSearch;
    @BindView(R.id.tv_bottom_search)
    TextView tvBottomSearch;
    @BindView(R.id.ll_bottom_search)
    LinearLayout llBottomSearch;
    @BindView(R.id.iv_bottom_mall)
    ImageView ivBottomMall;
    @BindView(R.id.tv_bottom_mall)
    TextView tvBottomMall;
    @BindView(R.id.ll_bottom_mall)
    LinearLayout llBottomMall;
    @BindView(R.id.iv_bottom_me)
    ImageView ivBottomMe;
    @BindView(R.id.tv_bottom_me)
    TextView tvBottomMe;
    @BindView(R.id.ll_bottom_me)
    LinearLayout llBottomMe;
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    private ImageView ivCurrent;
    private TextView tvCurrent;
    private HomeFragment homeFragment;
    private ServerFragment serverFragment;
    private DownloadFragment downloadFragment;
    private MeFragment meFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        initView();
        setDefaultFragment();
    }

    private void initView() {
        //初始化默认显示home
        ivBottomHome.setSelected(true);
        tvBottomHome.setSelected(true);
        ivCurrent = ivBottomHome;
        tvCurrent = tvBottomHome;
    }

    private void setDefaultFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        homeFragment = new HomeFragment();
        transaction.replace(R.id.fl_content,homeFragment);
        transaction.commit();
    }
    @OnClick({R.id.ll_bottom_home, R.id.ll_bottom_search, R.id.ll_bottom_mall, R.id.ll_bottom_me})
    public void onViewClicked(View view) {
        ivCurrent.setSelected(false);
        tvCurrent.setSelected(false);
        switch (view.getId()) {
            case R.id.ll_bottom_home:
                ivCurrent = ivBottomHome;
                tvCurrent = tvBottomHome;
                ivBottomHome.setSelected(true);
                tvBottomHome.setSelected(true);
                changeFragment(0);
                break;
            case R.id.ll_bottom_search:
                ivCurrent = ivBottomSearch;
                tvCurrent = tvBottomSearch;
                ivBottomSearch.setSelected(true);
                tvBottomSearch.setSelected(true);
                changeFragment(1);
                break;
            case R.id.ll_bottom_mall:
                ivCurrent = ivBottomMall;
                tvCurrent = tvBottomMall;
                ivBottomMall.setSelected(true);
                tvBottomMall.setSelected(true);
                changeFragment(2);
                break;
            case R.id.ll_bottom_me:
                ivCurrent = ivBottomMe;
                tvCurrent = tvBottomMe;
                ivBottomMe.setSelected(true);
                tvBottomMe.setSelected(true);
                changeFragment(3);
                break;
        }
    }

    private void changeFragment(int id) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (id) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                }
                transaction.replace(R.id.fl_content,homeFragment).commit();
                break;
            case 1:
                if (serverFragment == null) {
                    serverFragment = new ServerFragment();
                }
                transaction.replace(R.id.fl_content,serverFragment).commit();
                break;
            case 2:
                if (downloadFragment == null) {
                    downloadFragment = new DownloadFragment();
                }
                transaction.replace(R.id.fl_content,downloadFragment).commit();
                break;
            case 3:
                if (meFragment == null) {
                    meFragment = new MeFragment();
                }
                transaction.replace(R.id.fl_content,meFragment).commit();
                break;
        }
    }
}
