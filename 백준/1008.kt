import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(br.readLine())

    println((Integer.parseInt(token.nextToken()).toDouble()/  Integer.parseInt(token.nextToken())).toFloat().toDouble())
    br.close() }

