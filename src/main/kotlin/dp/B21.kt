// 区間DP
package dp

import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val s = readln()

    val dp = Array(n+1) { IntArray(n+1) }

    /* 初期化 */
    // 1文字
    for (i in 0 until n) {
        dp[i][i] = 1
    }

    // 2文字
    for (i in 0 until n-1) {
        if (s[i] == s[i+1]) {
            dp[i][i+1] = 2
        } else {
            dp[i][i+1] = 1
        }
    }

    /* DP */
    for (len in 2 until n) {
        for (l in 0 until n-len) {
            val r = l + len
            if (s[l] == s[r]) {
                dp[l][r] = maxOf(dp[l+1][r], dp[l][r-1], dp[l+1][r-1] + 2)
            } else {
                dp[l][r] = max(dp[l+1][r], dp[l][r-1])
            }
        }
    }

    println(dp[0][n-1])

}