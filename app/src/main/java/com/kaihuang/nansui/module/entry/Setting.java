package com.kaihuang.nansui.module.entry;

import java.io.Serializable;


/**
 * 设置实体类
 *
 * @author admin
 *         方式一：Code-->Generate
 *         <p>
 *         方式二：通过快捷键Alt+Insert
 */
public class Setting implements Serializable {

    private int wifi;//网络提醒 1：非wifi环境下每次都提醒； 2：非wifi环境下首次都提醒；3：不做任何提醒
    private boolean prompt;//true提示音开启
    private boolean diialog;//true 接收消息时弹框提醒，
    private boolean positioning;//true 定位，可以通过：false关闭定位时，进入发现频道，未提示需要打开定位服务


    public Setting() {
    }

    public Setting(boolean diialog, boolean positioning, boolean prompt, int wifi) {
        this.diialog = diialog;
        this.positioning = positioning;
        this.prompt = prompt;
        this.wifi = wifi;
    }

    public boolean isDiialog() {
        return diialog;
    }

    public void setDiialog(boolean diialog) {
        this.diialog = diialog;
    }

    public boolean isPositioning() {
        return positioning;
    }

    public void setPositioning(boolean positioning) {
        this.positioning = positioning;
    }

    public boolean isPrompt() {
        return prompt;
    }

    public void setPrompt(boolean prompt) {
        this.prompt = prompt;
    }

    public int getWifi() {
        if(wifi==0){
            return 2;
        }else{
            return wifi;
        }

    }

    public void setWifi(int wifi) {
        this.wifi = wifi;
    }
}
