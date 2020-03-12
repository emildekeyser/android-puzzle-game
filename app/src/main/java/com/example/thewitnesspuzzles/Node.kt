package com.example.thewitnesspuzzles

class Node(_xPos: Int, _yPos: Int, _nodeType: NodeType, _dot: Boolean) {
    constructor(_xPos: Int, _yPos: Int, _nodeType: NodeType) : this(_xPos, _yPos, _nodeType, false)

    var enabled = false
    var xPos: Int = _xPos
    var yPos: Int = _yPos
    var nodeType = _nodeType
    var dot: Boolean = _dot;

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
