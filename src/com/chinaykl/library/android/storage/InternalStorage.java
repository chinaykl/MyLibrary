package com.chinaykl.library.android.storage;

import java.io.File;

import android.os.Environment;

public class InternalStorage extends StorageDevice
{
	public InternalStorage()
	{
		// TODO Auto-generated constructor stub
		File InternalStorage = Environment.getRootDirectory();
		this.setDevice(InternalStorage);
		this.setReady(true);
	}
}
