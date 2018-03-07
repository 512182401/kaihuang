package com.kaihuang.nansui.module.ui.home.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.kaihuang.nansui.R;
import com.kaihuang.nansui.common.view.Indicator;
import com.kaihuang.nansui.module.base.BaseFragment;



/**
 *
 */
@SuppressLint("ValidFragment")
public class FragmentScan extends BaseFragment {

    private Intent intent;

    String pkid =  "1";
    private TabLayout tab;//
    private ViewPager viewPager;//Viewpager
    private Indicator indicator;//页面指示器
    private int index;//ViewPager的位置（+2）

    String responsemsg = "请求数据为空";//网络请求返回信息

    @Override
    public void handMsg(Message msg) {
        switch (msg.what) {
            case -1:
                toast("联网登录出现网络异常错误");
                break;
            case 0:
                initData();
                break;
            case 1:
////                toast( responsemsg );//
//                imageView.setVisibility(View.VISIBLE);
//                madapter.setDataList(null);
////                handler.sendEmptyMessageDelayed( 1, 100 );
                break;
            case 2://刷新成功，刷新界面
////                initData();
//                imageView.setVisibility(View.GONE);
//                madapter.setDataList(mMyWorkInfo.getResults());
//                personalActivity.setTabText(0,workNum);
////                handler.sendEmptyMessageDelayed( 2, 100 );
                break;
            case 3://轮播图数据

                break;

            case 102://作品bu在本地存在，提示
                toast(responsemsg);//
//                handler.sendEmptyMessageDelayed( 102, 100 );
                break;


        }
    }

    public static FragmentScan newInstance(String param1) {
        FragmentScan fragment = new FragmentScan();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_scan;
    }

    @Override
    protected void initViews() {
//        tab = (TabLayout) root.findViewById(R.id.personal_activity_tl);

    }

    @Override
    protected void initEvents() {}


    @Override
    protected void initData() {
    }


    private void initDataes(final String page) {

    }


























    @Override
    public void onResume() {
        super.onResume();
    }


    @Override

    public void onPause() {
        super.onPause();
    }
}
