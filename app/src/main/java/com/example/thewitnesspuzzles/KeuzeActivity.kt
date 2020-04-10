package com.example.thewitnesspuzzles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thewitnesspuzzles.model.Maze
import com.example.thewitnesspuzzles.service.MazeService
import kotlinx.android.synthetic.main.activity_keuze.*

class KeuzeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keuze)
        val service = intent.getSerializableExtra("Extra") as? MazeService

        level1.setOnClickListener {
            if (service != null) {
                service.setMaze(1)
            }

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Extra", service)
            startActivity(intent)}

        level2.setOnClickListener {
            if (service != null) {
                service.setMaze(2)
            }
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Extra", service)
            startActivity(intent)}

        level3.setOnClickListener {
            if (service != null) {
                service.setMaze(3)
            }
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Extra", service)
            startActivity(intent)}
    }
}
