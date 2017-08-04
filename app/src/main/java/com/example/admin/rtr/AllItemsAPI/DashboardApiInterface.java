package com.example.admin.rtr.AllItemsAPI;

import com.example.admin.rtr.ModelDashboard.DesktopWallboardResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Admin on 03-05-2017.
 */

public interface DashboardApiInterface
{
    @GET("desktop_wallboard/?fields=overflowed,in_abnd,available_agents,unavailable_agents,busy_agents,wait_now,wrap_up,sign_in,avg_ans,tot_tlk,avg_tlk,avg_abnd,out,out_ans,max_wait,avg_wait,svc,in,in_ans&format=json&report_id=desktop_wallboard&service_level=0&user_timezone=America%2FToronto")
    Call<DesktopWallboardResponse> getDesktopWallboard(@Query("end_time") String endTime,
                                                       @Query("start_time") String startTime);



}
