package com.chinaykl.library.android.hardware;

import java.util.ArrayList;

import android.R.string;
import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.util.Log;

public class Hardware
{
	private static String TAG = "Hardware";
	private static Hardware instance = null;
	private ArrayList<FeatureInfo> featureInfos = new ArrayList<FeatureInfo>();
	private String[] sysHwFeatures =
	{
			// ------Audio
			/*
			 * The application uses a low-latency audio pipeline on the device
			 * and is sensitive to delays or lag in sound input or output.
			 */
			"android.hardware.audio.low_latency",

			// ------Bluetooth
			/* The application uses Bluetooth radio features in the device. */
			"android.hardware.bluetooth",
			/*
			 * The application uses Bluetooth Low Energy radio features in the
			 * device.
			 */
			"android.hardware.bluetooth_le",

			// ------Camera
			/*
			 * The application uses the device's camera. If the device supports
			 * multiple cameras, the application uses the camera that facing
			 * away from the screen.
			 */
			"android.hardware.camera",
			/*
			 * Subfeature. The application uses the device camera's autofocus
			 * capability.
			 */
			"android.hardware.camera.autofocus",
			/*
			 * Subfeature. The application uses the device camera's flash.
			 */
			"android.hardware.camera.flash",
			/*
			 * Subfeature. The application uses a front-facing camera on the
			 * device.
			 */
			"android.hardware.camera.front",
			/*
			 * The application uses at least one camera facing in any direction.
			 * Use this in preference to android.hardware.camera if a
			 * back-facing camera is not required.
			 */
			"android.hardware.camera.any",

			// ------Infrared
			/* The application uses the consumer IR capabilities on the device. */
			"android.hardware.consumerir",

			// ------Location
			/*
			 * The application uses one or more features on the device for
			 * determining location, such as GPS location, network location, or
			 * cell location.
			 */
			"android.hardware.location",
			/*
			 * Subfeature. The application uses coarse location coordinates
			 * obtained from a network-based geolocation system supported on the
			 * device.
			 */
			"android.hardware.location.network",
			/*
			 * Subfeature. The application uses precise location coordinates
			 * obtained from a Global Positioning System receiver on the device.
			 */
			"android.hardware.location.gps",

			// ------Microphone
			/* The application uses a microphone on the device. */
			"android.hardware.microphone",

			// ------NFC
			/*
			 * The application uses Near Field Communications radio features in
			 * the device.
			 */
			"android.hardware.nfc",
			/*
			 * The application uses the NFC card emulation feature in the
			 * device.
			 */
			"android.hardware.nfc.hce",

			// ------Sensors
			/*
			 * The application uses motion readings from an accelerometer on the
			 * device.
			 */
			"android.hardware.sensor.accelerometer",
			/* The application uses the device's barometer. */
			"android.hardware.sensor.barometer",
			/*
			 * The application uses directional readings from a magnetometer
			 * (compass) on the device.
			 */
			"android.hardware.sensor.compass",
			/* The application uses the device's gyroscope sensor. */
			"android.hardware.sensor.gyroscope",
			/* The application uses the device's light sensor. */
			"android.hardware.sensor.light",
			/* The application uses the device's proximity sensor. */
			"android.hardware.sensor.proximity",
			/* The application uses the device's step counter. */
			"android.hardware.sensor.stepcounter",
			/* The application uses the device's step detector. */
			"android.hardware.sensor.stepdetector",

			// ------Screen
			/* The application requires landscape orientation. */
			"android.hardware.screen.landscape",
			/* The application requires portrait orientation. */
			"android.hardware.screen.portrait",

			// ------Telephony
			/*
			 * The application uses telephony features on the device, such as
			 * telephony radio with data communication services.
			 */
			"android.hardware.telephony",
			/*
			 * Subfeature. The application uses CDMA telephony radio features on
			 * the device.
			 */
			"android.hardware.telephony.cdma",
			/*
			 * Subfeature. The application uses GSM telephony radio features on
			 * the device.
			 */
			"android.hardware.telephony.gsm",

			// ------Television
			/* The application is designed for a television user experience. */
			"android.hardware.type.television",

			// ------Touchscreen
			/*
			 * The application uses basic touch interaction events, such as
			 * "click down", "click up", and drag.
			 */
			"android.hardware.faketouch",
			/*
			 * The application performs distinct tracking of two or more
			 * "fingers" on a fake touch interface. This is a superset of the
			 * faketouch feature.
			 */
			"android.hardware.faketouch.multitouch.distinct",
			/*
			 * The application performs distinct tracking of five or more
			 * "fingers" on a fake touch interface. This is a superset of the
			 * faketouch feature.
			 */
			"android.hardware.faketouch.multitouch.jazzhand",
			/*
			 * The application uses touchscreen capabilities for gestures that
			 * are more interactive than basic touch events, such as a fling.
			 * This is a superset of the basic faketouch feature.
			 */
			"android.hardware.touchscreen",
			/*
			 * The application uses basic two-point multitouch capabilities on
			 * the device screen, such as for pinch gestures, but does not need
			 * to track touches independently. This is a superset of touchscreen
			 * feature.
			 */
			"android.hardware.touchscreen.multitouch",
			/*
			 * Subfeature. The application uses advanced multipoint multitouch
			 * capabilities on the device screen, such as for tracking two or
			 * more points fully independently. This is a superset of multitouch
			 * feature.
			 */
			"android.hardware.touchscreen.multitouch.distinct",
			/*
			 * The application uses advanced multipoint multitouch capabilities
			 * on the device screen, for tracking up to five points fully
			 * independently. This is a superset of distinct multitouch feature.
			 */
			"android.hardware.touchscreen.multitouch.jazzhand",

			// ------USB
			/*
			 * The application uses USB host mode features (behaves as the host
			 * and connects to USB devices).
			 */
			"android.hardware.usb.host",
			/*
			 * The application uses USB accessory features (behaves as the USB
			 * device and connects to USB hosts).
			 */
			"android.hardware.usb.accessory",

			// ------Wi-Fi
			/*
			 * The application uses 802.11 networking (Wi-Fi) features on the
			 * device.
			 */
			"android.hardware.wifi",
			/*
			 * The application uses the Wi-Fi Direct networking features on the
			 * device.
			 */
			"android.hardware.wifi.direct"

	};

