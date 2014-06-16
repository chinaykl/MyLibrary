package com.chinaykl.library.android.multimedia.media;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.chinaykl.library.android.multimedia.Player;

public class SysDefaultMPlayer implements Player
{
	private final String LOG_TAG="SysDefaultMPlayer";
	private Uri multimediaPath;
	private Context mContext;
	
	public SysDefaultMPlayer(Context context,Uri uri) 
	{
		// TODO Auto-generated constructor stub
		multimediaPath=uri;
		mContext=context;
	}

	public Uri getMultimediaPath()
	{
		return multimediaPath;
	}
	
	public void setMultimediaPath(Uri multimediaPath)
	{
		this.multimediaPath = multimediaPath;
	}
	
	@Override
	public void play()
	{
		// TODO Auto-generated method stub
		Intent intent = new Intent(Intent.ACTION_VIEW);
		Log.i(LOG_TAG, "uri:"+multimediaPath.toString());
		intent.setDataAndType(multimediaPath, "video/mp4");  
		mContext.startActivity(intent);
	}
}
