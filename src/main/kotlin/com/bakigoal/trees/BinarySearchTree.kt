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

    fun inOrderPrint(root: Node<T>?) {
        if (root == null) {
            return
        }
        inOrderPrint(root.left)
        print("[ ${root.value} ] ")
        inOrderPrint(root.right)
    }

    fun preOrderPrint(root: Node<T>?) {
        if (root == null) {
            return
        }
        print("[ ${root.value} ] ")
        inOrderPrint(root.left)
        inOrderPrint(root.right)
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

    printTree(bst.root)
    bst.inOrderPrint(bst.root)
    println()
    bst.preOrderPrint(bst.root)
}