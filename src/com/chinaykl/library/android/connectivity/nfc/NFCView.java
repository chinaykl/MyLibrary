package com.chinaykl.library.android.connectivity.nfc;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.MifareUltralight;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.nfc.tech.TagTechnology;
import android.os.Bundle;
import android.util.Log;

public class NFCView extends Activity
{
	private final String tag = "NFCView";
	private NfcAdapter mAdapter;
	PendingIntent pendingIntent;
	IntentFilter typeNDEF;
	IntentFilter httpNDEF;
	String[][] techListsArray;
	IntentFilter[] filters;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mAdapter = NfcAdapter.getDefaultAdapter(this);
		if (mAdapter == null)
		{
			Log.i(tag, "Can not get default NFC adapter");
			System.exit(0);
		}
		pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
		
		typeNDEF=new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
		try
		{
			typeNDEF.addDataType("*/*");
		}
		catch (MalformedMimeTypeException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		httpNDEF = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
		httpNDEF.addDataScheme("http");
		
		filters=new IntentFilter[]
				{
					typeNDEF,
					httpNDEF
				};
		
		techListsArray= new String[][]
				{
					new String[]{ TagTechnology.class.getName() },
					new String[]{ NfcA.class.getName() },
					new String[]{ NfcB.class.getName() },
					new String[]{ NfcF.class.getName() },
					new String[]{ NfcV.class.getName() },
					new String[]{ IsoDep.class.getName() },
					new String[]{ Ndef.class.getName() },
					new String[]{ NdefFormatable.class.getName() },
					new String[]{ MifareClassic.class.getName() },
					new String[]{ MifareUltralight.class.getName() }
				};
	}

	@Override
	protected void onNewIntent(Intent intent)
	{
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
		Tag mTag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
		Log.i(tag, "tag:"+mTag.toString());
	}
	
	@Override
	protected void onPause()
	{
		// TODO Auto-generated method stub
		super.onPause();
		if (mAdapter != null)
		{
			mAdapter.disableForegroundDispatch(this);
		}
	}

	@Override
	protected void onResume()
	{
		// TODO Auto-generated method stub
		super.onResume();
		if (mAdapter != null)
		{
			mAdapter.enableForegroundDispatch(this, pendingIntent, filters, techListsArray);
		}
	}
}
