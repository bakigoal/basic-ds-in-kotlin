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

    fun preOrderTraversal(action: Consumer<T>) = preOrderTraversal(root, action)

    fun inOrderTraversal(action: Consumer<T>) = inOrderTraversal(root, action)

    fun postOrderTraversal(action: Consumer<T>) = postOrderTraversal(root, action)

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