package binary_search

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }
    val b = readln().split(" ").map { it.toInt() }
    val c = readln().split(" ").map { it.toInt() }
    val d = readln().split(" ").map { it.toInt() }

    val p = IntArray(n * n)
    val q = IntArray(n * n)

    // a,b -> p
    var pIdx = 0
    a.forEach{ ai ->
        b.forEach { bi ->
            p[pIdx] = ai + bi
            pIdx++
        }
    }

    // c,d -> q
    var qIdx = 0
    c.forEach{ ci ->
        d.forEach { di ->
            q[qIdx] = ci + di
            qIdx++
        }
    }

    q.sort()

    var ans = false
    p.forEach {
        val target = k - it
        val idx = q.binarySearch(target)
        if (idx >= 0) {
            ans = true
            return@forEach // ブロック内のみ終了。@forEachがないとmain関数が終わっちゃう
        }
    }

    println(if (ans) "Yes" else "No")
}
