package com.chinaykl.library.android.storage;

import java.io.File;

import android.os.Environment;

public class DataDirectory extends StorageDevice
{
	public DataDirectory()
	{
		// TODO Auto-generated constructor stub
		File rootDirectory = Environment.getDataDirectory();
		this.setDevice(rootDirectory);
		this.setReady(true);
	}
}
