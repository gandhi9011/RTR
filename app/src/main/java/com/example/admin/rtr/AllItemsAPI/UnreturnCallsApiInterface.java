package com.example.admin.rtr.AllItemsAPI;

/**
 * Created by Admin on 09-06-2017.
 */
import com.example.admin.rtr.ModelUnreturnCall.UnreturnCallResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UnreturnCallsApiInterface
{
    @GET("lost_calls/?fields=extension,call_return,extId,returned_by&format=json&report_id=lost_calls&user_timezone=America%2FToronto")
    Call<UnreturnCallResponse> getUnreturnCalls(@Query("end_time") String endTime,
                                                   @Query("start_time") String startTime);
}
