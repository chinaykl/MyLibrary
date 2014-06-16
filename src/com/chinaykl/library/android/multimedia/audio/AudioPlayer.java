package com.chinaykl.library.android.multimedia.audio;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.util.Log;

import com.chinaykl.library.android.multimedia.Player;

public class AudioPlayer implements Player
{
	private final String LOG_TAG = "AudioPlayer";
	private String multimediaPath;
	private String recordPath;
	private MediaPlayer mPlayer = null;
	private MediaRecorder mRecorder = null;
	private float leftVolume = 1.0f;
	private float rightVolume = 1.0f;

	public AudioPlayer(String pPath, String rPath)
	{
		// TODO Auto-generated constructor stub
		mRecorder = new MediaRecorder();
		mPlayer = new MediaPlayer();
		multimediaPath = pPath;
		recordPath = rPath;
	}

	private void startRecord()
	{
		// TODO Auto-generated method stub
		FileDescriptor mFileName = null;
		try
		{
			mFileName = new FileInputStream(recordPath).getFD();
		}
		catch (FileNotFoundException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		mRecorder.setOutputFile(mFileName);
		mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

		try
		{
			mRecorder.prepare();
		}
		catch (IOException e)
		{
			Log.e(LOG_TAG, "prepare() failed");
		}

		mRecorder.start();
	}

	private void stopRecord()
	{
		// TODO Auto-generated method stub
		mRecorder.stop();
		mRecorder.release();
		mRecorder = null;

	}

	private void startplay()
	{
		// TODO Auto-generated method stub
		try
		{
			mPlayer.setDataSource(multimediaPath);
			mPlayer.setVolume(leftVolume, rightVolume);
			mPlayer.prepare();
			mPlayer.start();
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

	private void stopplay()
	{
		// TODO Auto-generated method stub
		mPlayer.release();
		mPlayer = null;
	}

	@Override
	public void play()
	{
		// TODO Auto-generated method stub
		startRecord();
	}

}
