package com.example.thewitnesspuzzles.rendering

import com.example.thewitnesspuzzles.model.Line
import com.example.thewitnesspuzzles.model.Node
import com.example.thewitnesspuzzles.model.NodeType
import kotlin.math.absoluteValue

class PuzzleConverter(
    private val screenWidth: Int,
    private val screenHeight: Int,
    private val colorPalette: ColorPalette,
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
        val renderableLines = lines.map { line -> convertLine(line)}
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
            val (rx1, ry1) = Pair(line.begin.xPos.toFloat(), line.begin.yPos.toFloat())
            val (rx2, ry2) = Pair(line.end.xPos.toFloat(), line.end.yPos.toFloat())

            val ax1 = (rx1 * absoluteUnit) + xMove
            val ay1 = (ry1 * absoluteUnit) + yMove
            val ax2 = (rx2 * absoluteUnit) + xMove
            val ay2 = (ry2 * absoluteUnit) + yMove

            val left:Float
            val top:Float
            val right:Float
            val bottom:Float
            println(ry1)
            println(ry2)
        // TODO: this needs to be reworked to support diagonal
        // can I remove this, use vector product ??
        if (ry1 == ry2){ // horizontale lijn
                left = ax1
                top = ay1 - lineThickness / 2
                right = ax2 //- (lineThickness * 2) // als naar end of start gaat anders volle lengte
                bottom = ay2 + lineThickness / 2
            } else {//if (rx1 == rx2) { // verticale lijn
                left = ax1 - lineThickness / 2
                top = ay1
                right = ax2 + lineThickness / 2 // y2 == y1
                bottom = ay2
            }

            val paint = if (line.taken) colorPalette.enabledPaint else colorPalette.disabledPaint
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
            val paint = if (node.taken) colorPalette.enabledPaint else colorPalette.disabledPaint
        return if (node.nodeType == NodeType.END) {
            val halfSide = startNodeRadius
            val left = ax - halfSide
            val top = ay - halfSide
            val right = ax + halfSide
            val bottom = ay + halfSide
            Rectangle(left, top, right, bottom , paint, node)
        } else {
            var r = nodeRadius
            if (node.nodeType == NodeType.START) {
                r = startNodeRadius
            }
            Circle(ax, ay, r, paint, node)
        }
    }

    private fun unpack(puzzleData: List<Line>): Pair<MutableList<Node>, List<Line>> {
        val nodes = mutableListOf<Node>()
        val lines = mutableListOf<Line>()
        for (relLine in puzzleData){
            lines.add(relLine)
            nodes.add(relLine.begin)
            nodes.add(relLine.end)
        }
        return Pair(nodes, lines)
    }
}
