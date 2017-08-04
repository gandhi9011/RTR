package com.example.admin.rtr.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.admin.rtr.ModelCallbyHalfnHour.CallbyhalfnhourChild;
import com.example.admin.rtr.ModelCallbyHalfnHour.CallbyhalfnhourGroup;
import com.example.admin.rtr.R;

import java.util.ArrayList;

/**
 * Created by Admin on 20-07-2017.
 */

public class CallbyhalfnhourExpandableListViewAdapter extends BaseExpandableListAdapter
{

    private Context _context;
    private ArrayList<CallbyhalfnhourGroup> callbyhalfnhourGroups;
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
    int j=0;
    private int[] colors = {Color.rgb(0,8,115),Color.rgb(0,141,28),Color.rgb(219,153,22),Color.rgb(135,13,179)};
    public CallbyhalfnhourExpandableListViewAdapter(Context context, ArrayList<CallbyhalfnhourGroup> groups) {
        this._context = context;
        this.callbyhalfnhourGroups=groups;

    }


    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        CallbyhalfnhourChild callbyhalfnhourChild=callbyhalfnhourGroups.get(groupPosition).getCallbyhalfnhourChild();
        return  callbyhalfnhourChild;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        CallbyhalfnhourChild child= (CallbyhalfnhourChild)  getChild(groupPosition,childPosition);



        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.callbyhalfnhour_list_item, null);
        }
        View v=convertView;

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




                callbyhalfnhour_start_time.setText(child.getCallbyhalfnhour_start_time());
                callbyhalfnhour_end_time.setText(child.getCallbyhalfnhour_end_time());
                callbyhalfnhour_in_calls.setText(child.getCallbyhalfnhour_in_calls());
                callbyhalfnhour_in_ans.setText(child.getCallbyhalfnhour_in_ans());
                callbyhalfnhour_avg_ans.setText(child.getCallbyhalfnhour_avg_ans());
                callbyhalfnhour_total_talk.setText(child.getCallbyhalfnhour_total_talk());
                callbyhalfnhour_avg_talk.setText(child.getCallbyhalfnhour_avg_talk());
                callbyhalfnhour_in_abnd.setText(child.getCallbyhalfnhour_in_abnd());
                callbyhalfnhour_avg_abnd.setText(child.getCallbyhalfnhour_avg_abnd());
                callbyhalfnhour_out.setText(child.getCallbyhalfnhour_out());
                callbyhalfnhour_out_ans.setText(child.getCallbyhalfnhour_out_ans());
                callbyhalfnhour_max_wait.setText(child.getCallbyhalfnhour_max_wait());
                callbyhalfnhour_avg_wait.setText(child.getCallbyhalfnhour_avg_wait());
                callbyhalfnhour_svc.setText(child.getCallbyhalfnhour_svc());
                callbyhalfnhour_vm_redricts.setText(child.getCallbyhalfnhour_vm_redricts());
                callbyhalfnhour_avg_wrapup.setText(child.getCallbyhalfnhour_avg_wrapup());






        return v;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return callbyhalfnhourGroups.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return callbyhalfnhourGroups.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        CallbyhalfnhourGroup group=(CallbyhalfnhourGroup) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.callbyhalfnhour_list_group, null);
        }

        TextView callbyhalfnhourtime1 = (TextView) convertView
                .findViewById(R.id.callbyhalfnhourtime1);
        TextView callbyhalfnhourtime2 = (TextView) convertView
                .findViewById(R.id.callbyhalfnhourtime2);
        callbyhalfnhourtime1.setTypeface(null, Typeface.BOLD);
        callbyhalfnhourtime2.setTypeface(null, Typeface.BOLD);
        callbyhalfnhourtime1.setText(String.valueOf(group.getTime1()));
        callbyhalfnhourtime2.setText(String.valueOf(group.getTime2()));

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
