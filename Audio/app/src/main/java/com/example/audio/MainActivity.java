package com.example.audio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button, button2, button3, button4, button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int clickedButtonId = v.getId();

        if (clickedButtonId == R.id.button) {
            PlaySounds(R.raw.kill);
        } else if (clickedButtonId == R.id.button2) {
            PlaySounds(R.raw.meet);
        } else if (clickedButtonId == R.id.button3) {
            PlaySounds(R.raw.report);
        } else if (clickedButtonId == R.id.button4) {
            PlaySounds(R.raw.reveal);
        } else if (clickedButtonId == R.id.button5) {
            PlaySounds(R.raw.troll);
    }

}

    public void PlaySounds(int id) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, id);
        mediaPlayer.start();
    }
}