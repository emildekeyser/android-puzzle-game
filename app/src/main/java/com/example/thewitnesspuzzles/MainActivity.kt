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
import android.os.Build
import android.widget.ImageView;
import androidx.annotation.RequiresApi
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

        val bitmap = drawPuzzle(screenWidth, screenHeight)
        imageView.background = BitmapDrawable(resources, bitmap)
    }

    fun drawPuzzle(screenWidth: Int, screenHeight: Int): Bitmap{

        val bitmap: Bitmap = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888)
        val canvas: Canvas = Canvas(bitmap)

        // Draw path

        val pathThickness = screenWidth * 0.05f
        val pathLength = screenWidth * 0.6f

        var left = screenWidth * 0.2f
        var top = screenHeight / 2 - pathThickness / 2
        var right = left + pathLength
        var bottom = top + pathThickness

        val paint = Paint()
        paint.setColor(Color.YELLOW)

        canvas.drawRect(left, top, right, bottom, paint)

        // Draw start

        var radius = pathThickness
        var x = left
        var y = top + pathThickness / 2

        canvas.drawCircle(x, y, radius, paint)

        // Draw end

        radius = pathThickness / 2
        x = right

        canvas.drawCircle(x, y, radius, paint)

        return bitmap;
    }
}