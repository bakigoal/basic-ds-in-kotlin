package com.bakigoal.trees

fun isSameTrees(root1: Node<Int>?, root2: Node<Int>?): Boolean {
    if (root1 == null && root2 == null) {
        return true
    }
    if (root1 == null || root2 == null) {
        return false
    }
    return root1.value.compareTo(root2.value) == 0
            && isSameTrees(root1.left, root2.left)
            && isSameTrees(root1.right, root2.right)
}

fun main() {
    val tree1 = Node(12, Node(1), Node(3, Node(2, Node(5))))
    val tree2 = Node(12, Node(1), Node(3, Node(2, Node(5))))
    val tree3 = Node(12, Node(1), Node(4, Node(2, Node(5))))
    println(isSameTrees(tree1, tree2))
    println(isSameTrees(tree1, tree3))
}