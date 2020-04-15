package com.example.thewitnesspuzzles.service

class MazeService {
=======
import com.example.thewitnesspuzzles.model.Line
import com.example.thewitnesspuzzles.model.Maze
import com.example.thewitnesspuzzles.model.Node
import com.example.thewitnesspuzzles.model.NodeType
import java.io.Serializable

class MazeService: Serializable {
    private val start = Node(0, 0, NodeType.START)
    private val end = Node(1, 0, NodeType.END)
    private val line = Line(start, end)
    private var maze = Maze(0, setOf(line))

    // kan de functie niet getMaze noemen? geeft een conflict ergens in het domain?
    fun getServiceMaze(): Maze {
        return maze
    }
}
