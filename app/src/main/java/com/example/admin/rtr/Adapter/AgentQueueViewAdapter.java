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

import com.example.admin.rtr.APIData.ApiHelperAgentList;
import com.example.admin.rtr.AllItemsAPI.AgentListApiInterface;
import com.example.admin.rtr.DateTimeDuration.Datetimeconversion;
import com.example.admin.rtr.ModelAgentList.AgentNameresponse;
import com.example.admin.rtr.ModelAgentList.Object;
import com.example.admin.rtr.R;

import java.text.ParseException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.google.android.gms.plus.PlusOneDummyView.TAG;

/**
 * Created by Admin on 08-06-2017.
 */

public class AgentQueueViewAdapter extends ArrayAdapter<com.example.admin.rtr.ModelAgentQueue.Agent>
{

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
            agent_dnd_status,
                    agent_id,
                    agent_name;
    int j = 0;
    private int[] colors = {Color.rgb(0,8,115),Color.rgb(0,141,28),Color.rgb(219,153,22),Color.rgb(135,13,179)};

    public AgentQueueViewAdapter(Context context, int resource, List<com.example.admin.rtr.ModelAgentQueue.Agent> agents) {
        super(context, resource, agents);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (null == v) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item_agent_queue, null);
        }
        com.example.admin.rtr.ModelAgentQueue.Agent agent = getItem(position);

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
                agent_dnd_status=(TextView)v.findViewById(R.id.agent_dnd_status);
                agent_id=(TextView)v.findViewById(R.id.agent_id);
                agent_name=(TextView)v.findViewById(R.id.agent_name);



        if (j == 4) {
            j = 0;

        }
                agent_abandoned_calls.setText(String.valueOf(agent.getInAbnd()));
                agent_answers_call.setText(String.valueOf(agent.getInAns()));
                agent_inbound_calls.setText(String.valueOf(agent.getIn()));
                agent_outbound_total_calls.setText(String.valueOf(agent.getOut()));
                agent_outbound_total_duration.setText(new Datetimeconversion().getDurationString(Long.valueOf(agent.getOutTotTlk())));
                agent_acd_state.setText(agent.getStatus());
                agent_acd_state_duration.setText(new Datetimeconversion().getDate(agent.getStatusTimestamp()));
                agent_total_call_duration.setText(new Datetimeconversion().getDurationString(agent.getTotTlk()));
                agent_outbound_internal_calls.setText(String.valueOf(agent.getOutInt()));
                agent_outbound_external_calls.setText(String.valueOf(agent.getOutExt()));
                agent_inbound_outbound_total_calls.setText(String.valueOf(agent.getInOut()));
                agent_inbound_outbound_call_duration.setText(new Datetimeconversion().getDurationString(agent.getInOutTotTlk()));
                agent_transferred_call.setText(String.valueOf(agent.getTransferred()));
                agent_voice_mail.setText(String.valueOf(agent.getVmRedirects()));
                agent_dnd_status.setText(agent.getDndStatus());
                agent_id.setText(agent.getId());
        AgentListApiInterface apiService = ApiHelperAgentList.get();



        Call<AgentNameresponse> call = null;
        try {
            call = apiService.getAgentList(agent.getId(),String.valueOf(new Datetimeconversion().EndTimeStamp()), String.valueOf(new Datetimeconversion().StartTimeStamp()));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        call.enqueue(new Callback<AgentNameresponse>() {
            @Override
            public void onResponse(Call<AgentNameresponse> call, Response<AgentNameresponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.e(TAG,response.body().toString()+"jsonmodel");
                    AgentNameresponse Agentnamerespone = response.body(); //JSON DATA
                    List<Object> objects=Agentnamerespone.getObjects();
                    agent_name.setText(objects.get(0).getName().toString());

                }
            }

            @Override
            public void onFailure(Call<AgentNameresponse> call, Throwable t) {
                Log.e(TAG,"Callback Failed. No Response."+t.getMessage());t.printStackTrace();
            }
        });





                agent_abandoned_calls.setTextColor(colors[j]);
                agent_answers_call.setTextColor(colors[j]);
                agent_inbound_calls.setTextColor(colors[j]);
                agent_outbound_total_calls.setTextColor(colors[j]);
                agent_outbound_total_duration.setTextColor(colors[j]);
                agent_acd_state.setTextColor(colors[j]);
                agent_acd_state_duration.setTextColor(colors[j]);
                agent_total_call_duration.setTextColor(colors[j]);
                agent_outbound_internal_calls.setTextColor(colors[j]);
                agent_outbound_external_calls.setTextColor(colors[j]);
                agent_inbound_outbound_total_calls.setTextColor(colors[j]);
                agent_inbound_outbound_call_duration.setTextColor(colors[j]);
                agent_transferred_call.setTextColor(colors[j]);
                agent_voice_mail.setTextColor(colors[j]);
                agent_dnd_status.setTextColor(colors[j]);
                agent_id.setTextColor(colors[j]);
                agent_name.setTextColor(Color.RED);
        j++;


        return v;
    }






}
