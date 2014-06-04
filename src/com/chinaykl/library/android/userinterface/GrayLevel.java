package com.chinaykl.library.android.userinterface;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

@SuppressLint("ViewConstructor")
public class GrayLevel extends View
{
	static private int[] LCDInfo = new int[3];
	final private int Width = 0;
	final private int Height = 1;
	final private int Density = 2;
	final private int defaultlevel = 64;
	private Paint mpaint;
	final private String tag = "GrayLevel";

	public GrayLevel(Context context)
	{
		super(context);
		// TODO Auto-generated constructor stub
		DisplayScreen mDisplayScreen = new DisplayScreen(context);
		LCDInfo[Width] = mDisplayScreen.getWidthPixels();
		LCDInfo[Height] = mDisplayScreen.getHeightPixels();
		LCDInfo[Density] = mDisplayScreen.getDensityDpi();
		Log.i(tag, "LCD Width   :" + LCDInfo[Width]);
		Log.i(tag, "LCD Height  :" + LCDInfo[Height]);
		Log.i(tag, "LCD Density :" + LCDInfo[Density]);
		mpaint = new Paint();
		mpaint.setStrokeJoin(Paint.Join.ROUND);
		mpaint.setStrokeCap(Paint.Cap.ROUND);
		mpaint.setAntiAlias(true);
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		// TODO Auto-generated method stub
		super.onDraw(canvas);

		DrawGrayLevel(canvas, defaultlevel);
	}

	private void DrawGrayLevel(Canvas canvas, int level)
	{
		int i = 0;
		float x = 0;
		final float w = (float) (LCDInfo[Width]) / level;
		for (i = 0; i < level; i++)
		{
			int rgb = 256 / level * i;
			mpaint.setColor(Color.rgb(rgb, rgb, rgb));
			canvas.drawRect(x, 0, x + w, LCDInfo[Height], mpaint);
			x += w;
		}
	}
}
