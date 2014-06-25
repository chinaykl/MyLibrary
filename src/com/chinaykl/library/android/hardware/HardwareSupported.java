package com.chinaykl.library.android.hardware;

import java.util.ArrayList;

import com.chinaykl.library.android.hardware.systeminfo.SystemCheck;

import android.content.Context;
import android.util.Log;

//try to use different way to find out is this module can be tested
public class HardwareSupported
{
	private static String TAG = "HardwareSupported";
	private Context mContext;

	public HardwareSupported(Context context)
	{
		// TODO Auto-generated constructor stub
		mContext = context;
	}

	public ArrayList<String> hardwareCheck()
	{
		ArrayList<String> result = new ArrayList<String>();
		result.add("audio");
		result.add("battery");
		result.addAll(new BluetoothCheck(mContext).getModuleList());
		result.addAll(new CameraCheck(mContext).getModuleList());
		result.addAll(new GpsCheck(mContext).getModuleList());
		result.add("keypad");
		result.add("lcd");
		result.add("led");
		result.addAll(new MicrophoneCheck(mContext).getModuleList());
		result.addAll(new NfcCheck(mContext).getModuleList());
		result.add("rtc");
		result.add("sd");
		result.addAll(new SensorCheck(mContext).getModuleList());
		result.add("hallSensor");
		result.addAll(new TouchscreenCheck(mContext).getModuleList());
		result.addAll(new UsbCheck(mContext).getModuleList());
		result.addAll(new WifiCheck(mContext).getModuleList());
		
		//for debug
		for (int i = 0; i < result.size(); i++)
		{
			Log.d(TAG, i+":"+result.get(i));
		}
		
		return result;
	}

	private class BluetoothCheck implements ModuleList
	{
		String matchString = "android.hardware.bluetooth";
		SystemCheck mSystemCheck;

		public BluetoothCheck(Context context)
		{
			// TODO Auto-generated constructor stub
			mSystemCheck = new SystemCheck(context)
			{
				@Override
				public ArrayList<String> getInfoList()
				{
					// TODO Auto-generated method stub
					ArrayList<String> result = new ArrayList<String>();
					addfilter(matchString);
					result.clear();
					result.addAll(getInfo());
					return result;
				}
			};
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

	private class CameraCheck implements ModuleList
	{
		String matchString = "android.hardware.camera";
		SystemCheck mSystemCheck;

		public CameraCheck(Context context)
		{
			// TODO Auto-generated constructor stub
			mSystemCheck = new SystemCheck(context)
			{
				@Override
				public ArrayList<String> getInfoList()
				{
					// TODO Auto-generated method stub
					ArrayList<String> result = new ArrayList<String>();
					addfilter(matchString);
					result.clear();
					result.addAll(getInfo());
					return result;
				}
			};
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

	private class GpsCheck implements ModuleList
	{
		String matchString = "android.hardware.location";
		SystemCheck mSystemCheck;

		public GpsCheck(Context context)
		{
			// TODO Auto-generated constructor stub
			mSystemCheck = new SystemCheck(context)
			{
				@Override
				public ArrayList<String> getInfoList()
				{
					// TODO Auto-generated method stub
					ArrayList<String> result = new ArrayList<String>();
					addfilter(matchString);
					result.clear();
					result.addAll(getInfo());
					return result;
				}
			};
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

	private class MicrophoneCheck implements ModuleList
	{
		String matchString = "android.hardware.microphone";
		SystemCheck mSystemCheck;

		public MicrophoneCheck(Context context)
		{
			// TODO Auto-generated constructor stub
			mSystemCheck = new SystemCheck(context)
			{
				@Override
				public ArrayList<String> getInfoList()
				{
					// TODO Auto-generated method stub
					ArrayList<String> result = new ArrayList<String>();
					addfilter(matchString);
					result.clear();
					result.addAll(getInfo());
					return result;
				}
			};
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

	private class NfcCheck implements ModuleList
	{
		String matchString = "android.hardware.nfc";
		SystemCheck mSystemCheck;

		public NfcCheck(Context context)
		{
			// TODO Auto-generated constructor stub
			mSystemCheck = new SystemCheck(context)
			{
				@Override
				public ArrayList<String> getInfoList()
				{
					// TODO Auto-generated method stub
					ArrayList<String> result = new ArrayList<String>();
					addfilter(matchString);
					result.clear();
					result.addAll(getInfo());
					return result;
				}
			};
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

	private class SensorCheck implements ModuleList
	{
		String matchString = "android.hardware.sensor.";
		SystemCheck mSystemCheck;

		public SensorCheck(Context context)
		{
			// TODO Auto-generated constructor stub
			mSystemCheck = new SystemCheck(context)
			{
				@Override
				public ArrayList<String> getInfoList()
				{
					// TODO Auto-generated method stub
					ArrayList<String> result = new ArrayList<String>();
					addfilter(matchString);
					result.clear();
					result.addAll(getInfo());
					return result;
				}
			};
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
			return result;
		}
	}

	private class TouchscreenCheck implements ModuleList
	{
		String matchString = "android.hardware.faketouch";
		SystemCheck mSystemCheck;

		public TouchscreenCheck(Context context)
		{
			// TODO Auto-generated constructor stub
			mSystemCheck = new SystemCheck(context)
			{
				@Override
				public ArrayList<String> getInfoList()
				{
					// TODO Auto-generated method stub
					ArrayList<String> result = new ArrayList<String>();
					addfilter(matchString);
					result.clear();
					result.addAll(getInfo());
					return result;
				}
			};
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

	private class UsbCheck implements ModuleList
	{
		String matchString = "android.hardware.usb";
		SystemCheck mSystemCheck;

		public UsbCheck(Context context)
		{
			// TODO Auto-generated constructor stub
			mSystemCheck = new SystemCheck(context)
			{
				@Override
				public ArrayList<String> getInfoList()
				{
					// TODO Auto-generated method stub
					ArrayList<String> result = new ArrayList<String>();
					addfilter(matchString);
					result.clear();
					result.addAll(getInfo());
					return result;
				}
			};
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

	private class WifiCheck implements ModuleList
	{
		String matchString = "android.hardware.wifi";
		SystemCheck mSystemCheck;

		public WifiCheck(Context context)
		{
			// TODO Auto-generated constructor stub
			mSystemCheck = new SystemCheck(context)
			{
				@Override
				public ArrayList<String> getInfoList()
				{
					// TODO Auto-generated method stub
					ArrayList<String> result = new ArrayList<String>();
					addfilter(matchString);
					result.clear();
					result.addAll(getInfo());
					return result;
				}
			};
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

interface ModuleList
{
	// use to check android device
	ArrayList<String> getModuleList();
}
