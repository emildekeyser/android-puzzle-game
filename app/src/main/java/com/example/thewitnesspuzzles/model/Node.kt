package com.example.thewitnesspuzzles.model

class Node(
    val xPos: Int,
    val yPos: Int,
    val nodeType: NodeType,
    val dot: Boolean,
    var enabled: Boolean = false
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Node

        if (xPos != other.xPos) return false
        if (yPos != other.yPos) return false
        if (nodeType != other.nodeType) return false
        if (enabled != other.enabled) return false
        if (dot != other.dot) return false

        return true
    }

    override fun hashCode(): Int {
        var result = xPos
        result = 31 * result + yPos
        result = 31 * result + dot.hashCode()
        return result
    }
}
