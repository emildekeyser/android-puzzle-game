package com.example.thewitnesspuzzles.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.lang.Integer.max
import java.lang.Integer.min

class Node(
    val xPos: Int,
    val yPos: Int,
    val nodeType: NodeType,
    val dot: Boolean,
    var taken: Boolean = false
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Node

        if (xPos != other.xPos) return false
        if (yPos != other.yPos) return false
        if (nodeType != other.nodeType) return false
        if (taken != other.taken) return false
        if (dot != other.dot) return false

        return true
    }

    override fun hashCode(): Int {
        var result = xPos
        result = 31 * result + yPos
        result = 31 * result + dot.hashCode()
        return result
    }
    
    @RequiresApi(Build.VERSION_CODES.N)
    fun reachableBy(other: Node): Boolean {
        if (xPos == other.xPos) {
            if ((max(yPos, other.yPos) - min(yPos, other.yPos)) == 1)
                return true
        }
        if (yPos == other.yPos) {
            if ((max(xPos, other.xPos) - min(xPos, other.xPos)) == 1)
                return true
        }
        return false
    }
}
