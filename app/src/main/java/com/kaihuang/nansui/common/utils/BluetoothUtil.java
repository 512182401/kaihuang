package com.kaihuang.nansui.common.utils;

/**
 * 字符串相关类：
 */
public class BluetoothUtil {

    public static int[] isIncludeAll(int type, int[] value) {
//        int lenght = 0x13;
        int lenght = value.length + 5;
        int[] all = new int[lenght];
        all[0] = 0xfe;
        all[1] = 0x00;
        all[2] = lenght;
        all[3] = type;
        if (lenght > 5) {
            for (int l = 4; l < lenght; l++) {
                all[l] = value[l - 4];
            }
        }
        for (int i = 2; i < lenght; i++) {
            all[lenght - 1] += all[i];
        }
        return all;
    }

    public static int[] isInclude80() {
        int[] all = new int[5];
        all[0] = 0xfe;
        all[1] = 0x00;
        all[2] = 0x05;
        all[3] = 0x80;
        all[4] = 0x85;
        return all;
    }

    public static int[] isInclude81(int value) {
        int lenght = 6;
        int[] all = new int[lenght];
        all[0] = 0xfe;
        all[1] = 0x00;
        all[2] = lenght;
        all[3] = 0x81;
        all[4] = value;
//        all[5] = all[2] + all[3] + all[4];
        for (int i = 2; i < lenght; i++) {
            all[lenght - 1] += all[i];
        }
        return all;
    }


    public static int[] isInclude84(int type, int value) {
        int lenght = 7;
        int[] all = new int[lenght];
        all[0] = 0xfe;
        all[1] = 0x00;
        all[2] = lenght;
        all[3] = 0x84;
        all[4] = type;
        all[5] = value;
//        all[6] = all[2] + all[3] + all[4] + all[5];
        for (int i = 2; i < lenght; i++) {
            all[lenght - 1] += all[i];
        }
        return all;
    }


    public static int[] isInclude85(int value) {
        int lenght = 6;
        int[] all = new int[lenght];
        all[0] = 0xfe;
        all[1] = 0x00;
        all[2] = lenght;
        all[3] = 0x85;
        all[4] = value;
//        all[5] = all[2] + all[3] + all[4];
        for (int i = 2; i < lenght; i++) {
            all[lenght - 1] += all[i];
        }
        return all;
    }

    public static int[] isInclude86(int value) {
        int lenght = 6;
        int[] all = new int[lenght];
        all[0] = 0xfe;
        all[1] = 0x00;
        all[2] = lenght;
        all[3] = 0x86;
        all[4] = value;
//        all[5] = all[2] + all[3] + all[4];
        for (int i = 2; i < lenght; i++) {
            all[lenght - 1] += all[i];
        }
        return all;
    }

    public static int[] isInclude87(int value) {
        int lenght = 6;
        int[] all = new int[lenght];
        all[0] = 0xfe;
        all[1] = 0x00;
        all[2] = lenght;
        all[3] = 0x87;
        all[4] = value;
//        all[5] = all[2] + all[3] + all[4];
        for (int i = 2; i < lenght; i++) {
            all[lenght - 1] += all[i];
        }
        return all;
    }

    public static int[] isInclude88(int value) {
        int lenght = 6;
        int[] all = new int[lenght];
        all[0] = 0xfe;
        all[1] = 0x00;
        all[2] = lenght;
        all[3] = 0x88;
        all[4] = value;
//        all[5] = all[2] + all[3] + all[4];
        for (int i = 2; i < lenght; i++) {
            all[lenght - 1] += all[i];
        }
        return all;
    }

    public static int[] isInclude89(int type, int value) {
        int lenght = 7;
        int[] all = new int[lenght];
        all[0] = 0xfe;
        all[1] = 0x00;
        all[2] = lenght;
        all[3] = 0x89;
        all[4] = type;
        all[5] = value;
//        all[6] = all[2] + all[3] + all[4] + all[5];
        for (int i = 2; i < lenght; i++) {
            all[lenght - 1] += all[i];
        }
        return all;
    }

    public static int[] isInclude8b(int type, int value) {
        int lenght = 7;
        int[] all = new int[lenght];
        all[0] = 0xfe;
        all[1] = 0x00;
        all[2] = lenght;
        all[3] = 0x8b;
        all[4] = type;
        all[5] = value;
//        all[6] = all[2] + all[3] + all[4] + all[5];
        for (int i = 2; i < lenght; i++) {
            all[lenght - 1] += all[i];
        }
        return all;
    }

    public static int[] isInclude8c(int type, int value) {
        int lenght = 7;
        int[] all = new int[lenght];
        all[0] = 0xfe;
        all[1] = 0x00;
        all[2] = lenght;
        all[3] = 0x8c;
        all[4] = type;
        all[5] = value;
//        all[6] = all[2] + all[3] + all[4] + all[5];
        for (int i = 2; i < lenght; i++) {
            all[lenght - 1] += all[i];
        }
        return all;
    }

    public static int[] isInclude8e() {
        int[] all = new int[5];
        all[0] = 0xfe;
        all[1] = 0x00;
        all[2] = 0x05;
        all[3] = 0x8e;
        all[4] = 0x93;
        return all;
    }

    public static int[] isInclude90() {
        int[] all = new int[5];
        all[0] = 0xfe;
        all[1] = 0x00;
        all[2] = 0x05;
        all[3] = 0x90;
        all[4] = 0x95;
        return all;
    }


    public static int[] isInclude91(int value) {
        int lenght = 6;
        int[] all = new int[lenght];
        all[0] = 0xfe;
        all[1] = 0x00;
        all[2] = lenght;
        all[3] = 0x91;
        all[4] = value;
//        all[5] = all[2] + all[3] + all[4];
        for (int i = 2; i < lenght; i++) {
            all[lenght - 1] += all[i];
        }
        return all;
    }


    //    public static int[] isInclude94(int value4, int value5, int value6, int value7, int value8, int value9, int value10, int value11,
//                                    int value12, int value13, int value14, int value15, int value16, int value17) {
    public static int[] isInclude94(int[] value) {
//        int lenght = 0x13;
        int lenght = value.length + 5;
        int[] all = new int[lenght];
        all[0] = 0xfe;
        all[1] = 0x00;
        all[2] = lenght;
        all[3] = 0x94;

//        all[6] = all[2] + all[3] + all[4] + all[5];
        for (int l = 4; l < lenght; l++) {
            all[l] = value[l - 4];
        }
        for (int i = 2; i < lenght; i++) {
            all[lenght - 1] += all[i];
        }
        return all;
    }


}
