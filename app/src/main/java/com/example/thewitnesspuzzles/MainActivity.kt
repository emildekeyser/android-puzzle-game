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
import android.widget.ImageView;
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bitmap: Bitmap = Bitmap.createBitmap(700, 1000, Bitmap.Config.ARGB_8888)
        val canvas: Canvas = Canvas(bitmap)

        var shapeDrawable: ShapeDrawable

        // rectangle positions
        var left = 100
        var top = 100
        var right = 600
        var bottom = 400

        // draw rectangle shape to canvas
        shapeDrawable = ShapeDrawable(RectShape())
        shapeDrawable.setBounds( left, top, right, bottom)
        shapeDrawable.getPaint().setColor(Color.parseColor("#009944"))
        shapeDrawable.draw(canvas)

        // oval positions
        left = 100
        top = 500
        right = 600
        bottom = 800

        // draw oval shape to canvas
        shapeDrawable = ShapeDrawable(OvalShape())
        shapeDrawable.setBounds( left, top, right, bottom)
        shapeDrawable.getPaint().setColor(Color.parseColor("#009191"))
        shapeDrawable.draw(canvas)

        // now bitmap holds the updated pixels

        // set bitmap as background to ImageView
        imageView.background = BitmapDrawable(getResources(), bitmap)

    }
}