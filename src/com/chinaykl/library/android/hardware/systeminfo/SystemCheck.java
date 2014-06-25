package com.chinaykl.library.android.hardware.systeminfo;

import java.util.ArrayList;

import android.content.Context;
import android.content.pm.FeatureInfo;

//use to call filter with input strings
public abstract class SystemCheck implements IInfoList
{
	private static String TAG = "SystemCheck";
	InfoBase mInfoBase;
	ArrayList<String> mfilter = new ArrayList<String>();

	public SystemCheck(Context context)
	{
		// TODO Auto-generated constructor stub
		mInfoBase= new InfoBase(context);
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
			mInfoBase.setMatch(string);
			result.addAll(mInfoBase.getMatchInfo());
		}
		return result;
	}
}

//use to filtrate the FeatureInfos with input string
class InfoBase
{
	private String match;
	private PreSystemCheck mPreSystemCheck;
	private ArrayList<String> matchInfo=new ArrayList<String>();

	public InfoBase(Context context)
	{
		// TODO Auto-generated constructor stub
		mPreSystemCheck = PreSystemCheck.getInstance(context);
	}

	private void refreshArrayList()
	{
		int size = mPreSystemCheck.getFeatureInfos().size();
		matchInfo.clear();
		for (int i = 0; i < size; i++)
		{
			FeatureInfo info = mPreSystemCheck.getFeatureInfos().get(i);
			if (info.name.startsWith(match) == true)
			{
				matchInfo.add(info.name);
			}
		}
	}

	public void setMatch(String match)
	{
		this.match = match;
		refreshArrayList();
	}
	
	public ArrayList<String> getMatchInfo()
	{
		return matchInfo;
	}
}

interface IInfoList
{
	// use to check android device
	ArrayList<String> getInfoList();
}
