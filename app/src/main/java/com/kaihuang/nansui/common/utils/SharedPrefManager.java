package com.kaihuang.nansui.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;

import com.kaihuang.nansui.module.base.BaseApplication;
import com.kaihuang.nansui.module.entry.Setting;
import com.kaihuang.nansui.module.entry.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;


public class SharedPrefManager {
    private static final String SHAREPRE_FILE_NAME = "user";
    private static SharedPrefManager instance;
    private static SharedPreferences mShpr;//

    private static final String USER_Object = "user";
    private static final String SOUND_Object = "Soundes";//各种音量大小
    private static final String Language_Object = "language";//语言类型
    /**
     * 支付相关保存
     */
    private static final String PAY_WXALI = "paywxali";//支付相关保存

    private static final String PersonSet_Object = "personset";//个人设置信息

    private static final String SETTING_Object = "setting";//设置

    private String IS_AutoLogin = "autologin";
    private String lock = "lock";


    private static final String Code_Section1_Cache_Data = "";
    //是否更新app的日期
    public static final String IS_UP_APP = "is_upapp";

    // 保存字段名称 start
    /**
     * 是否第一次启动App
     */
    public static final String IS_EXECUTE_FIRST = "is_execute_first";
    public static final String IS_Device_ID_upload = "device_id_upload";

    // 保存字段名称 end

    private SharedPrefManager() {
        mShpr = BaseApplication.app.getSharedPreferences(SHAREPRE_FILE_NAME,
                Context.MODE_PRIVATE);
    }

    /**
     * 单例模式，返回SharedPrefManager的静态实例；
     *
     * @return
     */
    public static SharedPrefManager getInstance() {
        if (instance == null) {
            instance = new SharedPrefManager();
        }
        return instance;
    }

    /**
     * 清除缓存
     */
    public void clearAllData() {
        synchronized (lock) {
            mShpr.edit().clear().commit();
        }
    }


    /**
     * 保存语言设置
     */
    public void cacheApiLanguage(String json) {
        synchronized (lock) {
            mShpr.edit().putString(Language_Object, json).commit();
        }
    }

    public String getCacheApiLanguage() {
        synchronized (lock) {
            return mShpr.getString(Language_Object, "language");
//            return mShpr.getString( Language_Object, "zh_TW" );
        }
    }

//    /**
//     * 支付相关保存(微信，支付宝)
//     */
//    public void cachePayWXAliData(WXResult mWXResult) {
//        synchronized (lock) {
////            mShpr.ad( PAY_WXALI, json ).commit();
//            setObject(PAY_WXALI, mWXResult);
//        }
//    }


//    public WXResult getCachePayWXAliData() {
//        synchronized (lock) {
//            return getObject(PAY_WXALI, WXResult.class);
//        }
//    }


    /**
     * 保存app检测的时间
     */
    public void cacheApiupapp(String json) {
        synchronized (lock) {
            mShpr.edit().putString( IS_UP_APP, json ).commit();
        }
    }

    public String getCacheApiupapp() {
        synchronized (lock) {
            return mShpr.getString( IS_UP_APP, "" );
        }
    }


    /**
     * 保存用户信息到本地
     *
     * @param user
     */
    public void saveUserToLocal(User user) {
        setObject(USER_Object, user);

        LogUtils.sysout("保存user数据，为了自动登录");
    }

    //
    public User getUserFromLocal() {

        LogUtils.sysout("请求登录数据");
        return getObject(USER_Object, User.class);
    }


    /**
     * 针对复杂类型存储<对象>
     */
    public void setObject(String key, Object object) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(baos);
            out.writeObject(object);
            String objectVal = new String(Base64.encode(baos.toByteArray(),
                    Base64.DEFAULT));
            Editor editor = mShpr.edit();
            editor.putString(key, objectVal);
            editor.commit();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getObject(String key, Class<T> clazz) {
        if (mShpr.contains(key)) {
            String objectVal = mShpr.getString(key, null);
            byte[] buffer = Base64.decode(objectVal, Base64.DEFAULT);
            ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(bais);
                T t = (T) ois.readObject();
                return t;
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bais != null) {
                        bais.close();
                    }
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


//保存设置数据：

    public void saveSettingToLocal(Setting setting) {
        setObject(SETTING_Object, setting);

        LogUtils.sysout("保存setting数据，为了");
    }

    public Setting getSettingFromLocal() {

        LogUtils.sysout("请求设置数据");
        return getObject(SETTING_Object, Setting.class);
    }
}
