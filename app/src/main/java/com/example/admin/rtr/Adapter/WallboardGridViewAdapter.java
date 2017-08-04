package com.example.admin.rtr.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.admin.rtr.DateTimeDuration.Datetimeconversion;
import com.example.admin.rtr.ModelDashboard.Object;
import com.example.admin.rtr.R;

import java.util.List;

/**
 * Created by NgocTri on 10/22/2016.
 */

public class WallboardGridViewAdapter extends ArrayAdapter<Object> {
    public ProgressBar fieldprogress;
    public TextView fieldname;
    public TextView fieldvalue;
    int j=0;
    private int[] colors={Color.rgb(206,21,21),Color.rgb(0,8,115),Color.rgb(0,141,28),Color.rgb(219,153,22),Color.rgb(135,13,179)} ;

    public WallboardGridViewAdapter(Context context, int resource, List<Object> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = convertView;

        if(null == v) {
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.grid_item_dashboard, null);
        }
        Object object = getItem(position);
        fieldprogress = (ProgressBar) v.findViewById(R.id.thresholdbarBar);
        fieldname = (TextView)v.findViewById(R.id.fieldname);
        fieldvalue = (TextView)v.findViewById(R.id.fieldvalue);
        if(j==5)
        {
            j=0;

        }
        fieldname.setText(object.getName());

        if(object.getValue()>100)
        {
            fieldvalue.setText(new Datetimeconversion().getDurationString(object.getValue()));
        }
        else
        {
            fieldvalue.setText(object.getValue().toString());
        }
        fieldname.setBackgroundColor(colors[j]);
        fieldvalue.setTextColor(colors[j]);
        fieldprogress.setIndeterminate(true);
        j++;


        return v;
    }



}
