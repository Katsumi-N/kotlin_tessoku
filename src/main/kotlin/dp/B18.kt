package dp

fun main() {
    val (n, s) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }

    val dp = Array(n + 1) { BooleanArray(s + 1) }

    dp[0][0] = true

    for (i in 0 until n) {
        for (j in 0..s) {
            if (dp[i][j]) {
                dp[i+1][j] = true
                if (j + a[i] <= s) {
                    dp[i+1][j + a[i]] = true
                }
            }
        }
    }

    if (!dp[n][s]) {
        println(-1)
        return
    }

    // 復元
    val ans = mutableListOf<Int>()
    var place = s
    for (i in n downTo 1) {
        if (dp[i-1][place]) {
            continue
        }
        place -= a[i-1]
        ans.add(i)
    }

    ans.reverse()
    println(ans.size)
    println(ans.joinToString(" "))
}