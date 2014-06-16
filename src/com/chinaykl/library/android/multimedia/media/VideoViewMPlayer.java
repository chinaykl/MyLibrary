package com.chinaykl.library.android.multimedia.media;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import com.chinaykl.library.android.multimedia.Player;

//this class need WRITE_EXTERNAL_STORAGE permission
// you should add 
// "<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>" 
// in AndroidManifest.xml
public class VideoViewMPlayer implements Player
{
	private final String LOG_TAG = "VideoViewMPlayer";
	private Uri multimediaPath;
	private Activity mActivity;

	public VideoViewMPlayer(Activity activity, Uri uri)
	{
		// TODO Auto-generated constructor stub
		multimediaPath = uri;
		mActivity = activity;
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
		VideoView videoView = new VideoView(mActivity);
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		mActivity.addContentView(videoView, params);
		videoView.setMediaController(new MediaController(mActivity));
		videoView.setVideoURI(multimediaPath);
		Log.i(LOG_TAG, "uri:" + multimediaPath.toString());
		videoView.start();
		videoView.requestFocus();
	}

}
