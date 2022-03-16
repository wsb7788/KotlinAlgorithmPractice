import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    while (true) {
        val input = readLine() ?: break
        val answer = getAnswer(input)
        bufferedWriter.append("$answer\n")
    }

    bufferedWriter.flush()
    bufferedWriter.close()
    close()
}

fun getAnswer(input: String): Int {
    var result = 1
    var num = 1
    var modSum = 0
    while (true) {
        val mod = num % input.toInt()
        modSum += mod
        if (modSum % input.toInt() == 0) {
            break
        }
        result++
        num = mod * 10
    }
    return result
}