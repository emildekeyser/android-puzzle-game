package com.example.thewitnesspuzzles.model

import java.io.Serializable

class Path(
    var pathOfNodes: LinkedHashSet<Node> = LinkedHashSet(),
    var currentNode: Node? = null
): Serializable
