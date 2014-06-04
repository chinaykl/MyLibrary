package com.chinaykl.library.android.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

public class LightSensor extends EnvironmentSensors implements SensorEventListener
{
	final private String tag = "LightSensor";
	static final public int LUX = 0;

	public LightSensor(Context context)
	{
		super(context, Sensor.TYPE_LIGHT);
		// TODO Auto-generated constructor stub
		max = 1;
		getmSensorManager().registerListener(this, msensor, SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	public void onSensorChanged(SensorEvent event)
	{
		// TODO Auto-generated method stub
		data[LUX] = event.values[0];
		Log.i(tag, "lux:" + data[LUX]);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy)
	{
		// TODO Auto-generated method stub

	}

	protected void finalize()
	{
		getmSensorManager().unregisterListener(this);
	}
}
