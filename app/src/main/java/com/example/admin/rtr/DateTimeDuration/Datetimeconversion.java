package com.example.admin.rtr.DateTimeDuration;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Admin on 29-06-2017.
 */

public class Datetimeconversion {
    public  String getDate(long milliSeconds) {
        SimpleDateFormat formatter = new SimpleDateFormat(" hh:mm:ss a");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    public  String getDateonly(long milliSeconds) {
        SimpleDateFormat formatter = new SimpleDateFormat(" hh a");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    public long StartTimeStamp() throws ParseException {
        Date today = new Date();
        long ts_now = today.getTime();
        Calendar cal = Calendar.getInstance();
        long milisSinceMidnight = (cal.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000) + (cal.get(Calendar.MINUTE) * 60 * 1000) + (cal.get(Calendar.SECOND) * 1000) + (cal.get(Calendar.MILLISECOND));
        Log.e("StartTime",""+((ts_now - (milisSinceMidnight + 3600000)) / 1000));
        return ((ts_now - (milisSinceMidnight + 3600000)) / 1000);
    }

    public long EndTimeStamp() throws ParseException {

        Date today = new Date();
        long ts_now = today.getTime();
        Calendar cal = Calendar.getInstance();
        long milisSinceMidnight = (cal.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000) + (cal.get(Calendar.MINUTE) * 60 * 1000) + (cal.get(Calendar.SECOND) * 1000) + (cal.get(Calendar.MILLISECOND));
        Log.e("EndTime",""+(((ts_now - milisSinceMidnight) + 82740000) / 1000));
        return (((ts_now - milisSinceMidnight) + 82740000) / 1000);
    }

    public String getDurationString(long miliseconds) {

        long seconds = miliseconds / 1000;
        int hours = (int) seconds / 3600;
        int minutes = (int) (seconds % 3600) / 60;
        seconds = seconds % 60;
        if(hours == 0 && minutes==0 && seconds==0)
        {
            return "No Duration";
        }
        else if (hours == 0 && minutes==0 && seconds!=0)
        {
            return (seconds) + " seconds" ;
        }
        else if (hours==0 && minutes!=0 )
        {
        return  (minutes) + "minutes & "+ (seconds) + "seconds" ;
        }
        else
         {
            return (hours) + " hours & " + (minutes) + "minutes";
         }
    }
}
