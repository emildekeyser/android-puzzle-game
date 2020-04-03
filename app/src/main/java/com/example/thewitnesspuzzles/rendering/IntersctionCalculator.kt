package com.example.thewitnesspuzzles.rendering

import com.example.thewitnesspuzzles.model.Node

class IntersctionCalculator {
    fun calculateTouched(
        nodes: List<RenderableNode>,
        input: Pair<Float, Float>
    ): Node? {
        for (node in nodes) {
            if (intersects(node, input))
                return node.relativeNodeRef
        }
        return null
    }

    private fun intersects(node: RenderableNode, input: Pair<Float, Float>): Boolean {
        val (x, y) = input
        val r = node.nodeRadius
        val isBelow = (y >= node.y - r)
        val isAbove = (y <= node.y + r)
        val isRightOf = (x >= node.x - r)
        val isLeftOf = (x <= node.x + r)
        return isAbove && isBelow && isLeftOf && isRightOf
    }
}


