package com.example.thewitnesspuzzles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.shapes.RectShape
import android.icu.lang.UCharacter
import android.os.Build
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView;
import androidx.annotation.RequiresApi
import com.example.thewitnesspuzzles.rendering.Renderer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO: vind dit dynamisch
//        val screenWidth = imageView.width
//        val screenHeight = imageView.height
        val screenWidth = 1080
        val screenHeight = 1920

        /// STUB
//
//        var chosenPuzzle = getChosen()
//        var puzzle: Puzzle(chosenPuzzle)
//        var renderer: Renderer(puzzle)
//
//        while(puzzle.noVictory())
//        {
//            touchedNode = renderer.getTouchedNode(input.touchedLocation())
//            puzzle.update(touchedNode)
//            renderer.render(puzzle)
//        }
//
        /// ENDSTUB

        val renderer = Renderer()
        val bitmap = renderer.drawPuzzle(screenWidth, screenHeight, Color.BLACK, Color.RED)
        imageView.background = BitmapDrawable(resources, bitmap)

//        touch();
    }

    fun touch() {
        this.imageView.setOnTouchListener(View.OnTouchListener { _, event ->
            val x = event.x
            val y = event.y

            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    println("ACTION_DOWN \nx: $x\ny: $y")
                }
                MotionEvent.ACTION_MOVE -> {
                    //println("ACTION_MOVE \nx: $x\ny: $y")
                }
                MotionEvent.ACTION_UP -> {
                    println("ACTION_UP \nx: $x\ny: $y")
                }
            }
            return@OnTouchListener true
        })

    }
}
