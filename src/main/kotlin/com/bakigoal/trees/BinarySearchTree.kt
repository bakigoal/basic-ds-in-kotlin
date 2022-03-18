package com.bakigoal.trees

class BinarySearchTree<T : Comparable<T>>(rootData: T) {
    private val root: Node<T> = Node(rootData)

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

    fun delete(value: T) = delete(root, value)

    private fun delete(root: Node<T>?, value: T) {
        if (root == null) {
            return
        }

        var node = root

        while (true) {
            when {
                value < node.value -> delete(root.left, value)
                value > node.value -> delete(root.right, value)
                else -> {
                    // case 1: leaf
                    if (isLeaf(root)) {
//                        root = null
                    }
                }
            }
        }



    }

    private fun isLeaf(root: Node<T>) = root.left == null && root.right == null

    override fun toString(): String {
        return root.toString()
    }
}

fun main() {
    val bst = BinarySearchTree(42)
    bst.insert(12)
    bst.insert(1)
    bst.insert(45)
    bst.insert(33)
    bst.insert(38)
    bst.insert(98)
    bst.insert(32)
    bst.insert(77)

    println(bst.toString())
}