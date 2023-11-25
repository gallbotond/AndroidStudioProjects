package com.example.androidfundamentals

import java.io.Serializable

data class Person(
    val name: String,
    val age: Int
) : Serializable
