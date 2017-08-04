package com.example.admin.rtr.AllItemsAPI;

import com.example.admin.rtr.ModelAgentList.AgentNameresponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Admin on 31-05-2017.
 */

public interface AgentListApiInterface
{
    @GET("{id}/extension_list/?format=json&periods=hh&report_id=extension_list&&user_timezone=America%2FToronto")
    Call<AgentNameresponse> getAgentList(@Path("id") String id, @Query("end_time") String endTime,
                                         @Query("start_time") String startTime
                                         );

}
