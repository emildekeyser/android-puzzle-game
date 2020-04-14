package com.example.thewitnesspuzzles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thewitnesspuzzles.service.MazeFactory
import kotlinx.android.synthetic.main.activity_keuze.*

class KeuzeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keuze)
        val service = intent.getSerializableExtra("Extra") as? MazeFactory

        level1.setOnClickListener {
            service?.createSmallLineMaze()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Extra", service)
            startActivity(intent)}

        level2.setOnClickListener {
            service?.createMediumLineMaze()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Extra", service)
            startActivity(intent)}

        level3.setOnClickListener {
            service?.createCornerMaze()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Extra", service)
            startActivity(intent)}
    }
}
