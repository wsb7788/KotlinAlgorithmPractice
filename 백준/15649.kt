import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n:Int=0
var m:Int=0
lateinit var arr:IntArray
lateinit var visit:BooleanArray
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
     n = st.nextToken().toInt()
     m = st.nextToken().toInt()

    arr = IntArray(m)
    visit = BooleanArray(n)

    dfs(0)

}

fun dfs(depth: Int) {
    if(depth == m){
        arr.forEach { print("$it ") }
        println()
        return
    }

    for(i in 0 until n){
        if(!visit[i]){
            visit[i] = true
            arr[depth] = i + 1
            dfs(depth + 1)
            visit[i] = false
        }
    }

}
