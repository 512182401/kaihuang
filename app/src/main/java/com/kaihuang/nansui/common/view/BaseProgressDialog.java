/**
 * @Title: BaseProgressDialog.java
 * @Package com.klch.fc.base
 * @Description: TODO
 * Copyright: Copyright (c) 2012 
 * Company:ezg
 * 
 * @author Comsys-ningh
 * @date 2014-5-4 下午3:44:46
 * @version V1.0
 */

package com.kaihuang.nansui.common.view;


import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kaihuang.nansui.R;


/**
 */

public class BaseProgressDialog {
	private Dialog pd;
	private static BaseProgressDialog instance ;
	public BaseProgressDialog(){};
	public static BaseProgressDialog getInstance(){
		if(instance==null){
			instance=new BaseProgressDialog();
		}
		return instance;
	}
	/**
	 * pd
	 * 
	 * @return the pd
	 * @since CodingExample Ver() 1.0
	 */

	public Dialog getPd() {
		return pd;
	}

	/**
	 * @param pd
	 *            the pd to set
	 */

	public void setPd(ProgressDialog pd) {
		this.pd = pd;
	}

	public void show(Activity context, CharSequence message, boolean isCancelable) {
		if(context==null||context.isFinishing())return;
		LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(R.layout.common_progress_dialog, null);// 得到加载view
		LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);// 加载布局
		// main.xml中的ImageView
		ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
		TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);// 提示文字
		String msg=(String) message;
		if(TextUtils.isEmpty(msg)){
			tipTextView.setVisibility(View.GONE);
		}else{
			tipTextView.setVisibility(View.VISIBLE);
		}
//		// 加载动画
//		AnimationDrawable animationDrawable = (AnimationDrawable) spaceshipImage
//				.getBackground();
//		animationDrawable.start();
		Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
				context, R.anim.loading_progress);
//		 使用ImageView显示动画
		spaceshipImage.startAnimation(hyperspaceJumpAnimation);
		tipTextView.setText(message);// 设置加载信息

		pd = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog

//		pd.setCancelable(false);// 不可以用“top_choose_back”取消
		pd.setContentView(layout, new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));// 设置布局
//		this.pd = ProgressDialog.show(context, title, message);
		this.pd.setCancelable(isCancelable);
		this.pd.setCanceledOnTouchOutside(isCancelable);
		if(context==null||context.isFinishing()){
			return;
		}		
		this.pd.show();
	}
	
	public void dismiss() {
		if(pd!=null&&pd.isShowing()){
			this.pd.dismiss();
		}
	}

}
