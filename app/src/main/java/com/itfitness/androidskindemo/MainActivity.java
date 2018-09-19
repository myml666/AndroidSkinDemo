package com.itfitness.androidskindemo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,SwipeRefreshLayout.OnRefreshListener{
    private Toolbar activityMainToolbar;
    private ImageView activityMainToolbarImgMore;
    private RecyclerView activityMainRecyclerview;
    private DrawerLayout activityMainDrawerlayout;
    private LinearLayout menuLeftLayout;
    private CardView menuLeftLayoutCdChangeskin;
    private SwipeRefreshLayout activityMainSrf;

    private BaseQuickAdapter<TestBean.DataBean,BaseViewHolder> mBeanBaseViewHolderBaseQuickAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainToolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        activityMainToolbarImgMore = (ImageView) findViewById(R.id.activity_main_toolbar_img_more);
        activityMainRecyclerview = (RecyclerView) findViewById(R.id.activity_main_recyclerview);
        activityMainDrawerlayout = (DrawerLayout) findViewById(R.id.activity_main_drawerlayout);
        menuLeftLayout = (LinearLayout) findViewById(R.id.menu_left_layout);
        menuLeftLayoutCdChangeskin = (CardView) findViewById(R.id.menu_left_layout_cd_changeskin);
        activityMainSrf = (SwipeRefreshLayout) findViewById(R.id.activity_main_srf);
        setSupportActionBar(activityMainToolbar);
        activityMainToolbarImgMore.setOnClickListener(this);
        menuLeftLayoutCdChangeskin.setOnClickListener(this);
        activityMainSrf.setOnRefreshListener(this);
        initData();
    }

    @SuppressLint("CheckResult")
    private void initData() {
        RetrofitUtils.getInstance().getApiServier(Api.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TestBean>() {
                    @Override
                    public void accept(TestBean testBean) throws Exception {
                        if(testBean.getCode()==0){
                            if(activityMainSrf.isRefreshing()){
                                    activityMainSrf.setRefreshing(false);
                             }
                            initAdapter(testBean.getData());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if(activityMainSrf.isRefreshing()){
                            activityMainSrf.setRefreshing(false);
                        }
                    }
                });
    }

    private void initAdapter(List<TestBean.DataBean> data) {
        if(mBeanBaseViewHolderBaseQuickAdapter==null){
            mBeanBaseViewHolderBaseQuickAdapter=new BaseQuickAdapter<TestBean.DataBean, BaseViewHolder>(R.layout.item,data) {
                @Override
                protected void convert(BaseViewHolder helper, TestBean.DataBean item) {
                    ImageView imageView = helper.getView(R.id.item_img);
                    helper.setText(R.id.item_title,item.getTitle());
                    Glide.with(MainActivity.this).load(item.getImg()).into(imageView);
                }
            };
            activityMainRecyclerview.setLayoutManager(new LinearLayoutManager(this));
            activityMainRecyclerview.setAdapter(mBeanBaseViewHolderBaseQuickAdapter);
            mBeanBaseViewHolderBaseQuickAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
            mBeanBaseViewHolderBaseQuickAdapter.isFirstOnly(false);
        }else {
            mBeanBaseViewHolderBaseQuickAdapter.setNewData(data);
            mBeanBaseViewHolderBaseQuickAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_main_toolbar_img_more:
                switchLeftMenu();
                break;
            case R.id.menu_left_layout_cd_changeskin:
                startActivity(new Intent(this,ChangeSkinActivity.class));
                break;
        }
    }
    private void switchLeftMenu(){
        if (activityMainDrawerlayout.isDrawerOpen(menuLeftLayout)) {
            activityMainDrawerlayout.closeDrawer(menuLeftLayout);
        } else {
            activityMainDrawerlayout.openDrawer(menuLeftLayout);
        }
    }

    @Override
    public void onRefresh() {
        initData();
    }
}
