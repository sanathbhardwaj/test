package com.example.recycler_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements adapter.DataTransferInterface {

    RecyclerView recycler;
    TextView print;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recycler);

        recycler = findViewById(R.id.recycler);
        print = findViewById(R.id.print);


        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(testingLayoutManager);
        final adapter adapter = new adapter(this);
        recycler.setAdapter(adapter);
    }

    @Override
    public void setValues(String count) {
        print.setText(count);
    }
}