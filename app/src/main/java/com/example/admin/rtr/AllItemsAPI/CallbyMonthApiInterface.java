package com.example.admin.rtr.AllItemsAPI;

import com.example.admin.rtr.ModelCallbyMonth.CallbyMonthResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Admin on 22-06-2017.
 */

public interface CallbyMonthApiInterface
{

    @GET("period_stats/?fields=in_calls,in_ans,avg_ans,tot_tlk,avg_tlk,in_abnd,avg_abnd,out,out_ans,max_wait,avg_wait,svc,vm_redirects,avg_wrp_up&format=json&periods=month&service_level=60&user_timezone=UTC")
    Call<CallbyMonthResponse> getCallbyMonthResponse();
}
