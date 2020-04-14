package com.example.thewitnesspuzzles

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

class MenuActivity : AppCompatActivity () {
    var service = MazeFactory()
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // music
//        mediaPlayer = MediaPlayer.create(this, R.raw.mario)
//        mediaPlayer?.start()


        // layout
        val layout = findViewById(R.id.layout) as LinearLayout


        val startbutton = Button(this)
        val keuzebutton = Button(this)
        val closebutton = Button(this)


        startbutton.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        startbutton.setPadding(0,1500,0,0)
        startbutton.text = "START"
        startbutton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Extra", service)
            startActivity(intent)
        }
        startbutton.setBackgroundColor(0x00000000)
        startbutton.setTextColor(Color.parseColor("#ffffff"))
        startbutton.setTextSize(TypedValue.COMPLEX_UNIT_DIP,35f)

        keuzebutton.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        keuzebutton.text = "KIES PUZZLE"
        keuzebutton.setOnClickListener {
            //Toast.makeText(this@MenuActivity, "Demoversie voorziet geen extra puzzels", Toast.LENGTH_LONG).show()
            val intent = Intent(this, LevelActivity::class.java)
            intent.putExtra("Extra",service)
            startActivity(intent)
        }
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


        val mShaker = ShakeListener(this)
        mShaker.setOnShakeListener(object : OnShakeListener {
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onShake() {

                val randomInteger = ThreadLocalRandom.current().nextInt(1, 7)

                if(randomInteger == 1) {
                    startbutton.setPadding(0,0,0,0)
                    closebutton.setPadding(0,0,0,0)
                    keuzebutton.setPadding(0,0,0,0)
                    layout.removeAllViews();
                    startbutton.setPadding(0,1500,0,0)
                    layout.addView(startbutton)
                    layout.addView(closebutton)
                    layout.addView(keuzebutton)
                }

                if(randomInteger == 2) {
                    startbutton.setPadding(0,0,0,0)
                    closebutton.setPadding(0,0,0,0)
                    keuzebutton.setPadding(0,0,0,0)
                    layout.removeAllViews();
                    startbutton.setPadding(0,1500,0,0)
                    layout.addView(startbutton)
                    layout.addView(keuzebutton)
                    layout.addView(closebutton)
                }

                if(randomInteger == 3) {
                    startbutton.setPadding(0,0,0,0)
                    closebutton.setPadding(0,0,0,0)
                    keuzebutton.setPadding(0,0,0,0)
                    layout.removeAllViews();
                    keuzebutton.setPadding(0,1500,0,0)
                    layout.addView(keuzebutton)
                    layout.addView(startbutton)
                    layout.addView(closebutton)
                }

                if(randomInteger == 4) {
                    startbutton.setPadding(0,0,0,0)
                    closebutton.setPadding(0,0,0,0)
                    keuzebutton.setPadding(0,0,0,0)
                    layout.removeAllViews();
                    keuzebutton.setPadding(0,1500,0,0)
                    layout.addView(keuzebutton)
                    layout.addView(closebutton)
                    layout.addView(startbutton)
                }

                if(randomInteger == 5) {
                    startbutton.setPadding(0,0,0,0)
                    closebutton.setPadding(0,0,0,0)
                    keuzebutton.setPadding(0,0,0,0)
                    layout.removeAllViews();
                    closebutton.setPadding(0,1500,0,0)
                    layout.addView(closebutton)
                    layout.addView(startbutton)
                    layout.addView(keuzebutton)
                }
                if(randomInteger == 6) {
                    startbutton.setPadding(0,0,0,0)
                    closebutton.setPadding(0,0,0,0)
                    keuzebutton.setPadding(0,0,0,0)
                    layout.removeAllViews();
                    closebutton.setPadding(0,1500,0,0)
                    layout.addView(closebutton)
                    layout.addView(keuzebutton)
                    layout.addView(startbutton)
                }
            }
        })
    }
}
