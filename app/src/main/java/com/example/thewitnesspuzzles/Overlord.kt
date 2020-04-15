package com.example.thewitnesspuzzles

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.thewitnesspuzzles.model.Maze
import com.example.thewitnesspuzzles.model.Node
import com.example.thewitnesspuzzles.rendering.Renderer

@RequiresApi(Build.VERSION_CODES.JELLY_BEAN) // negeer
class Overlord(val renderer: Renderer, val maze: Maze) {
    init {
        renderer.render(maze.getLinesAsList())
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun gameUpdate(input: Pair<Float, Float>) {
        val touchedNode = renderer.getTouched(input)
        if (touchedNode != null) {
            maze.updatePath(Pair(touchedNode.xPos, touchedNode.yPos))
        }
//        maze.update(touched) // TODO
//        FAKEupdate(touchedNode, maze)
//        renderer.render(maze.getLinesAsList())
        renderer.render(maze.getLinesAsList())
//        if(puzzle.victorious()){ // TODO
//           // end game // TODO
//        }
    }

    // always marks node as taken, depends on custom .equals
    fun FAKEupdate(n: Node?, m: Maze) {
        for (l in m.getLinesAsList()) {
            if (l.begin == n) {
                l.begin.taken = true
            } else if (l.end == n) {
                l.taken = true
                l.end.taken = true
            }
        }
    }
}
