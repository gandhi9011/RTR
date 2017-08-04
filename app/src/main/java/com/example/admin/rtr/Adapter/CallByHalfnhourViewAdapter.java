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
import com.example.admin.rtr.ModelCallbyHalfnHour.Object;
import com.example.admin.rtr.R;

import java.util.List;

/**
 * Created by Admin on 22-06-2017.
 */

public class CallByHalfnhourViewAdapter extends ArrayAdapter<Object>
{

    public TextView
            callbyhalfnhour_start_time,
            callbyhalfnhour_end_time,
            callbyhalfnhour_in_calls,
            callbyhalfnhour_in_ans,
            callbyhalfnhour_avg_ans,
            callbyhalfnhour_total_talk,
            callbyhalfnhour_avg_talk,
            callbyhalfnhour_in_abnd,
            callbyhalfnhour_avg_abnd,
            callbyhalfnhour_out,
            callbyhalfnhour_out_ans,
            callbyhalfnhour_max_wait,
            callbyhalfnhour_avg_wait,
            callbyhalfnhour_svc,
            callbyhalfnhour_vm_redricts,
            callbyhalfnhour_avg_wrapup;


    int j = 0;
    private int[] colors = {Color.rgb(0,8,115),Color.rgb(0,141,28),Color.rgb(219,153,22),Color.rgb(135,13,179)};

    public CallByHalfnhourViewAdapter(Context context, int resource, List<Object> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (null == v) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item_call_by_halfnhour, null);
        }
        Object object = getItem(position);
                callbyhalfnhour_start_time=(TextView)v.findViewById(R.id.callby_halfnhour_start_time);
                callbyhalfnhour_end_time=(TextView)v.findViewById(R.id.callby_halfnhour_end_time);
                callbyhalfnhour_in_calls=(TextView)v.findViewById(R.id.callby_halfnhour_in_calls);
                callbyhalfnhour_in_ans=(TextView)v.findViewById(R.id.callby_halfnhour_in_ans);
                callbyhalfnhour_avg_ans=(TextView)v.findViewById(R.id.callby_halfnhour_avg_ans);
                callbyhalfnhour_total_talk=(TextView)v.findViewById(R.id.callby_halfnhour_total_talk);
                callbyhalfnhour_avg_talk=(TextView)v.findViewById(R.id.callby_halfnhour_avg_talk);
                callbyhalfnhour_in_abnd=(TextView)v.findViewById(R.id.callby_halfnhour_in_abnd);
                callbyhalfnhour_avg_abnd=(TextView)v.findViewById(R.id.callby_halfnhour_avg_abnd);
                callbyhalfnhour_out=(TextView)v.findViewById(R.id.callby_halfnhour_out);
                callbyhalfnhour_out_ans=(TextView)v.findViewById(R.id.callby_halfnhour_out_ans);
                callbyhalfnhour_max_wait=(TextView)v.findViewById(R.id.callby_halfnhour_max_wait);
                callbyhalfnhour_avg_wait=(TextView)v.findViewById(R.id.callby_halfnhour_avg_wait);
                callbyhalfnhour_svc=(TextView)v.findViewById(R.id.callby_halfnhour_svc);
                callbyhalfnhour_vm_redricts=(TextView)v.findViewById(R.id.callby_halfnhour_vm_redricts);
                callbyhalfnhour_avg_wrapup=(TextView)v.findViewById(R.id.callby_halfnhour_avg_wrapup);



        if (j == 4)
        {
            j = 0;

        }

                callbyhalfnhour_start_time.setText(new Datetimeconversion().getDate(Long.valueOf(object.getStartTime())));
                callbyhalfnhour_end_time.setText(new Datetimeconversion().getDate(Long.valueOf(object.getEndTime())));
                callbyhalfnhour_in_calls.setText(String.valueOf(object.getInCalls()));
                callbyhalfnhour_in_ans.setText(String.valueOf(object.getInAns()));
                callbyhalfnhour_avg_ans.setText(new Datetimeconversion().getDurationString(Long.valueOf(object.getAvgAns())));
                callbyhalfnhour_total_talk.setText(new Datetimeconversion().getDurationString(Long.valueOf(object.getTotTlk())));
                callbyhalfnhour_avg_talk.setText(new Datetimeconversion().getDurationString(Long.valueOf(object.getAvgTlk())));
                callbyhalfnhour_in_abnd.setText(String.valueOf(object.getInAbnd()));
                callbyhalfnhour_avg_abnd.setText(new Datetimeconversion().getDurationString(Long.valueOf(object.getAvgAbnd())));
                callbyhalfnhour_out.setText(String.valueOf(object.getOut()));
                callbyhalfnhour_out_ans.setText(String.valueOf(object.getOutAns()));
                callbyhalfnhour_max_wait.setText(new Datetimeconversion().getDurationString(Long.valueOf(object.getMaxWait())));
                callbyhalfnhour_avg_wait.setText(new Datetimeconversion().getDurationString(Long.valueOf(object.getAvgWait())));
                callbyhalfnhour_svc.setText(String.valueOf(object.getSvc()));
                callbyhalfnhour_vm_redricts.setText(String.valueOf(object.getVmRedirects()));
                callbyhalfnhour_avg_wrapup.setText(new Datetimeconversion().getDurationString(Long.valueOf(object.getAvgWrpUp())));

                callbyhalfnhour_start_time.setTextColor(colors[j]);
                callbyhalfnhour_end_time.setTextColor(colors[j]);
                callbyhalfnhour_in_calls.setTextColor(colors[j]);
                callbyhalfnhour_in_ans.setTextColor(colors[j]);
                callbyhalfnhour_avg_ans.setTextColor(colors[j]);
                callbyhalfnhour_total_talk.setTextColor(colors[j]);
                callbyhalfnhour_avg_talk.setTextColor(colors[j]);
                callbyhalfnhour_in_abnd.setTextColor(colors[j]);
                callbyhalfnhour_avg_abnd.setTextColor(colors[j]);
                callbyhalfnhour_out.setTextColor(colors[j]);
                callbyhalfnhour_out_ans.setTextColor(colors[j]);
                callbyhalfnhour_max_wait.setTextColor(colors[j]);
                callbyhalfnhour_avg_wait.setTextColor(colors[j]);
                callbyhalfnhour_svc.setTextColor(colors[j]);
                callbyhalfnhour_vm_redricts.setTextColor(colors[j]);
                callbyhalfnhour_avg_wrapup.setTextColor(colors[j]);
        j++;


        return v;
    }

}
