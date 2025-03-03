package cumsum

fun main() {
    val n = readln().toInt()
    val grid = Array(1501) { IntArray(1501) { 0 } }
    repeat(n) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        grid[x][y]++
    }

    for (i in 1..1500) {
        for (j in 1..1500) {
            grid[i][j] += grid[i][j-1]
        }
    }

    for (i in 1..1500) {
        for (j in 1..1500) {
            grid[i][j] += grid[i-1][j]
        }
    }


    val q = readln().toInt()
    repeat(q) {
        val (a, b, c, d) = readln().split(" ").map { it.toInt() }
        val ans = grid[a-1][b-1] + grid[c][d] - grid[a-1][d] - grid[c][b-1]
        println(ans)
    }
}
