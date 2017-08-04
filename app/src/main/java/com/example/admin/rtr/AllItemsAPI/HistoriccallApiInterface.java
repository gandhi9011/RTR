package com.example.admin.rtr.AllItemsAPI;

import com.example.admin.rtr.ModelHistoricCall.HistoricCallResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Admin on 05-06-2017.
 */

public interface HistoriccallApiInterface
{
    @GET("call_history/?fields=device,date,Type,From,to,seg,forwarded_from,duration,service_time&format=json&report_id=call_history&service_level=60&type_of_calls=all1,all2&user_timezone=UTC")
    Call<HistoricCallResponse> gethistoriccallresponse(@Query("end_time") String endTime,
                                                   @Query("start_time") String startTime);

}
