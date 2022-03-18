package com.bakigoal.trees

/**
 * It is typical to have one function to call on the root
 * and a recursive function with extra parameters
 */
fun printTree(root: Node<Int>) {
    printTree(root, 0, true, "")
}

fun printTree(root: Node<Int>, depth: Int, isLeft: Boolean, prefix: String) {
    val right = root.right
    val left = root.left

    if (right != null) {
        printTree(right, depth + 1, false, prefix + if (isLeft) "│   " else "    ")
    }

    println(prefix + (if (isLeft) "└── " else "┌── ")  + root.value)

    if (left != null) {
        printTree(left, depth + 1, true, prefix + if (isLeft) "    " else "│   ")
    }
}

fun main() {
    val root = Node(
        1,
        left = Node(
            2,
            left = Node(6),
            right = Node(7)
        ),
        right = Node(
            3,
            left = Node(4),
            right = Node(5)
        )
    )
    printTree(root)
}