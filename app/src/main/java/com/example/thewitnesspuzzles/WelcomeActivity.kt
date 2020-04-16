package com.example.thewitnesspuzzles

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {
    private var PRIVATE_MODE = 0
    private val PREF_NAME = "welkom"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPref : SharedPreferences = getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        if (sharedPref.getBoolean(PREF_NAME,false)) {
            val intent = Intent(this,MenuActivity::class.java)
            startActivity(intent)
            finish()
        }
        else {
            setContentView(R.layout.activity_welcome)
            val editor = sharedPref.edit()
            editor.putBoolean(PREF_NAME,true)
            editor.apply()
        }

        btnok.setOnClickListener {
            val intent = Intent(this,MenuActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}
