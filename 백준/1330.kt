import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(br.readLine())
    val a = Integer.parseInt(token.nextToken())
    val b = Integer.parseInt(token.nextToken())
    if(a>b)
        println(">")
    else if(a<b)
        println("<")
    else
        println("==")
    br.close() }

