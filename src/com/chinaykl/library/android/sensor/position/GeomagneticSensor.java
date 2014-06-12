package com.chinaykl.library.android.sensor.position;

import com.chinaykl.library.android.sensor.PositionSensors;

import android.content.Context;
import android.hardware.Sensor;
import android.util.Log;

public class GeomagneticSensor extends PositionSensors
{
	final private String tag = "GeomagneticSensor";
	static final public int GX = 0;
	static final public int GY = 1;
	static final public int GZ = 2;

	public GeomagneticSensor(Context context)
	{
		super(context, Sensor.TYPE_LIGHT);
		// TODO Auto-generated constructor stub
		numOfdata = 3;
		Log.i(tag, "Geomagnetic Sensor exist:" + exist);
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
