package binary_search

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }

    val left = a.slice(0 until n/2)
    val right = a.slice(n/2 until n)

    val leftPattern = mutableListOf<Int>()
    // bit全探索でleftの選び方を列挙
    for (i in 0 until (1 shl left.size)) {
        var sum = 0
        for (j in left.indices) {
            if ((i shr j) and 1 == 1) {
                sum += left[j]
            }
        }
        leftPattern.add(sum)
    }

    val rightPattern = mutableListOf<Int>()
    for (i in 0 until (1 shl right.size)) {
        var sum = 0
        for (j in right.indices) {
            if ((i shr j) and 1 == 1) {
                sum += right[j]
            }
        }
        rightPattern.add(sum)
    }
    rightPattern.sort()

    leftPattern.forEach {
        val target = k - it
        val idx = rightPattern.binarySearch(target)
        if (idx >= 0) {
            println("Yes")
            return
        }
    }

    println("No")
}
