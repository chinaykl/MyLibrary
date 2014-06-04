package com.chinaykl.library.android.display;

import com.chinaykl.library.android.userinterface.DisplayScreen;

import android.content.Context;
import android.util.Log;
import android.view.View;

public class DisplayView extends View
{
	protected int width = 0;
	protected int height = 0;
	protected int density = 0;
	final private String tag = "DisplayView";

	public DisplayView(Context context)
	{
		super(context);
		// TODO Auto-generated constructor stub
		DisplayScreen mDisplayScreen = new DisplayScreen(context);
		width = mDisplayScreen.getWidthPixels();
		height = mDisplayScreen.getHeightPixels();
		density = mDisplayScreen.getDensityDpi();
		Log.i(tag, "LCD Width   :" + width);
		Log.i(tag, "LCD Height  :" + height);
		Log.i(tag, "LCD Density :" + density);
	}

}
