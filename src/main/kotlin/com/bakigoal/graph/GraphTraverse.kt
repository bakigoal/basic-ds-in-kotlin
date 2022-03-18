package com.bakigoal.graph

import java.util.function.Consumer
import java.util.function.Function

fun <T : Comparable<T>> dfs(
    node: GraphNode<T>,
    visited: MutableSet<GraphNode<T>>,
    adjacentListSupplier: Function<GraphNode<T>, List<GraphNode<T>>>,
    action: Consumer<T>
) {
    if (visited.contains(node)) {
        return
    }
    visited += node

    action.accept(node.data)

    for (adjacent in adjacentListSupplier.apply(node)) {
        dfs(adjacent, visited, adjacentListSupplier, action)
    }
}

fun <T : Comparable<T>> bfs(
    node: GraphNode<T>,
    adjacentListSupplier: Function<GraphNode<T>, List<GraphNode<T>>>,
    action: Consumer<T>
) {
    val visited = mutableSetOf<GraphNode<T>>()
    val queue = ArrayDeque<GraphNode<T>>()
    queue.addLast(node)

    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 1..size) {
            val current = queue.removeFirst()
            if (visited.contains(current)) {
                continue
            }
            action.accept(current.data)
            visited += current

            for (adjacent in adjacentListSupplier.apply(current)) {
                queue.addLast(adjacent)
            }
        }
    }
}