package com.example.thewitnesspuzzles.rendering

import com.example.thewitnesspuzzles.Node
import com.example.thewitnesspuzzles.NodeType

class PuzzleConverter(
    val screenWidth: Int,
    val screenHeight: Int,
    val colorPallete: ColorPallete
) {

    // TODO: dit maakt nu een hardcoded zwarte dildo, refactor is nodig
    // evt.: beginnen met hen hoekige dildo te maken om middle nodes te testen
    // middle nodes moeten ook een radius hebben om te kunnen touchen
    fun convertPuzzle(puzzleData: Unit):
            Pair<Map<RenderableNode, Node>, Map<RenderableLine, Unit>> {

        val lineThickness = screenWidth * 0.05f
        val startNodeRadius = lineThickness
        val endNodeRadius = lineThickness / 2
        val lineLength = screenWidth - startNodeRadius * 2

        var x = startNodeRadius
        var y = screenHeight / 2f
        val absoluteStart = RenderableNode(x, y, startNodeRadius, colorPallete.disabledPaint)
        val relativeStart = Node(0, 0, NodeType.START)

        var left = x
        var top = y - lineThickness / 2
        var right = left + lineLength
        var bottom = y + lineThickness / 2
        val absoluteLine = RenderableLine(left, top, right, bottom, colorPallete.disabledPaint)
        val relativeline = Unit // = null ==> word later tegoei he (Line())

        x = startNodeRadius + lineLength
//        y = screenHeight / 2f  => same
        val absoluteEnd = RenderableNode(x, y, endNodeRadius, colorPallete.disabledPaint)
        val relativeEnd = Node(0, 0, NodeType.END)

        val nodeMap = mapOf(
            absoluteStart to relativeStart,
            absoluteEnd to relativeEnd
        )
        val lineMap = mapOf(
            absoluteLine to relativeline
        )
        return Pair(nodeMap, lineMap)
    }

    fun nodes(): Map<RenderableNode, Node> {
        val (nodeMap, _) = this.convertPuzzle(Unit) // TODO
        return nodeMap
    }
}
