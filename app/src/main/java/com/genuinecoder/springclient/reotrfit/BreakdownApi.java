package com.genuinecoder.springclient.reotrfit;

import com.genuinecoder.springclient.model.Breakedown;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BreakdownApi {

    @GET("/findall")
    Call<List<Breakedown>> getAllEmployees();

    @POST("/breakdown")
    Call<Breakedown> save(@Body Breakedown breakedown);
}