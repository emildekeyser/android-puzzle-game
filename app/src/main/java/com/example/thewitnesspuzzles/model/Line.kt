package com.example.thewitnesspuzzles.model

import java.io.Serializable

class Line(_one: Node, _other: Node, val dot: Boolean = false, var taken: Boolean = false): Serializable {

    val begin = sortedNodes(_one, _other).first
    val end = sortedNodes(_one, _other).second

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Line

        if (begin != other.begin) {
                return false
        }
        if (end != other.end) {
                return false
        }

        // if (taken != other.taken) return false
        if (dot != other.dot) return false

        return true
    }

    override fun hashCode(): Int {
        var result = begin.hashCode()
        result = 31 * result + end.hashCode()
        result = 31 * result + dot.hashCode()
        return result
    }

    fun containsNode(coordinates: Pair<Int, Int>): Boolean {
        return begin.hasMatchingCoordinates(coordinates)
                || end.hasMatchingCoordinates(coordinates)
    }

    fun reverseLine(): Line {
        return Line(end, begin)
    }

    private fun sortedNodes(one: Node, other: Node): Pair<Node, Node> {
        val list = listOf(one, other)
        return list.sortedWith(compareBy({ it.yPos}, { it.xPos })).zipWithNext().first()
    }
}
