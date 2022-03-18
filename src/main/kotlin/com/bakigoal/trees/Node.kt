package com.bakigoal.trees

data class Node<T: Comparable<T>>(
    val value: T,
    var left: Node<T>? = null,
    var right: Node<T>? = null
)