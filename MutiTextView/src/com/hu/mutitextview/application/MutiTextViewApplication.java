package com.hu.mutitextview.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;

/**
 *created by dabing on 2015-11-18下午4:39:14
 */
public class MutiTextViewApplication extends Application {
	//全局的上下文对象
		private static Context context;
		private static Handler mHandler;
	@Override
	public void onCreate() {
		super.onCreate();
		this.context = this;
		mHandler = new Handler();
	}
	public static Context getContext(){
		return context;
	}
	public static Handler getHandler(){
		return mHandler;
	}
}
