package com.example.thewitnesspuzzles.model

class Line(val begin: Node, val end: Node, val dot: Boolean = false, var taken: Boolean = false) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Line

        if (begin != other.begin) {
            if (begin != other.end)
                return false
        }
        if (end != other.end) {
            if (end != other.begin)
                return false
        }
        if (taken != other.taken) return false
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
}
