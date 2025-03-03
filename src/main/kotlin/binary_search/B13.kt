// しゃくとり法
package binary_search

import kotlin.collections.ArrayDeque

// 右端固定
fun main(){
    // n, k
    val (n, k) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }
    val deque = ArrayDeque<Int>(n)

    var sum = 0
    var count = 0

    for (i in 0 until n) {
        deque.add(a[i])
        sum += a[i]

        while (sum > k) {
            sum -= deque.removeFirst()
        }

        count += deque.size
    }

    println(count)
}
