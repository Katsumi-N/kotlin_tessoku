package binary_search

// 尺取り法
// https://atcoder.jp/contests/arc022/tasks/arc022_2

fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }

    val deque = ArrayDeque<Int>(n)
    var maxLen = 0
    val kind = mutableSetOf<Int>()

    for (i in 0 until n) {
        deque.add(a[i])
        while (kind.contains(a[i])) {
            kind.remove(deque.removeFirst())
        }
        kind.add(a[i])
        maxLen = maxOf(maxLen, deque.size)
    }

    println(maxLen)
}
