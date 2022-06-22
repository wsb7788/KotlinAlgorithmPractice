/*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

private data class CCTV(var x:Int, var y:Int, val type:Int)

private val camera = arrayOf(
    arrayOf(arrayOf(0)),
    arrayOf(arrayOf(0), arrayOf(1), arrayOf(2), arrayOf(3)),                            // 1번 CCTV
    arrayOf(arrayOf(0, 2), arrayOf(1, 3)),                                              // 2번 CCTV
    arrayOf(arrayOf(0, 1), arrayOf(1, 2), arrayOf(2, 3), arrayOf(3, 0)),                // 3번 CCTV
    arrayOf(arrayOf(1, 0, 3), arrayOf(1, 2, 3), arrayOf(0, 2, 1), arrayOf(0, 2, 3)),    // 4번 CCTV
    arrayOf(arrayOf(0, 1, 2, 3))
)
private var n = 0
private var m = 0
private lateinit var array : Array<IntArray>
private var max = 0
private var q  = LinkedList<CCTV>()
private val dy = arrayOf(-1, 0, 1, 0) // 북, 동, 남, 서 방향에 대한 정보
private val dx = arrayOf(0, 1, 0, -1)
private var ans = Int.MAX_VALUE
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val aa = readLine().split(" ").map { it.toInt() }
    n = aa[0]
    m = aa[1]
    max = n * m
    array = Array(n){IntArray(m)}

    for(i in 0 until n){
        val temp = readLine().split(" ").map { it.toInt() }.toIntArray()
        array[i] = temp
        temp.forEachIndexed { index, it -> if(it != 0){
            if(it != 6) q.offer(CCTV(index, i, it))
        }
            max--
        }
    }
    permutation(max)
    println(ans)
}
private fun permutation(range:Int){
    if(q.isEmpty()){
        ans = min(ans, range)
        return
    }
    val cur = q.poll()

    val clone = Array(n){IntArray(m)}
    for(i in 0 until n){
        clone[i] = array[i].clone()
    }
    for(i in 0 until camera[cur.type].size){
        var cnt = 0
        for(j in 0 until camera[cur.type][i].size){
            val dir = camera[cur.type][i][j]
            cnt += move(cur.x, cur.y, dir)
        }
        permutation(range - cnt)
        for(a in 0 until n){
            array[a] = clone[a].clone()
        }
    }
    q.offer(cur)

}
private fun move(x:Int, y:Int, dir:Int):Int{
    var cnt = 0
    var cur = CCTV(x,y,dir)
    array[y][x] = -1
    while(true){
        cur.x = cur.x + dx[dir]
        cur.y = cur.y + dy[dir]
        if(!(cur.x in 0 until m && cur.y in 0 until n && array[cur.y][cur.x] != 6))
            return cnt
        if(array[cur.y][cur.x] != 0) continue
        cnt ++
        array[cur.y][cur.x] = -1
    }
}*/
import java.util.*
import kotlin.math.min

// CCTV 타입별로 비추는 모든 방향을 나타낸다.
val camera = arrayOf(
    arrayOf(arrayOf(0)),
    arrayOf(arrayOf(0), arrayOf(1), arrayOf(2), arrayOf(3)),                            // 1번 CCTV
    arrayOf(arrayOf(0, 2), arrayOf(1, 3)),                                              // 2번 CCTV
    arrayOf(arrayOf(0, 1), arrayOf(1, 2), arrayOf(2, 3), arrayOf(3, 0)),                // 3번 CCTV
    arrayOf(arrayOf(1, 0, 3), arrayOf(1, 2, 3), arrayOf(0, 2, 1), arrayOf(0, 2, 3)),    // 4번 CCTV
    arrayOf(arrayOf(0, 1, 2, 3))                                                        // 5번 CCTV
)
private val dy = arrayOf(-1, 0, 1, 0) // 북, 동, 남, 서 방향에 대한 정보
private val dx = arrayOf(0, 1, 0, -1)
private var max = 0
private var ans = Integer.MAX_VALUE
private lateinit var q: Queue<CCTV>
private lateinit var map: Array<IntArray>
fun main() {
    val (R, C) = readln().split(" ").map { it.toInt() }
    max = R * C

    q = LinkedList<CCTV>()
    map = Array(R) { IntArray(C) }
    for (i in 0 until R) {
        val st = StringTokenizer(readln())
        for (j in 0 until C) {
            map[i][j] = st.nextToken().toInt()
            if (map[i][j] != 0) {
                if (map[i][j] != 6) {
                    q.offer(CCTV(j, i, map[i][j]))
                }
                max--
            }
        }
    }
    permutation(max)
    println(ans)

}
// 백트래킹을 이용하여 모든 경우의 수를 따져 최솟값을 추려내야함
/** @param range: 카메라가 비춘 총 범위 **/
fun permutation(range: Int) {
    if (q.isEmpty()) {
        ans = min(ans, range)
        return
    }
    val cur = q.poll()
    // 배열 복사
    val clone = Array(map.size) { IntArray(map[0].size) }
    for (i in map.indices) {
        clone[i] = map[i].clone()
    }
    for (i in 0 until camera[cur.type].size) {
        var cnt = 0 // 카메라가 총 비춘 범위를 cnt 하는 변수
        for (j in 0 until camera[cur.type][i].size) {
            val dir = camera[cur.type][i][j]
            cnt += move(cur.x, cur.y, dir)
        }
        permutation(range - cnt)
        // 백트래킹: 앞서 작업했던 내용을 원래대로 복구한다.
        for (a in map.indices) {
            map[a] = clone[a].clone()
        }
    }
    q.offer(cur)
}


fun move(x: Int, y: Int, dir: Int): Int {
    var cnt = 0
    var cur = CCTV(x, y, dir)
    map[y][x] = -1 //이미 방문한 경로
    while (true) {
        cur.x = cur.x + dx[dir]
        cur.y = cur.y + dy[dir]
        // 비추는 곳이 벽에 닿거나, 범위를 이탈했을 시 루프를 빠져나와야 한다.
        if (!(cur.x in 0 until map[0].size && cur.y in 0 until map.size
                    && map[cur.y][cur.x] != 6)
        ) return cnt

        if (map[cur.y][cur.x] != 0) continue
        cnt++
        map[cur.y][cur.x] = -1

    }
}

data class CCTV(var x: Int, var y: Int, val type: Int)