package com.example.thewitnesspuzzles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val puzzle_links = arrayOf("Emil", "Thomas", "Florian", "Johan", "Jaron")
        val listView: ListView = findViewById(R.id.main_menu)
        listView.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, puzzle_links)

    }
}
