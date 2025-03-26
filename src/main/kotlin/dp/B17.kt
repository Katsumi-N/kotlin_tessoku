// 復元
// dp[x] = dp[x-1] + abs(a[x] - a[x-1]) または dp[x-2] + abs(a[x] - a[x-2])
package dp

import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }

    val dp = IntArray(n+1) { 0 }
    dp[1] = abs(a[1] - a[0])

    for (i in 2 until n) {
        dp[i] = minOf(abs(a[i] - a[i-1]) + dp[i-1], abs(a[i] - a[i-2]) + dp[i-2])
    }

    // 復元
    val ans = mutableListOf<Int>()
    var place = n - 1
    while (place >= 0) {
        ans.add(place+1)
        place = if (place == 0 || dp[place] == dp[place-1] + abs(a[place] - a[place-1])) {
            place - 1
        } else {
            place - 2
        }
    }

    ans.reverse()
    println(ans.size)
    println(ans.joinToString(" "))
}