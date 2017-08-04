package com.example.admin.rtr.APIData;

import com.example.admin.rtr.AllItemsAPI.DashboardApiInterface;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Admin on 03-05-2017.
 */

public class ApiHelperDashboard
{
    private static final String API_URL = "http://data.myossbss.com/api/v1/devices/BCTCARollover/";
    //http://data.myossbss.com/api/v1/devices/rtrtestqueue,BCTCARollover/
    private static DashboardApiInterface REST_CLIENT;
    static
    {
        setupRestClient();
    }

    private ApiHelperDashboard() {
    }

    public static DashboardApiInterface get() {
        return REST_CLIENT;
    }



    private static void setupRestClient() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        //Uncomment these lines below to start logging each request.

        /*
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);
        */

        final String authToken = Credentials.basic(ApiAppUtils.USERNAME, ApiAppUtils.PASSWORD);
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .header("Authorization", authToken)
                        .build();
                return chain.proceed(request);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();




        REST_CLIENT = retrofit.create(DashboardApiInterface.class);


    }
}
