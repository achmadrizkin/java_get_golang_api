package com.example.java_get_api_golang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.example.java_get_api_golang.adapter.RecyclerViewAdapter;
import com.example.java_get_api_golang.model.RecyclerData;
import com.example.java_get_api_golang.viewmodel.MainActivityViewModel;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private RecyclerViewAdapter recyclerViewAdapter;
    EditText inputBookName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputBookName = findViewById(R.id.inputBookName);

        initRecyclerView();
        makeApiCall();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void makeApiCall() {
        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.getLiveDataObservable().observe(this, new Observer<List<RecyclerData>>() {
            @Override
            public void onChanged(List<RecyclerData> recyclerData) {
                if (recyclerData != null) {
                    recyclerViewAdapter.setListDataItems(recyclerData);
                    recyclerViewAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Error in getting data", Toast.LENGTH_LONG).show();
                }
            }
        });
        viewModel.makeApiCall();
    }


}