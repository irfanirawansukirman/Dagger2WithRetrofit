package com.iriras.androiddagger2withretrofit.api.service;

import com.iriras.androiddagger2withretrofit.api.dao.Province;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by irfan on 02/04/17.
 */

public interface Service {
    @GET("api/ayodonor?view=list_propinsi")
    Observable<Province> getPosts();
}
