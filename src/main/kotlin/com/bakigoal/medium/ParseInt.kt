package com.bakigoal.medium

fun myAtoi(s: String): Int {
    var result = 0L
    var overflow = false
    var sign = 1
    val numbers = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

    val trim = s.trim()
    for (i in trim.indices) {
        val char = trim[i]
        if (i == 0) {
            if (char == '-' || char == '+'){
                sign = if (char == '-') -1 else 1
                continue
            }
        }

        if (char in numbers) {
            val value = Integer.parseInt(char.toString())
            if ((Int.MAX_VALUE - value) / 10 < result) {
                overflow = true
                break
            }
            result = result * 10 + value
            continue
        }
        break
    }

    if (overflow) {
        return if (sign < 0) Int.MIN_VALUE else Int.MAX_VALUE
    }

    return result.toInt() * sign
}