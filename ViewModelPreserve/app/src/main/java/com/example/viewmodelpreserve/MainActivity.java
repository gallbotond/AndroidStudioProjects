package com.example.viewmodelpreserve;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.number);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        LiveData<Integer> counterLiveData = viewModel.getCounter();
        counterLiveData.observe(this, integer -> {
            textView.setText(String.valueOf(integer));
        });

        button.setOnClickListener(v -> {
            viewModel.incrementCounter();
        });
    }
}