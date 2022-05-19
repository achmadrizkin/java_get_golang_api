package com.example.java_get_api_golang.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.java_get_api_golang.model.RecyclerData;
import com.example.java_get_api_golang.network.RetroServiceInterface;
import com.example.java_get_api_golang.repository.RetroRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainActivityViewModel extends ViewModel {
    MutableLiveData<List<RecyclerData>> liveData;

    @Inject
    RetroServiceInterface retroServiceInterface;

    @Inject
    public MainActivityViewModel() {
        liveData = new MutableLiveData();
    }

    public MutableLiveData<List<RecyclerData>> getLiveDataObservable() {
        return liveData;
    }

    public void makeApiCall() {
        RetroRepository retroRepository = new RetroRepository(retroServiceInterface);
        retroRepository.makeAPICall(liveData);
    }
}
