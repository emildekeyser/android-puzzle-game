package com.example.thewitnesspuzzles.rendering

import com.example.thewitnesspuzzles.model.Line
import com.example.thewitnesspuzzles.model.Node
import com.example.thewitnesspuzzles.model.NodeType

class PuzzleConverter(
    private val screenWidth: Int,
    private val screenHeight: Int,
    private val colorPallete: ColorPallete
) {

    // TODO: dit maakt nu een hardcoded zwarte dildo, refactor is nodig
    // evt.: beginnen met hen hoekige dildo te maken om middle nodes te testen
    // middle nodes moeten ook een radius hebben om te kunnen touchen
    fun convertPuzzle(puzzleData: List<Line>):
            Pair<List<RenderableNode>, List<RenderableLine>> {
        val (nodes, lines) = unpack(puzzleData)
        val nodeZero = calculateNodeZeroZero()
        val renderableLines = convertLines(nodeZero, lines)
        val renderableNodes = convertNodes(nodeZero, nodes)
        return Pair(renderableNodes, renderableLines)
    }

    private fun convertLines(nodeZero: RenderableNode, lines: List<Line>): List<RenderableLine> {
        val au = absoluteUnit()
        val lineThickness = screenWidth * 0.05f
        val renderableLines = mutableListOf<RenderableLine>()
        for (line in lines) {
            var (rx1, ry1) = Pair(line.begin.xPos.toFloat(), line.begin.yPos.toFloat())
            var (rx2, ry2) = Pair(line.end.xPos.toFloat(), line.end.yPos.toFloat())

            val ax1 = nodeZero.x + (rx1 * au)
            val ay1 = nodeZero.y + (ry1 * au)

            val ax2 = nodeZero.x + (rx2 * au)
            val ay2 = nodeZero.y + (ry2 * au)

            var left:Float
            var top:Float
            var right:Float
            var bottom:Float
            println(ry1)
            println(ry2)
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
            val absoluteLine = RenderableLine(left, top, right, bottom, colorPallete.disabledPaint)
            println("------------------------------------------------------------")
            println(absoluteLine)
            println("------------------------------------------------------------")
            renderableLines.add(absoluteLine)
        }
        return renderableLines
    }

    private fun absoluteUnit(): Float {
        val maxRelativeLength = 1f // TODO
        val space = screenWidth * 0.1f
        return (screenWidth - space) / maxRelativeLength
    }

    private fun convertNodes(nodeZero: RenderableNode, nodes: List<Node>): List<RenderableNode> {
        val au = absoluteUnit()
        val renderableNodes = mutableListOf<RenderableNode>(nodeZero) // TODO ??
        for (node in nodes){
            if (node.nodeType == NodeType.END) {
                val (rx, ry) = Pair(node.xPos, node.yPos)
                val ax = nodeZero.x + (rx * au)
                val ay = nodeZero.y + (ry * au)
                val endNodeRadius = screenWidth * 0.025f // TODO
                val absoluteEnd = RenderableNode(ax, ay, endNodeRadius, colorPallete.disabledPaint)
                renderableNodes.add(absoluteEnd)
            }
        }
        return renderableNodes
    }

    fun unpack(puzzleData: List<Line>): Pair<List<Node>, List<Line>> {
        var nodes = mutableListOf<Node>()
        var lines = mutableListOf<Line>()
        for (relLine in puzzleData){
            lines.add(relLine)
            nodes.add(relLine.begin)
            nodes.add(relLine.end)
        }
        for (n in nodes){
            if (n.xPos == 0 && n.yPos == 0) {
                nodes.remove(n)
                break
            }
        }
        return Pair(nodes, lines)
    }

    private fun calculateNodeZeroZero(): RenderableNode {
        var startcolor = colorPallete.disabledPaint
//        var lineAndEndColor = colorPallete.disabledPaint

        val lineThickness = screenWidth * 0.05f
        val startNodeRadius = lineThickness
//        val endNodeRadius = lineThickness / 2
//        val lineLength = screenWidth - startNodeRadius * 2

        var x = startNodeRadius
        val y = screenHeight / 2f
        val absoluteStart = RenderableNode(x, y, startNodeRadius, startcolor) // FAKE
        return absoluteStart
    }

    // hardcoded
//    fun fake(): Pair<List<RenderableNode>, List<RenderableLine>> {
//        var startcolor = colorPallete.disabledPaint
//        var lineAndEndColor = colorPallete.disabledPaint
//
//        val lineThickness = screenWidth * 0.05f
//        val startNodeRadius = lineThickness
//        val endNodeRadius = lineThickness / 2
//        val lineLength = screenWidth - startNodeRadius * 2
//
//        var x = startNodeRadius
//        val y = screenHeight / 2f
////        val absoluteStart = RenderableNode(x, y, startNodeRadius, colorPallete.disabledPaint)
//        val absoluteStart = RenderableNode(x, y, startNodeRadius, startcolor) // FAKE
//        val relativeStart =
//            Node(0, 0, NodeType.START, false)
//
//        val left = x
//        val top = y - lineThickness / 2
//        val right = left + lineLength
//        val bottom = y + lineThickness / 2
////        val absoluteLine = RenderableLine(left, top, right, bottom, colorPallete.disabledPaint)
//        val absoluteLine = RenderableLine(left, top, right, bottom, lineAndEndColor)
//        val relativeline = Unit // = null ==> word later tegoei he (Line())
//
//        x = startNodeRadius + lineLength
////        y = screenHeight / 2f  => same
////        val absoluteEnd = RenderableNode(x, y, endNodeRadius, colorPallete.disabledPaint)
//        val absoluteEnd = RenderableNode(x, y, endNodeRadius, lineAndEndColor)
//        val relativeEnd =
//            Node(0, 0, NodeType.END, false)
//
////        val nodeMap = mapOf(
////            absoluteStart to relativeStart,
////            absoluteEnd to relativeEnd
////        )
////        val lineMap = mapOf(
////            absoluteLine to relativeline
////        )
//        val nodes = listOf(absoluteStart, absoluteEnd)
//        val lines = listOf(absoluteLine)
//        return Pair(nodes, lines)
//    }

    // get from cache ?
    fun getNodes(): Map<RenderableNode, Node> {
        return mapOf() // TODO
    }
}
