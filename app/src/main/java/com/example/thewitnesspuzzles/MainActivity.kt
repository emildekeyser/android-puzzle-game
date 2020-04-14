package com.example.thewitnesspuzzles

import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.thewitnesspuzzles.rendering.Renderer
import com.example.thewitnesspuzzles.service.MazeFactory
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity: AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main)
        val service = intent.getSerializableExtra("Extra") as MazeFactory
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels
        // This way if we want to keep the status bar
        //val height = displayMetrics.heightPixels - 75
        val height = displayMetrics.heightPixels
        var maze = service.createEight()
//        var maze = service!!.getServiceMaze();
        // TODO: Possibly not do the width and height here
        val renderer = Renderer(imageView, resources, width, height)
        var overlord = Overlord(renderer, maze)

        this.imageView.setOnTouchListener(View.OnTouchListener { _, event ->
//            this.imageView.layoutParams.width = 1080
//            this.imageView.layoutParams.height = 1920
            val input = Pair(event.x, event.y)
            if(event.action == MotionEvent.ACTION_UP){
                overlord.gameUpdate(input)
            }
            return@OnTouchListener true
        })
    }
}

