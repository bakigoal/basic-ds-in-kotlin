package com.bakigoal.trees

class BinarySearchTree<T : Comparable<T>>(rootData: T) {
    private var root: Node<T>? = Node(rootData)

    fun insert(data: T) = insert(root, Node(data))

    private fun insert(root: Node<T>?, node: Node<T>) {
        if (root == null) {
            return
        }
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

    fun delete(value: T) {
        root = delete(root, value)
    }

    private fun delete(root: Node<T>?, value: T): Node<T>? {
        if (root == null) {
            return root
        }

        when {
            value < root.value -> root.left = delete(root.left, value)
            value > root.value -> root.right = delete(root.right, value)
            else -> return when {
                // case 1 : Leaf
                root.left == null && root.right == null -> null
                // case 2 : One Child
                root.left == null -> root.right
                root.right == null -> root.left
                // case 3 : Two children
                else -> {
                    val rightMin: Node<T> = min(root.right!!)
                    root.copy(value = rightMin.value, right = delete(root.right, rightMin.value))
                }
            }
        }
        return root
    }

    fun min() = min(root!!)

    private fun min(node: Node<T>): Node<T> {
        var left = node
        while (left.left != null) left = left.left!!
        return left
    }

    fun max() = max(root!!)

    private fun max(node: Node<T>): Node<T> {
        var right = node
        while (right.right != null) right = right.right!!
        return right
    }

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
    bst.insert(99)

    println(bst.toString())

    bst.delete(42)
    bst.delete(33)
    bst.delete(99)
    bst.delete(1)

    println(bst.toString())

    println()
    println("min: ${bst.min().value}")
    println("max: ${bst.max().value}")
}