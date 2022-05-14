import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var change = 1000 - readLine().toInt()
    var count = 0
    val coins = intArrayOf(500,100,50,10,5,1)

    for (i in coins) {
        val value = change / i
        if (value != 0) {
            count += value
            change -= value * i
        }
    }

    println(count)
}