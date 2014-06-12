package com.chinaykl.library.android.sensor.environment;

import com.chinaykl.library.android.sensor.EnvironmentSensors;

import android.content.Context;
import android.hardware.Sensor;
import android.util.Log;

public class LightSensor extends EnvironmentSensors 
{
	final private String tag = "LightSensor";
	static final public int LUX = 0;

	public LightSensor(Context context)
	{
		super(context, Sensor.TYPE_LIGHT);
		// TODO Auto-generated constructor stub
		numOfdata = 1;
		Log.i(tag, "Light Sensor exist:"+exist);
	}
	
	public float getlx()
	{
		// TODO Auto-generated method stub
		return getData(LUX);
	}
}
