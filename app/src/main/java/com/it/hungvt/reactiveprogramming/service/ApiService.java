package com.it.hungvt.reactiveprogramming.service;

import com.it.hungvt.reactiveprogramming.model.AndroidOS;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Administrator on 11/6/2017.
 */

public interface ApiService {

    @GET("android/jsonos/")
    Observable<List<AndroidOS>> register();

}
