package com.example.admin.rtr.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.rtr.ModelAgentQueue.AgentChild;
import com.example.admin.rtr.ModelAgentQueue.AgentGroup;
import com.example.admin.rtr.R;

import java.util.ArrayList;

/**
 * Created by Admin on 14-07-2017.
 */

public class AgentExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private ArrayList<AgentGroup> Agentgroups; // header titles
    public TextView
            agent_abandoned_calls,
            agent_answers_call,
            agent_inbound_calls,
            agent_outbound_total_calls,
            agent_outbound_total_duration,
            agent_acd_state,
            agent_acd_state_duration,
            agent_total_call_duration,
            agent_outbound_internal_calls,
            agent_outbound_external_calls,
            agent_inbound_outbound_total_calls,
            agent_inbound_outbound_call_duration,
            agent_transferred_call,
            agent_voice_mail,
            agent_id;
    int j=0;
    private int[] colors = {Color.rgb(0,8,115),Color.rgb(0,141,28),Color.rgb(219,153,22),Color.rgb(135,13,179)};
    public AgentExpandableListAdapter(Context context, ArrayList<AgentGroup> groups) {
        this._context = context;
        this.Agentgroups=groups;

    }


    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        AgentChild Agentchild=Agentgroups.get(groupPosition).getAgentChild();
        return  Agentchild;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        AgentChild child= (AgentChild)  getChild(groupPosition,childPosition);



        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.agent_list_item, null);
        }
        View v=convertView;

        agent_id=(TextView)v.findViewById(R.id.agent_id);
        agent_abandoned_calls=(TextView)v.findViewById(R.id.agent_abandoned_calls);
        agent_answers_call=(TextView)v.findViewById(R.id.agent_answers_call);
        agent_inbound_calls=(TextView)v.findViewById(R.id.agent_inbound_calls);
        agent_outbound_total_calls=(TextView)v.findViewById(R.id.agent_outbound_total_calls);
        agent_outbound_total_duration=(TextView)v.findViewById(R.id.agent_outbound_call_duration);
        agent_acd_state=(TextView)v.findViewById(R.id.agent_acd_state);
        agent_acd_state_duration=(TextView)v.findViewById(R.id.agent_acd_state_duration);
        agent_total_call_duration=(TextView)v.findViewById(R.id.agent_total_call_duration);
        agent_outbound_internal_calls=(TextView)v.findViewById(R.id.agent_outbound_internal_calls);
        agent_outbound_external_calls=(TextView)v.findViewById(R.id.agent_outbound_external_calls);
        agent_inbound_outbound_total_calls=(TextView)v.findViewById(R.id.agent_inbound_outbound_total_calls);
        agent_inbound_outbound_call_duration=(TextView)v.findViewById(R.id.agent_inbound_outbound_total_duration);
        agent_transferred_call=(TextView)v.findViewById(R.id.agent_transfered_call);
        agent_voice_mail=(TextView)v.findViewById(R.id.agent_voice_mail);




        agent_id.setText(child.getAgent_id());
        agent_abandoned_calls.setText(child.getAgent_abandoned_calls());
        agent_answers_call.setText(child.getAgent_answers_call());
        agent_inbound_calls.setText(child.getAgent_inbound_calls());
        agent_outbound_total_calls.setText(child.getAgent_outbound_total_calls());
        agent_outbound_total_duration.setText(child.getAgent_outbound_total_duration());
        agent_acd_state.setText(child.getAgent_acd_state());
        agent_acd_state_duration.setText(child.getAgent_acd_state_duration());
        agent_total_call_duration.setText(child.getAgent_total_call_duration());
        agent_outbound_internal_calls.setText(child.getAgent_outbound_internal_calls());
        agent_outbound_external_calls.setText(child.getAgent_outbound_external_calls());
        agent_inbound_outbound_total_calls.setText(child.getAgent_inbound_outbound_total_calls());
        agent_inbound_outbound_call_duration.setText(child.getAgent_inbound_outbound_call_duration());
        agent_transferred_call.setText(child.getAgent_transferred_call());
        agent_voice_mail.setText(child.getAgent_voice_mail());



        agent_id.setTextColor(Color.rgb(0,8,115));
        agent_abandoned_calls.setTextColor(Color.rgb(0,8,115));
        agent_answers_call.setTextColor(Color.rgb(0,8,115));
        agent_inbound_calls.setTextColor(Color.rgb(0,8,115));
        agent_outbound_total_calls.setTextColor(Color.rgb(0,8,115));
        agent_outbound_total_duration.setTextColor(Color.rgb(0,8,115));
        agent_acd_state.setTextColor(Color.rgb(0,8,115));
        agent_acd_state_duration.setTextColor(Color.rgb(0,8,115));
        agent_total_call_duration.setTextColor(Color.rgb(0,8,115));
        agent_outbound_internal_calls.setTextColor(Color.rgb(0,8,115));
        agent_outbound_external_calls.setTextColor(Color.rgb(0,8,115));
        agent_inbound_outbound_total_calls.setTextColor(Color.rgb(0,8,115));
        agent_inbound_outbound_call_duration.setTextColor(Color.rgb(0,8,115));
        agent_transferred_call.setTextColor(Color.rgb(0,8,115));
        agent_voice_mail.setTextColor(Color.rgb(0,8,115));

        return v;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return Agentgroups.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return Agentgroups.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        AgentGroup group=(AgentGroup)getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.agent_list_group, null);
        }

        TextView agent_name = (TextView) convertView
                .findViewById(R.id.agent_name);
        ImageView agent_dnd_status = (ImageView) convertView
                .findViewById(R.id.agent_dndstatus);
        agent_name.setTypeface(null, Typeface.BOLD);
        agent_name.setText(String.valueOf(group.getAgent_name()));

        if (String.valueOf(group.getAgent_dnd_status()).equals("OFF"))
        {agent_dnd_status.setImageResource(R.drawable.onlinenew);}
        else
        {
            agent_dnd_status.setImageResource(R.drawable.offlinenew);
        }
        Animation shake;
        shake = AnimationUtils.loadAnimation(_context, R.xml.blink);
        if (group.getAgentChild().getAgent_acd_state().equals("Alerting"))
        {
        agent_name.startAnimation(shake);
        }


        agent_name.setTextColor(Color.rgb(90, 87, 163));


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
