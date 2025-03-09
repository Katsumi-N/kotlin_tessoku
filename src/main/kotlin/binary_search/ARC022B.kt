// 尺取り法
// https://atcoder.jp/contests/arc022/tasks/arc022_2
package binary_search

fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }

    val deque = ArrayDeque<Int>(n)
    var maxLen = 0
    val kind = mutableSetOf<Int>()

    // 右端を固定して左端を動かす
    // 条件に合わなかったら左端を削除する
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
