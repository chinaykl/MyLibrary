package com.chinaykl.library.android.display;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

@SuppressLint("ViewConstructor")
public class GrayLevel extends DisplayView
{
	final private int defaultlevel = 64;
	final private Paint mpaint;
	final private String tag = "GrayLevel";

	public GrayLevel(Context context)
	{
		super(context);
		// TODO Auto-generated constructor stub
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
		final float w = (float) width / level;
		for (i = 0; i < level; i++)
		{
			int rgb = 256 / level * i;
			mpaint.setColor(Color.rgb(rgb, rgb, rgb));
			canvas.drawRect(x, 0, x + w, height, mpaint);
			x += w;
		}
	}
}
