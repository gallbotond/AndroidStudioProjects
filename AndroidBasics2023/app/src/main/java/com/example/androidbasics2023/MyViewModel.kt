package com.example.androidbasics2023

import android.content.Context
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    var context: Context? = null // not advisable to store context outside of activity


}