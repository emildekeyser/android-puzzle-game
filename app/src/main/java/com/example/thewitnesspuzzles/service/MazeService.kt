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



    // kan de functie niet getMaze noemen? geeft een conflict ergens in het domain?
    fun getServiceMaze(): Maze {
        return maze;
    }

}