
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main()  {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val st1 = StringTokenizer(br.readLine())
        val A = Integer.parseInt(st1.nextToken())
        val B = Integer.parseInt(st1.nextToken())

        if (A == 0 && B == 0) {
            break
        }

        println("${A + B}")
    }
}