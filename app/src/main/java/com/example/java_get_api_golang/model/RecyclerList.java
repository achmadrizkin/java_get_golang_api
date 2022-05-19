package com.example.java_get_api_golang.model;

import java.util.List;

public class RecyclerList {
    private List<RecyclerData> data;

    public RecyclerList(List<RecyclerData> data) {
        this.data = data;
    }

    public List<RecyclerData> getData() {
        return data;
    }

    public void setData(List<RecyclerData> data) {
        this.data = data;
    }
}