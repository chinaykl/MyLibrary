package com.chinaykl.library.android.input.key;

import android.util.Log;
import android.view.KeyEvent;

/* before use this class you should mark the function of powerkey and other keys in PhoneWindowManager.java 
 * or you will not reveive the event in your app
 */
public class Keypad
{
	private static final String TAG = "Keypad";

	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		// TODO Auto-generated method stub
		switch (keyCode)
		{
			case KeyEvent.KEYCODE_POWER:
				Log.i(TAG, "POWER DOWN");
				break;
			case KeyEvent.KEYCODE_VOLUME_UP:
				Log.i(TAG, "VOLUME UP DOWN");
				break;
			case KeyEvent.KEYCODE_VOLUME_DOWN:
				Log.i(TAG, "VOLUME DOWN DOWN");
				break;
			default:
				break;
		}
		return false;
	}

	public boolean onKeyLongPress(int keyCode, KeyEvent event)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onKeyUp(int keyCode, KeyEvent event)
	{
		// TODO Auto-generated method stub
		switch (keyCode)
		{
			case KeyEvent.KEYCODE_POWER:
				Log.i(TAG, "POWER UP");
				break;
			case KeyEvent.KEYCODE_VOLUME_UP:
				Log.i(TAG, "VOLUME UP UP");
				break;
			case KeyEvent.KEYCODE_VOLUME_DOWN:
				Log.i(TAG, "VOLUME DOWN UP");
				break;
			default:
				break;
		}
		return false;
	}

	public boolean onKeyMultiple(int keyCode, int count, KeyEvent event)
	{
		// TODO Auto-generated method stub
		return false;
	}

}
