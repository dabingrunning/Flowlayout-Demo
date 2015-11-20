package com.hu.mutitextview.view;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class FlowLayout extends ViewGroup {
	private final int horizontalSpacing = 12;
	private final int verticalSpacing = 12;
	private ArrayList<Line> lineList = new ArrayList<FlowLayout.Line>();

	public FlowLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public FlowLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public FlowLayout(Context context) {
		super(context);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		//在遍历之前最好清空lineList
				lineList.clear();
		int width = MeasureSpec.getSize(widthMeasureSpec);// 控件的总宽度
//		int width = getContext().getResources().getDisplayMetrics().widthPixels;
		int noPaddingWidth = width - getPaddingLeft() - getPaddingRight();// 不包含左右边距的宽度
		// 遍历FlowLayOut的子View，进行分行处理
		Line line = null;
		for (int i = 0; i < getChildCount(); i++) {
			View child = getChildAt(i);
			//为了保证能获取到子控件的尺寸，通知父控件测量
			child.measure(0, 0);
			if (line == null) {
				line = new Line();
			}
			if (line.list.size() == 0) {
				line.add(child);
			} else if (line.width + horizontalSpacing
					+ child.getMeasuredWidth() > noPaddingWidth) {
				// 判断本行的当前宽度加上新的子view后是否大于控件的总宽度,大于的话另起一行
				lineList.add(line);
				line = new Line();
				line.add(child);
			} else {// 不大于，加入当前行
				line.add(child);
			}
			if (i == (getChildCount() - 1)) {
				lineList.add(line);
			}
		}
		// for循环结束
		// 向父控件申请空间
		// 总高度 = 每行的高度和 + 上下的padding + 每行的间距
		int totleHeight = getPaddingBottom() + getPaddingTop();
		for (int i = 0; i < lineList.size(); i++) {
			totleHeight += lineList.get(i).height;
		}
		totleHeight += (lineList.size() - 1) * verticalSpacing;
		setMeasuredDimension(width, totleHeight);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		int paddingLeft = getPaddingLeft();// 控件的左内边距
		int paddingTop = getPaddingTop();// 空间的上内边距
		for (int i = 0; i < lineList.size(); i++) {
			// 得到每行
			Line line = lineList.get(i);
			if(i>0){//不是第一行，就要重新改变paddingTop的值
				paddingTop +=( lineList.get(i-1).height+verticalSpacing);
			}
			ArrayList<View> viewList = line.list;
			//1计算控件摆放完毕之后，每行的空白区域
			int remainWidth = getMeasuredWidth()-getPaddingLeft()-getPaddingRight()-line.width;
			//2平均分配给每个子view
			float perWidth = remainWidth/line.list.size();
			
			for (int j = 0; j < viewList.size(); j++) {
				View view = viewList.get(j);
				
				//3根据新的宽度设置测量规则
				int widthMeasureSpec = MeasureSpec.makeMeasureSpec((int)perWidth+view.getMeasuredWidth(), MeasureSpec.EXACTLY);
				view.measure(widthMeasureSpec, 0);
				if (j == 0) {// 每行的第一个子view的位置根据控件的padding值确定
					view.layout(paddingLeft, paddingTop,
							paddingLeft + view.getMeasuredWidth(), paddingTop
									+ view.getMeasuredHeight());
				}else{//根据前一个view的右边确定当前view的位置
					View preView = viewList.get(j-1);
					int preRight = preView.getRight();
					int left = preRight + horizontalSpacing;
					view.layout(left, preView.getTop(), left+view.getMeasuredWidth(), preView.getBottom());
				}
			}
		}
	}

	// 定义一个Line类，表示每行子View的数据
	class Line {
		private int width;// 每行的宽度
		private int height;// 每行的高度
		private ArrayList<View> list;// 用于记录本行的所有view

		public Line() {
			list = new ArrayList<View>();
		}

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}

		public void add(View childView) {
			if (!list.contains(childView)) {
				if (list.size() == 0) {// 如果之前没有子view，直接将子viwe的宽度赋值给行的宽度
					width = childView.getMeasuredWidth();
				} else {
					width += childView.getMeasuredWidth() + horizontalSpacing;
				}
				height = Math.max(height, childView.getMeasuredHeight());
				list.add(childView);
			}
		}

		public ArrayList<View> getList() {
			return list;
		}
	}
}
