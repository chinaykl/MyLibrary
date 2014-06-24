package com.chinaykl.library.android.power;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

public class BatteryStatus extends BroadcastReceiver
{
	public BatteryStatus(Context context)
	{
		// TODO Auto-generated constructor stub
		IntentFilter ifilter = new IntentFilter();
		ifilter.addAction(Intent.ACTION_BATTERY_CHANGED);
		ifilter.addAction(Intent.ACTION_POWER_CONNECTED);
		ifilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
		ifilter.addAction(Intent.ACTION_POWER_USAGE_SUMMARY);
		Intent batteryStatus = context.registerReceiver(null, ifilter);
	}
	
	public void checkBatteryStatus()
	{
/*		// Are we charging / charged?
		int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
		boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
		                     status == BatteryManager.BATTERY_STATUS_FULL;

		// How are we charging?
		int chargePlug = battery.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
		boolean usbCharge = chargePlug == BATTERY_PLUGGED_USB;
		boolean acCharge = chargePlug == BATTERY_PLUGGED_AC;*/
	}
	
	@Override
	public void onReceive(Context context, Intent intent)
	{
/*		// TODO Auto-generated method stub
        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                            status == BatteryManager.BATTERY_STATUS_FULL;
    
        int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        boolean usbCharge = chargePlug == BATTERY_PLUGGED_USB;
        boolean acCharge = chargePlug == BATTERY_PLUGGED_AC;*/

	}
}
