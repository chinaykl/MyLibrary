package com.chinaykl.library.android.sensor.motion;

import com.chinaykl.library.android.sensor.MotionSensors;

import android.content.Context;
import android.hardware.Sensor;
import android.util.Log;

public class GravitySensor extends MotionSensors
{
	final private String tag = "GravitySensor";
	static final public int GX = 0;
	static final public int GY = 1;
	static final public int GZ = 2;

	public GravitySensor(Context context)
	{
		super(context, Sensor.TYPE_GRAVITY);
		// TODO Auto-generated constructor stub
		numOfdata = 3;
		Log.i(tag, "Gravity Sensor exist:" + exist);
	}

	public float getGravityX()
	{
		// TODO Auto-generated method stub
		return getData(GX);
	}

	public float getGravityY()
	{
		// TODO Auto-generated method stub
		return getData(GY);
	}

	public float getGravityZ()
	{
		// TODO Auto-generated method stub
		return getData(GZ);
	}
}
