package dp

import kotlin.math.abs

fun main(){
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }

    val dp = IntArray(n+1) { 0 }
    dp[1] = abs(a[1] - a[0])

    for (i in 2 until n) {
        dp[i] = minOf(abs(a[i] - a[i-1]) + dp[i-1], abs(a[i] - a[i-2]) + dp[i-2])
    }

//    println(dp.toList())
    println(dp[n-1])
}