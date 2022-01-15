import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(br.readLine())
    val a = Integer.parseInt(token.nextToken())
    for(i in 1..9){
        println("$a * $i = ${a*i}")
    }
    br.close() }

