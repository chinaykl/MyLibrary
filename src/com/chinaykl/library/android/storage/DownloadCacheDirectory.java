package com.chinaykl.library.android.storage;

import java.io.File;

import android.os.Environment;

public class DownloadCacheDirectory extends StorageDevice
{
	public DownloadCacheDirectory()
	{
		// TODO Auto-generated constructor stub
		File rootDirectory = Environment.getDownloadCacheDirectory();
		this.setDevice(rootDirectory);
		this.setReady(true);
	}
}
