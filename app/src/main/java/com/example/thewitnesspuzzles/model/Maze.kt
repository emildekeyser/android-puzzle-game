package com.example.thewitnesspuzzles.model

class Maze(
    val id: Int,
    var lines: Set<Line>,
    var path: Path
) {

    fun getLinesAsList(): List<Line> {
        return lines.toList()
    }

    fun updatePath(coordinates: Pair<Int, Int>): Boolean {
        var coordinatesFound = false
        for (line in lines) {
            if (line.containsNode(coordinates)) {
                coordinatesFound = true
                break
            }
        }
        if (!coordinatesFound) {
            return false
        }

        // TODO continue with algorithm
        return true
    }
}
