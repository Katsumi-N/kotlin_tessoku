package dp

const val POSITIVE_INFINITY = 1_000_000_001
fun main(){
    val (n, w) = readln().split(" ").map { it.toInt() }
    val wv = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until n) {
        val (wi, vi) = readln().split(" ").map { it.toInt() }
        wv.add(Pair(wi, vi))
    }

    val sumValue = wv.sumOf { it.second }

    val dp = Array(n + 1) { IntArray(sumValue + 1) }
    for (i in 0..n) {
        for (j in 0..sumValue ) {
            dp[i][j] = POSITIVE_INFINITY
        }
    }
    dp[0][0] = 0

    for (i in 0 until n) { // i番目までの品物
        for (j in 0..sumValue) { // 価値
            if (dp[i][j] == POSITIVE_INFINITY) {
                continue
            }

            dp[i+1][j] = minOf(dp[i+1][j], dp[i][j]) // i番目を選ばない

            if (j + wv[i].second <= sumValue) {
                dp[i+1][j + wv[i].second] = minOf(dp[i+1][j + wv[i].second], dp[i][j] + wv[i].first) // i番目を選ぶ
            }

        }
    }

    var ans = 0
    for (i in 0..sumValue) {
        if (dp[n][i] <= w) {
            ans = i
        }
    }
    println(ans)
}