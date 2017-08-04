package com.example.admin.rtr.Agent_Queue;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ExpandableListView;

import com.example.admin.rtr.APIData.ApiHelperAgentQueue;
import com.example.admin.rtr.Adapter.AgentExpandableListAdapter;
import com.example.admin.rtr.AllItemsAPI.AgentQueueApiInterface;
import com.example.admin.rtr.DateTimeDuration.Datetimeconversion;
import com.example.admin.rtr.General.ErrorFragment;
import com.example.admin.rtr.ModelAgentQueue.Agent;
import com.example.admin.rtr.ModelAgentQueue.AgentChild;
import com.example.admin.rtr.ModelAgentQueue.AgentGroup;
import com.example.admin.rtr.ModelAgentQueue.AgentQueueResponse;
import com.example.admin.rtr.ModelAgentQueue.Object;
import com.example.admin.rtr.R;
import com.example.admin.rtr.activity.MainActivity;

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

public class ResultsFragmentsN extends Fragment {

    private ViewStub stubGrid;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ExpandableListView extlistView;


    private Runnable Timer_Tick = new Runnable() {
        public void run() {
            fetchData();
        }
    };

    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b) {
        return li.inflate(R.layout.fragment_agent_queue_new_results, vg, false);
    }

    public void onViewCreated(View v, Bundle bundle) {
        ((MainActivity)getActivity()).setActionBarTitle("Agent/Queue");
        stubGrid = (ViewStub) v.findViewById(R.id.stub_grid);
        stubGrid.inflate();
        extlistView = (ExpandableListView) v.findViewById(R.id.extlistview);
        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh_layout_agent_queue);
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



                    ArrayList<AgentGroup> agentGroups = new ArrayList<AgentGroup>();
                    for (Agent agent : agents) {


                        AgentChild agentChild = new AgentChild(String.valueOf(agent.getInAbnd()),
                                String.valueOf(agent.getInAns()),
                                String.valueOf(agent.getIn()),
                                String.valueOf(agent.getOut()),
                                new Datetimeconversion().getDurationString(Long.valueOf(agent.getOutTotTlk())),
                                String.valueOf(agent.getStatus()),
                                new Datetimeconversion().getDate(agent.getStatusTimestamp()),
                                new Datetimeconversion().getDurationString(agent.getTotTlk()),
                                String.valueOf(agent.getOutInt()),
                                String.valueOf(agent.getOutExt()),
                                String.valueOf(agent.getInOut()),
                                new Datetimeconversion().getDurationString(agent.getInOutTotTlk()),
                                String.valueOf(agent.getTransferred()),
                                String.valueOf(agent.getVmRedirects()),String.valueOf(agent.getId()));

                        AgentGroup agentGroup = new AgentGroup(String.valueOf(agent.getName()), String.valueOf(agent.getDndStatus()), agentChild);
                        agentGroups.add(agentGroup);
                    }
                    if (getActivity() != null) {

                        AgentExpandableListAdapter agentExpandableListAdapter = new AgentExpandableListAdapter(getActivity(), agentGroups);
                        extlistView.invalidateViews();
                        extlistView.setAdapter(agentExpandableListAdapter);
                        extlistView.setIndicatorBounds(100, 100);

                    }
                }
                mProgressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<AgentQueueResponse> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e(TAG, "Callback Failed. No Response.");
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_content, new ErrorFragment(), "ResultsFragmentCallbyHalfnHour");
                transaction.commit();
            }
        });

    }


}
