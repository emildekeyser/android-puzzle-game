package com.example.thewitnesspuzzles.rendering

import com.example.thewitnesspuzzles.model.Line
import com.example.thewitnesspuzzles.model.Node
import com.example.thewitnesspuzzles.model.NodeType
import kotlin.math.abs
import kotlin.math.absoluteValue

class PuzzleConverter(
    private val screenWidth: Int,
    private val screenHeight: Int,
    private val colorPallete: ColorPallete,
    private var absoluteUnit: Float = 0f,
    private var xMove: Float = 0f,
    private var yMove: Float = 0f,
    private val lineThickness: Float = screenWidth * 0.05f,
    private val startNodeRadius: Float = lineThickness,
    private val nodeRadius: Float = startNodeRadius * 0.75f
) {

    fun convertPuzzle(puzzleData: List<Line>):
            Pair<List<RenderableNode>, List<RenderableLine>> {
        val (nodes, lines) = unpack(puzzleData)
        absoluteUnit = calculateAbsoluteUnit(nodes)
        xMove = calculateXMove(nodes)
        yMove = calculateYMove(nodes)
        val renderableLines = lines.map {line -> convertLine(line)}
        val renderableNodes = nodes.map { node -> convertNode(node) }
        return Pair(renderableNodes, renderableLines)
    }

    private fun calculateYMove(nodes: List<Node>): Float {
        val max = (nodes.maxBy { n -> n.yPos})!!.yPos * absoluteUnit
        val min = (nodes.minBy { n -> n.yPos})!!.yPos * absoluteUnit
        val midMaze = (max - min) / 2
        val midScreen = screenHeight / 2f
        return midScreen - midMaze
    }

    private fun calculateXMove(nodes: List<Node>): Float {
        val max = (nodes.maxBy { n -> n.xPos})!!.xPos * absoluteUnit
        val min = (nodes.minBy { n -> n.xPos})!!.xPos * absoluteUnit
        val midMaze = (max - min) / 2
        val midScreen = screenWidth / 2f
        return midScreen - midMaze
    }

    private fun convertLine(line: Line): RenderableLine {
            var (rx1, ry1) = Pair(line.begin.xPos.toFloat(), line.begin.yPos.toFloat())
            var (rx2, ry2) = Pair(line.end.xPos.toFloat(), line.end.yPos.toFloat())

            val ax1 = (rx1 * absoluteUnit) + xMove
            val ay1 = (ry1 * absoluteUnit) + yMove
            val ax2 = (rx2 * absoluteUnit) + xMove
            val ay2 = (ry2 * absoluteUnit) + yMove

            var left:Float
            var top:Float
            var right:Float
            var bottom:Float
            println(ry1)
            println(ry2)
            // TODO: can I remove this if ?
            if (ry1 == ry2){
                left = ax1
                top = ay1 - lineThickness / 2
                right = ax2 //- (lineThickness * 2) // als naar end of start gaat anders volle lengte
                bottom = ay2 + lineThickness / 2
            } else {//if (rx1 == rx2) {
                left = ax1 - lineThickness / 2
                top = ay1
                right = ax2 + lineThickness / 2 // y2 == y1
                bottom = ay2
            }

            val paint = if (line.taken) colorPallete.enabledPaint else colorPallete.disabledPaint
            return RenderableLine(left, top, right, bottom, paint, line)
    }

    private fun calculateAbsoluteUnit(nodes: List<Node>): Float {
        val maxY = (nodes.maxBy { n -> n.yPos.absoluteValue})!!.yPos.absoluteValue + 1
        val maxX = (nodes.maxBy { n -> n.xPos.absoluteValue})!!.xPos.absoluteValue + 1
        val max = listOf(maxX, maxY).max()!!
        val space = screenWidth * 0.1f
        return (screenWidth - space) / max
    }

    private fun convertNode(node: Node): RenderableNode {
            val (rx, ry) = Pair(node.xPos, node.yPos)
            val ax = (rx * absoluteUnit) + xMove
            val ay = (ry * absoluteUnit) + yMove
            val paint = if (node.taken) colorPallete.enabledPaint else colorPallete.disabledPaint
            if (node.nodeType == NodeType.END) {
                val halfSide = startNodeRadius
                val left = ax - halfSide
                val top = ay - halfSide
                val right = ax + halfSide
                val bottom = ay + halfSide
                val absoluteNode = Rectangle(left, top, right, bottom , paint, node)
                return absoluteNode
            } else {
                var r = nodeRadius
                if (node.nodeType == NodeType.START) {
                    r = startNodeRadius
                }
                val absoluteNode = Circle(ax, ay, r, paint, node)
                return absoluteNode
            }
    }

    fun unpack(puzzleData: List<Line>): Pair<MutableList<Node>, List<Line>> {
        var nodes = mutableListOf<Node>()
        var lines = mutableListOf<Line>()
        for (relLine in puzzleData){
            lines.add(relLine)
            nodes.add(relLine.begin)
            nodes.add(relLine.end)
        }
        return Pair(nodes, lines)
    }
}
