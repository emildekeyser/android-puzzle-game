package com.example.thewitnesspuzzles

import android.content.Intent
import android.graphics.Color
import android.graphics.Color.red
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
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
        startbutton.setPadding(0,1500,0,0)
        startbutton.text = "START"
        startbutton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        startbutton.setBackgroundColor(0x00000000)
        startbutton.setTextColor(Color.parseColor("#ffffff"))
        startbutton.setTextSize(TypedValue.COMPLEX_UNIT_DIP,35f)

        keuzebutton.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        keuzebutton.text = "KIES PUZZLE"
        keuzebutton.setOnClickListener { Toast.makeText(this@MenuActivity, "Demoversie voorziet geen extra puzzels", Toast.LENGTH_LONG).show() }
        keuzebutton.setBackgroundColor(0x00000000)
        keuzebutton.setTextColor(Color.parseColor("#ffffff"))
        keuzebutton.setTextSize(TypedValue.COMPLEX_UNIT_DIP,35f)

        closebutton.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        closebutton.text = "AFSLUITEN"
        closebutton.setOnClickListener {
            finish();
            System.exit(0);
        }
        closebutton.setBackgroundColor(0x00000000)
        closebutton.setTextColor(Color.parseColor("#ffffff"))
        closebutton.setTextSize(TypedValue.COMPLEX_UNIT_DIP,35f)

        // add Button to LinearLayout
        layout.addView(startbutton)
        layout.addView(keuzebutton)
        layout.addView(closebutton)
    }
}
