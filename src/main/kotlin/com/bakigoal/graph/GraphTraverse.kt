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