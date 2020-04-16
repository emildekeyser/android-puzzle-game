package com.example.thewitnesspuzzles

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.thewitnesspuzzles.model.Maze
import com.example.thewitnesspuzzles.model.Node
import com.example.thewitnesspuzzles.rendering.Renderer
import com.example.thewitnesspuzzles.service.MazeFactory
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity: AppCompatActivity() {

    private lateinit var renderer: Renderer
    private lateinit var maze: Maze

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main)
        val service = intent.getSerializableExtra("Extra") as MazeFactory
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels
        // This way if we want to keep the status bar
        //val height = displayMetrics.heightPixels - 75
        val height = displayMetrics.heightPixels
//        val maze = service.createEight()
        maze = service!!.getServiceMaze();
        renderer = Renderer(imageView, resources, width, height)
        renderer.render(maze.getLinesAsList())
        //val overlord = Overlord(renderer, maze)
        this.imageView.setOnTouchListener(View.OnTouchListener { _, event ->
//            this.imageView.layoutParams.width = 1080
//            this.imageView.layoutParams.height = 1920
            val input = Pair(event.x, event.y)
            if(event.action == MotionEvent.ACTION_UP){
                gameUpdate(input)
            }
            return@OnTouchListener true
        })
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun gameUpdate(input: Pair<Float, Float>) {
        val touchedNode = renderer.getTouched(input)
        if (touchedNode != null) {
            maze.updatePath(Pair(touchedNode.xPos, touchedNode.yPos))
        }
//        maze.update(touched) // TODO
        FAKEupdate(touchedNode, maze)
        renderer.render(maze.getLinesAsList())
        if (maze.victorious()) {
            println("VICTORY!!!")
            val intent = Intent(this, VictoryActivity::class.java)
            startActivity(intent)
        }
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


