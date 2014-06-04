package com.chinaykl.library.android.sensor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.util.Log;

public class EnvironmentSensors extends SensorBase
{
	private final String tag = "EnvironmentSensors";
	private final int sensorsType[] =
	{ 		Sensor.TYPE_AMBIENT_TEMPERATURE, 
			Sensor.TYPE_LIGHT, 
			Sensor.TYPE_PRESSURE, 
			Sensor.TYPE_RELATIVE_HUMIDITY, 
			Sensor.TYPE_TEMPERATURE
	};
	
	@SuppressLint("NewApi")
	public EnvironmentSensors(Context context, int sensorType)
	{
		super(context);
		// TODO Auto-generated constructor stub
		// Do some check
		for (int i = 0; i < sensorsType.length; i++)
		{
			if (sensorType == sensorsType[i])
			{
				msensor = getmSensorManager().getDefaultSensor(sensorType);
				if (msensor != null)
				{
					exist = true;
					fifoMaxEventCount = msensor.getFifoMaxEventCount();
					fifoReservedEventCount = msensor.getFifoReservedEventCount();
					maximumRange = msensor.getMaximumRange();
					minDelay = msensor.getMinDelay();
					String name = msensor.getName();
					float power = msensor.getPower();
					float resoultion = msensor.getResolution();
					int type = msensor.getType();
					String vendor = msensor.getVendor();
					int version = msensor.getVersion();
					Log.i(tag, "Sensor already got");
				}
			}
		}
	}
}
