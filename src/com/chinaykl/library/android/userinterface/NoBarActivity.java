package com.chinaykl.library.android.userinterface;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class NoBarActivity extends Activity
{
	final private String tag = "NoBarActivity";

	@SuppressLint("InlinedApi")
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		View decorView = getWindow().getDecorView();
		// Hide the status bar.
		int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE;
		decorView.setSystemUiVisibility(uiOptions);

		// Remember that you should never show the action bar if the
		// status bar is hidden, so hide that too if necessary.
		ActionBar actionBar = getActionBar();
		actionBar.hide();

		decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
		{

			View decorView = getWindow().getDecorView();

			@Override
			public void onSystemUiVisibilityChange(int visibility)
			{
				// TODO Auto-generated method stub
				int uiOptions = visibility;
				if ((visibility & View.SYSTEM_UI_FLAG_LAYOUT_STABLE) == 0)
				{
					uiOptions |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
				}
				if ((visibility & View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION) == 0)
				{
					uiOptions |= View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
				}
				if ((visibility & View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN) == 0)
				{
					uiOptions |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
				}
				if ((visibility & View.SYSTEM_UI_FLAG_HIDE_NAVIGATION) == 0)
				{
					uiOptions |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
				}
				if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0)
				{
					uiOptions |= View.SYSTEM_UI_FLAG_FULLSCREEN;
				}
				if ((visibility & View.SYSTEM_UI_FLAG_IMMERSIVE) == 0)
				{
					uiOptions |= View.SYSTEM_UI_FLAG_IMMERSIVE;
				}
				decorView.setSystemUiVisibility(uiOptions);
				Log.i(tag, "System Ui Visibility Change");
			}
		});
	}

}
