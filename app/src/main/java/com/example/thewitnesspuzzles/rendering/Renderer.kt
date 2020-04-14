package com.example.thewitnesspuzzles.rendering

import android.content.res.Resources
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.widget.ImageView
import androidx.annotation.RequiresApi
import com.example.thewitnesspuzzles.model.Line
import com.example.thewitnesspuzzles.model.Node
import com.example.thewitnesspuzzles.model.NodeType

class Renderer(
    private val imageView: ImageView,
    private val resources: Resources,
    private val screenWidth: Int,
    private val screenHeight: Int
) {
    //private val screenWidth = 1080
    //private val screenHeight = 1580 // !! Omdat er nog een titel banner is !!
    private val colorPalette = ColorPalette()
    private val bitmap: Bitmap = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888)
    private val canvas: Canvas = Canvas(bitmap)
    private val converter = PuzzleConverter(
        this.screenWidth,
        this.screenHeight,
        this.colorPalette
    )
    private var nodes = listOf<RenderableNode>()
    private var lines = listOf<RenderableLine>()

    init {
        colorPalette.disabledPaint.color = Color.BLACK
        colorPalette.enabledPaint.color = Color.RED
        colorPalette.transparentPaint.color = Color.TRANSPARENT
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    fun render(mazeData: List<Line>) {
        val (n, l) = converter.convertPuzzle(mazeData)
        nodes = n
        lines = l
        this.drawPuzzle()
        imageView.background = BitmapDrawable(resources, bitmap)
    }

    private fun drawPuzzle(){
        // volgorde lines -> nodes belangrijk
        for (line in lines) {
            canvas.drawRect(line.left, line.top, line.right, line.bottom, line.paint)
        }
        for (node in nodes) {
            if (node.relativeNodeRef.nodeType == NodeType.END) {
                val rect = node as Rectangle
                canvas.drawRect(rect.left, rect.top, rect.right, rect.bottom, rect.paint)
            } else {
                val circle = node as Circle
                canvas.drawCircle(circle.x, circle.y, circle.radius, circle.paint)
            }
        }
    }

    fun getTouched(input: Pair<Float, Float>): Node? {
        return IntersectionCalculator().calculateTouched(nodes, input)
    }
}

