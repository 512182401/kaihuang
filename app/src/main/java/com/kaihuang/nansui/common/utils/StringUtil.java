package com.kaihuang.nansui.common.utils;

import android.content.Context;

/**
 * 字符串相关类：
 */
public class StringUtil {
    /**
     * 判断字符串包含某个字符段
     */
    public static boolean isInclude(Context context, String desString, String key) {
        boolean isinclude = false;
        if (desString.indexOf(key) != -1) {
//			System.out.println("包含该字符串");
            isinclude = true;
        }
        return isinclude;
    }

    /**
     * 根据逗号拆分：
     */
    public static String[] subStr(Context context, String desString, String splites) {
//        String[] all = desString.split(",");
        String[] all = desString.split(splites);
        return all;
    }

    /**
     * 根据逗号拆分：
     */
    public static String[] checkStr(Context context, String desString, String splites) {
//        String[] all = desString.split("|");
        String[] all = desString.split(splites);
        return all;
    }

    /**
     * 校验和
     *
     * @param msg 需要计算校验和的byte数组
     * @param length 校验和位数
     * @return 计算出的校验和数组
     */
    private byte[] SumCheck(byte[] msg, int length) {
        long mSum = 0;
        byte[] mByte = new byte[length];

        /** 逐Byte添加位数和 */
        for (byte byteMsg : msg) {
            long mNum = ((long)byteMsg >= 0) ? (long)byteMsg : ((long)byteMsg + 256);
            mSum += mNum;
        } /** end of for (byte byteMsg : msg) */

        /** 位数和转化为Byte数组 */
        for (int liv_Count = 0; liv_Count < length; liv_Count++) {
            mByte[length - liv_Count - 1] = (byte)(mSum >> (liv_Count * 8) & 0xff);
        } /** end of for (int liv_Count = 0; liv_Count < length; liv_Count++) */

        return mByte;
    }

}
