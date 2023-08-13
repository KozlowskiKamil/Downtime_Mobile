package com.downtime.mobile.reotrfit;

import com.downtime.mobile.model.Breakedown;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BreakdownApi {

    @GET("/findall")
    Call<List<Breakedown>> getAllfailures();

    @PATCH("/breakdown")
    Call<Breakedown> save(@Body Breakedown breakedown);

    @GET("/ended")
    Call<List<Breakedown>> getEnded();

    @GET("/ongoing")
    Call<List<Breakedown>> getOngoing();

    @GET("/samefailure/{computerName}/{failureName}")
    Call<List<Breakedown>> findAllByComputerNameAndFailureName(@Path("computerName") String computerName,
                                                         @Path("failureName")String failureName);


}