package com.bakigoal.trees

import java.util.function.Consumer

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

    fun lowestCommonAncestor(nodeValue1: T, nodeValue2: T) =
        lowestCommonAncestor(root, Node(nodeValue1), Node(nodeValue2))

    private fun lowestCommonAncestor(root: Node<T>?, node1: Node<T>, node2: Node<T>): Node<T>? {
        if (root == null) {
            return null
        }

        val v1 = node1.value
        val v2 = node2.value
        val currentValue = root.value
        return when {
            currentValue == v1 || currentValue == v2 -> root
            currentValue >= v1 && currentValue < v2 -> root
            currentValue >= v2 && currentValue < v1 -> root
            currentValue > v1 && currentValue > v2 -> lowestCommonAncestor(root.left, node1, node2)
            else -> lowestCommonAncestor(root.right, node1, node2)
        }
    }

    fun levelOrderTraversal(action: Consumer<T>) = levelOrderTraversal(root, action)

    private fun levelOrderTraversal(root: Node<T>?, action: Consumer<T>) {
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
    println("lowest ancestor (1, 32): ${bst.lowestCommonAncestor(1, 32)?.value}")
    println("lowest ancestor (77, 33): ${bst.lowestCommonAncestor(77, 33)?.value}")
    println("lowest ancestor (45, 99): ${bst.lowestCommonAncestor(45, 99)?.value}")
    println()

    bst.delete(42)
    bst.delete(33)
    bst.delete(99)
    bst.delete(1)

    println(bst.toString())

    println()
    println("min: ${bst.min().value}")
    println("max: ${bst.max().value}")
    bst.levelOrderTraversal { println("value $it") }
}