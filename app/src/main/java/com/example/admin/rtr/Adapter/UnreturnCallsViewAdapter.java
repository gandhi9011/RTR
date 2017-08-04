package com.example.admin.rtr.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.admin.rtr.DateTimeDuration.Datetimeconversion;
import com.example.admin.rtr.R;

import java.util.List;

import static com.google.android.gms.plus.PlusOneDummyView.TAG;

/**
 * Created by Admin on 09-06-2017.
 */

public class UnreturnCallsViewAdapter extends ArrayAdapter<com.example.admin.rtr.ModelUnreturnCall.Object>
{

    public TextView unreturn_date, unreturn_extention, unreturn_from, unreturn_to;
    int j = 0;
    private int[] colors = {Color.rgb(0,8,115),Color.rgb(0,141,28),Color.rgb(219,153,22),Color.rgb(135,13,179)};

    public UnreturnCallsViewAdapter(Context context, int resource, List<com.example.admin.rtr.ModelUnreturnCall.Object> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (null == v) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item_unreturn_call, null);
        }
        com.example.admin.rtr.ModelUnreturnCall.Object object = getItem(position);
        unreturn_date = (TextView) v.findViewById(R.id.date);
        unreturn_extention = (TextView) v.findViewById(R.id.extention);
        unreturn_from = (TextView) v.findViewById(R.id.from);
        unreturn_to = (TextView) v.findViewById(R.id.to);

        if (j == 4) {
            j = 0;

        }
        unreturn_date.setText(new Datetimeconversion().getDate(object.getDate()));
        unreturn_extention.setText(String.valueOf(object.getExtension()));
        unreturn_from.setText(String.valueOf(object.getFrom()));
        unreturn_to.setText(String.valueOf(object.getTo()));

        Log.e(TAG, "" + j);
        unreturn_date.setTextColor(colors[j]);
        unreturn_extention.setTextColor(colors[j]);
        unreturn_from.setTextColor(colors[j]);
        unreturn_to.setTextColor(colors[j]);
        //fieldprogress.setProgressBackgroundTintList(ColorStateList.valueOf(colors[j]));
        j++;


        return v;
    }





}
