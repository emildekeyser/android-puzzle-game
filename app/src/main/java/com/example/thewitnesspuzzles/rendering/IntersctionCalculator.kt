package com.example.thewitnesspuzzles.rendering

import com.example.thewitnesspuzzles.model.Node
import com.example.thewitnesspuzzles.model.NodeType

class IntersctionCalculator {
    fun calculateTouched(
        nodes: List<RenderableNode>,
        input: Pair<Float, Float>
    ): Node? {
        for (node in nodes) {
            if (node is Circle && circleIntersects(node as Circle, input)) {
                return node.relativeNodeRef
            } else if (node is Rectangle && rectangleIntersects(node as Rectangle, input)) {
                return node.relativeNodeRef
            }
        }
        return null
    }

    private fun circleIntersects(node: Circle, input: Pair<Float, Float>): Boolean {
        val (x, y) = input
        val r = node.radius
        val isBelow = (y >= node.y - r)
        val isAbove = (y <= node.y + r)
        val isRightOf = (x >= node.x - r)
        val isLeftOf = (x <= node.x + r)
        return isAbove && isBelow && isLeftOf && isRightOf
    }

    private fun rectangleIntersects(node: Rectangle, input: Pair<Float, Float>): Boolean {
        val (x, y) = input
        val isBelow = (y >= node.top)
        val isAbove = (y <= node.bottom)
        val isRightOf = (x >= node.left)
        val isLeftOf = (x <= node.right)
        return isAbove && isBelow && isLeftOf && isRightOf
    }

}


