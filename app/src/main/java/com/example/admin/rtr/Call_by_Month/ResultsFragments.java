package com.example.admin.rtr.Call_by_Month;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ListView;

import com.example.admin.rtr.APIData.ApiHelperCallbyMonth;
import com.example.admin.rtr.Adapter.CallByMonthViewAdapter;
import com.example.admin.rtr.AllItemsAPI.CallbyMonthApiInterface;
import com.example.admin.rtr.ModelCallbyMonth.CallbyMonthResponse;
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
 * Created by Admin on 22-06-2017.
 */

public class ResultsFragments extends Fragment {
    private ViewStub stubGrid;
    private ListView listView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private CallByMonthViewAdapter CallbyMonthViewAdapter;
    private Runnable Timer_Tick = new Runnable() {
        public void run() {
            fetchData();
        }
    };

    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b) {
        return li.inflate(R.layout.fragment_call_by_halfnhour_resuilts, vg, false);
    }

    public void onViewCreated(View v, Bundle bundle) {
        ((MainActivity)getActivity()).setActionBarTitle("Calls By Month");
        stubGrid = (ViewStub) v.findViewById(R.id.stub_grid);
        stubGrid.inflate();
        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh_layout_call_by_half_n_hour);
        listView = (ListView) v.findViewById(R.id.mylistview_call_by_halfnhour);
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
        CallbyMonthApiInterface apiService = ApiHelperCallbyMonth.get();
        Call<CallbyMonthResponse> call = null;
        call = apiService.getCallbyMonthResponse();
        final ProgressDialog mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();
        call.enqueue(new Callback<CallbyMonthResponse>() {
            @Override
            public void onResponse(Call<CallbyMonthResponse> call, Response<CallbyMonthResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.e(TAG, response.body().toString() + "jsonmodel");
                    CallbyMonthResponse CallbyMonthResponse = response.body(); //JSON DATA
                    List<com.example.admin.rtr.ModelCallbyMonth.Object> objects = CallbyMonthResponse.getObjects();
                    if (getActivity() != null) {
                        CallbyMonthViewAdapter = new CallByMonthViewAdapter(getActivity(), R.layout.list_item_call_by_month, objects);
                        listView.invalidateViews();
                        listView.setAdapter(CallbyMonthViewAdapter);
                    }

                }
                mProgressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<CallbyMonthResponse> call, Throwable t) {
                Log.e(TAG, "Callback Failed. No Response.");
                mProgressDialog.dismiss();
            }
        });
    }
}
