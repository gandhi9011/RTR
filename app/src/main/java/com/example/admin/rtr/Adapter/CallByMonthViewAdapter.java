package com.example.admin.rtr.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.admin.rtr.DateTimeDuration.Datetimeconversion;
import com.example.admin.rtr.ModelCallbyMonth.Object;
import com.example.admin.rtr.R;

import java.util.List;

/**
 * Created by Admin on 22-06-2017.
 */

public class CallByMonthViewAdapter extends ArrayAdapter<Object>
{

    public TextView
            callbymonth_start_time,
            callbymonth_end_time,
            callbymonth_in_calls,
            callbymonth_in_ans,
            callbymonth_avg_ans,
            callbymonth_total_talk,
            callbymonth_avg_talk,
            callbymonth_in_abnd,
            callbymonth_avg_abnd,
            callbymonth_out,
            callbymonth_out_ans,
            callbymonth_max_wait,
            callbymonth_avg_wait,
            callbymonth_svc,
            callbymonth_vm_redricts,
            callbymonth_avg_wrapup;


    int j = 0;
    private int[] colors = {Color.rgb(0,8,115),Color.rgb(0,141,28),Color.rgb(219,153,22),Color.rgb(135,13,179)};

    public CallByMonthViewAdapter(Context context, int resource, List<Object> objects)
    {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (null == v) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item_call_by_month, null);
        }
        Object object = getItem(position);
        callbymonth_start_time=(TextView)v.findViewById(R.id.callby_month_start_time);
        callbymonth_end_time=(TextView)v.findViewById(R.id.callby_month_end_time);
        callbymonth_in_calls=(TextView)v.findViewById(R.id.callby_month_in_calls);
        callbymonth_in_ans=(TextView)v.findViewById(R.id.callby_month_in_ans);
        callbymonth_avg_ans=(TextView)v.findViewById(R.id.callby_month_avg_ans);
        callbymonth_total_talk=(TextView)v.findViewById(R.id.callby_month_total_talk);
        callbymonth_avg_talk=(TextView)v.findViewById(R.id.callby_month_avg_talk);
        callbymonth_in_abnd=(TextView)v.findViewById(R.id.callby_month_in_abnd);
        callbymonth_avg_abnd=(TextView)v.findViewById(R.id.callby_month_avg_abnd);
        callbymonth_out=(TextView)v.findViewById(R.id.callby_month_out);
        callbymonth_out_ans=(TextView)v.findViewById(R.id.callby_month_out_ans);
        callbymonth_max_wait=(TextView)v.findViewById(R.id.callby_month_max_wait);
        callbymonth_avg_wait=(TextView)v.findViewById(R.id.callby_month_avg_wait);
        callbymonth_svc=(TextView)v.findViewById(R.id.callby_month_svc);
        callbymonth_vm_redricts=(TextView)v.findViewById(R.id.callby_month_vm_redricts);
        callbymonth_avg_wrapup=(TextView)v.findViewById(R.id.callby_month_avg_wrapup);



        if (j == 4)
        {
            j = 0;

        }

        callbymonth_start_time.setText(new Datetimeconversion().getDate(Long.valueOf(object.getStartTime())));
        callbymonth_end_time.setText(new Datetimeconversion().getDate(Long.valueOf(object.getEndTime())));
        callbymonth_in_calls.setText(String.valueOf(object.getInCalls()));
        callbymonth_in_ans.setText(String.valueOf(object.getInAns()));
        callbymonth_avg_ans.setText(new Datetimeconversion().getDurationString(Long.valueOf(object.getAvgAns())));
        callbymonth_total_talk.setText(new Datetimeconversion().getDurationString(Long.valueOf(object.getTotTlk())));
        callbymonth_avg_talk.setText(new Datetimeconversion().getDurationString(Long.valueOf(object.getAvgTlk())));
        callbymonth_in_abnd.setText(String.valueOf(object.getInAbnd()));
        callbymonth_avg_abnd.setText(new Datetimeconversion().getDurationString(Long.valueOf(object.getAvgAbnd())));
        callbymonth_out.setText(String.valueOf(object.getOut()));
        callbymonth_out_ans.setText(String.valueOf(object.getOutAns()));
        callbymonth_max_wait.setText(new Datetimeconversion().getDurationString(Long.valueOf(object.getMaxWait())));
        callbymonth_avg_wait.setText(new Datetimeconversion().getDurationString(Long.valueOf(object.getAvgWait())));
        callbymonth_svc.setText(String.valueOf(object.getSvc()));
        callbymonth_vm_redricts.setText(String.valueOf(object.getVmRedirects()));
        callbymonth_avg_wrapup.setText(new Datetimeconversion().getDurationString(Long.valueOf(object.getAvgWrpUp())));

        callbymonth_start_time.setTextColor(colors[j]);
        callbymonth_end_time.setTextColor(colors[j]);
        callbymonth_in_calls.setTextColor(colors[j]);
        callbymonth_in_ans.setTextColor(colors[j]);
        callbymonth_avg_ans.setTextColor(colors[j]);
        callbymonth_total_talk.setTextColor(colors[j]);
        callbymonth_avg_talk.setTextColor(colors[j]);
        callbymonth_in_abnd.setTextColor(colors[j]);
        callbymonth_avg_abnd.setTextColor(colors[j]);
        callbymonth_out.setTextColor(colors[j]);
        callbymonth_out_ans.setTextColor(colors[j]);
        callbymonth_max_wait.setTextColor(colors[j]);
        callbymonth_avg_wait.setTextColor(colors[j]);
        callbymonth_svc.setTextColor(colors[j]);
        callbymonth_vm_redricts.setTextColor(colors[j]);
        callbymonth_avg_wrapup.setTextColor(colors[j]);
        j++;


        return v;
    }

}
