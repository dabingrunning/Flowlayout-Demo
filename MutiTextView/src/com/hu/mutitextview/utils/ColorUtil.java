package com.hu.mutitextview.utils;

import java.util.Random;

import android.graphics.Color;

public class ColorUtil {
	public static int randomColor(){
		Random random = new Random();
		//上色
		int red = random.nextInt(150)+50;
		int green = random.nextInt(150)+50;
		int blue = random.nextInt(150)+50;
		return Color.argb(255,red, green, blue);
	}
}
