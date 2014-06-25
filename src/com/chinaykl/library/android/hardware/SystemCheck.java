package com.chinaykl.library.android.hardware;

import java.util.ArrayList;

import android.content.Context;
import android.content.pm.FeatureInfo;

public abstract class SystemCheck extends InfoBase
{
	private static String TAG = "SystemCheck";
	ArrayList<String> mfilter = new ArrayList<String>();

	public SystemCheck(Context context)
	{
		// TODO Auto-generated constructor stub
		super(context);
	}

	public void addfilter(String[] filter)
	{
		// TODO Auto-generated method stub
		for (int i = 0; i < filter.length; i++)
		{
			mfilter.add(filter[i]);
		}
	}
	
	public void addfilter(String filter)
	{
		// TODO Auto-generated method stub
		mfilter.add(filter);
	}
	
	public ArrayList<String> getInfo()
	{
		// TODO Auto-generated method stub
		ArrayList<String> result = new ArrayList<String>();
		result.clear();
		for (int i = 0; i < mfilter.size(); i++)
		{
			String string = mfilter.get(i);
			result.addAll(super.setMatch(string));
		}
		return result;
	}
}

abstract class InfoBase implements InfoList
{
	private String match;
	private PreSystemCheck mPreSystemCheck;

	public InfoBase(Context context)
	{
		// TODO Auto-generated constructor stub
		mPreSystemCheck = PreSystemCheck.getInstance(context);
	}

	private ArrayList<String> refreshArrayList()
	{
		ArrayList<String> result = new ArrayList<String>();
		int size = mPreSystemCheck.getFeatureInfos().size();
		result.clear();
		for (int i = 0; i < size; i++)
		{
			FeatureInfo info = mPreSystemCheck.getFeatureInfos().get(i);
			if (info.name.startsWith(match) == true)
			{
				result.add(info.name);
			}
		}
		return result;
	}

	public ArrayList<String> setMatch(String match)
	{
		this.match = match;
		return refreshArrayList();
	}
}

interface InfoList
{
	// use to check android device
	ArrayList<String> getInfoList();
}
