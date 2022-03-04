package com.bakigoal.easy

data class TreeNode(val value: Int, val left: TreeNode? = null, val right: TreeNode? = null) {
    fun prettyPrint(): String = prettyPrintTree(this, "", true)
}

fun prettyPrintTree(node: TreeNode?, prefix: String, isLeft: Boolean): String {
    if (node == null) {
        return "Empty tree"
    }
    val sb = StringBuilder()
    if (node.right != null) {
        sb.append(prettyPrintTree(node.right, prefix + if (isLeft) "│   " else "    ", false))
    }
    val printNode = prefix + (if (isLeft) "└── " else "┌── ") + node.value
    sb.append(printNode)
    sb.append("\n")
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