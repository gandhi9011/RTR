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

public class AllResultFragments extends Fragment
{
    private ViewStub stubGrid;
    private ListView listView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private HistoricListViewAdapter historicListViewAdapter;
    private String time_am[] = new String[]{"06 AM","07 AM","08 AM","09 AM","10 AM","11 AM","12 PM","01 PM","02 PM","03 PM","04 PM","05 PM","06 PM","07 PM","08 PM","09 PM","10 PM","11 PM"};




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
                    if (getActivity() != null) {
//                        ArrayList<java.lang.Object> items=new ArrayList<java.lang.Object>();
//                        for (Object obj:objects)
//                        {
//                         for (int i=0;i<time_am.length;i++)
//                         {
//                            if (new Datetimeconversion().getDate(obj.getDate()).equals(time_am[i]))
//                            {
//                                if (i != time_am.length)
//                                {
//                                    items.add(new String(time_am[i] + "TO" + time_am[i + 1]));
//                                } else
//                                {
//                                    items.add(new String(time_am[i] + "TO" + time_am[0]));
//                                }
//
//
//                                items.add(new ListItem(new Datetimeconversion().getDate(obj.getDate()), new Datetimeconversion().getDurationString(obj.getDuration()), String.valueOf(obj.getFrom()), String.valueOf(obj.getTo())));
//                            }
//                            }
//                         }
                            historicListViewAdapter = new HistoricListViewAdapter(getActivity(), R.layout.list_item_historic_call, objects);
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
