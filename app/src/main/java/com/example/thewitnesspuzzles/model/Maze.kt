package com.example.thewitnesspuzzles.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.Serializable

class Maze(
    val id: Int,
    var lines: Set<Line>,
    var path: Path = Path()
) : Serializable{

    fun getLinesAsList(): List<Line> {
        return lines.toList()
    }

    // TODO why is this in domain code, Johan?
    @RequiresApi(Build.VERSION_CODES.N)
    fun updatePath(coordinates: Pair<Int, Int>): Boolean {
        var coordinatesFound = false
        var selectedNode: Node? = null
        for (line in lines) {
            if (line.containsNode(coordinates)) {
                coordinatesFound = true
                if (line.begin.hasMatchingCoordinates(coordinates)) selectedNode = line.begin
                else selectedNode = line.end
                break
            }
        }
        if (!coordinatesFound) {
            return false
        }
        if (path.currentNode == null) { // if there is no currentNode make selectedNode it
            if (selectedNode!!.nodeType.equals(NodeType.START)) { // if it's of typ START
                path.currentNode = selectedNode
                return true
            }
            return false
        }
        if (selectedNode!!.isReachable(path.currentNode!!)) { // if the selectedNode can be reached from the current Node
            val line = Line(path.currentNode!!, selectedNode) // create Line object
            val reversedLine = line.reverseLine()
            if (path.lines.contains(reversedLine)) { // check if the reversed line has been added
                path.lines = path.lines.minus(reversedLine)
                path.currentNode = reversedLine.begin
                return true
            }
            path.lines =
                path.lines.plus(line) // add a Line consisting of the currentNode and the selectedNode
            return true
        }
        return false
        //todo optimise
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
                || l.end.nodeType == NodeType.END && l.end.taken) {
                return true
            }
        }
        return false
    }

}
