package com.example.thewitnesspuzzles.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.lang.Integer.max
import java.lang.Integer.min

class Node(
    val xPos: Int,
    val yPos: Int,
    val nodeType: NodeType,
    val dot: Boolean = false,
    var taken: Boolean = false
): Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Node

        if (xPos != other.xPos) return false
        if (yPos != other.yPos) return false
        if (nodeType != other.nodeType) return false
        // TODO think about this
//        if (taken != other.taken) return false
//        if (dot != other.dot) return false

        return true
    }

    override fun hashCode(): Int {
        var result = xPos
        result = 31 * result + yPos
        result = 31 * result + dot.hashCode()
        return result
    }

    // TODO why is this in domain code, Johan?
    @RequiresApi(Build.VERSION_CODES.N)
    fun isAdjacent(other: Node): Boolean {
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

    // TODO why is this in domain code, Johan?
    @RequiresApi(Build.VERSION_CODES.N)
    fun isReachable(other: Node): Boolean {
        return isAdjacent(other)
        //todo adapt reachable to adjust for diagonals and longer lines
    }

    fun hasMatchingCoordinates(coordinates: Pair<Int, Int>): Boolean {
        val (x, y) = coordinates
        return xPos == x && yPos == y
    }
}
