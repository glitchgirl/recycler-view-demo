package com.example.recyclerviewdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val pets = listOf(
            Pet("Bella", "Loves belly rubs 🐶"),
            Pet("Max", "Enjoys long walks in the park 🌳"),
            Pet("Luna", "Professional napper 😴"),
            Pet("Charlie", "Fetch champion 🥎"),
            Pet("Daisy", "Snack enthusiast 🦴")
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PetAdapter(pets)
    }
}