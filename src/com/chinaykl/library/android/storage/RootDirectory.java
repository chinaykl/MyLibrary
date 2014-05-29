package com.chinaykl.library.android.storage;

import java.io.File;

import android.os.Environment;

public class RootDirectory extends StorageDevice
{
	public RootDirectory()
	{
		// TODO Auto-generated constructor stub
		File rootDirectory = Environment. getRootDirectory();
		this.setDevice(rootDirectory);
		this.setReady(true);
	}
}
