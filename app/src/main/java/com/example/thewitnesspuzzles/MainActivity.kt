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
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView;
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        draw();
        touch();
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
            return@OnTouchListener  true
        })
    }
    fun draw() {
        val bitmap: Bitmap = Bitmap.createBitmap(700, 1000, Bitmap.Config.ARGB_8888)
        val canvas: Canvas = Canvas(bitmap)

        var shapeDrawable: ShapeDrawable

        // rectangle positions
        var left = 100
        var top = 100
        var right = 600
        var bottom = 200

        // draw rectangle shape to canvas
        shapeDrawable = ShapeDrawable(RectShape())
        shapeDrawable.setBounds( left, top, right, bottom)
        shapeDrawable.getPaint().setColor(Color.YELLOW)
        shapeDrawable.draw(canvas)

        // oval positions
        left = 100
        top = 500
        right = 200
        bottom = 600

        // draw oval shape to canvas
        shapeDrawable = ShapeDrawable(OvalShape())
        shapeDrawable.setBounds( left, top, right, bottom)
        shapeDrawable.getPaint().setColor(Color.YELLOW)
        shapeDrawable.draw(canvas)

        // oval positions
        left = 300
        top = 500
        right = 500
        bottom = 600

        // draw oval shape to canvas
        shapeDrawable = ShapeDrawable(OvalShape())
        shapeDrawable.setBounds( left, top, right, bottom)
        shapeDrawable.getPaint().setColor(Color.YELLOW)
        shapeDrawable.draw(canvas)

        // now bitmap holds the updated pixels

        // set bitmap as background to ImageView
        imageView.background = BitmapDrawable(getResources(), bitmap)
    }
}