package com.example.thewitnesspuzzles.model

import java.io.Serializable

class Path(
    var lines: Set<Line> = emptySet(),
    var currentNode: Node? = null
): Serializable {
}
