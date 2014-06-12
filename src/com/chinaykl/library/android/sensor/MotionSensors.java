package com.chinaykl.library.android.sensor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.Log;

public class MotionSensors extends SensorBase
{
	private final String tag = "MotionSensors";
	private Sensor msensor;
	private final int sensorsType[] =
	{ 		Sensor.TYPE_ACCELEROMETER, 
			Sensor.TYPE_GRAVITY, 
			Sensor.TYPE_GYROSCOPE, 
			Sensor.TYPE_GYROSCOPE_UNCALIBRATED, 
			Sensor.TYPE_LINEAR_ACCELERATION, 
			Sensor.TYPE_ROTATION_VECTOR, 
			Sensor.TYPE_SIGNIFICANT_MOTION, 
			Sensor.TYPE_STEP_COUNTER, 
			Sensor.TYPE_STEP_DETECTOR
	};

	@SuppressLint("NewApi")
	public MotionSensors(Context context, int sensorType)
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

	public void enable()
	{
		if (enable = false)
		{
			enable = getmSensorManager().registerListener(this, msensor, SensorManager.SENSOR_DELAY_NORMAL);
		}
	}

	public void disable()
	{
		getmSensorManager().unregisterListener(this);
		enable = false;
	}
}
