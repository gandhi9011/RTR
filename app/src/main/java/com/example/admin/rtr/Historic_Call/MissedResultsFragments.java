package com.example.admin.rtr.Historic_Call;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ListView;

import com.example.admin.rtr.APIData.ApiHelperHistoricCall;
import com.example.admin.rtr.Adapter.HistoricListViewAdapter;
import com.example.admin.rtr.AllItemsAPI.HistoriccallApiInterface;
import com.example.admin.rtr.DateTimeDuration.Datetimeconversion;
import com.example.admin.rtr.ModelHistoricCall.HistoricCallResponse;
import com.example.admin.rtr.ModelHistoricCall.Object;
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
 * Created by Admin on 19-07-2017.
 */

public class MissedResultsFragments  extends Fragment
{
    private ViewStub stubGrid;
    private ListView listView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private HistoricListViewAdapter historicListViewAdapter;

    private Runnable Timer_Tick = new Runnable() {
        public void run() {
            fetchData();
        }
    };

    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b) {

        return li.inflate(R.layout.fragment_historic_call_results, vg, false);
    }

    public void onViewCreated(View v, Bundle bundle) {

        stubGrid = (ViewStub) v.findViewById(R.id.stub_grid);
        stubGrid.inflate();
        //imageView=(ImageView)v.findViewById(R.id.filterview);
        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh_layout_historic_call);

        listView = (ListView) v.findViewById(R.id.mylistview_historic);
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
        }, 0, 60000);
    }


    private void TimerMethod() {


        if (getActivity() != null) {

            getActivity().runOnUiThread(Timer_Tick);
        }

    }

    private void fetchData() {
        HistoriccallApiInterface apiService = ApiHelperHistoricCall.get();


        Call<HistoricCallResponse> call = null;
        try {
            call = apiService.gethistoriccallresponse(String.valueOf(new Datetimeconversion().EndTimeStamp()), String.valueOf(new Datetimeconversion().StartTimeStamp()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        call.enqueue(new Callback<HistoricCallResponse>() {
            @Override
            public void onResponse(Call<HistoricCallResponse> call, Response<HistoricCallResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.e(TAG, response.body().toString() + "jsonmodel");
                    HistoricCallResponse HistoricCallResponse = response.body(); //JSON DATA
                    List<Object> objects = HistoricCallResponse.getObjects();
                    List<Object> objects1=new ArrayList<Object>();
                    for(Object obj:objects )
                    {
                        if (obj.getType().equals("INT-IN-ABAN") || obj.getType().equals("IN-ABAN") )
                        {
                            objects1.add(obj);
                        }
                    }
                    if (getActivity() != null) {
                        historicListViewAdapter = new HistoricListViewAdapter(getActivity(), R.layout.list_item_historic_call, objects1);
                        listView.invalidateViews();
                        listView.setAdapter(historicListViewAdapter);
                    }

                }
            }

            @Override
            public void onFailure(Call<HistoricCallResponse> call, Throwable t) {
                Log.e(TAG, "Callback Failed. No Response.");
            }
        });
    }
}

