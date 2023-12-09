package com.example.sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editTextText);
        button = findViewById(R.id.button);

        DisplaySavedText();

        button.setOnClickListener(v -> {
            String text = editText.getText().toString();
            DisplayAndSaveText(text);
        });
    }

    private void DisplaySavedText() {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String text = sharedPreferences.getString("text", "");
        textView.setText(text);
    }

    private void DisplayAndSaveText(String text) {
        textView.setText(text);
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("text", text);
        editor.commit();
    }
}