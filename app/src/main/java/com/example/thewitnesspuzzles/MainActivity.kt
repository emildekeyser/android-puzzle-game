package com.example.thewitnesspuzzles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Build
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi
import com.example.thewitnesspuzzles.model.Line
import com.example.thewitnesspuzzles.model.Maze
import com.example.thewitnesspuzzles.model.Node
import com.example.thewitnesspuzzles.model.NodeType
import com.example.thewitnesspuzzles.rendering.Renderer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var maze = makeDildo() // = mazeService.makeMaze(0) // TODO
        val renderer = Renderer(imageView, resources)
        var overlord = Overlord(renderer, maze)

        this.imageView.setOnTouchListener(View.OnTouchListener { _, event ->
//            this.imageView.layoutParams.width = 1080
//            this.imageView.layoutParams.height = 1920
            val input = Pair(event.x, event.y)
            if(event.action == MotionEvent.ACTION_UP){
                overlord.gameUpdate(input)
            }
            return@OnTouchListener true
        })


    }
}

fun makeDildo(): Maze {
    val start = Node(0, 0, NodeType.START)
    val end = Node(1, 0, NodeType.END)
    val line = Line(start, end)
    return Maze(0, setOf(line))
}


//        when(event.action) {
//            MotionEvent.ACTION_DOWN -> {
//                println("ACTION_DOWN \nx: $x\ny: $y")
//            }
//            MotionEvent.ACTION_MOVE -> {
//                //println("ACTION_MOVE \nx: $x\ny: $y")
//            }
