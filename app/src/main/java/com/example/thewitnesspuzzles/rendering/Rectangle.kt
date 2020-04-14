package com.example.thewitnesspuzzles.rendering

import android.graphics.Paint
import com.example.thewitnesspuzzles.model.Node

class Rectangle(var left: Float, var top: Float, var right: Float, var bottom: Float,
                paint: Paint,
                relativeNodeRef: Node
): RenderableNode(paint, relativeNodeRef) {
    override fun toString(): String {
        return "RENDERABLE_LINE: left:${left}, right:${right}, top:${top}, bottom: ${bottom}, color:${paint.color}, rline:${relativeNodeRef}"
    }
}