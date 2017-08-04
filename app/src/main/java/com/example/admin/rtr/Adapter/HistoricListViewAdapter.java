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
import com.example.admin.rtr.ModelHistoricCall.Object;
import com.example.admin.rtr.R;

import java.util.List;

/**
 * Created by Admin on 05-06-2017.
 */

public class HistoricListViewAdapter extends ArrayAdapter<Object> {
    public TextView historic_date,  historic_duration, historic_from, historic_to,historic_service_time,historic_service_time_tv,historic_date_tv,  historic_duration_tv, historic_from_tv, historic_to_tv,historic_device,historic_device_tv;
    int j = 0;
    private int[] colors = {Color.rgb(0,8,115),Color.rgb(0,141,28),Color.RED,Color.BLACK};


    public HistoricListViewAdapter(Context context, int resource, List<Object> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (null == v) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item_historic_call, null);
        }
        Object object = getItem(position);
        historic_date = (TextView) v.findViewById(R.id.date);
        historic_duration = (TextView) v.findViewById(R.id.duration);
        historic_from = (TextView) v.findViewById(R.id.from);
        historic_to = (TextView) v.findViewById(R.id.to);
        historic_device=(TextView)v.findViewById(R.id.device);
        historic_service_time=(TextView)v.findViewById(R.id.service_time);
        historic_device_tv=(TextView)v.findViewById(R.id.historic_device);
        historic_service_time_tv=(TextView)v.findViewById(R.id.historic_service_time);
        historic_to_tv = (TextView) v.findViewById(R.id.historic_to);
        historic_date_tv = (TextView) v.findViewById(R.id.historic_date);
        historic_duration_tv = (TextView) v.findViewById(R.id.historic_duration);
        historic_from_tv = (TextView) v.findViewById(R.id.historic_from);
        historic_date.setText(new Datetimeconversion().getDate(object.getDate()));
        historic_duration.setText(new Datetimeconversion().getDurationString(object.getDuration()));
        historic_from.setText(String.valueOf(object.getFrom()));
        historic_to.setText(String.valueOf(object.getTo()));
        historic_device.setText(String.valueOf(object.getDevice()));
        historic_service_time.setText(new Datetimeconversion().getDurationString(object.getServiceTime()));

        if(((object.getType().toString()).equals("INT-IN")) || ((object.getType().toString()).equals("IN")))
        {
           j=0;
        }
        if(((object.getType().toString()).equals("INT-OUT")) || ((object.getType().toString()).equals("OUT")))
        {
            j=1;
        }

        if(((object.getType().toString()).equals("INT-IN-ABAN")) || ((object.getType().toString()).equals("IN-ABAN")))
        {
           j=2;
        }
        if(((object.getType().toString()).equals("VM")))
        {
            j=3;
        }
        historic_date.setTextColor(colors[j]);
        historic_duration.setTextColor(colors[j]);
        historic_from.setTextColor(colors[j]);
        historic_to.setTextColor(colors[j]);
        historic_date_tv.setTextColor(colors[j]);
        historic_duration_tv.setTextColor(colors[j]);
        historic_from_tv.setTextColor(colors[j]);
        historic_to_tv.setTextColor(colors[j]);
        historic_device.setTextColor(colors[j]);
        historic_device_tv.setTextColor(colors[j]);
        historic_service_time.setTextColor(colors[j]);
        historic_service_time_tv.setTextColor(colors[j]);





        return v;
    }




}
