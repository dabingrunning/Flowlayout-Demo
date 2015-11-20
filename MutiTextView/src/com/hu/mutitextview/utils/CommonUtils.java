package com.hu.mutitextview.utils;

import com.hu.mutitextview.application.MutiTextViewApplication;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class CommonUtils {
	/**
	 * 移除指定child的父控件
	 * @param child
	 */
	public static void removeSelfFromParent(View child){
		if(child !=null){
			ViewParent parent = child.getParent();
			if(parent!=null && parent instanceof ViewGroup){
				ViewGroup group = (ViewGroup) parent;
				group.removeView(child);
			}
		}
	}
	/**
	 * 主线程上执行任务
	 * @param r
	 */
	public static void runOnUiThread(Runnable r){
		MutiTextViewApplication.getHandler().post(r);
	}
	
	public static Resources getResources(){
		return MutiTextViewApplication.getContext().getResources();
	}
	
	/**
	 * 获取字符串资源
	 * @param resId
	 * @return
	 */
	public static String getString(int resId){
		return getResources().getString(resId);
	}
	/**
	 * 获取图片资源
	 * @param resId
	 * @return
	 */
	public static Drawable getDrawable(int resId){
		return getResources().getDrawable(resId);
	}
	/**
	 * 获取颜色资源
	 * @param resId
	 * @return
	 */
	public static int getColor(int resId){
		return getResources().getColor(resId);
	}
	/**
	 * 获取dimens资源
	 * @param resId
	 * @return
	 */
	public static float getDimens(int resId){
		return getResources().getDimension(resId);
	}
	/**
	 * 获取字符串数组
	 * @param resId
	 * @return
	 */
	public static String[] getStringArray(int resId){
		return getResources().getStringArray(resId);
	} 
}
