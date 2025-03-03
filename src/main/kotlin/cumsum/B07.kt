package cumsum

fun main() {
    val t = readln().toInt()
    val n = readln().toInt()
    val employee = IntArray(t+1) { 0 }
    repeat(n) {
        val (l, r) = readln().split(" ").map { it.toInt() }
        employee[r]--
        employee[l]++
    }

    (1..t).forEach {
        employee[it] += employee[it-1]
    }

    (1..t).forEach {
        println(employee[it-1])
    }
}
