package com.chinaykl.library.android.userinterface;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

@SuppressLint("ViewConstructor")
public class ColorLevel extends View
{
	static private int[] LCDInfo = new int[3];
	final private int Width = 0;
	final private int Height = 1;
	final private int Density = 2;
	private Paint mpaint;
	final private int defaultlevel = 256;
	final private String tag = "ColorLevel";

	public ColorLevel(Context context)
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
		DrawColorLevel(canvas, defaultlevel);
	}

	private void DrawColorLevel(Canvas canvas, int level)
	{
		int i = 0;
		int j = 0;
		float x = 0;
		float y = 0;
		int r = 0;
		int g = 0;
		int b = 0;
		final float w = (float) (LCDInfo[Width]) / level;
		final float H = (float) (LCDInfo[Height]) / level;
		for (i = 0; i < level; i++)
		{
			y = 0;
			r = 256 / level * i;
			for (j = 0; j < level; j++)
			{

				g = 256 / level * j;
				b=(int) (255*Math.sin(Math.PI/256*j));
				mpaint.setColor(Color.rgb(r, g, b));
				canvas.drawRect(x, y, x + w, y + H, mpaint);
				y += H;
			}
			x += w;
		}
	}

}
