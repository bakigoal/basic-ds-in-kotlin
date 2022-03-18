package com.bakigoal.trees

data class Node<T: Comparable<T>>(
    val value: T,
    val left: Node<T>? = null,
    val right: Node<T>? = null
)