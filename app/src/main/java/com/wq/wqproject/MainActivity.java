package com.wq.wqproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wq.wqproject.adapter.MainVPAdapter;
import com.wq.wqproject.fragment.DownloadFragment;
import com.wq.wqproject.fragment.HomeFragment;
import com.wq.wqproject.fragment.MeFragment;
import com.wq.wqproject.fragment.ServerFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 采用ViewPager的形式，同时设置setOffscreenPageLimit为3（即缓存前后三页）。这种方式的初期化方式为
 *  HomeFragmenton Attach
 *  HomeFragmenton Create
 *  ServerFragmenton Attach
 *  ServerFragmenton Create
 *  DownloadFragmenton Attach
 *  DownloadFragmenton Create
 *  MeFragmenton Attach
 *  MeFragmenton Create
 *  HomeFragmenton CreateView
 *  HomeFragmenton ActivityCreated
 *  HomeFragmenton Start
 *  HomeFragmenton Resume
 *  ServerFragmenton CreateView
 *  ServerFragmenton ActivityCreated
 *  DownloadFragmenton CreateView
 *  DownloadFragmenton ActivityCreated
 *  MeFragmenton CreateView
 *  MeFragmenton ActivityCreated
 *  ServerFragmenton Start
 *  ServerFragmenton Resume
 *  DownloadFragmenton Start
 *  DownloadFragmenton Resume
 *  MeFragmenton Start
 *  MeFragmenton Resume
 *  这种方式在开启应用后，对应加载的fragment生命周期将一次性全部走完。之后如果应用程序一直在前台运行，则对应所有fragment
 *  的生命周期方法将不会再走。
 */
public class MainActivity extends AppCompatActivity {
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
    @BindView(R.id.vp_content)
    ViewPager vpContent;
    private ImageView ivCurrent;
    private TextView tvCurrent;
    private List<Fragment> fragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        //初始化默认显示home
        ivBottomHome.setSelected(true);
        tvBottomHome.setSelected(true);
        ivCurrent = ivBottomHome;
        tvCurrent = tvBottomHome;
        vpContent.setOffscreenPageLimit(3);//一次性全部缓存所有界面的方法。
        vpContent.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                changeTab(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initData() {
        fragments.add(new HomeFragment());
        fragments.add(new ServerFragment());
        fragments.add(new DownloadFragment());
        fragments.add(new MeFragment());
        MainVPAdapter mainVPAdapter = new MainVPAdapter(getSupportFragmentManager(),fragments);
        vpContent.setAdapter(mainVPAdapter);
    }

    @OnClick({R.id.ll_bottom_home, R.id.ll_bottom_search, R.id.ll_bottom_mall, R.id.ll_bottom_me})
    public void onViewClicked(View view) {
        changeTab(view.getId());
    }

    private void changeTab(int id) {
        ivCurrent.setSelected(false);
        tvCurrent.setSelected(false);
        switch (id) {
            case R.id.ll_bottom_home:
                vpContent.setCurrentItem(0);
            case 0:
                ivCurrent = ivBottomHome;
                tvCurrent = tvBottomHome;
                ivBottomHome.setSelected(true);
                tvBottomHome.setSelected(true);
                break;
            case R.id.ll_bottom_search:
                vpContent.setCurrentItem(1);
            case 1:
                ivCurrent = ivBottomSearch;
                tvCurrent = tvBottomSearch;
                ivBottomSearch.setSelected(true);
                tvBottomSearch.setSelected(true);
                break;
            case R.id.ll_bottom_mall:
                vpContent.setCurrentItem(2);
            case 2:
                ivCurrent = ivBottomMall;
                tvCurrent = tvBottomMall;
                ivBottomMall.setSelected(true);
                tvBottomMall.setSelected(true);
                break;
            case R.id.ll_bottom_me:
                vpContent.setCurrentItem(3);
            case 3:
                ivCurrent = ivBottomMe;
                tvCurrent = tvBottomMe;
                ivBottomMe.setSelected(true);
                tvBottomMe.setSelected(true);
                break;
        }
    }
}
