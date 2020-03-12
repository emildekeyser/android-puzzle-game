package com.example.thewitnesspuzzles

class Node(_xPos: Int, _yPos: Int, _nodeType: NodeType, _dot: Boolean) {
    constructor(_xPos: Int, _yPos: Int, _nodeType: NodeType) : this(_xPos, _yPos, _nodeType, false)

    var enabled = false
    var xPos: Int = _xPos
    var yPos: Int = _yPos
    var nodeType = _nodeType
    var dot: Boolean = _dot;
}
