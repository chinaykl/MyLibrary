package com.chinaykl.library.android.sensor;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

public class SensorBase
{
	private final String tag = "SensorBase";
	List<Sensor> msensor = new ArrayList<Sensor>();
	SensorManager mSensorManager;

	@SuppressLint("ServiceCast")
	public SensorBase(Context context)
	{
		// TODO Auto-generated constructor stub
		mSensorManager = (SensorManager) context.getSystemService(Context.SEARCH_SERVICE);
		msensor = mSensorManager.getSensorList(Sensor.TYPE_ALL);
	}
}
