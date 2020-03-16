package com.example.thewitnesspuzzles

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.thewitnesspuzzles.model.Maze
import com.example.thewitnesspuzzles.rendering.Renderer

@RequiresApi(Build.VERSION_CODES.JELLY_BEAN) // negeer
class Overlord(val renderer: Renderer, val maze: Maze) {
    init {
        renderer.render(maze.getLinesAsList())
    }
    fun gameUpdate(input: Pair<Float, Float>) {
        val touchedNode = renderer.getTouched(input)
//        updatedPuzzleData = puzzle.getUpdate(touched) // TODO
//        renderer.render(updatedPuzzleData) // TODO
//        if(puzzle.victorious()){ // TODO
//           // end game // TODO
//        }
    }
}
