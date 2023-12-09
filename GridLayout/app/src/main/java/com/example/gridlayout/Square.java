package com.example.gridlayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Square extends AppCompatActivity {
    TextView title, result;
    EditText number, number2;

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);

        title = findViewById(R.id.title);
        result = findViewById(R.id.result);
        number = findViewById(R.id.number);
        number2 = findViewById(R.id.number2);
        button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            double a = Double.parseDouble(number.getText().toString());
            double b = Double.parseDouble(number2.getText().toString());
            double volume = a * b;
            result.setText("Volume of square is " + volume);
        });
    }
}