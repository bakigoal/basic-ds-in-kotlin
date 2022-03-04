package com.bakigoal.easy

data class ListNode(var `val`: Int, var next: ListNode? = null) {
    override fun toString(): String {
        return "$`val` -> ${next?.toString()}"
    }
}

/**
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var node1 = l1
    var node2 = l2
    var memory = 0

    var value1 = node1?.`val` ?: 0
    var value2 = node2?.`val` ?: 0
    var sum = value1 + value2 + memory
    memory = sum / 10
    var curValue = sum % 10
    val result = ListNode(curValue)
    var currentNode = result

    while (node1?.next != null || node2?.next != null) {
        node1 = node1?.next
        node2 = node2?.next

        value1 = node1?.`val` ?: 0
        value2 = node2?.`val` ?: 0
        sum = value1 + value2 + memory
        memory = sum / 10
        curValue = sum % 10
        currentNode.next = ListNode(curValue)
        currentNode = currentNode.next!!
    }

    if (memory > 0) {
        currentNode.next = ListNode(memory)
    }

    return result
}