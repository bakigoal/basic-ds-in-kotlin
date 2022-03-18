package com.bakigoal.trees

import java.util.function.Consumer

fun <T: Comparable<T>> levelOrderTraversal(root: Node<T>?, action: Consumer<T>) {
    if (root == null) {
        return
    }

    val queue = ArrayDeque<Node<T>>()
    queue.addLast(root)

    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()
        val left = current.left
        val right = current.right

        action.accept(current.value)
        if (left != null) queue.addLast(left)
        if (right != null) queue.addLast(right)
    }
}

fun <T: Comparable<T>> preOrderTraversal(root: Node<T>?, action: Consumer<T>) {
    if (root == null) {
        return
    }

    action.accept(root.value)
    preOrderTraversal(root.left, action)
    preOrderTraversal(root.right, action)
}

fun <T: Comparable<T>> inOrderTraversal(root: Node<T>?, action: Consumer<T>) {
    if (root == null) {
        return
    }

    inOrderTraversal(root.left, action)
    action.accept(root.value)
    inOrderTraversal(root.right, action)
}

fun <T: Comparable<T>> postOrderTraversal(root: Node<T>?, action: Consumer<T>) {
    if (root == null) {
        return
    }

    postOrderTraversal(root.left, action)
    postOrderTraversal(root.right, action)
    action.accept(root.value)
}