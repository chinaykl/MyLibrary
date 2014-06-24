package com.chinaykl.library.android.hardware;

import java.util.ArrayList;

import android.content.pm.FeatureInfo;

public abstract class Module implements ModuleCheck
{
	protected ArrayList<FeatureInfo> infoList = new ArrayList<FeatureInfo>();
	private ArrayList<FeatureInfo> iList;
	
	private String match;

	public Module(ArrayList<FeatureInfo> list)
	{
		// TODO Auto-generated constructor stub
		iList=list;
	}
	
	public Boolean refreshArrayList()
	{
		Boolean result = false;
		for (int i = 0; i < iList.size(); i++)
		{
			FeatureInfo info = iList.get(i);
			if (info.name.startsWith(getMatch()) == true)
			{
				infoList.add(info);
				result=true;
			}
		}
		return result;
	}

	public String getMatch()
	{
		return match;
	}

	public void setMatch(String match)
	{
		this.match = match;
	}
}

interface ModuleCheck
{
	ArrayList<String> getModuleList();
}
