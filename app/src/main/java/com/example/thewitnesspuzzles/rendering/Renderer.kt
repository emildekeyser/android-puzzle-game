package com.example.thewitnesspuzzles.rendering

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.widget.ImageView
import androidx.annotation.RequiresApi
import com.example.thewitnesspuzzles.model.Line
import com.example.thewitnesspuzzles.model.Node

class Renderer(
    val imageView: ImageView,
    val resources: Resources
) {
    // TODO: vind dit dynamisch via imageView:
    // val screenWidth = imageView.width
    // val screenHeight = imageView.height
    private val screenWidth = 1080
    private val screenHeight = 1580 // !! Omdat er nog een titel banner is !!
    private val colorPallete = ColorPallete()
    private val bitmap: Bitmap = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888)
    private val canvas: Canvas = Canvas(bitmap)
    private val converter = PuzzleConverter(this.screenWidth, this.screenHeight, this.colorPallete)

    init {
        colorPallete.disabledPaint.setColor(Color.BLACK)
        colorPallete.enabledPaint.setColor(Color.RED)
        colorPallete.transparantPaint.setColor(Color.TRANSPARENT)
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    fun render(mazeData: List<Line>) {
        val (nodes, lines) = converter.convertPuzzle(mazeData)
        this.drawPuzzle(nodes, lines)
        imageView.background = BitmapDrawable(resources, bitmap)
    }

    private fun drawPuzzle(nodes: List<RenderableNode>, lines: List<RenderableLine>){
        // volgorde lines -> nodes belangrijk
        for (line in lines) {
            canvas.drawRect(line.left, line.top, line.right, line.bottom, line.paint)
        }
        for (node in nodes) {
            canvas.drawCircle(node.x, node.y, node.nodeRadius, node.paint)
        }
    }

    fun getTouched(input: Pair<Float, Float>): Node? {
        return IntersctionCalculator().calculateTouched(converter.getNodes(), input)
    }
}

class RenderableLine(var left: Float, var top: Float, var right: Float, var bottom: Float, var paint: Paint) {
    override fun toString(): String {
        return "RENDERABLE_NODE: left:${left}, right:${right}, top:${top}, bottom: ${bottom}, color:${paint.color}"
    }
}
class RenderableNode(var x: Float, var y: Float, var nodeRadius: Float, var paint: Paint) {
    override fun toString(): String {
        return "RENDERABLE_NODE: x:${x}, y:${y}, radius:${nodeRadius}, color:${paint.color}"
    }
}

