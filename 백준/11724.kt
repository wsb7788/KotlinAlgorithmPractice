import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var array:Array<ArrayList<Int>>
private var count = 0
private lateinit var visit:BooleanArray
fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,m) = readLine().split(" ").map { it.toInt() }
    array = Array(n+1) { ArrayList(n+1) }
    visit = BooleanArray(n+1)
    for(i in 0 until m){
        val temp = readLine().split(" ").map { it.toInt() }
        array[temp[0]].add(temp[1])
        array[temp[1]].add(temp[0])
    }

    for(i in 1 .. n){
        if(!visit[i]){
            dfs(i)
            count++
        }
    }
    print(count)
}

private fun dfs(v: Int){
    visit[v] = true

    for(i in array[v]){
        if(!visit[i]){
            dfs(i)
        }
    }
}