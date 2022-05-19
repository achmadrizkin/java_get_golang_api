package com.example.java_get_api_golang.network;

import com.example.java_get_api_golang.model.RecyclerList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface RetroServiceInterface {
    @GET("products")
    Call<RecyclerList> getDataFromApi();
}
