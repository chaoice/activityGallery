package com.example.chaoice3240.firstactivity.netservice;

import com.example.chaoice3240.firstactivity.netservice.dto.PerDetailsRes;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Admin on 2018/3/18.
 */

public interface netinterface {
    @POST("icore")
    Observable<PerDetailsRes> getUser(@Body RequestBody postdata);
}
