package com.example.java_get_api_golang.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.java_get_api_golang.model.RecyclerData;
import com.example.java_get_api_golang.model.RecyclerList;
import com.example.java_get_api_golang.network.RetroServiceInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetroRepository {
    private RetroServiceInterface retroServiceInterface;

    public RetroRepository(RetroServiceInterface retroServiceInterface) {
        this.retroServiceInterface = retroServiceInterface;
    }

    public void makeAPICall(MutableLiveData<List<RecyclerData>> liveData) {
        Call<RecyclerList> call  = retroServiceInterface.getDataFromApi();
        call.enqueue(new Callback<RecyclerList>() {
            @Override
            public void onResponse(Call<RecyclerList> call, Response<RecyclerList> response) {
                if(response.isSuccessful()) {
                    liveData.postValue(response.body().getData());
                } else {
                    liveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<RecyclerList> call, Throwable t) {
                liveData.postValue(null);
            }
        });
    }
}
