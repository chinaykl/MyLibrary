package com.chinaykl.library.android.power;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.util.Log;

public class BatteryStatus
{
	private final String TAG = "BatteryStatus";
	private IntentFilter ifilter = new IntentFilter();
	private Context mContext;
	private int mHealth;
	private int mIconSmall;
	private int mLevel;
	private int mPlugged;
	private boolean mPresent;
	private int mScale;
	private int mStatus;
	private String mTechnology;
	private int mTemperature;
	private int mVoltage;
	private boolean hasData = false;

	public BatteryStatus(Context context)
	{
		// TODO Auto-generated constructor stub
		mContext = context;
		ifilter.addAction(Intent.ACTION_BATTERY_CHANGED);
		Intent statusIntent = enableStatusCheck();
		if (statusIntent != null)
		{
			batteryChangedReceive(statusIntent);
		}
	}

	public Intent enableStatusCheck()
	{
		// TODO Auto-generated method stub
		hasData = false;
		return mContext.registerReceiver(mBroadcastReceiver, ifilter);

	}

	public void disableStatusCheck()
	{
		// TODO Auto-generated method stub
		hasData = false;
		mContext.unregisterReceiver(mBroadcastReceiver);

	}

	// current health constant
	public int getHealth()
	{
		return mHealth;
	}

	// the resource ID of a small status bar icon indicating the current battery
	// state
	public int getIconSmall()
	{
		return mIconSmall;
	}

	// the current battery level, from 0 to EXTRA_SCALE
	public int getLevel()
	{
		return mLevel;
	}

	// whether the device is plugged in to a power source; 0 means it is on
	// battery, other constants are different types of power sources.
	public int getPlugged()
	{
		return mPlugged;
	}

	// whether a battery is present
	public boolean isPresent()
	{
		return mPresent;
	}

	// the maximum battery level
	public int getScale()
	{
		return mScale;
	}

	// the current status constant
	public int getStatus()
	{
		return mStatus;
	}

	// the technology of the current battery
	public String getTechnology()
	{
		return mTechnology;
	}

	// the current battery temperature
	public int getTemperature()
	{
		return mTemperature;
	}

	// the current battery voltage level
	public int getVoltage()
	{
		return mVoltage;
	}

	private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver()
	{

		@Override
		public void onReceive(Context context, Intent intent)
		{
			// TODO Auto-generated method stub
			String action = intent.getAction();
			if (action.equals(Intent.ACTION_BATTERY_CHANGED))
			{
				hasData = true;
				batteryChangedReceive(intent);
			}
		}

	};

	private void batteryChangedReceive(Intent intent)
	{
		// TODO Auto-generated method stub
		mHealth = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, 0);
		mIconSmall = intent.getIntExtra(BatteryManager.EXTRA_ICON_SMALL, 0);
		mLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
		mPlugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);
		mPresent = intent.getBooleanExtra(BatteryManager.EXTRA_PRESENT, false);
		mScale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 0);
		mStatus = intent.getIntExtra(BatteryManager.EXTRA_STATUS, 0);
		mTechnology = intent.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY);
		mTemperature = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0);
		mVoltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0);
		Log.d(TAG, "Health:" + mHealth);
		Log.d(TAG, "IconSmall:" + mIconSmall);
		Log.d(TAG, "Level:" + mLevel);
		Log.d(TAG, "Plugged:" + mPlugged);
		Log.d(TAG, "Present:" + mPresent);
		Log.d(TAG, "Scale:" + mScale);
		Log.d(TAG, "Status:" + mStatus);
		Log.d(TAG, "Technology:" + mTechnology);
		Log.d(TAG, "Temperature:" + mTemperature);
		Log.d(TAG, "Voltage:" + mVoltage);
	}

	public boolean isHasData()
	{
		return hasData;
	}
}
