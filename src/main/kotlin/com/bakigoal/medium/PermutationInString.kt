package com.bakigoal.medium

var flag = false

fun checkInclusion(s1: String, s2: String): Boolean {
    permute(s1, s2, 0)
    return flag
}

fun swap(s: String, i0: Int, i1: Int): String {
    if (i0 == i1) return s
    val s1 = s.substring(0, i0)
    val s2 = s.substring(i0 + 1, i1)
    val s3 = s.substring(i1 + 1)
    return s1 + s[i1] + s2 + s[i0] + s3
}

fun permute(s1: String, s2: String, l: Int) {
    var tempS1 = s1
    if (l == tempS1.length) {
        if (s2.indexOf(tempS1) >= 0) flag = true
    } else {
        for (i in l until tempS1.length) {
            tempS1 = swap(tempS1, l, i)
            permute(tempS1, s2, l + 1)
            tempS1 = swap(tempS1, l, i)
        }
    }
}
