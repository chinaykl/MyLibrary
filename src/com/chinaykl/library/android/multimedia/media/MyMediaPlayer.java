package com.chinaykl.library.android.multimedia.media;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.ViewGroup.LayoutParams;

import com.chinaykl.library.android.multimedia.Player;
import com.chinaykl.library.android.userinterface.DisplayScreen;

public class MyMediaPlayer implements Player, Callback, OnCompletionListener, OnErrorListener, OnInfoListener, OnPreparedListener, OnSeekCompleteListener, OnVideoSizeChangedListener
{
	private final String LOG_TAG = "MyMediaPlayer";
	private String multimediaPath;
	private Activity activity;
	private SurfaceView surfaceView;
	private SurfaceHolder holder;
	private MediaPlayer player;
	private DisplayScreen screen;
	private boolean mediaReady;

	public MyMediaPlayer(Activity mActivity, String path)
	{
		// TODO Auto-generated constructor stub
		activity = mActivity;
		multimediaPath = path;
		screen = new DisplayScreen(mActivity);
		surfaceView = new SurfaceView(activity);
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		activity.addContentView(surfaceView, params);
		holder = surfaceView.getHolder();
		// Add a Callback interface for this holder
		holder.addCallback(this);

		player = new MediaPlayer();
		player.setOnCompletionListener(this);
		player.setOnErrorListener(this);
		player.setOnInfoListener(this);
		player.setOnPreparedListener(this);
		player.setOnSeekCompleteListener(this);
		player.setOnVideoSizeChangedListener(this);
		try
		{
			player.setDataSource(multimediaPath);
		}
		catch (IllegalArgumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SecurityException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalStateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onVideoSizeChanged(MediaPlayer mp, int width, int height)
	{
		// TODO Auto-generated method stub
		// Called to indicate the video size The video size (width and height)
		// could be 0 if there was no video, no display surface was set, or the
		// value was not determined yet.
		Log.d(LOG_TAG, "Video Size Changed");
	}

	@Override
	public void onSeekComplete(MediaPlayer mp)
	{
		// TODO Auto-generated method stub
		// Called to indicate the completion of a seek operation.
		Log.d(LOG_TAG, "Seek Complete");
	}

	@Override
	public void onPrepared(MediaPlayer mp)
	{
		// TODO Auto-generated method stub
		// Called when the media file is ready for playback.
		mediaReady = true;

	}

	@Override
	public boolean onInfo(MediaPlayer mp, int what, int extra)
	{
		// TODO Auto-generated method stub
		// Called to indicate an info or a warning.
		switch (what)
		{
			case MediaPlayer.MEDIA_INFO_UNKNOWN:
				Log.d(LOG_TAG, "MEDIA_INFO_UNKNOWN");
				break;
			case MediaPlayer.MEDIA_INFO_VIDEO_TRACK_LAGGING:
				Log.d(LOG_TAG, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
				break;
			case MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START:
				Log.d(LOG_TAG, "MEDIA_INFO_VIDEO_RENDERING_START");
				break;
			case MediaPlayer.MEDIA_INFO_BUFFERING_START:
				Log.d(LOG_TAG, "MEDIA_INFO_BUFFERING_START");
				break;
			case MediaPlayer.MEDIA_INFO_BUFFERING_END:
				Log.d(LOG_TAG, "MEDIA_INFO_BUFFERING_END");
				break;
			case MediaPlayer.MEDIA_INFO_BAD_INTERLEAVING:
				Log.d(LOG_TAG, "MEDIA_INFO_BAD_INTERLEAVING");
				break;
			case MediaPlayer.MEDIA_INFO_NOT_SEEKABLE:
				Log.d(LOG_TAG, "MEDIA_INFO_NOT_SEEKABLE");
				break;
			case MediaPlayer.MEDIA_INFO_METADATA_UPDATE:
				Log.d(LOG_TAG, "MEDIA_INFO_METADATA_UPDATE");
				break;
			case MediaPlayer.MEDIA_INFO_UNSUPPORTED_SUBTITLE:
				Log.d(LOG_TAG, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
				break;
			case MediaPlayer.MEDIA_INFO_SUBTITLE_TIMED_OUT:
				Log.d(LOG_TAG, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
				break;
			default:
				Log.d(LOG_TAG, "No Define");
				break;
		}
		return false;
	}

	@Override
	public boolean onError(MediaPlayer mp, int what, int extra)
	{
		// TODO Auto-generated method stub
		switch (what)
		{
			case MediaPlayer.MEDIA_ERROR_UNKNOWN:
				Log.d(LOG_TAG, "MEDIA_ERROR_UNKNOWN");
				break;
			case MediaPlayer.MEDIA_ERROR_SERVER_DIED:
				Log.d(LOG_TAG, "MEDIA_ERROR_SERVER_DIED");
				break;
			default:
				break;
		}
		return false;
	}

	@Override
	public void onCompletion(MediaPlayer mp)
	{
		// TODO Auto-generated method stub
		// Called when the end of a media source is reached during playback.
		Log.d(LOG_TAG, "Completion");

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder)
	{
		// TODO Auto-generated method stub
		player.setDisplay(holder);
		player.prepareAsync();
		Log.d(LOG_TAG, "surface Created");

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
	{
		// TODO Auto-generated method stub
		Log.d(LOG_TAG, "surface Changed");
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder)
	{
		// TODO Auto-generated method stub
		Log.d(LOG_TAG, "surface Destroyed");
	}

	public String getMultimediaPath()
	{
		return multimediaPath;
	}

	public void setMultimediaPath(String multimediaPath)
	{
		this.multimediaPath = multimediaPath;
	}

	public boolean isMediaReady()
	{
		return mediaReady;
	}

	@Override
	public void play()
	{
		// TODO Auto-generated method stub
		new Thread()
		{
			public void run()
			{
				while (mediaReady == false)
				{
					try
					{
						Thread.sleep(100);
						Log.d(LOG_TAG, "sleep");
					}
					catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				player.start();
			}
		}.start();
	}
}
