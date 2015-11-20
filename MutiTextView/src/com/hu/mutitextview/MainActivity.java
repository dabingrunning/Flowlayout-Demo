package com.hu.mutitextview;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hu.mutitextview.utils.ColorUtil;
import com.hu.mutitextview.utils.CommonUtils;
import com.hu.mutitextview.utils.DrawableUtil;
import com.hu.mutitextview.view.FlowLayout;

public class MainActivity extends Activity {

	private int horizontal_padding;
	private int vertical_padding;
	private int flow_padding;
	private FlowLayout flow;
	private EditText et_input;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		horizontal_padding = (int) CommonUtils
				.getDimens(R.dimen.horizontal_padding);
		vertical_padding = (int) CommonUtils
				.getDimens(R.dimen.vertical_padding);
		flow_padding = (int) CommonUtils.getDimens(R.dimen.flow_padding);
		
		setContentView(R.layout.activity_main);
		RelativeLayout container = (RelativeLayout)
				findViewById(R.id.flow_container);
		flow = (FlowLayout) findViewById(R.id.flow); 
		et_input = (EditText) findViewById(R.id.et_input);
		flow.setPadding(flow_padding, flow_padding, flow_padding,
				flow_padding);
		addTextView();
	}
	public void tijiao(View v){
		TextView textView = new TextView(this);
		textView.setText(et_input.getText());
		textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
		textView.setPadding(horizontal_padding, vertical_padding,
				horizontal_padding, vertical_padding);
		textView.setTextColor(Color.WHITE);
		textView.setGravity(Gravity.CENTER);
		int randomColor = ColorUtil.randomColor();
		GradientDrawable normal = DrawableUtil.getGradientDrawable(5,
				randomColor);
		GradientDrawable pressed = DrawableUtil.getGradientDrawable(5,
				Color.GRAY);
		StateListDrawable selector = DrawableUtil.getSelector(pressed,
				normal);
		textView.setBackgroundDrawable(selector);
		flow.addView(textView);
	}
	private void addTextView() {
		ArrayList<String> hotList = new ArrayList<String>();
		hotList.add("奇衡三1");
		hotList.add("奇衡三11");
		hotList.add("奇衡三22");
		hotList.add("奇衡三3222");
		hotList.add("奇衡三33");
		hotList.add("奇衡三444");
		hotList.add("奇衡三555");
		hotList.add("奇衡三12443");
		hotList.add("奇衡三522");
		hotList.add("奇衡三2342");
		hotList.add("奇衡三23");
		
		
		for (int i = 0; i < hotList.size(); i++) {
			final TextView textView = new TextView(this);
			textView.setText(hotList.get(i));
			textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
			textView.setPadding(horizontal_padding, vertical_padding,
					horizontal_padding, vertical_padding);
			textView.setTextColor(Color.WHITE);
			textView.setGravity(Gravity.CENTER);
			int randomColor = ColorUtil.randomColor();
			GradientDrawable normal = DrawableUtil.getGradientDrawable(5,
					randomColor);
			GradientDrawable pressed = DrawableUtil.getGradientDrawable(5,
					Color.GRAY);
			StateListDrawable selector = DrawableUtil.getSelector(pressed,
					normal);
			textView.setBackgroundDrawable(selector);
			flow.addView(textView);
		}
	}

}
