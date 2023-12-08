package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<DataModel> dataModelArrayList;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        dataModelArrayList = new ArrayList<>();
        dataModelArrayList.add(new DataModel("Android", R.drawable.boss));
        dataModelArrayList.add(new DataModel("IOs", R.drawable.fat));
        dataModelArrayList.add(new DataModel("Andfdafroid", R.drawable.fat));
        dataModelArrayList.add(new DataModel("Andrfffffoid", R.drawable.fb));
        dataModelArrayList.add(new DataModel("Androdddddid", R.drawable.gas));
        dataModelArrayList.add(new DataModel("Andrssssssssoid", R.drawable.gigachad));

        myAdapter = new MyAdapter(this, dataModelArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);
    }
}