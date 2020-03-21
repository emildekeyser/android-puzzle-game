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
        return fake()
    }

    // hardcoded
    fun fake(): Pair<List<RenderableNode>, List<RenderableLine>> {
        var startcolor = colorPallete.disabledPaint
        var lineAndEndColor = colorPallete.disabledPaint

        val lineThickness = screenWidth * 0.05f
        val startNodeRadius = lineThickness
        val endNodeRadius = lineThickness / 2
        val lineLength = screenWidth - startNodeRadius * 2

        var x = startNodeRadius
        val y = screenHeight / 2f
//        val absoluteStart = RenderableNode(x, y, startNodeRadius, colorPallete.disabledPaint)
        val absoluteStart = RenderableNode(x, y, startNodeRadius, startcolor) // FAKE
        val relativeStart =
            Node(0, 0, NodeType.START, false)

        val left = x
        val top = y - lineThickness / 2
        val right = left + lineLength
        val bottom = y + lineThickness / 2
//        val absoluteLine = RenderableLine(left, top, right, bottom, colorPallete.disabledPaint)
        val absoluteLine = RenderableLine(left, top, right, bottom, lineAndEndColor)
        val relativeline = Unit // = null ==> word later tegoei he (Line())

        x = startNodeRadius + lineLength
//        y = screenHeight / 2f  => same
//        val absoluteEnd = RenderableNode(x, y, endNodeRadius, colorPallete.disabledPaint)
        val absoluteEnd = RenderableNode(x, y, endNodeRadius, lineAndEndColor)
        val relativeEnd =
            Node(0, 0, NodeType.END, false)

//        val nodeMap = mapOf(
//            absoluteStart to relativeStart,
//            absoluteEnd to relativeEnd
//        )
//        val lineMap = mapOf(
//            absoluteLine to relativeline
//        )
        val nodes = listOf(absoluteStart, absoluteEnd)
        val lines = listOf(absoluteLine)
        return Pair(nodes, lines)
    }

    // get from cache ?
    fun nodes(): Map<RenderableNode, Node> {
        return mapOf() // TODO
    }
}
