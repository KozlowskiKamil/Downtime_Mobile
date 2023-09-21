package com.downtime.mobile.reotrfit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private Retrofit retrofit;

    public static final String IP_ADDRESS = "http://kozlowski.alwaysdata.net"; // TODO: 03.08.2023 Konfiguracja IP
//    public static final String IP_ADDRESS = "http://192.168.43.171:8080"; // TODO: 03.08.2023 Konfiguracja IP
//    public static final String IP_ADDRESS = "http://192.168.157.7:8080"; // TODO: 03.08.2023 Konfiguracja IP
//    public static final String IP_ADDRESS = "http://192.168.0.240:8080"; // TODO: 03.08.2023 Konfiguracja IP

    public RetrofitService() {
        initializeRetrofit();
    }

    private void initializeRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(IP_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
