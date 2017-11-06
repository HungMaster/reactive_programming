package com.it.hungvt.reactiveprogramming.service;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 11/6/2017.
 */

public class ApiServiceBuilder {
    public static final String BASE_URL = "https://api.learn2crack.com/";

    private static ApiServiceBuilder instance;
    private ApiService apiService;

    public static ApiService getApiService(){

        if (instance==null){
        instance = new ApiServiceBuilder();
        }
        return instance.apiService;
    }

    private ApiServiceBuilder() {
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }


}
