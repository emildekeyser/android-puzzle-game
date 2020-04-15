package com.example.thewitnesspuzzles.rendering

import android.graphics.Paint
import com.example.thewitnesspuzzles.model.Line

class RenderableLine(var left: Float, var top: Float, var right: Float, var bottom: Float, var paint: Paint, var relativeLineRef: Line) {
    override fun toString(): String {
        return "RENDERABLE_LINE: left:${left}, right:${right}, top:${top}, bottom: ${bottom}, color:${paint.color}, rline:${relativeLineRef}"
    }
}