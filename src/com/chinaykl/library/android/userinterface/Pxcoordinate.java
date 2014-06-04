package com.chinaykl.library.android.userinterface;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

@SuppressLint("ViewConstructor")
public class Pxcoordinate extends View // implements Runnable
{
	static private int[] LCDInfo = new int[3];
	final private int Width = 0;
	final private int Height = 1;
	final private int Density = 2;
	final private int n = 3;
	final private int LineWidth = 10;
	final private int Margins = 20;
	final private float ArrowHeadLong = 20;
	final private float ArrowHeadDegrees = 45;
	final private float TextSize = 40;
	Paint mpaint;
	String tag = "PxCoordinate";

	public Pxcoordinate(Context context)
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
		mpaint.setColor(Color.BLUE);
		mpaint.setTextSize(TextSize);
		mpaint.setStrokeJoin(Paint.Join.ROUND);
		mpaint.setStrokeCap(Paint.Cap.ROUND);
		mpaint.setStrokeWidth(LineWidth);
		mpaint.setAntiAlias(true);
	}

	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);

		canvas.drawColor(Color.WHITE);

		DrawCoordinate(canvas);
		DrawInfomation(canvas);

	}

	private void DrawCoordinate(Canvas canvas)
	{
		float ratiox = (float) (LCDInfo[Width] - Margins) / LCDInfo[Width];
		float ratioy = (float) (LCDInfo[Height] - Margins) / LCDInfo[Height];
		canvas.drawLine(Margins, Margins, LCDInfo[Width], Margins, mpaint);
		canvas.drawLine(Margins, Margins, Margins, LCDInfo[Height], mpaint);
		canvas.save();
		// x
		canvas.translate(LCDInfo[Width], Margins);
		canvas.rotate(ArrowHeadDegrees);
		canvas.drawLine(0, 0, -ArrowHeadLong, 0, mpaint);
		canvas.drawLine(0, 0, 0, ArrowHeadLong, mpaint);

		canvas.restore();
		canvas.save();
		// y
		canvas.translate(Margins, LCDInfo[Height]);
		canvas.rotate(ArrowHeadDegrees);
		canvas.drawLine(0, 0, -ArrowHeadLong, 0, mpaint);
		canvas.drawLine(0, 0, 0, -ArrowHeadLong, mpaint);

		canvas.restore();
		canvas.save();
		// origin
		canvas.translate(Margins, Margins);
		canvas.drawText("0", Margins * 3, Margins * 3 + TextSize / 2, mpaint);
		{
			// x
			int i = 0;
			int w = 0;
			float x = 0;
			for (i = 0; i < LCDInfo[Width]; i = i + 100)
			{
				if (i > 0)
				{
					x = i * ratiox;
					if (i % 500 == 0)
					{
						w = Margins * 2;
						canvas.drawText(String.valueOf(i), x - TextSize / 4, Margins * 3 + TextSize / 2, mpaint);
					}
					else
					{
						w = Margins;
					}
				}
				else
				{
					continue;
				}
				canvas.drawLine(x, 0, x, w, mpaint);
			}
		}
		{
			// y
			int i = 0;
			int w = 0;
			float y = 0;
			for (i = 0; i < LCDInfo[Height]; i = i + 100)
			{
				if (i > 0)
				{
					y = i * ratioy;
					if (i % 500 == 0)
					{
						w = Margins * 2;
						canvas.drawText(String.valueOf(i), Margins * 3, y + TextSize / 3, mpaint);
					}
					else
					{
						w = Margins;
					}
				}
				else
				{
					continue;
				}
				canvas.drawLine(0, y, w, y, mpaint);
			}
		}
	}

	private void DrawInfomation(Canvas canvas)
	{
		int i = 0;
		int x = LCDInfo[Width] / 3;
		int y = LCDInfo[Height] / 4;
		for (i = 0; i < n; i++)
		{
			y += TextSize * 2;
			switch (i)
			{
				case Width:
					canvas.drawText("LCD Width   :", x, y, mpaint);
					break;
				case Height:
					canvas.drawText("LCD Height  :", x, y, mpaint);
					break;
				case Density:
					canvas.drawText("LCD Density :", x, y, mpaint);
					break;
				default:
					break;
			}
			canvas.drawText(String.valueOf(LCDInfo[i]), x + TextSize * 7, y, mpaint);
		}
	}
}
