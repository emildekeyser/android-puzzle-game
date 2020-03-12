package com.example.thewitnesspuzzles.rendering

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.thewitnesspuzzles.Node
import com.example.thewitnesspuzzles.NodeType

class Renderer {
    fun drawPuzzle(screenWidth: Int, screenHeight: Int, disabledColor: Int, enabledColor: Int):Bitmap{
        val transparantPaint = Paint()
        val disabledPaint= Paint()
        disabledPaint.setColor(disabledColor)
        val enabledPaint= Paint()
        enabledPaint.setColor(enabledColor)

        val bitmap: Bitmap = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888)
        val canvas: Canvas = Canvas(bitmap)

        val lineThickness = screenWidth * 0.05f
        val startNodeRadius = lineThickness
        val endNodeRadius = lineThickness / 2
        val lineLength = screenWidth - startNodeRadius * 2

        var x = startNodeRadius
        var y = screenHeight / 2f
        val absoluteStart = Node(x.toInt(), y.toInt(), NodeType.START)
        val relativeStart = Node(0, 0, NodeType.START)

        var left = x
        var top = y - lineThickness / 2
        var right = left + lineLength
        var bottom = y + lineThickness / 2
        val absoluteLine = RenderableLine(left, top, right, bottom)
        val relativeline = Unit // = null ==> word later tegoei he (Line())

        x = startNodeRadius + lineLength
//        y = screenHeight / 2f  => same
        val absoluteEnd = Node(x.toInt(), y.toInt(), NodeType.END)
        val relativeEnd = Node(0, 0, NodeType.END)

        val nodeMap = mapOf(
            absoluteStart to relativeStart,
            absoluteEnd to relativeEnd
        )

        val lineMap = mapOf(
            absoluteLine to relativeline
        )

        for (node in nodeMap.keys) {
            var paint = if (node.enabled) enabledPaint else disabledPaint
            var radius: Float

            when (node.nodeType) {
                NodeType.START -> {
                    radius = startNodeRadius
                }
                NodeType.END -> {
                    radius = endNodeRadius
                }
                NodeType.MIDDLE -> {
                    radius = startNodeRadius
                    paint = transparantPaint
                }
            }
            canvas.drawCircle(node.xPos.toFloat(), node.yPos.toFloat(), radius, paint)
        }

        for (line in lineMap.keys) {
            val paint = if (line.enabled) enabledPaint else disabledPaint
            canvas.drawRect(line.left, line.top, line.right, line.bottom, paint)
        }

        return bitmap
    }
}

class RenderableLine(left: Float, top: Float, right: Float, bottom: Float) {
    var left = left
    var top = top
    var right = right
    var bottom = bottom
    var enabled = false
}
