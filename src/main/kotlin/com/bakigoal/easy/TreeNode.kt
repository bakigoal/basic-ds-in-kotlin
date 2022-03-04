package com.bakigoal.easy

data class TreeNode(val value: Int, val left: TreeNode? = null, val right: TreeNode? = null)

fun TreeNode.prettyPrint() = prettyPrintTree(this, "", true)

fun prettyPrintTree(node: TreeNode?, prefix: String, isLeft: Boolean): String {
    if (node == null) {
        return "Empty tree"
    }
    val sb = StringBuilder()

    // print right
    if (node.right != null) {
        sb.append(prettyPrintTree(node.right, prefix + if (isLeft) "│   " else "    ", false))
    }

    // print value
    sb.append(prefix + (if (isLeft) "└── " else "┌── ") + node.value).append("\n")

    // print left
    if (node.left != null) {
        sb.append(prettyPrintTree(node.left, prefix + if (isLeft) "    " else "│   ", true))
    }

    return sb.toString()
}

fun main() {
    val treeNode = TreeNode(1, TreeNode(3), TreeNode(2))
    val prettyPrint = treeNode.prettyPrint()

    println()
    println(prettyPrint)
}