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
                    var minRight: Node<T> = root.right!!
                    while (minRight.left != null) {
                        minRight = minRight.left!!
                    }
                    root.copy(value = minRight.value, right = delete(root.right, minRight.value))
                }
            }
        }
        return root
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

    println(bst.toString())
}