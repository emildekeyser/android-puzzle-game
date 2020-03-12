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
import com.example.thewitnesspuzzles.Node

class Renderer(
    val imageView: ImageView,
    val resources: Resources
) {
    // TODO: vind dit dynamisch via imageView:
    // val screenWidth = imageView.width
    // val screenHeight = imageView.height
    private val screenWidth = 1080
    private val screenHeight = 1920
    private val colorPallete = ColorPallete()
    private val bitmap: Bitmap = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888)
    private val canvas: Canvas = Canvas(bitmap)
    private val converter = Converter(this.screenWidth, this.screenHeight, this.colorPallete)

    init {
        colorPallete.disabledPaint.setColor(Color.BLACK)
        colorPallete.enabledPaint.setColor(Color.RED)
        colorPallete.transparantPaint.setColor(Color.TRANSPARENT)
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    fun render(puzzleData: Unit) {
        val (nodeMap, lineMap) = converter.convertPuzzle(puzzleData)
        this.drawPuzzle(nodeMap, lineMap)
        imageView.background = BitmapDrawable(resources, bitmap)
    }

    private fun drawPuzzle(nodeMap: Map<RenderableNode, Node>, lineMap: Map<RenderableLine, Unit>){
        for (node in nodeMap.keys) {
            canvas.drawCircle(node.x, node.y, node.nodeRadius, node.paint)
        }
        for (line in lineMap.keys) {
            canvas.drawRect(line.left, line.top, line.right, line.bottom, line.paint)
        }
    }

}

class RenderableLine(var left: Float, var top: Float, var right: Float, var bottom: Float, var paint: Paint) {}
class RenderableNode(var x: Float, var y: Float, var nodeRadius: Float, var paint: Paint) {}

