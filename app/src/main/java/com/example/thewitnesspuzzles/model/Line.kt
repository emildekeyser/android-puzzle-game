package com.example.thewitnesspuzzles.model

class Line(_begin: Node, _end: Node, _dot: Boolean) {
    var begin: Node = _begin
    var end: Node = _end
    var dot: Boolean = _dot


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
        if (dot != other.dot) return false

        return true
    }

    override fun hashCode(): Int {
        var result = begin.hashCode()
        result = 31 * result + end.hashCode()
        result = 31 * result + dot.hashCode()
        return result
    }


}
