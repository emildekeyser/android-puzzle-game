package com.example.thewitnesspuzzles

import android.os.Build
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi
import com.example.thewitnesspuzzles.rendering.Renderer

@RequiresApi(Build.VERSION_CODES.JELLY_BEAN) // negeer
class Overlord(val renderer: Renderer, val puzzle: Unit) {
    init {
        renderer.render(puzzle)
    }
    fun gameUpdate(input: Pair<Float, Float>) {
//        touchedPuzzleData = renderer.getTouched(input)
//        updatedPuzzleData = puzzle.getUpdate(touched)
//        renderer.render(updatedPuzzleData)
//        if(puzzle.victorious()){
//           // end game
//        }
    }
}
