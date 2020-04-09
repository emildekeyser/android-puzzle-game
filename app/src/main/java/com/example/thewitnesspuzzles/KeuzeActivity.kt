package com.example.thewitnesspuzzles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_keuze.*

class KeuzeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keuze)
        puzzel1.setOnClickListener() {
            println("puzzel1")
        }
        puzzel2.setOnClickListener() {
            println("puzzel2")
        }
    }
}
