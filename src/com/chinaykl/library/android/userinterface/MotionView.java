package com.chinaykl.library.android.userinterface;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.View;

public class MotionView extends View
{

	private final String tag = "MotionView";
	ArrayList<MotionView.Pointer> list = new ArrayList<MotionView.Pointer>();
	Paint mPaint = new Paint();
	final float textSize = 20.0f;
	final float scaleX = 2.0f;
	final int picLineWidth = 8;
	final int textLineWidth = 2;
	final int mcolor[] =
	{ Color.BLUE, Color.CYAN, Color.DKGRAY, Color.BLACK, Color.GREEN, Color.MAGENTA, Color.RED, Color.GRAY, Color.YELLOW };
	DisplayScreen mDisplayScreen;

	public MotionView(Context context)
	{
		super(context);
		// TODO Auto-generated constructor stub
		mDisplayScreen = new DisplayScreen(context);
		mPaint.setTextScaleX(scaleX);
		mPaint.setStrokeJoin(Paint.Join.ROUND);
		mPaint.setStrokeCap(Paint.Cap.ROUND);
		mPaint.setAntiAlias(true);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		// TODO Auto-generated method stub
		switch (event.getActionMasked())
		{
			case MotionEvent.ACTION_DOWN:
				Log.i(tag, "ACTION_DOWN");
				pointerAdd(event);
				break;
			case MotionEvent.ACTION_POINTER_DOWN:
				Log.i(tag, "ACTION_POINTER_DOWN");
				pointerAdd(event);
				break;
			case MotionEvent.ACTION_MOVE:
				Log.i(tag, "ACTION_MOVE");
				pointerMove(event);
				break;
			case MotionEvent.ACTION_POINTER_UP:
				Log.i(tag, "ACTION_POINTER_UP");
				pointerRemove(event);
				break;
			case MotionEvent.ACTION_UP:
				Log.i(tag, "ACTION_UP");
				pointerRemove(event);
				break;
			case MotionEvent.ACTION_OUTSIDE:
				Log.i(tag, "ACTION_OUTSIDE");
				break;
			case MotionEvent.ACTION_CANCEL:
				Log.i(tag, "ACTION_CANCEL");
				break;
			default:
				return super.onTouchEvent(event);
		}
		return true;
	}

	private void pointerAdd(MotionEvent event)
	{
		// TODO Auto-generated method stub
		int index = event.getActionIndex();
		Pointer pointer = new Pointer();
		event.getPointerProperties(index, pointer.properties);
		event.getPointerCoords(index, pointer.coords);
		list.add(pointer);
		Log.i(tag, "pointer " + event.getPointerId(index) + " added");
		postInvalidate();
	}

	private void pointerMove(MotionEvent event)
	{
		// TODO Auto-generated method stub
		for (int i = 0; i < event.getPointerCount(); i++)
		{
			for (int j = 0; j < list.size(); j++)
			{
				if (event.getPointerId(i) == list.get(j).properties.id)
				{
					int historicalPosX = 0;
					int historicalPosY = 0;
					int posX = 0;
					int posY = 0;
					MotionEvent.PointerCoords mpointerCoords = new PointerCoords();
					historicalPosX = (int) list.get(j).coords.x;
					historicalPosY = (int) list.get(j).coords.y;
					event.getPointerCoords(i, mpointerCoords);
					posX = (int) mpointerCoords.x;
					posY = (int) mpointerCoords.y;
					Log.i(tag, "x:" + posX + " y:" + posY + " hx:" + historicalPosX + " hy:" + historicalPosY);
					if ((historicalPosX - posX > 1) || (historicalPosX - posX < -1) || (historicalPosY - posY > 1) || (historicalPosY - posY < -1))
					{
						event.getPointerCoords(i, list.get(j).coords);
						Log.i(tag, "pointer " + event.getPointerId(i) + " moved");
					}
				}
			}
		}
		postInvalidate();
	}

	private void pointerRemove(MotionEvent event)
	{
		// TODO Auto-generated method stub
		int index = event.getActionIndex();
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).properties.id == event.getPointerId(index))
			{
				Log.i(tag, "pointer " + list.get(i).properties.id + " removed");
				list.remove(i);
			}
		}
		postInvalidate();
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas)
	{
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		for (int i = 0; i < list.size(); i++)
		{
			float x = list.get(i).coords.x;
			float y = list.get(i).coords.y;

			float major = list.get(i).coords.touchMajor;
			float minor = list.get(i).coords.touchMinor;
			float orientation = list.get(i).coords.orientation;
			// Log.i(tag, "x:" + x + "y:" + y + "major" + major + "minor" +
			// minor + "orientation" + orientation);
			// the major always equal with minor
			// canvas.drawCircle(x, y, major, mPaint);
			mPaint.setColor(mcolor[list.get(i).properties.id % 9]);
			mPaint.setStrokeWidth(picLineWidth);
			mPaint.setStyle(Paint.Style.STROKE);
			RectF rectF = new RectF(-minor, -major, minor, major);
			canvas.save();
			canvas.translate(x, y);
			canvas.rotate(orientation);
			canvas.drawOval(rectF, mPaint);

			mPaint.setStyle(Paint.Style.FILL);
			mPaint.setTextSize(textSize * 2);
			{
				float posX = 0.0f;
				float[] idWidths = new float[5];
				int idCount = mPaint.getTextWidths("ID:" + list.get(i).properties.id, idWidths);
				float idWidth = floatsToWidth(idWidths, idCount);
				if ((x + major + idWidth) > mDisplayScreen.getWidthPixels())
				{
					posX = -major - idWidth - mPaint.getTextSize();
				}
				else
				{
					posX = major + mPaint.getTextSize();
				}
				canvas.drawText("ID:" + list.get(i).properties.id, posX, 0, mPaint);
			}
			mPaint.setStrokeWidth(textLineWidth);
			mPaint.setTextSize(textSize);
			{
				float posX = 0.0f;
				float PosY = 0.0f;
				float[] coordsWidths = new float[20];
				int coordsCount = mPaint.getTextWidths("x:" + (int) x + " y:" + (int) y, coordsWidths);
				float coordsWidth = floatsToWidth(coordsWidths, coordsCount);
				if ((x + major + coordsWidth) > mDisplayScreen.getWidthPixels())
				{
					posX = -major - coordsWidth - mPaint.getTextSize();
				}
				else
				{
					posX = major + mPaint.getTextSize();
				}
				if (y - minor - mPaint.getTextSize() < 0)
				{
					PosY = minor;
				}
				else
				{
					PosY = -minor;
				}
				canvas.drawText("x:" + (int) x + " y:" + (int) y, posX, PosY, mPaint);
			}
			canvas.restore();
		}
	}

	private float floatsToWidth(float[] iWidths, int count)
	{
		// TODO Auto-generated method stub
		float widths = 0.0f;
		for (int i = 0; i < count; i++)
		{
			widths += iWidths[i];
		}
		return widths;

	}

	private class Pointer
	{
		private PointerProperties properties = new PointerProperties();
		private PointerCoords coords = new PointerCoords();
	}
}
