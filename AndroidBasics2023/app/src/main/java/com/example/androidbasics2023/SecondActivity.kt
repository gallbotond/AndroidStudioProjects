package com.example.androidbasics2023

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import com.example.androidbasics2023.ui.theme.AndroidBasics2023Theme

class SecondActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.getStringExtra("key")
        setContent {
            AndroidBasics2023Theme {
                Text(text = "Hello")
            }
        }
    }
}