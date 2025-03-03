// 配列の二分探索
package binary_search

fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }.sorted()
    val q = readln().toInt()
    repeat(q) {
        val x = readln().toInt()
        val idx = lowerBound(a, x)
        println(idx)
    }
}

fun lowerBound(a: List<Int>, target: Int): Int {
    var left = 0
    var right = a.size-1

    while (left <= right) {
        val mid = (left + right) / 2
        if (a[mid] < target) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return left
}
