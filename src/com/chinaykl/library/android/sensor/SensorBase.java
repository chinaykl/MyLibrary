package com.chinaykl.library.android.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

public class SensorBase implements SensorEventListener
{
	private final String tag = "SensorBase";
	private SensorManager mSensorManager;
	protected boolean exist = false;
	protected boolean enable = false;
	protected int fifoMaxEventCount = 0;
	protected int fifoReservedEventCount = 0;
	protected float maximumRange = 0.0f;
	protected int minDelay = 0;
	protected String name = "";
	protected float power = 0.0f;
	protected float resoultion = 0.0f;
	protected int type = 0;
	protected String vendor = "";
	protected int version = 0;
	private float data[] = new float[10];
	protected int numOfdata = 0;

	public SensorBase(Context context)
	{
		// TODO Auto-generated constructor stub
		mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
		Log.i(tag, "SensorManager already got");
	}

	protected SensorManager getmSensorManager()
	{
		return mSensorManager;
	}

	public int getFifoMaxEventCount()
	{
		if (exist == true)
		{
			return fifoMaxEventCount;
		}
		return 0;
	}

	public int getFifoReservedEventCount()
	{
		if (exist == true)
		{
			return fifoReservedEventCount;
		}
		return 0;
	}

	public float getMaximumRange()
	{
		if (exist == true)
		{
			return maximumRange;
		}
		return 0.0f;
	}

	public int getMinDelay()
	{
		if (exist == true)
		{
			return minDelay;
		}
		return 0;
	}

	public String getName()
	{
		if (exist == true)
		{
			return name;
		}
		return "";
	}

	public float getPower()
	{
		if (exist == true)
		{
			return power;
		}
		return 0.0f;
	}

	public float getResoultion()
	{
		if (exist == true)
		{
			return resoultion;
		}
		return 0.0f;
	}

	public int getType()
	{
		if (exist == true)
		{
			return type;
		}
		return 0;
	}

	public String getVendor()
	{
		if (exist == true)
		{
			return vendor;
		}
		return "";
	}

	public int getVersion()
	{
		if (exist == true)
		{
			return version;
		}
		return 0;
	}

	protected float getData(int item)
	{
		if (exist == true)
		{
			if (enable == true)
			{
				if (item < numOfdata)
				{
					return data[item];
				}
			}
			else
			{
				Log.i(tag, "NFC did not enabled");
			}
		}
		Log.i(tag, "NFC not exist");
		return 0.0f;
	}

	@Override
	public void onSensorChanged(SensorEvent event)
	{
		// TODO Auto-generated method stub
		for (int i = 0; i < numOfdata; i++)
		{
			data[i] = event.values[i];
		}
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy)
	{
		// TODO Auto-generated method stub
	}
}
