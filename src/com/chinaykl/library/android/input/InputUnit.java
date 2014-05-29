package com.chinaykl.library.android.input;

import java.util.ArrayList;

import android.util.Log;
import android.view.InputDevice;

public class InputUnit
{
	private final String tag = "InputUnit";
	private int num = 0;
	ArrayList<InputDevice> list = new ArrayList<InputDevice>();

	public InputUnit()
	{
		// TODO Auto-generated constructor stub
		int[] inputDevices = InputDevice.getDeviceIds();
		for (int i = 0; i < inputDevices.length; i++)
		{
			InputDevice inputDevice = InputDevice.getDevice(inputDevices[i]);
			list.add(inputDevice);
			Log.i(tag, inputDevice.getName());
			num++;
		}
	}
	
	public int getNum()
	{
		return num;
	}
}
