package com.chinaykl.library.android.hardware;

import java.util.ArrayList;

import com.chinaykl.library.android.hardware.systeminfo.SystemCheck;

import android.content.Context;
import android.util.Log;

//try to use different way to find out is this module can be tested
public class HardwareSupported
{
	private static String TAG = "HardwareSupported";
	private final int ITEMNUM = 16;
	private Context mContext;

	public HardwareSupported(Context context)
	{
		// TODO Auto-generated constructor stub
		mContext = context;
	}

	public ArrayList<String> hardwareCheck()
	{
		ArrayList<String> result = new ArrayList<String>();
		ModuleCheck[] mCheck = new ModuleCheck[ITEMNUM];
		mCheck[0] = new AudioCheck();
		mCheck[1] = new BatteryCheck();
		mCheck[2] = new BluetoothCheck(mContext);
		mCheck[3] = new CameraCheck(mContext);
		mCheck[4] = new GpsCheck(mContext);
		mCheck[5] = new KeypadCheck();
		mCheck[6] = new LcdCheck();
		mCheck[7] = new LedCheck();
		mCheck[8] = new MicrophoneCheck(mContext);
		mCheck[9] = new NfcCheck(mContext);
		mCheck[10] = new RtcCheck();
		mCheck[11] = new SdCheck();
		mCheck[12] = new SensorCheck(mContext);
		mCheck[13] = new TouchscreenCheck(mContext);
		mCheck[14] = new UsbCheck(mContext);
		mCheck[15] = new WifiCheck(mContext);
		for (int i = 0; i < ITEMNUM; i++)
		{
			result.addAll(mCheck[i].getModuleList());
		}

		// for debug
		for (int i = 0; i < result.size(); i++)
		{
			Log.d(TAG, i + ":" + result.get(i));
		}

		return result;
	}

	private class AudioCheck extends ModuleCheck
	{

		@Override
		ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			result.add("audio");
			return result;
		}

	}

	private class BatteryCheck extends ModuleCheck
	{

		@Override
		ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			result.add("battery");
			return result;
		}

	}

	private class BluetoothCheck extends ModuleCheck
	{
		String matchString = "android.hardware.bluetooth";
		SystemCheck mSystemCheck;

		public BluetoothCheck(Context context)
		{
			// TODO Auto-generated constructor stub
			mSystemCheck = new SystemCheck(context, matchString);
		}

		@Override
		public ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			if (mSystemCheck.getInfoList().isEmpty() == false)
			{
				result.add("bluetooth");
			}
			return result;
		}
	}

	private class CameraCheck extends ModuleCheck
	{
		String matchString = "android.hardware.camera";
		SystemCheck mSystemCheck;

		public CameraCheck(Context context)
		{
			// TODO Auto-generated constructor stub
			mSystemCheck = new SystemCheck(context, matchString);
		}

		@Override
		public ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			if (mSystemCheck.getInfoList().isEmpty() == false)
			{
				result.add("camera");
			}
			return result;
		}
	}

	private class GpsCheck extends ModuleCheck
	{
		String matchString = "android.hardware.location";
		SystemCheck mSystemCheck;

		public GpsCheck(Context context)
		{
			// TODO Auto-generated constructor stub
			mSystemCheck = new SystemCheck(context, matchString);
		}

		@Override
		public ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			if (mSystemCheck.getInfoList().isEmpty() == false)
			{
				result.add("gps");
			}
			return result;
		}
	}

	private class KeypadCheck extends ModuleCheck
	{

		@Override
		ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			result.add("keypad");
			return result;
		}

	}

	private class LcdCheck extends ModuleCheck
	{

		@Override
		ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			result.add("lcd");
			return result;
		}

	}

	private class LedCheck extends ModuleCheck
	{

		@Override
		ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			result.add("led");
			return result;
		}

	}

	private class MicrophoneCheck extends ModuleCheck
	{
		String matchString = "android.hardware.microphone";
		SystemCheck mSystemCheck;

		public MicrophoneCheck(Context context)
		{
			// TODO Auto-generated constructor stub
			mSystemCheck = new SystemCheck(context, matchString);
		}

		@Override
		public ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			if (mSystemCheck.getInfoList().isEmpty() == false)
			{
				result.add("microphone");
			}
			return result;
		}
	}

	private class NfcCheck extends ModuleCheck
	{
		String matchString = "android.hardware.nfc";
		SystemCheck mSystemCheck;

		public NfcCheck(Context context)
		{
			// TODO Auto-generated constructor stub
			mSystemCheck = new SystemCheck(context, matchString);
		}

		@Override
		public ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			if (mSystemCheck.getInfoList().isEmpty() == false)
			{
				result.add("nfc");
			}
			return result;
		}
	}

	private class RtcCheck extends ModuleCheck
	{

		@Override
		ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			result.add("rtc");
			return result;
		}

	}

	private class SdCheck extends ModuleCheck
	{

		@Override
		ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			result.add("sd");
			return result;
		}

	}

	private class SensorCheck extends ModuleCheck
	{
		String matchString = "android.hardware.sensor.";
		SystemCheck mSystemCheck;

		public SensorCheck(Context context)
		{
			// TODO Auto-generated constructor stub
			mSystemCheck = new SystemCheck(context, matchString);
		}

		@Override
		public ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			int size = mSystemCheck.getInfoList().size();
			for (int i = 0; i < size; i++)
			{
				String info = mSystemCheck.getInfoList().get(i);
				if (info.startsWith(matchString) == true)
				{
					result.add(info.replaceFirst(matchString, ""));
				}
			}
			result.add("hallsensor");
			return result;
		}
	}

	private class TouchscreenCheck extends ModuleCheck
	{
		String matchString = "android.hardware.faketouch";
		SystemCheck mSystemCheck;

		public TouchscreenCheck(Context context)
		{
			// TODO Auto-generated constructor stub
			mSystemCheck = new SystemCheck(context, matchString);
		}

		@Override
		public ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			if (mSystemCheck.getInfoList().isEmpty() == false)
			{
				result.add("touchscreen");
			}
			return result;
		}
	}

	private class UsbCheck extends ModuleCheck
	{
		String matchString = "android.hardware.usb";
		SystemCheck mSystemCheck;

		public UsbCheck(Context context)
		{
			// TODO Auto-generated constructor stub
			mSystemCheck = new SystemCheck(context, matchString);
		}

		@Override
		public ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			if (mSystemCheck.getInfoList().isEmpty() == false)
			{
				result.add("usb");
			}
			return result;
		}
	}

	private class WifiCheck extends ModuleCheck
	{
		String matchString = "android.hardware.wifi";
		SystemCheck mSystemCheck;

		public WifiCheck(Context context)
		{
			// TODO Auto-generated constructor stub
			mSystemCheck = new SystemCheck(context, matchString);
		}

		@Override
		public ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			if (mSystemCheck.getInfoList().isEmpty() == false)
			{
				result.add("wifi");
			}
			return result;
		}
	}
}
