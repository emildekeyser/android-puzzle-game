package com.example.thewitnesspuzzles

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.thewitnesspuzzles.ShakeListener.OnShakeListener
import com.example.thewitnesspuzzles.service.MazeFactory
import java.util.concurrent.ThreadLocalRandom
import kotlin.system.exitProcess

class MenuActivity : AppCompatActivity () {
    var service = MazeFactory()
    private var mediaPlayer: MediaPlayer? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        // music
//        mediaPlayer = MediaPlayer.create(this, R.raw.mario)
//        mediaPlayer?.start()

        // layout
        val layout = findViewById<LinearLayout>(R.id.layout)

        val startButton = Button(this)
        val choiceButton = Button(this)
        val closeButton = Button(this)


        startButton.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        startButton.setPadding(0,1500,0,0)
        startButton.text = "START"
        startButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Extra", service)
            startActivity(intent)
        }
        startButton.setBackgroundColor(0x00000000)
        startButton.setTextColor(Color.parseColor("#ffffff"))
        startButton.setTextSize(TypedValue.COMPLEX_UNIT_DIP,35f)

        choiceButton.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        choiceButton.text = "KIES PUZZLE"
        choiceButton.setOnClickListener {
            //Toast.makeText(this@MenuActivity, "Demoversie voorziet geen extra puzzels", Toast.LENGTH_LONG).show()
            val intent = Intent(this, LevelActivity::class.java)
            intent.putExtra("Extra",service)
            startActivity(intent)
        }
        choiceButton.setBackgroundColor(0x00000000)
        choiceButton.setTextColor(Color.parseColor("#ffffff"))
        choiceButton.setTextSize(TypedValue.COMPLEX_UNIT_DIP,35f)

        closeButton.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        closeButton.text = "AFSLUITEN"
        closeButton.setOnClickListener {
            finish()
            exitProcess(0)
        }
        closeButton.setBackgroundColor(0x00000000)
        closeButton.setTextColor(Color.parseColor("#ffffff"))
        closeButton.setTextSize(TypedValue.COMPLEX_UNIT_DIP,35f)

        // add Button to LinearLayout
        layout.addView(startButton)
        layout.addView(choiceButton)
        layout.addView(closeButton)

        val mShaker = ShakeListener(this)
        mShaker.setOnShakeListener(object : OnShakeListener {
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onShake() {

                val randomInteger = ThreadLocalRandom.current().nextInt(1, 7)

                if(randomInteger == 1) {
                    startButton.setPadding(0,0,0,0)
                    closeButton.setPadding(0,0,0,0)
                    choiceButton.setPadding(0,0,0,0)
                    layout.removeAllViews()
                    startButton.setPadding(0,1500,0,0)
                    layout.addView(startButton)
                    layout.addView(closeButton)
                    layout.addView(choiceButton)
                }

                if(randomInteger == 2) {
                    startButton.setPadding(0,0,0,0)
                    closeButton.setPadding(0,0,0,0)
                    choiceButton.setPadding(0,0,0,0)
                    layout.removeAllViews()
                    startButton.setPadding(0,1500,0,0)
                    layout.addView(startButton)
                    layout.addView(choiceButton)
                    layout.addView(closeButton)
                }

                if(randomInteger == 3) {
                    startButton.setPadding(0,0,0,0)
                    closeButton.setPadding(0,0,0,0)
                    choiceButton.setPadding(0,0,0,0)
                    layout.removeAllViews()
                    choiceButton.setPadding(0,1500,0,0)
                    layout.addView(choiceButton)
                    layout.addView(startButton)
                    layout.addView(closeButton)
                }

                if(randomInteger == 4) {
                    startButton.setPadding(0,0,0,0)
                    closeButton.setPadding(0,0,0,0)
                    choiceButton.setPadding(0,0,0,0)
                    layout.removeAllViews()
                    choiceButton.setPadding(0,1500,0,0)
                    layout.addView(choiceButton)
                    layout.addView(closeButton)
                    layout.addView(startButton)
                }

                if(randomInteger == 5) {
                    startButton.setPadding(0,0,0,0)
                    closeButton.setPadding(0,0,0,0)
                    choiceButton.setPadding(0,0,0,0)
                    layout.removeAllViews()
                    closeButton.setPadding(0,1500,0,0)
                    layout.addView(closeButton)
                    layout.addView(startButton)
                    layout.addView(choiceButton)
                }
                if(randomInteger == 6) {
                    startButton.setPadding(0,0,0,0)
                    closeButton.setPadding(0,0,0,0)
                    choiceButton.setPadding(0,0,0,0)
                    layout.removeAllViews()
                    closeButton.setPadding(0,1500,0,0)
                    layout.addView(closeButton)
                    layout.addView(choiceButton)
                    layout.addView(startButton)
                }
            }
        })
    }
}
