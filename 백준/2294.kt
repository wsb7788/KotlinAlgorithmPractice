/*문제
n가지 종류의 동전이 있다. 이 동전들을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 그러면서 동전의 개수가 최소가 되도록 하려고 한다. 각각의 동전은 몇 개라도 사용할 수 있다.

사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.

입력
첫째 줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 다음 n개의 줄에는 각각의 동전의 가치가 주어진다. 동전의 가치는 100,000보다 작거나 같은 자연수이다. 가치가 같은 동전이 여러 번 주어질 수도 있다.

출력
첫째 줄에 사용한 동전의 최소 개수를 출력한다. 불가능한 경우에는 -1을 출력한다.*/

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

private var n = 0
private var k = 0
private lateinit var coins: IntArray
private lateinit var cache: IntArray

fun main() {
    init()
    solve()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        k = nextToken().toInt()
    }
    coins = IntArray(n) {
        readLine().toInt()
    }
    coins.sort()
    cache = IntArray(k + 1) { Int.MAX_VALUE }
    close()
}

private fun solve() {
    for (i in 0 until n) {
        for (j in 1..k) {
            if (j % coins[i] == 0) {
                cache[j] = j / coins[i]
            } else if (j - coins[i] in 1..k && cache[j - coins[i]] != Int.MAX_VALUE) {
                cache[j] = min(cache[j], cache[j - coins[i]] + 1)
            }
        }
    }
    println(if (cache[k] == Int.MAX_VALUE) - 1 else cache[k])
}