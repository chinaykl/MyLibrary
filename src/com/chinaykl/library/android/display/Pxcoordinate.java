package com.chinaykl.library.android.display;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

@SuppressLint("ViewConstructor")
public class Pxcoordinate extends DisplayView // implements Runnable
{
	final private int LineWidth = 10;
	final private int Margins = 20;
	final private float ArrowHeadLong = 20;
	final private float ArrowHeadDegrees = 45;
	final private float TextSize = 40;
	final private Paint mpaint;
	final private String tag = "PxCoordinate";

	public Pxcoordinate(Context context)
	{
		super(context);
		// TODO Auto-generated constructor stub
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
		float ratiox = (float) (width - Margins) / width;
		float ratioy = (float) (height - Margins) / height;
		canvas.drawLine(Margins, Margins, width, Margins, mpaint);
		canvas.drawLine(Margins, Margins, Margins, height, mpaint);
		canvas.save();
		// x
		canvas.translate(width, Margins);
		canvas.rotate(ArrowHeadDegrees);
		canvas.drawLine(0, 0, -ArrowHeadLong, 0, mpaint);
		canvas.drawLine(0, 0, 0, ArrowHeadLong, mpaint);

		canvas.restore();
		canvas.save();
		// y
		canvas.translate(Margins, height);
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
			for (i = 0; i < width; i = i + 100)
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
			for (i = 0; i < height; i = i + 100)
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
		int x = width / 3;
		int y = height / 4;
		// Width
		y += TextSize * 2;
		canvas.drawText("LCD Width   :", x, y, mpaint);
		canvas.drawText(String.valueOf(width), x + TextSize * 7, y, mpaint);
		// Height:
		y += TextSize * 2;
		canvas.drawText("LCD Height  :", x, y, mpaint);
		canvas.drawText(String.valueOf(height), x + TextSize * 7, y, mpaint);
		// Density:
		y += TextSize * 2;
		canvas.drawText("LCD Density :", x, y, mpaint);
		canvas.drawText(String.valueOf(density), x + TextSize * 7, y, mpaint);
	}
}
