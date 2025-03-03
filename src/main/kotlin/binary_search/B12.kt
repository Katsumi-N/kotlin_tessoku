// 答えで二分探索
package binary_search

import kotlin.math.*

fun check(x: Float): Float  {
    return x.pow(3) + x
}

fun main() {
    val n = readln().toInt()

    var left = 0.toFloat()
    var right = 1000000.toFloat()
    while (right - left > 0.001) {
        val mid: Float = (left + right) / 2
        // println(mid)
        if (check(mid.toFloat()) > n) {
            right = mid
        } else {
            left = mid
        }
    }

    println(left)
}

