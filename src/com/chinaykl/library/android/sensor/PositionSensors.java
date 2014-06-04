package com.chinaykl.library.android.sensor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.util.Log;

public class PositionSensors extends SensorBase
{
	private final String tag = "PositionSensors";
	private final int sensorsType[] =
	{ 		Sensor.TYPE_GAME_ROTATION_VECTOR, 
			Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR, 
			Sensor.TYPE_MAGNETIC_FIELD, 
			Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED, 
			Sensor.TYPE_ORIENTATION, 
			Sensor.TYPE_PROXIMITY
	};

	@SuppressLint("NewApi")
	public PositionSensors(Context context, int sensorType)
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
