/*문제
동물원에서 막 탈출한 원숭이 한 마리가 세상구경을 하고 있다. 그 녀석은 말(Horse)이 되기를 간절히 원했다. 그래서 그는 말의 움직임을 유심히 살펴보고 그대로 따라 하기로 하였다. 말은 말이다. 말은 격자판에서 체스의 나이트와 같은 이동방식을 가진다. 다음 그림에 말의 이동방법이 나타나있다. x표시한 곳으로 말이 갈 수 있다는 뜻이다. 참고로 말은 장애물을 뛰어넘을 수 있다.

 	x	 	x
x	 	 	 	x
 	 	말
x	 	 	 	x
 	x	 	x
근데 원숭이는 한 가지 착각하고 있는 것이 있다. 말은 저렇게 움직일 수 있지만 원숭이는 능력이 부족해서 총 K번만 위와 같이 움직일 수 있고, 그 외에는 그냥 인접한 칸으로만 움직일 수 있다. 대각선 방향은 인접한 칸에 포함되지 않는다.

이제 원숭이는 머나먼 여행길을 떠난다. 격자판의 맨 왼쪽 위에서 시작해서 맨 오른쪽 아래까지 가야한다. 인접한 네 방향으로 한 번 움직이는 것, 말의 움직임으로 한 번 움직이는 것, 모두 한 번의 동작으로 친다. 격자판이 주어졌을 때, 원숭이가 최소한의 동작으로 시작지점에서 도착지점까지 갈 수 있는 방법을 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 정수 K가 주어진다. 둘째 줄에 격자판의 가로길이 W, 세로길이 H가 주어진다. 그 다음 H줄에 걸쳐 W개의 숫자가 주어지는데, 0은 아무것도 없는 평지, 1은 장애물을 뜻한다. 장애물이 있는 곳으로는 이동할 수 없다. 시작점과 도착점은 항상 평지이다. W와 H는 1이상 200이하의 자연수이고, K는 0이상 30이하의 정수이다.

출력
첫째 줄에 원숭이의 동작수의 최솟값을 출력한다. 시작점에서 도착점까지 갈 수 없는 경우엔 -1을 출력한다.*/
/*
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

private var K = 0
private var W = 0
private var H = 0
private lateinit var array: Array<IntArray>
private lateinit var visit: Array<Array<BooleanArray>>
private var min = 40001
private val dx = arrayOf(0,0,1,-1)
private val dy = arrayOf(1,-1,0,0)
private val horseDx = arrayOf(2,2,-2,-2,1,1,-1,-1)
private val horseDy = arrayOf(1,-1,1,-1,2,-2,2,-2)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    K = readLine().toInt()
    val aa = readLine().split(" ").map { it.toInt() }
    H = aa[0]
    W = aa[1]
    array = Array(W) { IntArray(H) }
    visit = Array(K+1){Array(W) { BooleanArray(H) }}
    for (i in 0 until W) {
        array[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    gogo(0, 0, 0,0)


    if(min==40001)
        println(-1)
    else
        println(min)

}

private fun gogo(row: Int, col: Int, isHorse:Int,count:Int) {

    if(min <= count) return

    if(row+1 == W && col+1 == H){
        min = min(min, count)
        return
    }

    if(isHorse<K){
        for(i in 0 until 8){
            val xx = horseDx[i] + row
            val yy = horseDy[i] + col
            if(!(xx in 0 until W && yy in 0 until H)) continue
            if(array[xx][yy] == 1||visit[isHorse][xx][yy]) continue
            visit[isHorse+1][xx][yy] = true
            gogo(xx, yy, isHorse + 1, count + 1)
            visit[isHorse+1][xx][yy] = true
        }
    }

    for(i in 0 until 4){
        val xx = dx[i] + row
        val yy = dy[i] + col
        if(!(xx in 0 until W && yy in 0 until H)) continue
        if(array[xx][yy] == 1||visit[isHorse][xx][yy]) continue
        visit[isHorse][xx][yy] = true
        gogo(xx, yy, isHorse, count + 1)
        visit[isHorse][xx][yy] = true
    }


}*/

import java.util.*

private var k = 0
private var n = 0
private var m = 0

private lateinit var arr : Array<IntArray>
private lateinit var visited : Array<Array<IntArray>>
private val dx = arrayOf(0,0,1,-1)
private val dy = arrayOf(1,-1,0,0)
private val hdx = arrayOf(2,2,1,-1,-2,-2,1,-1)
private val hdy = arrayOf(1,-1,2,2,1,-1,-2,-2)
fun main() {
    val br = System.`in`.bufferedReader()
    k = br.readLine().toInt()
    val tmp = br.readLine().split(" ").map { it.toInt() }
    n = tmp[1]
    m = tmp[0]
    arr = Array(n){ IntArray(m) }
    visited = Array(n){ Array(m){ IntArray(k+1){-1} } }
    repeat(n){
        val points = br.readLine().split(" ").map { it.toInt() }
        arr[it] = points.toIntArray()
    }
    bfs()
    var result = m * n
    var bool = false
    for(i in 0 .. k){
        if(visited[n-1][m-1][i] != -1) {
            bool = true
            result = Math.min(result, visited[n-1][m-1][i])
        }
    }
    if(bool) println(result)
    else println(-1)
}
private fun bfs(){
    val queue : Queue<Triple<Int,Int,Int>> = ArrayDeque()
    for(i in 0 ..k){
        visited[0][0][i] = 0
    }
    queue.offer(Triple(0,0,0))
    while(queue.isNotEmpty()){
        val q = queue.poll()
        val x = q.first
        val y = q.second
        val jumped = q.third
        if(x == n && y == m) return
        //나이트 점프 x
        for(i in 0 .. 3){
            val nx = x + dx[i]
            val ny = y + dy[i]
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue
            if(arr[nx][ny] == 1) continue
            if(visited[nx][ny][jumped] != -1) continue
            visited[nx][ny][jumped] =  visited[x][y][jumped]+1
            queue.offer(Triple(nx,ny,jumped))
        }
        // 나이트 점프
        if(jumped < k){
            for(i in 0 ..7){
                val nx = x + hdx[i]
                val ny = y + hdy[i]
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue
                if(arr[nx][ny] == 1) continue
                if(visited[nx][ny][jumped+1] != -1) continue
                visited[nx][ny][jumped+1] =  visited[x][y][jumped]+1
                queue.offer(Triple(nx,ny,jumped+1))
            }
        }
    }
}