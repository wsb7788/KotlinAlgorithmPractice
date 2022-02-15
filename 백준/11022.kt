import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    for (i in 1..Integer.parseInt(br.readLine())) {
        val input = br.readLine()
        val st = StringTokenizer(input, " ")
        val a = Integer.parseInt(st.nextToken())
        val b = Integer.parseInt(st.nextToken())
        println("Case #${i}: ${a} + ${b} = ${a + b}") }
}
