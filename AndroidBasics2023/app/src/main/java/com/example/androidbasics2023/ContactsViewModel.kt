package com.example.androidbasics2023

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class ContactsViewModel(
    hello : String
): ViewModel() {

    var backgroundColor by mutableStateOf(Color.White)
    private set
    fun changeBackgroundColor() {
        println("changeBackgroundColor")
        backgroundColor = Color.Red
    }
}