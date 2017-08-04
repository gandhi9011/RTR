package com.example.admin.rtr.Unreturn_Calls;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ListView;

import com.example.admin.rtr.APIData.ApiHelperUnreturnCalls;
import com.example.admin.rtr.Adapter.UnreturnCallsViewAdapter;
import com.example.admin.rtr.AllItemsAPI.UnreturnCallsApiInterface;
import com.example.admin.rtr.DateTimeDuration.Datetimeconversion;
import com.example.admin.rtr.General.ErrorFragment;
import com.example.admin.rtr.ModelUnreturnCall.UnreturnCallResponse;
import com.example.admin.rtr.R;
import com.example.admin.rtr.activity.MainActivity;

import java.text.ParseException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultsFragments extends Fragment {
    private ViewStub stubGrid;
    private ListView listView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private UnreturnCallsViewAdapter unreturnCallsViewAdapter;
    private Runnable Timer_Tick = new Runnable() {
        public void run() {
            fetchData();
        }
    };

    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b) {
        return li.inflate(R.layout.fragment_unreturn_calls_results, vg, false);
    }

    public void onViewCreated(View v, Bundle bundle) {
        ((MainActivity)getActivity()).setActionBarTitle("Unreturn Calls");
        stubGrid = (ViewStub) v.findViewById(R.id.stub_grid);
        stubGrid.inflate();
        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh_layout_unreturn_call);
        listView = (ListView) v.findViewById(R.id.mylistview_unreturn);
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
        UnreturnCallsApiInterface apiService = ApiHelperUnreturnCalls.get();

//        try {
//            Log.e("12345678+", "" + StartTimeStamp() + "........" + EndTimeStamp());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Call<UnreturnCallResponse> call = null;
        try {
            call = apiService.getUnreturnCalls(String.valueOf(new Datetimeconversion().EndTimeStamp()), String.valueOf(new Datetimeconversion().StartTimeStamp()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        call.enqueue(new Callback<UnreturnCallResponse>() {
            @Override
            public void onResponse(Call<UnreturnCallResponse> call, Response<UnreturnCallResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.e(TAG, response.body().toString() + "jsonmodel");
                    UnreturnCallResponse UnreturnCallResponse = response.body(); //JSON DATA
                    List<com.example.admin.rtr.ModelUnreturnCall.Object> objects = UnreturnCallResponse.getObjects();
                    if (objects.isEmpty())
                    {
                        android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                        transaction.replace(R.id.frame, new ErrorFragment(), "ResultsFragmentCallbyHalfnHour");
                        transaction.commit();
                    }
                    if (getActivity() != null) {
                        unreturnCallsViewAdapter = new UnreturnCallsViewAdapter(getActivity(), R.layout.list_item_historic_call, objects);
                        listView.invalidateViews();
                        listView.setAdapter(unreturnCallsViewAdapter);
                    }

                }
            }

            @Override
            public void onFailure(Call<UnreturnCallResponse> call, Throwable t) {
                Log.e(TAG, "Callback Failed. No Response.");
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_content, new ErrorFragment(), "ResultsFragmentError");
                transaction.commit();
            }
        });
    }
}
