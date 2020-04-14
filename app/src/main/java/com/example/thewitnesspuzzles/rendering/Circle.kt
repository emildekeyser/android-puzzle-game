package com.example.thewitnesspuzzles.rendering

import android.graphics.Paint
import com.example.thewitnesspuzzles.model.Node

class Circle(var x: Float, var y: Float, var radius: Float, paint: Paint, relativeNodeRef: Node):
    RenderableNode(paint, relativeNodeRef) {
    override fun toString(): String {
        return "RENDERABLE_NODE: x:${x}, y:${y}, radius:${radius}, color:${paint.color}, rnode:${relativeNodeRef}"
    }
}