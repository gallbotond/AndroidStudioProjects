package com.example.android14p1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android14p1.R;

public class LuckyNumberActivity extends AppCompatActivity {

    Button shareButton;
    TextView luckyNumberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        shareButton = findViewById(R.id.btn_share);
        luckyNumberTextView = findViewById(R.id.tv_lucky_number);

        // receive data from MainActivity
        Intent i = getIntent();
        String userName = i.getStringExtra("name");

        luckyNumberTextView.setText(userName + ", your lucky number is: " + (int) (Math.random() * 100));

        shareButton.setOnClickListener(v -> ShareData(userName, luckyNumberTextView.getText().toString()));
    }

    public void ShareData(String username, String luckyNumber) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, username + "got lucky");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "His lucky number is: " + luckyNumber);
        startActivity(Intent.createChooser(shareIntent, "Share via"));
    }
}