package com.example.gridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<Shape> shapes;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        shapes = new ArrayList<>();

        shapes.add(new Shape(R.drawable.react, "Circle"));
        shapes.add(new Shape(R.drawable.firebase, "Square"));
        shapes.add(new Shape(R.drawable.spring, "Triangle"));
        shapes.add(new Shape(R.drawable.react, "Circle"));
        shapes.add(new Shape(R.drawable.firebase, "Square"));
        shapes.add(new Shape(R.drawable.spring, "Triangle"));
        shapes.add(new Shape(R.drawable.react, "Circle"));
        shapes.add(new Shape(R.drawable.firebase, "Square"));
        shapes.add(new Shape(R.drawable.spring, "Triangle"));

        customAdapter = new CustomAdapter(shapes, getApplicationContext());
        gridView.setAdapter(customAdapter);
//        gridView.setNumColumns(2);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Intent i = new Intent(getApplicationContext(), Sphere.class);
            startActivity(i);
        });
    }
}