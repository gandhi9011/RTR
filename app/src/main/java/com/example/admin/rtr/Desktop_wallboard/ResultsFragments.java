package com.example.admin.rtr.Desktop_wallboard;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.GridView;

import com.example.admin.rtr.APIData.ApiHelperDashboard;
import com.example.admin.rtr.Adapter.WallboardGridViewAdapter;
import com.example.admin.rtr.AllItemsAPI.DashboardApiInterface;
import com.example.admin.rtr.DateTimeDuration.Datetimeconversion;
import com.example.admin.rtr.ModelDashboard.DesktopWallboardResponse;
import com.example.admin.rtr.ModelDashboard.Object;
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

public class ResultsFragments extends Fragment
{
    private ViewStub stubGrid;
    private SwipeRefreshLayout swipeRefreshLayout;
    private GridView gridView;
    private WallboardGridViewAdapter wallboardGridViewAdapter;
    private Runnable Timer_Tick = new Runnable() {

        public void run() {

            fetchData();


        }
    };

    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b) {
        return li.inflate(R.layout.fragment_wallboard_results, vg, false);
    }

    public void onViewCreated(View v, Bundle bundle) {
        ((MainActivity)getActivity()).setActionBarTitle("Wallboard");
        stubGrid = (ViewStub) v.findViewById(R.id.stub_grid);
        stubGrid.inflate();
        gridView = (GridView) v.findViewById(R.id.mygridview);
        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh_layout_desktop_wallboard);
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
        DashboardApiInterface apiService = ApiHelperDashboard.get();


        Call<DesktopWallboardResponse> call = null;
        try {
            call = apiService.getDesktopWallboard(String.valueOf(new Datetimeconversion().EndTimeStamp()), String.valueOf(new Datetimeconversion().StartTimeStamp()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        call.enqueue(new Callback<DesktopWallboardResponse>() {
            @Override
            public void onResponse(Call<DesktopWallboardResponse> call, Response<DesktopWallboardResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.e(TAG, response.body().toString() + "jsonmodel");
                    DesktopWallboardResponse desktopWallboardResponse = response.body(); //JSON DATA
                    List<Object> objects = desktopWallboardResponse.getObjects();
                    if (getActivity() != null) {
                        wallboardGridViewAdapter = new WallboardGridViewAdapter(getActivity(), R.layout.grid_item_dashboard, objects);
                        gridView.setAdapter(wallboardGridViewAdapter);
                    }

                }
            }

            @Override
            public void onFailure(Call<DesktopWallboardResponse> call, Throwable t) {
                Log.e(TAG, "Callback Failed. No Response.");
            }
        });
    }


}
