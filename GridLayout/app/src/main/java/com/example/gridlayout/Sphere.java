package com.example.gridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Sphere extends AppCompatActivity {
    TextView title, result;
    EditText number;

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);

        title = findViewById(R.id.title);
        result = findViewById(R.id.result);
        number = findViewById(R.id.number);
        button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            double radius = Double.parseDouble(number.getText().toString());
            double volume = (4.0/3.0) * Math.PI * Math.pow(radius, 3);
            result.setText("Volume of sphere is " + volume);
        });
    }
}