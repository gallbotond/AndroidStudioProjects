package com.example.planetlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Planet> planetsArrayList;
    private static MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        planetsArrayList = new ArrayList<>();
        planetsArrayList.add(new Planet("Mercury", 0, R.drawable.im1));
        planetsArrayList.add(new Planet("Venus", 0, R.drawable.im2));
        planetsArrayList.add(new Planet("Earth", 1, R.drawable.im3));
        planetsArrayList.add(new Planet("Mars", 2, R.drawable.im4));
        planetsArrayList.add(new Planet("Jupiter", 79, R.drawable.im1));
        planetsArrayList.add(new Planet("Saturn", 82, R.drawable.im2));
        planetsArrayList.add(new Planet("Uranus", 27, R.drawable.boss));
        planetsArrayList.add(new Planet("Neptune", 14, R.drawable.gas));
        planetsArrayList.add(new Planet("Pluto", 5, R.drawable.im4));

        adapter = new MyAdapter(planetsArrayList, this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                        MainActivity.this,
                        "You clicked: " + planetsArrayList.get(position).getPlanetName(),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}