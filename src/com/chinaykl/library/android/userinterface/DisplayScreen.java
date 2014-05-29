package com.chinaykl.library.android.userinterface;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

public class DisplayScreen
{
	private final String tag = "DisplayScreen";
	private int widthPixels;
	private int heightPixels;
	private int densityDpi;

	@SuppressLint("NewApi")
	public DisplayScreen(Context context)
	{
		// TODO Auto-generated constructor stub
		WindowManager windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics mDisplayMetrics = new DisplayMetrics();
		windowManager.getDefaultDisplay().getRealMetrics(mDisplayMetrics);
		widthPixels = mDisplayMetrics.widthPixels;
		heightPixels = mDisplayMetrics.heightPixels;
		densityDpi = mDisplayMetrics.densityDpi;

		Log.i(tag, "Width :" + widthPixels);
		Log.i(tag, "Height:" + heightPixels);
		Log.i(tag, "DPI   :" + densityDpi);
	}

	public int getWidthPixels()
	{
		return widthPixels;
	}

	public int getHeightPixels()
	{
		return heightPixels;
	}

	public int getDensityDpi()
	{
		return densityDpi;
	}
}
