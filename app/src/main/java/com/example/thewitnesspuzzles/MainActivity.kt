package com.example.thewitnesspuzzles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Build
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi
import com.example.thewitnesspuzzles.model.Line
import com.example.thewitnesspuzzles.model.Maze
import com.example.thewitnesspuzzles.model.Node
import com.example.thewitnesspuzzles.model.NodeType
import com.example.thewitnesspuzzles.rendering.Renderer
import com.example.thewitnesspuzzles.service.MazeFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service = intent.getSerializableExtra("Extra") as? MazeFactory
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels
        val height = displayMetrics.heightPixels
        // This is a test for if we want to keep the actionbar
        //var defaultHeight = displayMetrics.heightPixels
        //val height = width - (actionBar?.customView?.height ?: 0)
        var maze = makeEight()
//        var maze = service!!.getServiceMaze();
        // TODO: change the parameters the renderer receives
        val renderer = Renderer(imageView, resources, width, height)
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

fun makeSnake(): Maze {
    val start = Node(0, 0, NodeType.START)
    val n1 = Node(1, 0, NodeType.MIDDLE)
    val n2 = Node(1, 1, NodeType.MIDDLE)
    val n3 = Node(0, 1, NodeType.MIDDLE)
    val n4 = Node(0, 2, NodeType.MIDDLE)
    val end = Node(1, 2, NodeType.END)
    val line1 = Line(start, n1)
    val line2 = Line(n1, n2)
    val line3 = Line(n2, n3)
    val line4 = Line(n3, n4)
    val line5 = Line(n4, end)
    return Maze(0, setOf(line1, line2, line3, line4, line5))
}

fun makeEight(): Maze {
    val start = Node(0, 0, NodeType.START)
    val n1 = Node(1, 0, NodeType.MIDDLE)
    val n2 = Node(1, 1, NodeType.MIDDLE)
    val n3 = Node(0, 1, NodeType.MIDDLE)
    val n4 = Node(0, 2, NodeType.MIDDLE)
    val end = Node(1, 2, NodeType.END)
    val line1 = Line(start, n1)
    val line2 = Line(n1, n2)
    val line3 = Line(n2, n3)
    val line4 = Line(n3, n4)
    val line5 = Line(n4, end)

    val line6 = Line(start, n3)
    val line7 = Line(n2, end)
    return Maze(0, setOf(line1, line2, line3, line4, line5, line6, line7))
}
