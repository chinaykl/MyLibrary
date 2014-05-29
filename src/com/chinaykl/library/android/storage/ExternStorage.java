package com.chinaykl.library.android.storage;

import java.io.File;

import android.os.Environment;

public class ExternStorage extends StorageDevice
{
	public ExternStorage()
	{
		// TODO Auto-generated constructor stub
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state))
		{
			File externalStorage = Environment.getExternalStorageDirectory();
			this.setDevice(externalStorage);
			this.setReady(true);
		}
	}
}
