package com.chinaykl.library.android.storage;

import java.io.File;

import android.os.StatFs;

public class StorageDevice
{
	private StatFs storageDevice;
	private boolean deviceReady = false;
	
	public void setDevice(File file)
	{
		File Storage = file;
		storageDevice = new StatFs(Storage.getPath());
	}
	
	//check Storage device is ready or not
	public boolean isReady()
	{
		// TODO Auto-generated method stub
		return deviceReady;
	}
	
	public void setReady(boolean value)
	{
		// TODO Auto-generated method stub
		deviceReady=value;
	}

	// The number of blocks that are free on the file system and available to
	// applications.
	public long getAvailableBlocksLong()
	{
		if (deviceReady)
		{
			return storageDevice.getAvailableBlocksLong();
		}
		return 0;
	}

	// The number of bytes that are free on the file system and available to
	// applications.
	public long getAvailableBytes()
	{
		if (deviceReady)
		{
			return storageDevice.getAvailableBytes();
		}
		return 0;
	}

	// The total number of blocks on the file system.
	long getBlockCountLong()
	{
		if (deviceReady)
		{
			return storageDevice.getBlockCountLong();
		}
		return 0;
	}

	// The size, in bytes, of a block on the file system.
	public long getBlockSizeLong()
	{
		if (deviceReady)
		{
			return storageDevice.getBlockSizeLong();
		}
		return 0;
	}

	// The total number of blocks that are free on the file system, including
	// reserved blocks (that are not available to normal applications).
	public long getFreeBlocksLong()
	{
		if (deviceReady)
		{
			return storageDevice.getFreeBlocksLong();
		}
		return 0;
	}

	// The number of bytes that are free on the file system, including reserved
	// blocks (that are not available to normal applications).
	public long getFreeBytes()
	{
		if (deviceReady)
		{
			return storageDevice.getFreeBytes();
		}
		return 0;
	}
}
