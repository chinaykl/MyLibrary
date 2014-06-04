package com.chinaykl.library.android.display;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

@SuppressLint("ViewConstructor")
public class ColorLevel extends DisplayView
{
	private Paint mpaint;
	final private int defaultlevel = 256;
	final private String tag = "ColorLevel";

	public ColorLevel(Context context)
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
		final float w = (float) (width) / level;
		final float H = (float) (height) / level;
		for (i = 0; i < level; i++)
		{
			y = 0;
			r = 256 / level * i;
			for (j = 0; j < level; j++)
			{

				g = 256 / level * j;
				b = (int) (255 * Math.sin(Math.PI / 256 * j));
				mpaint.setColor(Color.rgb(r, g, b));
				canvas.drawRect(x, y, x + w, y + H, mpaint);
				y += H;
			}
			x += w;
		}
	}

}
