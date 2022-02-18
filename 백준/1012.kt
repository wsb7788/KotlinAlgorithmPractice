import java.io.BufferedReader
import java.io.InputStreamReader


private var m= 0
private var n= 0
private var k= 0
private lateinit var  bat: Array<BooleanArray>
private lateinit var  visit: Array<BooleanArray>
private var count = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val t = readLine().toInt()

    for(i in 0 until t){
        val st = readLine().split(" ").map { it.toInt() }
        m = st[0]; n=st[1]; k=st[2]
        bat = Array(n){ BooleanArray(m) }
        visit = Array(n){ BooleanArray(m){false} }
        count = 0
        for(k in 0 until k){
            val st = readLine().split(" ").map{it.toInt()}
            bat[st[1]][st[0]] = true
        }
        for(i in 0 until n){
            for(j in 0 until m){
                dfs(i,j,true)
            }
        }
        println(count)
    }
}
private fun dfs(x:Int, y:Int,isFirst:Boolean){

    if(bat[x][y]&&!visit[x][y]){
        if(isFirst){
            count++
        }
        visit[x][y] = true
        if(x>0){
            dfs(x-1,y,false)
        }
        if(y>0){
            dfs(x,y-1,false)
        }
        if(x<n-1){
            dfs(x+1,y,false)
        }
        if(y<m-1){
            dfs(x,y+1,false)
        }
    }

}