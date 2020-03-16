package com.example.thewitnesspuzzles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        val layout = findViewById(R.id.layout) as LinearLayout

        // creating the button
        val startbutton = Button(this)
        val keuzebutton = Button(this)
        val closebutton = Button(this)

            startbutton.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            startbutton.text = "START"
            startbutton.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            keuzebutton.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            keuzebutton.text = "KIES PUZZLE"
            keuzebutton.setOnClickListener { Toast.makeText(this@MenuActivity, "Demoversie voorziet geen extra puzzels", Toast.LENGTH_LONG).show() }
            closebutton.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            closebutton.text = "AFSLUITEN"
            closebutton.setOnClickListener {
                finish();
                System.exit(0);
            }

        // add Button to LinearLayout
        layout.addView(startbutton)
        layout.addView(keuzebutton)
        layout.addView(closebutton)
    }
}