	private Hardware(Context context)
	{
		// TODO Auto-generated constructor stub
		PackageManager pm = context.getPackageManager();
		FeatureInfo[] fi = pm.getSystemAvailableFeatures();
		for (int i = 0; i < fi.length; i++)
		{
			if (fi[i].name != null)
			{
				if (fi[i].name.startsWith("android.hardware.") == true)
				{
					featureInfos.add(fi[i]);
					Log.d(TAG, fi[i].name);
				}
			}
		}
	}

	public static Hardware getInstance(Context context)
	{
		if (instance == null)
		{
			synchronized (Hardware.class)
			{
				if (instance == null)
				{
					instance = new Hardware(context);
				}
			}
		}
		return instance;
	}

	public ArrayList<String> hardwareCheck()
	{
		ArrayList<String> result = new ArrayList<String>();
		result.add("audio");
		result.add("battery");
		result.addAll(new MBluetooth(featureInfos).getModuleList());
		result.addAll(new MCamera(featureInfos).getModuleList());
		result.addAll(new MGPS(featureInfos).getModuleList());
		result.add("Keypad");
		result.add("LCD");
		result.add("LED");
		result.addAll(new MMicrophone(featureInfos).getModuleList());
		result.addAll(new MNFC(featureInfos).getModuleList());
		result.add("RTC");
		result.add("SD");
		result.addAll(new MSensor(featureInfos).getModuleList());
		result.add("HallSensor");
		result.addAll(new MTouchscreen(featureInfos).getModuleList());
		result.addAll(new MUSB(featureInfos).getModuleList());
		result.addAll(new MWifi(featureInfos).getModuleList());
		return result;
	}

