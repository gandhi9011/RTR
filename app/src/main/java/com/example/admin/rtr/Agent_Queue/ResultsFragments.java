package com.example.admin.rtr.Agent_Queue;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.rtr.APIData.ApiHelperAgentQueue;
import com.example.admin.rtr.Adapter.AgentQueueViewAdapter;
import com.example.admin.rtr.AllItemsAPI.AgentQueueApiInterface;
import com.example.admin.rtr.DateTimeDuration.Datetimeconversion;
import com.example.admin.rtr.ModelAgentQueue.Agent;
import com.example.admin.rtr.ModelAgentQueue.AgentQueueResponse;
import com.example.admin.rtr.ModelAgentQueue.Object;
import com.example.admin.rtr.R;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by Admin on 07-06-2017.
 */

public class ResultsFragments extends android.support.v4.app.Fragment {

    private ViewStub stubGrid;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;
    private TextView staffed_ratio;
    private AgentQueueViewAdapter AgentQueueViewAdapter;
    private Runnable Timer_Tick = new Runnable() {
        public void run() {
            fetchData();
        }
    };

    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b) {
        return li.inflate(R.layout.fragment_agent_queue_results, vg, false);
    }

    public void onViewCreated(View v, Bundle bundle) {

        stubGrid = (ViewStub) v.findViewById(R.id.stub_grid);
        stubGrid.inflate();
        listView = (ListView) v.findViewById(R.id.mylistview_agent_queue);
        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh_layout_agent_queue);
        staffed_ratio = (TextView) v.findViewById(R.id.agent_name);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (getActivity() != null) {
                    fetchData();
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        });

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (getActivity() != null) {
                    TimerMethod();
                }
            }
        }, 0, 1200000);

    }


    private void TimerMethod() {
        getActivity().runOnUiThread(Timer_Tick);
    }

    private void fetchData() {
        AgentQueueApiInterface apiService = ApiHelperAgentQueue.get();
        Call<AgentQueueResponse> call = null;
        try {
            call = apiService.getAgentQueueResponse(String.valueOf(new Datetimeconversion().EndTimeStamp()), String.valueOf(new Datetimeconversion().StartTimeStamp()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        final ProgressDialog mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();
        call.enqueue(new Callback<AgentQueueResponse>() {
            @Override
            public void onResponse(Call<AgentQueueResponse> call, Response<AgentQueueResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.e(TAG, response.body().toString() + "jsonmodel");
                    AgentQueueResponse AgentQueueResponse = response.body(); //JSON DATA
                    List<com.example.admin.rtr.ModelAgentQueue.Object> objects = AgentQueueResponse.getObjects();
                    List<Agent> agents = new ArrayList();
                    for (int i = 1; i < objects.size(); i++) {
                        Object ob = objects.get(i);
                        agents.add(ob.getAgent());
                    }
                    Log.e(TAG, agents.toString());
                    if (getActivity() != null)
                    {

                        AgentQueueViewAdapter = new AgentQueueViewAdapter(getActivity(), R.layout.list_item_agent_queue, agents);
                        listView.invalidateViews();
                        listView.setAdapter(AgentQueueViewAdapter);
                    }
                }
                mProgressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<AgentQueueResponse> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e(TAG, "Callback Failed. No Response.");
            }
        });

    }


}
