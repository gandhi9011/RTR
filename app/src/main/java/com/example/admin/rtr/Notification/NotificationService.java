package com.example.admin.rtr.Notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;

import com.example.admin.rtr.APIData.ApiHelperDashboard;
import com.example.admin.rtr.AllItemsAPI.DashboardApiInterface;
import com.example.admin.rtr.DateTimeDuration.Datetimeconversion;
import com.example.admin.rtr.ModelDashboard.DesktopWallboardResponse;
import com.example.admin.rtr.ModelDashboard.Object;
import com.example.admin.rtr.R;

import java.text.ParseException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

public class NotificationService extends Service
{
    List<Object> objects;
    public NotificationService() {
    }

    @Override
    public IBinder onBind(Intent intent)
    {
     return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
       timer = new Timer();
       timer.schedule(timerTask,10000,60000);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        try
        {
        }catch (Exception e){e.printStackTrace(); }
        return super.onStartCommand(intent, flags, startId);
    }



    private Timer timer;
    TimerTask timerTask=new TimerTask() {
        @Override
        public void run()
        {
            DashboardApiInterface apiService = ApiHelperDashboard.get();


            Call<DesktopWallboardResponse> call = null;
            try {
                call = apiService.getDesktopWallboard(String.valueOf(new Datetimeconversion().EndTimeStamp()), String.valueOf(new Datetimeconversion().StartTimeStamp()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            call.enqueue(new Callback<DesktopWallboardResponse>() {
                @Override
                public void onResponse(Call<DesktopWallboardResponse> call, Response<DesktopWallboardResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        Log.e(TAG, response.body().toString() + "jsonmodel");
                        DesktopWallboardResponse desktopWallboardResponse = response.body(); //JSON DATA
                        List<Object> objects = desktopWallboardResponse.getObjects();
                        for (int i=0;i<objects.size();i++)
                        {
                            Object object=objects.get(i);
                            if(object.getId().equals("sign_in") && object.getValue()>=12)
                            {
                                notifiy();
                                Log.e("noticount","123");

                            }

                        }


                    }
                }

                @Override
                public void onFailure(Call<DesktopWallboardResponse> call, Throwable t) {
                    Log.e(TAG, "Callback Failed. No Response.");
                }
            });

        }
    };

    @Override
    public void onDestroy()
    {
        try
        {
            timer.cancel();
            timerTask.cancel();
        }catch (Exception e){e.printStackTrace();}
            Intent intent=new Intent("com.example.admin.rtr");
            intent.putExtra("a","b");
            sendBroadcast(intent);


    }
    public void notifiy()
    {
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("RSSPullService");

        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(""));
        PendingIntent pendingIntent=PendingIntent.getActivity(getBaseContext(),0,intent,Intent.FLAG_ACTIVITY_NEW_TASK);
        Context context=getApplicationContext();
        Notification.Builder builder;
        builder=new Notification.Builder(context)
                    .setContentTitle("DesktopWallboard")
                    .setContentText("Sign-in amount goes above 12")
                    .setContentIntent(pendingIntent)
                    .setDefaults(Notification.DEFAULT_SOUND)
                    .setAutoCancel(true)
                    .setSmallIcon(R.drawable.bct_logo);

        Notification notification=builder.build();

        NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1,notification);
    }



}