	private class MBluetooth extends Module
	{
		String matchString = "android.hardware.bluetooth";

		public MBluetooth(ArrayList<FeatureInfo> list)
		{
			super(list);
			// TODO Auto-generated constructor stub
			setMatch(matchString);
			refreshArrayList();
		}

		@Override
		public ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			if (infoList.isEmpty() == false)
			{
				result.add("bluetooth");
			}
			return result;
		}

	}

	private class MCamera extends Module
	{
		String matchString = "android.hardware.camera";

		public MCamera(ArrayList<FeatureInfo> list)
		{
			super(list);
			// TODO Auto-generated constructor stub
			setMatch(matchString);
			refreshArrayList();
		}

		@Override
		public ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			if (infoList.isEmpty() == false)
			{
				result.add("camera");
			}
			return result;
		}
	}

	private class MGPS extends Module
	{
		String matchString = "android.hardware.location";

		public MGPS(ArrayList<FeatureInfo> list)
		{
			super(list);
			// TODO Auto-generated constructor stub
			setMatch(matchString);
			refreshArrayList();
		}

		@Override
		public ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			if (infoList.isEmpty() == false)
			{
				result.add("GPS");
			}
			return result;
		}
	}

	private class MMicrophone extends Module
	{
		String matchString = "android.hardware.microphone";

		public MMicrophone(ArrayList<FeatureInfo> list)
		{
			super(list);
			// TODO Auto-generated constructor stub
			setMatch(matchString);
			refreshArrayList();
		}

		@Override
		public ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			if (infoList.isEmpty() == false)
			{
				result.add("Microphone");
			}
			return result;
		}
	}

	private class MNFC extends Module
	{
		String matchString = "android.hardware.nfc";

		public MNFC(ArrayList<FeatureInfo> list)
		{
			super(list);
			// TODO Auto-generated constructor stub
			setMatch(matchString);
			refreshArrayList();
		}

		@Override
		public ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			if (infoList.isEmpty() == false)
			{
				result.add("NFC");
			}
			return result;
		}
	}

	private class MSensor extends Module
	{
		String matchString = "android.hardware.sensor.";

		public MSensor(ArrayList<FeatureInfo> list)
		{
			super(list);
			// TODO Auto-generated constructor stub
			setMatch(matchString);
			refreshArrayList();
		}

		@Override
		public ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			for (int i = 0; i < infoList.size(); i++)
			{
				FeatureInfo info = infoList.get(i);
				if (info.name.startsWith(matchString) == true)
				{
					result.add(info.name.replaceFirst(matchString, ""));
				}
			}
			return result;
		}
	}

	private class MTouchscreen extends Module
	{
		String matchString = "android.hardware.faketouch";

		public MTouchscreen(ArrayList<FeatureInfo> list)
		{
			super(list);
			// TODO Auto-generated constructor stub
			setMatch(matchString);
			refreshArrayList();
		}

		@Override
		public ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			if (infoList.isEmpty() == false)
			{
				result.add("Touchscreen");
			}
			return result;
		}
	}

	private class MUSB extends Module
	{
		String matchString = "android.hardware.usb";

		public MUSB(ArrayList<FeatureInfo> list)
		{
			super(list);
			// TODO Auto-generated constructor stub
			setMatch(matchString);
			refreshArrayList();
		}

		@Override
		public ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			if (infoList.isEmpty() == false)
			{
				result.add("USB");
			}
			return result;
		}
	}

	private class MWifi extends Module
	{
		String matchString = "android.hardware.wifi";

		public MWifi(ArrayList<FeatureInfo> list)
		{
			super(list);
			// TODO Auto-generated constructor stub
			setMatch(matchString);
			refreshArrayList();
		}

		@Override
		public ArrayList<String> getModuleList()
		{
			// TODO Auto-generated method stub
			ArrayList<String> result = new ArrayList<String>();
			if (infoList.isEmpty() == false)
			{
				result.add("Wifi");
			}
			return result;
		}
	}
}
