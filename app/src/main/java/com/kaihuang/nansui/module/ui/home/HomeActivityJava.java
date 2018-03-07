package com.kaihuang.nansui.module.ui.home;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Message;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.kaihuang.nansui.R;
import com.kaihuang.nansui.common.utils.LogUtils;
import com.kaihuang.nansui.module.ui.base.BaseActivity;
import com.kaihuang.nansui.module.ui.home.fragment.HomeFragment;


/**
 * Class description
 *
 * @author ashokvarma
 * @version 1.0
 * @see
 * @since 10 Jul 2017
 */
public class HomeActivityJava extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener{

    private BottomNavigationBar bottomNavigationBar;//https://www.jianshu.com/p/249c78b497a3 BottomNavigationBar详解
    int lastSelectedPosition = 10;
    private String TAG = HomeActivityJava.class.getSimpleName();
    private HomeFragment mMyFragment;
    private HomeFragment mScanFragment;
    private HomeFragment mHomeFragment;
    private HomeFragment mMegFragment;
    private HomeFragment mCenterFragment;

    @Override
    public void handMsg(Message msg) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /**
         * bottomNavigation 设置
         */

        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        /** 导航基础设置 包括按钮选中效果 导航栏背景色等 */
        bottomNavigationBar
                .setTabSelectedListener(this)
                .setMode(BottomNavigationBar.MODE_FIXED)
                /**
                 *  setMode() 内的参数有三种模式类型：
                 *  MODE_DEFAULT 自动模式：导航栏Item的个数<=3 用 MODE_FIXED 模式，否则用 MODE_SHIFTING 模式
                 *  MODE_FIXED 固定模式：未选中的Item显示文字，无切换动画效果。
                 *  MODE_SHIFTING 切换模式：未选中的Item不显示文字，选中的显示文字，有切换动画效果。
                 */

                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                /**
                 *  setBackgroundStyle() 内的参数有三种样式
                 *  BACKGROUND_STYLE_DEFAULT: 默认样式 如果设置的Mode为MODE_FIXED，将使用BACKGROUND_STYLE_STATIC
                 *                                    如果Mode为MODE_SHIFTING将使用BACKGROUND_STYLE_RIPPLE。
                 *  BACKGROUND_STYLE_STATIC: 静态样式 点击无波纹效果
                 *  BACKGROUND_STYLE_RIPPLE: 波纹样式 点击有波纹效果
                 */

                .setActiveColor("#FF107FFD") //选中颜色
                .setInActiveColor("#e9e6e6") //未选中颜色
                .setBarBackgroundColor("#1ccbae");//导航栏背景色

        /** 添加导航按钮 */
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.home_toolbar_right, "南穗"))
                .addItem(new BottomNavigationItem(R.mipmap.home_toolbar_right, "发现"))
                .addItem(new BottomNavigationItem(R.mipmap.home_toolbar_right, "居中"))
                .addItem(new BottomNavigationItem(R.mipmap.home_toolbar_right, "消息"))
                .addItem(new BottomNavigationItem(R.mipmap.home_toolbar_right, "我的"))
                .setFirstSelectedPosition(lastSelectedPosition )
                .initialise(); //initialise 一定要放在 所有设置的最后一项

        setDefaultFragment();//设置默认导航栏

    }

    /**
     * 设置默认导航栏
     */
    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mHomeFragment = HomeFragment.newInstance("首页");
        transaction.replace(R.id.tb, mHomeFragment);
        transaction.commit();
    }

    /**
     * 设置导航选中的事件
     */
    @Override
    public void onTabSelected(int position) {
        LogUtils.sysout(TAG+"onTabSelected() called with: " + "position = [" + position + "]");
        FragmentManager fm = this.getFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.newInstance("南穗");
                }
                transaction.replace(R.id.tb, mHomeFragment);
                break;
            case 1:
                if (mScanFragment == null) {
                    mScanFragment = HomeFragment.newInstance("发现");
                }
                transaction.replace(R.id.tb, mScanFragment);
                break;
            case 2:
                if (mCenterFragment == null) {
                    mCenterFragment = HomeFragment.newInstance("居中");
                }
                transaction.replace(R.id.tb, mCenterFragment);
                break;
            case 3:
                if (mMegFragment == null) {
                    mMegFragment = HomeFragment.newInstance("消息");
                }
                transaction.replace(R.id.tb, mMegFragment);
                break;
            case 4:
                if (mMyFragment == null) {
                    mMyFragment = HomeFragment.newInstance("我的");
                }
                transaction.replace(R.id.tb, mMyFragment);
                break;

            default:
                break;
        }

        transaction.commit();// 事务提交
    }

    /**
     * 设置未选中Fragment 事务
     */
    @Override
    public void onTabUnselected(int position) {

    }

    /**
     * 设置释放Fragment 事务
     */
    @Override
    public void onTabReselected(int position) {

    }
}