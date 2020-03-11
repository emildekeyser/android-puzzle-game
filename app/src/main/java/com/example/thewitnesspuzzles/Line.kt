package com.example.thewitnesspuzzles

class Line(_begin: Node, _end: Node, _obstacle: Boolean) {
    var begin: Node = _begin
    var end: Node = _end
    var obstacle: Boolean = _obstacle


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
        if (obstacle != other.obstacle) return false

        return true
    }

    override fun hashCode(): Int {
        var result = begin.hashCode()
        result = 31 * result + end.hashCode()
        result = 31 * result + obstacle.hashCode()
        return result
    }


}
