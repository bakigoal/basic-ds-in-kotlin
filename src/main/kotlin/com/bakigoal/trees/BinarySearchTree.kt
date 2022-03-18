package com.bakigoal.trees

class BinarySearchTree<T : Comparable<T>>(rootData: T) {
    val root: Node<T> = Node(rootData)

    fun insert(data: T) = insert(root, Node(data))

    private fun insert(root: Node<T>, node: Node<T>) {
        if (node.value > root.value) {
            val right = root.right
            if (right == null) {
                root.right = node
            } else {
                insert(right, node)
            }
        } else {
            val left = root.left
            if (left == null) {
                root.left = node
            } else {
                insert(left, node)
            }
        }
    }
}

fun main() {
    val bst = BinarySearchTree(42)
    bst.insert(12)
    bst.insert(1)
    bst.insert(45)
    bst.insert(32)
    bst.insert(77)

    printTree(bst.root)
}