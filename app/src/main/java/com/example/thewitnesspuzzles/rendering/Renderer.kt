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
    private val converter = PuzzleConverter(
        this.screenWidth,
        this.screenHeight,
        this.colorPallete
    )
    private var nodes = listOf<RenderableNode>()
    private var lines = listOf<RenderableLine>()

    init {
        colorPallete.disabledPaint.setColor(Color.BLACK)
        colorPallete.enabledPaint.setColor(Color.RED)
        colorPallete.transparantPaint.setColor(Color.TRANSPARENT)
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

class RenderableLine(var left: Float, var top: Float, var right: Float, var bottom: Float, var paint: Paint, var relativeLineRef: Line) {
    override fun toString(): String {
        return "RENDERABLE_LINE: left:${left}, right:${right}, top:${top}, bottom: ${bottom}, color:${paint.color}, rline:${relativeLineRef}"
    }
}

open class RenderableNode(var paint: Paint, var relativeNodeRef: Node){}

class Circle(var x: Float, var y: Float, var radius: Float, paint: Paint, relativeNodeRef: Node):
    RenderableNode(paint, relativeNodeRef) {
    override fun toString(): String {
        return "RENDERABLE_NODE: x:${x}, y:${y}, radius:${radius}, color:${paint.color}, rnode:${relativeNodeRef}"
    }
}

class Rectangle(var left: Float, var top: Float, var right: Float, var bottom: Float,
                paint: Paint,
                relativeNodeRef: Node
): RenderableNode(paint, relativeNodeRef) {
    override fun toString(): String {
        return "RENDERABLE_LINE: left:${left}, right:${right}, top:${top}, bottom: ${bottom}, color:${paint.color}, rline:${relativeNodeRef}"
    }
}

