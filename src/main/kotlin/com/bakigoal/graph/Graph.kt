package com.bakigoal.graph

data class Graph<T : Comparable<T>>(
    val nodes: Set<GraphNode<T>>,
    val edges: Set<Edge<T>>
)

data class GraphNode<T : Comparable<T>>(
    val data: T
){
    override fun toString() = data.toString()
}

data class Edge<T : Comparable<T>>(
    val from: GraphNode<T>,
    val to: GraphNode<T>
){
    override fun toString() = "{$from -> $to}"
}

fun main() {
    val nodes = ArrayList<GraphNode<Int>>()
    val edges = HashSet<Edge<Int>>()

    for (i in 1..6) {
        nodes.add(GraphNode(i))
    }
    edges.add(Edge(nodes[0], nodes[1]))
    edges.add(Edge(nodes[1], nodes[2]))
    edges.add(Edge(nodes[2], nodes[3]))
    edges.add(Edge(nodes[2], nodes[4]))
    edges.add(Edge(nodes[3], nodes[4]))
    edges.add(Edge(nodes[4], nodes[5]))
    edges.add(Edge(nodes[1], nodes[5]))

    val graph = Graph(HashSet(nodes), edges)

    println(graph)
}

