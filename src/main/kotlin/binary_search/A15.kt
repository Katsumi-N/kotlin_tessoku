// 座標圧縮
package binary_search

fun main() {
    val n = readln().trim().toInt()
    val a = readln().trim().split(" ").filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()

    val ans = compression(a.toList())
    println(ans.joinToString(" "))
}

fun compression(a: List<Int>): List<Int> {
    val x = a.distinct().sorted()

    return a.map { x.binarySearch(it) + 1 }
}
