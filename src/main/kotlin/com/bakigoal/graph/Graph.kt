package com.bakigoal.graph

import java.util.function.Consumer

data class Graph<T : Comparable<T>>(
    val nodes: Set<GraphNode<T>>,
    val edges: Set<Edge<T>>
) {
    fun adjacentNodes(node: GraphNode<T>): List<GraphNode<T>> {
        val list = ArrayList<GraphNode<T>>()
        for (edge in edges) {
            if (edge.from == node) {
                list += edge.to
            }
            if (edge.to == node) {
                list += edge.from
            }
        }
        return list
    }

    fun dfs(action: Consumer<T>) = dfs(nodes.first(), mutableSetOf(), this::adjacentNodes, action)

    fun bfs(action: Consumer<T>) = bfs(nodes.first(), this::adjacentNodes, action)
}

data class GraphNode<T : Comparable<T>>(
    val data: T
) {
    override fun toString() = data.toString()
}

data class Edge<T : Comparable<T>>(
    val from: GraphNode<T>,
    val to: GraphNode<T>,
    val weight: Int = 1
) {
    override fun toString() = "{$from -> $to}"
}

fun main() {
    val nodes = ArrayList<GraphNode<Int>>()
    val edges = HashSet<Edge<Int>>()

    for (i in 0..4) {
        nodes.add(GraphNode(i))
    }
    edges.add(Edge(nodes[0], nodes[1]))
    edges.add(Edge(nodes[0], nodes[3]))
    edges.add(Edge(nodes[3], nodes[4]))
    edges.add(Edge(nodes[1], nodes[2]))
    edges.add(Edge(nodes[2], nodes[3]))

    val graph = Graph(HashSet(nodes), edges)

    println(graph)
    val adjacentNodes = graph.adjacentNodes(nodes[1])
    println(adjacentNodes)

    graph.dfs { println("dfs: $it") }
    println()
    graph.bfs { println("bfs: $it") }
}

