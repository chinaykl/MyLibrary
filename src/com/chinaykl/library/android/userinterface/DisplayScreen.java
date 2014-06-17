package com.chinaykl.library.android.userinterface;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

/*
 * Describing general information about a display, such as its size, density, and font scaling
*/
public class DisplayScreen
{
	private final String TAG = "DisplayScreen";
	private DisplayMetrics mDisplayMetrics;

	@SuppressLint("NewApi")
	public DisplayScreen(Context context)
	{
		// TODO Auto-generated constructor stub
		WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		mDisplayMetrics = new DisplayMetrics();
		windowManager.getDefaultDisplay().getRealMetrics(mDisplayMetrics);

		Log.d(TAG, "density     :" + mDisplayMetrics.density);
		Log.d(TAG, "densityDpi  :" + mDisplayMetrics.densityDpi);
		Log.d(TAG, "heightPixels:" + mDisplayMetrics.heightPixels);
		Log.d(TAG, "scaleDensity:" + mDisplayMetrics.scaledDensity);
		Log.d(TAG, "widthPixels :" + mDisplayMetrics.widthPixels);
		Log.d(TAG, "xdpi        :" + mDisplayMetrics.xdpi);
		Log.d(TAG, "ydpi        :" + mDisplayMetrics.ydpi);
	}

	public int getWidthPixels()
	{
		return mDisplayMetrics.widthPixels;
	}

	public int getHeightPixels()
	{
		return mDisplayMetrics.heightPixels;
	}

	public int getDensityDpi()
	{
		return mDisplayMetrics.densityDpi;
	}
}
