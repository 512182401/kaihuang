package com.kaihuang.nansui.module.base;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.kaihuang.nansui.common.utils.PreferUtil;
import com.kaihuang.nansui.common.utils.SharedPrefManager;
import com.kaihuang.nansui.module.entry.User;


public class BaseApplication extends MultiDexApplication {//MultiD
    private static User user;

    public static BaseApplication app;
    //	private static Context ct;
    private static boolean islogined = false;//用于判断是否登录



    @Override
    public void onCreate() {
        super.onCreate();
        app = this;


//        LeakCanary.install(this);//内存泄漏检测
//        CanaryLog.Logger.init("LogTAG");
        try {
            PreferUtil.getInstance().init(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        /***
//         * 初始化定位sdk，建议在Application中创建
//         */
//        locationService = new LocationService(getApplicationContext());
//        mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
////        SDKInitializer.initialize(getApplicationContext());

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    //各个平台的配置，建议放在全局Application或者程序入口vv
    static {
//        //微信 wx12342956d1cab4f9,a5ae111de7d9ea137e88a5e02c07c94d
//        PlatformConfig.setWeixin("wx11f4ad30030a2ea6", "6bafa9f4ac5657ab0a0b822a8c4f8fb7");
//        //sina_weibo
//        PlatformConfig.setSinaWeibo("583673191", "106e466b8caec96a011774cedc4ae571");//新浪：quchangkeji@126.com 密码：quchangkeji@123
//        PlatformConfig.setQQZone("1106497680", "fSX59q9mDQxxt1l0");//Android
    }

    public static boolean islogined() {
        return islogined;
    }

    public static void setIslogined(boolean islogined) {
        BaseApplication.islogined = islogined;
    }

    public static User getUser() {
        if (user != null) {
            return user;
        } else {
            user = SharedPrefManager.getInstance().getUserFromLocal();
            if (user != null) {
                setIslogined(true);
            }
            return user;
        }

    }


    public void setUser(User user) {
        BaseApplication.user = user;
    }


    /**
     * 退出登录
     */
    public void exitLogin() {
        user = null;
    }

    public static String getOpenId() {
        User user = getUser();
        if (user == null) {
            return "0";
        }
        return null;//user.getOpenid();
    }


    public static boolean isLogin() {
        User user = getUser();
        return user != null;
    }

    @Override
    public void onTerminate() {// 程序终止的时候执行
        super.onTerminate();
//        if (netWorkStateReceiver != null) {
//            unregisterReceiver(netWorkStateReceiver);
//        }
    }
}
