package com.bakigoal.easy

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 */
fun middleNode(head: ListNode?): ListNode? {
    val map = HashMap<Int, ListNode>()
    var index = 0
    var current = head
    while (current != null) {
        map[index++] = current
        current = current.next
    }
    if (index % 2 != 0) {
        index++
    }
    return map[index / 2]
}

fun middleNode2(head: ListNode?): ListNode? {
    var current = head
    var middle = head
    var counter = 0
    while (current != null) {
        current = current.next
        if (counter++ % 2 != 0 && middle != null) {
            middle = middle.next
        }
    }
    return middle
}