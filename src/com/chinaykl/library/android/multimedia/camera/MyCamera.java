/*
 * Camera Permission - Your application must request permission to use a device camera.
 * <uses-permission android:name="android.permission.CAMERA" />
 * Note: If you are using the camera via an intent, your application does not need to request this permission.
 * 
 * Camera Features - Your application must also declare use of camera features, for example:
 * <uses-feature android:name="android.hardware.camera" />
 * For a list of camera features, see the manifest Features Reference.
 * 
 * If your application can use a camera or camera feature for proper operation, but does not require it, 
 * you should specify this in the manifest by including the android:required attribute, and setting it to false:
 * <uses-feature android:name="android.hardware.camera" android:required="false" />
 * 
 * Storage Permission - If your application saves images or videos to the device's external storage (SD Card), 
 * you must also specify this in the manifest.
 * <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
 * 
 * Audio Recording Permission - For recording audio with video capture, 
 * your application must request the audio capture permission.
 * <uses-permission android:name="android.permission.RECORD_AUDIO" />
 * 
 * Location Permission - If your application tags images with GPS location information, 
 * you must request location permission:
 * <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
 */

package com.chinaykl.library.android.multimedia.camera;

import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.ViewGroup.LayoutParams;

public class MyCamera implements Callback
{
	private final String LOG_TAG = "MyCamera";
	private Activity activity;
	private Camera camera = null;
	private SurfaceView surfaceView;
	private SurfaceHolder holder;

	public MyCamera(Activity mActivity)
	{
		// TODO Auto-generated constructor stub
		activity = mActivity;
		if (checkCameraHardware(activity) == true)
		{
			camera = getCameraInstance();
			surfaceView = new SurfaceView(activity);
			LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			activity.addContentView(surfaceView, params);
			holder = surfaceView.getHolder();
			// Add a Callback interface for this holder
			holder.addCallback(this);
		}
	}

	/** Check if this device has a camera */
	private boolean checkCameraHardware(Context context)
	{
		if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA))
		{
			// this device has a camera
			return true;
		}
		else
		{
			// no camera on this device
			return false;
		}
	}

	/** A safe way to get an instance of the Camera object. */
	private Camera getCameraInstance()
	{
		Camera c = null;
		try
		{
			c = Camera.open(); // attempt to get a Camera instance
		}
		catch (Exception e)
		{
			// Camera is not available (in use or does not exist)
		}
		return c; // returns null if camera is unavailable
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder)
	{
		// TODO Auto-generated method stub
		// The Surface has been created, now tell the camera where to draw the
		// preview.
		try
		{
			camera.setPreviewDisplay(holder);
			camera.startPreview();
		}
		catch (IOException e)
		{
			Log.d(LOG_TAG, "Error setting camera preview: " + e.getMessage());
		}

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
	{
		// TODO Auto-generated method stub
		// If your preview can change or rotate, take care of those events here.
		// Make sure to stop the preview before resizing or reformatting it.

		if (holder.getSurface() == null)
		{
			// preview surface does not exist
			return;
		}

		// stop preview before making changes
		try
		{
			camera.stopPreview();
		}
		catch (Exception e)
		{
			// ignore: tried to stop a non-existent preview
		}

		// set preview size and make any resize, rotate or
		// reformatting changes here

		// start preview with new settings
		try
		{
			camera.setPreviewDisplay(holder);
			camera.startPreview();

		}
		catch (Exception e)
		{
			Log.d(LOG_TAG, "Error starting camera preview: " + e.getMessage());
		}

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder)
	{
		// TODO Auto-generated method stub

	}
}
