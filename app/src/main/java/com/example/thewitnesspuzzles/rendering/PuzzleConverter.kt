package com.example.thewitnesspuzzles.rendering

import com.example.thewitnesspuzzles.model.Line
import com.example.thewitnesspuzzles.model.Node
import com.example.thewitnesspuzzles.model.NodeType
import kotlin.math.absoluteValue

class PuzzleConverter(
    private val screenWidth: Int,
    private val screenHeight: Int,
    private val colorPallete: ColorPallete,
    private var absoluteUnit: Float = 0f
) {

    fun convertPuzzle(puzzleData: List<Line>):
            Pair<List<RenderableNode>, List<RenderableLine>> {
        val (nodes, lines) = unpack(puzzleData)
        absoluteUnit = calculateAbsoluteUnit(nodes)
        val nodeZero = calculateNodeZeroZero(nodes)
        val renderableLines = convertLines(nodeZero, lines)
        val renderableNodes = convertNodes(nodeZero, nodes)
        return Pair(renderableNodes, renderableLines)
    }

    private fun convertLines(nodeZero: RenderableNode, lines: List<Line>): List<RenderableLine> {
        val lineThickness = screenWidth * 0.05f
        val renderableLines = mutableListOf<RenderableLine>()
        for (line in lines) {
            var (rx1, ry1) = Pair(line.begin.xPos.toFloat(), line.begin.yPos.toFloat())
            var (rx2, ry2) = Pair(line.end.xPos.toFloat(), line.end.yPos.toFloat())

            val ax1 = nodeZero.x + (rx1 * absoluteUnit)
            val ay1 = nodeZero.y + (ry1 * absoluteUnit)

            val ax2 = nodeZero.x + (rx2 * absoluteUnit)
            val ay2 = nodeZero.y + (ry2 * absoluteUnit)

            var left:Float
            var top:Float
            var right:Float
            var bottom:Float
            println(ry1)
            println(ry2)
            // TODO: maybe remove this if
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
            val absoluteLine = RenderableLine(left, top, right, bottom, colorPallete.disabledPaint, line)
            println("------------------------------------------------------------")
            println(absoluteLine)
            println("------------------------------------------------------------")
            renderableLines.add(absoluteLine)
        }
        return renderableLines
    }

    private fun calculateAbsoluteUnit(nodes: List<Node>): Float {
        val maxY = (nodes.maxBy { n -> n.yPos.absoluteValue})!!.yPos.absoluteValue + 1
        val maxX = (nodes.maxBy { n -> n.xPos.absoluteValue})!!.xPos.absoluteValue + 1
        val max = listOf(maxX, maxY).max()!!
        val space = screenWidth * 0.1f
        return (screenWidth - space) / max
    }

    private fun convertNodes(nodeZero: RenderableNode, nodes: List<Node>): List<RenderableNode> {
        val renderableNodes = mutableListOf<RenderableNode>(nodeZero) // TODO ??
        for (node in nodes){
            if (node.nodeType == NodeType.END) {
                val (rx, ry) = Pair(node.xPos, node.yPos)
                val ax = nodeZero.x + (rx * absoluteUnit)
                val ay = nodeZero.y + (ry * absoluteUnit)
                val endNodeRadius = screenWidth * 0.025f // TODO
                val absoluteEnd = RenderableNode(ax, ay, endNodeRadius, colorPallete.disabledPaint, node)
                renderableNodes.add(absoluteEnd)
            }
        }
        return renderableNodes
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

    /* TODO: Dont do it this way, just take 0px,0px as starting point then calculate the whole
    maze, then at the end move point 0,0 to the correct spot depending on total w and h */
    private fun calculateNodeZeroZero(nodes: MutableList<Node>): RenderableNode {
        var startcolor = colorPallete.disabledPaint

        val maxY = (nodes.maxBy { n -> n.yPos.absoluteValue})!!.yPos
        val maxX = (nodes.maxBy { n -> n.xPos.absoluteValue})!!.xPos

        val lineThickness = screenWidth * 0.05f // TODO make class field ?
        val startNodeRadius = lineThickness
//        val endNodeRadius = lineThickness / 2
//        val lineLength = screenWidth - startNodeRadius * 2

//        var x = startNodeRadius + (screenWidth / (maxX + 2f)) // TODO also make class field ?
        var x = screenWidth / (maxX.absoluteValue + 2f)
        var y = screenHeight / (maxY.absoluteValue + 2f)

        if (maxX < 0) {
            x = screenWidth - x
        }
        if (maxY < 0) {
            y = screenHeight - y
        }
//        var x = startNodeRadius + absoluteUnit * (maxX + 1)
//        val y = absoluteUnit * (maxY + 1)
        var startref = Node(0, 0, NodeType.START, false)
        for (n in nodes){
            if (n.xPos == 0 && n.yPos == 0) {
                startref = n
                nodes.remove(n)
                break
            }
        }
        val absoluteStart = RenderableNode(x, y, startNodeRadius, startcolor, startref) // FAKE
        return absoluteStart
    }
}
