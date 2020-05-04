package com.example.thewitnesspuzzles.model

import java.io.Serializable

class Maze(
    val id: Int,
    var lines: Set<Line>,
    var path: Path = Path()
) : Serializable {

    fun getLinesAsList(): List<Line> { // returns all lines
        return lines.toList()
    }

    fun update(coordinates: Pair<Int, Int>): Boolean {
        var coordinatesFound = false
        var selectedNode: Node? = null
        for (line in lines) {
            if (line.containsNodeCoordinates(coordinates)) {
                coordinatesFound = true
                selectedNode = if (line.begin.hasMatchingCoordinates(coordinates)) line.begin
                else line.end
                break
            }
        }
        if (!coordinatesFound) {
            return false
        }
        if (path.currentNode == null) { // if there is no currentNode, then currentNode will be selectedNode
            if (selectedNode!!.nodeType == NodeType.START) { // if it's of type START
                selectedNode.taken = true
                path.currentNode = selectedNode
                return true
            }
            return false
        }
//        if (isReachable(
//                selectedNode!!,
//                path.currentNode!!
//            )
//        ) { // if the selectedNode can be reached from the current Node
        val dummyLine = Line(path.currentNode!!, selectedNode!!) // create Line object
        val selectedline = lines.find { line -> line == dummyLine }
        if (selectedline != null) {
            if (selectedline!!.taken) {
                var currentNode = path.currentNode
                path.pathOfNodes.remove(currentNode)
                path.currentNode = selectedNode
                currentNode!!.taken = false
                selectedline!!.taken=false
                return true
            } else {
                if (path.pathOfNodes.add(selectedNode)) {
                    selectedNode!!.taken = true
                    selectedline!!.taken = true
                    path.currentNode = selectedNode
                    return true
                }
            }
            return false
        }
        return false

//            val reversedLine = line.reverseLine()
//            if (path.lines.contains(reversedLine)) { // check if the reversed line has been added
//                path.currentNode!!.taken = false
//                path.lines = path.lines.minus(reversedLine)
//                path.currentNode = reversedLine.begin
//                return true
//            }
//        }
//        return false
    }

    // @Jaron isreachable is eigenlijk niet nodig, want we gaan kijken of ze in de lijnen zijn, en daarom al reachable is
    private fun isReachable(one: Node, other: Node): Boolean {
        return one.isDirectlyAdjacent(other)
        //todo adapt reachable to adjust for diagonals and longer lines
    }

    fun victorious(): Boolean {
        return simpleVictory() && dotVictory()
    }

    private fun dotVictory(): Boolean {
        var win = true
        for (l in lines) {
            if (l.begin.dot) {
                win = win && l.begin.taken
            }
        }
        return win
    }

    private fun simpleVictory(): Boolean {
        for (l in lines) {
            if ((l.begin.nodeType == NodeType.END && l.begin.taken)
                || (l.end.nodeType == NodeType.END && l.end.taken)
            ) {
                return true
            }
        }
        return false
    }
}
