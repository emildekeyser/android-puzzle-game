package com.example.thewitnesspuzzles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thewitnesspuzzles.service.MazeFactory
import kotlinx.android.synthetic.main.activity_victory.*

class VictoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_victory)
        val service = intent.getSerializableExtra("Extra") as? MazeFactory
        btnterug.setOnClickListener {
            val intent = Intent(this, LevelActivity::class.java)
            intent.putExtra("Extra", service)
            startActivity(intent)
        }
    }
}
