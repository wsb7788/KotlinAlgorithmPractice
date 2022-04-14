import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

/*문제
코레스코 콘도미니엄 8층은 학생들이 3끼의 식사를 해결하는 공간이다. 그러나 몇몇 비양심적인 학생들의 만행으로 음식물이 통로 중간 중간에 떨어져 있다. 이러한 음식물들은 근처에 있는 것끼리 뭉치게 돼서 큰 음식물 쓰레기가 된다.

이 문제를 출제한 선생님은 개인적으로 이러한 음식물을 실내화에 묻히는 것을 정말 진정으로 싫어한다. 참고로 우리가 구해야 할 답은 이 문제를 낸 조교를 맞추는 것이 아니다.

통로에 떨어진 음식물을 피해가기란 쉬운 일이 아니다. 따라서 선생님은 떨어진 음식물 중에 제일 큰 음식물만은 피해 가려고 한다.

선생님을 도와 제일 큰 음식물의 크기를 구해서 “10ra"를 외치지 않게 도와주자.

입력
첫째 줄에 통로의 세로 길이 N(1 ≤ N ≤ 100)과 가로 길이 M(1 ≤ M ≤ 100) 그리고 음식물 쓰레기의 개수 K(1 ≤ K ≤ N×M)이 주어진다.  그리고 다음 K개의 줄에 음식물이 떨어진 좌표 (r, c)가 주어진다.

좌표 (r, c)의 r은 위에서부터, c는 왼쪽에서부터가 기준이다. 입력으로 주어지는 좌표는 중복되지 않는다.

출력
첫째 줄에 음식물 중 가장 큰 음식물의 크기를 출력하라.*/
/*
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

private var n = 0
private var m = 0
private var k = 0
private lateinit var trash:Array<Array<Boolean>>
private lateinit var check:Array<Array<Boolean>>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

   val temp = readLine().split(" ").map { it.toInt() }
    n = temp[0]
    m = temp[1]
    k = temp[2]
    trash = Array(n){Array(m){false} }
    check = Array(n){Array(m){false} }

    for(i in 0 until k){
        val temp = readLine().split(" ").map { it.toInt() }
        trash[temp[0]-1][temp[1]-1] = true
    }
    var max = 0
    for(i in 0 until n-1){
        for(j in 0 until m-1){
            if(trash[i][j] && !check[i][j]){
                max = max(dfs(i,j,1),max)
            }
        }
    }

    println(max)

}
private fun dfs(i:Int, j:Int, count:Int):Int{
    check[i][j] = true
    var coco = count

    if(i>0){
        if(trash[i-1][j]&&!check[i-1][j]){
            coco = max(dfs(i-1,j,coco+1),coco)
        }
    }

    if(i<n-1){
        if(trash[i+1][j]&&!check[i+1][j]){
            coco = max(dfs(i+1,j,coco+1),coco)
        }
    }
    if(j>0){
        if(trash[i][j-1]&&!check[i][j-1]){
            coco = max(dfs(i,j-1,coco+1),coco)
        }
    }
    if(j<m-1){
        if(trash[i][j+1]&&!check[i][j+1]){
            coco = max(dfs(i,j+1,coco+1),coco)
        }
    }
    return coco
}*/
    private var N = 0
private var M = 0
private var K = 0
private var ans = 0
private  var temp = 0
private  var dx = intArrayOf(-1, 1, 0, 0)
private   var dy = intArrayOf(0, 0, -1, 1)
private   lateinit var map: Array<BooleanArray>
private   lateinit var visited: Array<BooleanArray>
    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())
        N = st.nextToken().toInt()
        M = st.nextToken().toInt()
        K = st.nextToken().toInt()
        map = Array(N) { BooleanArray(M) }
        visited = Array(N) { BooleanArray(M) }
        for (i in 0 until K) {
            st = StringTokenizer(br.readLine())
            val r = st.nextToken().toInt()
            val c = st.nextToken().toInt()
            map[r - 1][c - 1] = true
        }
        for (i in 0 until N) {
            for (j in 0 until M) {
                if (!visited[i][j] && map[i][j]) {
                    temp = 0
                    dfs(i, j)
                    ans = Math.max(ans, temp)
                }
            }
        }
        println(ans)
    }
    private fun dfs(x: Int, y: Int) {
        temp++
        visited[x][y] = true
        for (k in 0..3) {
            val xx = x + dx[k]
            val yy = y + dy[k]
            if (xx < 0 || yy < 0 || xx >= N || yy >= M) continue
            if (!visited[xx][yy] && map[xx][yy]) {
                dfs(xx, yy)
            }
        }
    }
