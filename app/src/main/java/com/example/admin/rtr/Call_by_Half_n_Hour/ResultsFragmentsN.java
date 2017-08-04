package com.example.admin.rtr.Call_by_Half_n_Hour;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ExpandableListView;

import com.example.admin.rtr.APIData.ApiHelperCallbyHalfnhour;
import com.example.admin.rtr.AllItemsAPI.CallbyHalfnhourApiInterface;
import com.example.admin.rtr.ModelCallbyHalfnHour.CallbyHalfnhourResponse;
import com.example.admin.rtr.R;
import com.example.admin.rtr.activity.MainActivity;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by Admin on 20-07-2017.
 */

public class ResultsFragmentsN extends Fragment
{

    private ViewStub stubGrid;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ExpandableListView extlistView;



    private Runnable Timer_Tick = new Runnable() {
        public void run() {
            fetchData();
        }
    };

    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b) {
        return li.inflate(R.layout.fragment_call_by_halfnhour_resuilts, vg, false);
    }

    public void onViewCreated(View v, Bundle bundle) {
        ((MainActivity)getActivity()).setActionBarTitle("Agent/Queue");
        stubGrid = (ViewStub) v.findViewById(R.id.stub_grid);
        stubGrid.inflate();
        extlistView = (ExpandableListView) v.findViewById(R.id.extlistview1);
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
        CallbyHalfnhourApiInterface apiService = ApiHelperCallbyHalfnhour.get();
        Call<CallbyHalfnhourResponse> call = null;
        call = apiService.getCallbyHalfnhourResponse();

        call.enqueue(new Callback<CallbyHalfnhourResponse>() {
            @Override
            public void onResponse(Call<CallbyHalfnhourResponse> call, Response<CallbyHalfnhourResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.e(TAG, response.body().toString() + "jsonmodel");
                    CallbyHalfnhourResponse CallbyHalfnhourResponse = response.body(); //JSON DATA
                    List<com.example.admin.rtr.ModelCallbyHalfnHour.Object> objects = CallbyHalfnhourResponse.getObjects();
                    if (getActivity() != null) {
                        //callbyhalfnhourViewAdapter = new CallByHalfnhourViewAdapter(getActivity(), R.layout.list_item_call_by_halfnhour, objects);
                        //listView.invalidateViews();
                        //listView.setAdapter(callbyhalfnhourViewAdapter);
                    }

                }
            }

            @Override
            public void onFailure(Call<CallbyHalfnhourResponse> call, Throwable t) {
                Log.e(TAG, "Callback Failed. No Response.");
                t.printStackTrace();
            }
        });
    }
}
