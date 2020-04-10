package com.example.thewitnesspuzzles.model

class Path(
    var lines: Set<Line> = emptySet(),
    var currentNode: Node? = null
)
