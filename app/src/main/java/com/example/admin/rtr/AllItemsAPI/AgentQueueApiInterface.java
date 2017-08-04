package com.example.admin.rtr.AllItemsAPI;

import com.example.admin.rtr.ModelAgentQueue.AgentQueueResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Admin on 08-06-2017.
 */

public interface AgentQueueApiInterface
{
    @GET("agent_queue/?calltype=all&fields=callcenter,agent&format=json&report_id=agent_queue&user_timezone=UTC")
    Call<AgentQueueResponse> getAgentQueueResponse(@Query("end_time") String endTime,
                                                       @Query("start_time") String startTime);
}