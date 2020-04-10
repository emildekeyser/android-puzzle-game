package com.example.thewitnesspuzzles.service

import com.example.thewitnesspuzzles.model.Line
import com.example.thewitnesspuzzles.model.Maze
import com.example.thewitnesspuzzles.model.Node
import com.example.thewitnesspuzzles.model.NodeType
import java.io.Serializable

class MazeService: Serializable {
    val start = Node(0, 0, NodeType.START)
    val end = Node(1, 0, NodeType.END)
    val line = Line(start, end)
    var maze = Maze(0, setOf(line))

    fun setMaze(x: Int) {
        if (x == 1) {
            println("maze 1 set")
            val start = Node(0, 0, NodeType.START)
            val end = Node(1, 0, NodeType.END)
            val line = Line(start, end)
            maze = Maze(0, setOf(line))
        }
        if (x == 2) {
            println("maze 2 set")
            val start = Node(0, 0, NodeType.START)
            val middle = Node(1, 0, NodeType.MIDDLE)
            val end = Node(2, 0, NodeType.END)
            val line1 = Line(start, middle)
            val line2 = Line(middle, end)
            maze = Maze(0, setOf(line1, line2))
        }
        if (x == 3) {
            println("maze 3 set")
            val start = Node(0, 0, NodeType.START)
            val middle = Node(0, 1, NodeType.MIDDLE)
            val end = Node(1, 1, NodeType.END)
            val line1 = Line(start, middle)
            val line2 = Line(middle, end)
            maze = Maze(0, setOf(line1, line2))
        }
    }

    // kan de functie niet getMaze noemen? geeft een conflict ergens in het domain?
    fun getServiceMaze(): Maze {
        return maze;
    }

}