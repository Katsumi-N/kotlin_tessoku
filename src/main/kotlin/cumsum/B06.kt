package cumsum

fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }
    val q = readln().toInt()

    val cumsum = IntArray(n+1) { 0}
    for (i in 1..n) {
        cumsum[i] = cumsum[i-1] + a[i-1]
    }
    repeat(q) {
        val (l, r) = readln().split(" ").map { it.toInt() }
        val res = cumsum[r] - cumsum[l-1]

        when {
            res * 2 > (r - l + 1) -> println("win")
            res * 2 < (r - l + 1) -> println("lose")
            else -> println("draw")
        }
    }
}
