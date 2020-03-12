package com.example.thewitnesspuzzles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Build
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi
import com.example.thewitnesspuzzles.rendering.Renderer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var puzzle = Unit // = null ==> wordt later: Puzzles.makePuzzle() // TODO
        val renderer = Renderer(imageView, resources)
        var overlord = Overlord(renderer, puzzle)

        this.imageView.setOnTouchListener(View.OnTouchListener { _, event ->
            val input = Pair(event.x, event.y)
            if(event.action == MotionEvent.ACTION_UP){
                overlord.gameUpdate(input)
            }
            return@OnTouchListener true
        })


    }
}


//        when(event.action) {
//            MotionEvent.ACTION_DOWN -> {
//                println("ACTION_DOWN \nx: $x\ny: $y")
//            }
//            MotionEvent.ACTION_MOVE -> {
//                //println("ACTION_MOVE \nx: $x\ny: $y")
//            }
