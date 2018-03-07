package com.kaihuang.nansui.module.engine;

import android.content.Context;
import android.view.View;

import com.kaihuang.nansui.common.utils.dialog.AlertDialog;


public class LoginedDialog {

	public static void loginedcheck(final Context context){
		new AlertDialog(context).builder()
				.setTitle("未登录")
				.setMsg("您当前未登录或者登录状态出错，请重新登录！")
				.setPositiveButton("登录", new View.OnClickListener() {
					@Override
					public void onClick(View v) {
//						Intent it = new Intent(context, LoginAuthActivity.class);
//						it.putExtra("isfirst",1);
//						context.startActivity(it);
					}
				}).setNegativeButton("取消", new View.OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		}).show();
	}

}
