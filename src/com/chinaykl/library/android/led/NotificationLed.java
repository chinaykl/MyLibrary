package com.chinaykl.library.android.led;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

public class NotificationLed
{

	public NotificationLed(Context context)
	{
		// TODO Auto-generated constructor stub
		final int ID_LED = 19871103;
		NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

		Notification notification = new Notification();
		notification.ledARGB = 0x00FF00;
		notification.ledOnMS = 10000000;
		notification.ledOffMS = 0;
		notification.flags = Notification.FLAG_SHOW_LIGHTS;
		nm.notify(ID_LED, notification);
		nm.cancel(ID_LED);
	}

}
