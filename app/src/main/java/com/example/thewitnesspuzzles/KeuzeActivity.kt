package com.example.thewitnesspuzzles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thewitnesspuzzles.service.MazeService
import kotlinx.android.synthetic.main.activity_keuze.*

class KeuzeActivity : AppCompatActivity() {
    val service = MazeService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keuze)

        level1.setOnClickListener {
            service.setMaze(1)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)}

        level2.setOnClickListener {
            service.setMaze(2)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)}

        level3.setOnClickListener {
            service.setMaze(3)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)}
    }
}
