// 編集距離
package dp

fun main() {
    val s = readln()
    val t = readln()

    val dp = Array(s.length + 1) { IntArray(t.length + 1) }

    /* 初期化 */
    for (i in 0..s.length) {
        dp[i][0] = i
    }

    for (j in 0..t.length) {
        dp[0][j] = j
    }

    /* DP */
    for (i in 1..s.length) {
        for (j in 1..t.length) {
            // 文字が同じ
            if (s[i-1] == t[j-1]) {
                dp[i][j] = dp[i-1][j-1]
            } else {
                // 文字が違う
                dp[i][j] = minOf(
                    dp[i-1][j] + 1, // 削除
                    dp[i][j-1] + 1,
                    dp[i-1][j-1] + 1
                )
            }
        }
    }

    println(dp[s.length][t.length])
}