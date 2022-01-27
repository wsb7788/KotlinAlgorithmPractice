import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val st = StringTokenizer(br.readLine())

    val n:Double = st.nextToken().toDouble()
    var num = 1
    var lineCount = 1
    while(true){
        if(n<=num){
            println(lineCount)
            return
        }
        num += (lineCount*6)
        lineCount++
    }
}