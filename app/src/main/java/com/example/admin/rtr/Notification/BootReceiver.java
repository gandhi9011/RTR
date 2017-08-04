package com.example.admin.rtr.Notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.i("Service Stop","ohhhh");
        context.startService(new Intent(context,NotificationService.class));
    }
}
