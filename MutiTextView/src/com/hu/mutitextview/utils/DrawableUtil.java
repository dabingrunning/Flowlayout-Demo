package com.hu.mutitextview.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

public class DrawableUtil {
	/**
	 * 根据传入的圆角半径和颜色值，构建一个图片
	 * @param radius
	 * @param argb
	 * @return
	 */
	public static GradientDrawable getGradientDrawable(float radius,int argb){
		GradientDrawable drawable = new GradientDrawable();
		drawable.setCornerRadius(radius);
		drawable.setColor(argb);
		drawable.setShape(GradientDrawable.RECTANGLE);
		return drawable;
	}
	/**
	 * 
	 * @param pressed
	 * @param normal
	 * @return
	 */
	public static StateListDrawable getSelector(Drawable pressed,Drawable normal){
		StateListDrawable stateDrawable = new StateListDrawable();
		stateDrawable.addState(new int[]{android.R.attr.state_pressed}, pressed);
		stateDrawable.addState(new int[]{}, normal);
		return stateDrawable;
	}
}
