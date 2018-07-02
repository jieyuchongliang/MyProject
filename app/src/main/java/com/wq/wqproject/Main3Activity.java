package com.wq.wqproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
 * 使用FragmentManager加hide，show方法的形式做切换页功能。
 *
 * 每个页面的生命周期都只走一次，且是在按钮触发后走的。只要fragment出现后，即被加入framgentmanager中。下次再走只是缓存。
 */
public class Main3Activity extends AppCompatActivity {

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
    private ImageView ivCurrent;
    private TextView tvCurrent;
    private HomeFragment homeFragment;
    private ServerFragment serverFragment;
    private DownloadFragment downloadFragment;
    private MeFragment meFragment;
    private static final String HOME = "HomeFragment";
    private static final String SERVER = "ServerFragment";
    private static final String DOWNLOAD = "DownloadFragment";
    private static final String ME = "MeFragment";
    private String current_fragment = HOME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);
        initView();
        initFragmentManager();
    }

    private void initView() {
        //初始化默认显示home
        ivBottomHome.setSelected(true);
        tvBottomHome.setSelected(true);
        ivCurrent = ivBottomHome;
        tvCurrent = tvBottomHome;
    }

    private void initFragmentManager() {
        homeFragment = new HomeFragment();
//        serverFragment = new ServerFragment();
//        downloadFragment = new DownloadFragment();
//        meFragment = new MeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fl_content_three, homeFragment, HOME);
//        transaction.add(R.id.fl_content_three,serverFragment,SERVER);
//        transaction.add(R.id.fl_content_three,downloadFragment,DOWNLOAD);
//        transaction.add(R.id.fl_content_three,meFragment,ME);
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
                changeFragment(HOME);
                break;
            case R.id.ll_bottom_search:
                ivCurrent = ivBottomSearch;
                tvCurrent = tvBottomSearch;
                ivBottomSearch.setSelected(true);
                tvBottomSearch.setSelected(true);
                changeFragment(SERVER);
                break;
            case R.id.ll_bottom_mall:
                ivCurrent = ivBottomMall;
                tvCurrent = tvBottomMall;
                ivBottomMall.setSelected(true);
                tvBottomMall.setSelected(true);
                changeFragment(DOWNLOAD);
                break;
            case R.id.ll_bottom_me:
                ivCurrent = ivBottomMe;
                tvCurrent = tvBottomMe;
                ivBottomMe.setSelected(true);
                tvBottomMe.setSelected(true);
                changeFragment(ME);
                break;
        }
    }

    private void changeFragment(String type) {
        if (current_fragment.equals(type)) {
            return;
        }
        FragmentManager manager = getSupportFragmentManager();
        Fragment showFragment = manager.findFragmentByTag(type);
        Fragment hideFragment = manager.findFragmentByTag(current_fragment);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (showFragment == null) {
            switch (type) {
                case HOME:
                    transaction.add(R.id.fl_content_three, new HomeFragment(), HOME);
                    break;
                case SERVER:
                    transaction.add(R.id.fl_content_three, new ServerFragment(), SERVER);
                    break;
                case DOWNLOAD:
                    transaction.add(R.id.fl_content_three, new DownloadFragment(), DOWNLOAD);
                    break;
                case ME:
                    transaction.add(R.id.fl_content_three, new MeFragment(), ME);
                    break;
            }
        } else {
            transaction.show(showFragment);
        }
        transaction.hide(hideFragment);
        current_fragment = type;
        transaction.commit();
    }
}
