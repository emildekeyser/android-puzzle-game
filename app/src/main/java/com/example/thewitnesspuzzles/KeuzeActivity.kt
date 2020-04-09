package com.example.thewitnesspuzzles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_keuze.*

class KeuzeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keuze)

        level1.setOnClickListener { println("level1") }
        level2.setOnClickListener { println("level2") }
        level3.setOnClickListener { println("level3") }
    }
}
