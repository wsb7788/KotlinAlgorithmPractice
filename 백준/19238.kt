/*문제
스타트링크가 "스타트 택시"라는 이름의 택시 사업을 시작했다. 스타트 택시는 특이하게도 손님을 도착지로 데려다줄 때마다 연료가 충전되고, 연료가 바닥나면 그 날의 업무가 끝난다.

택시 기사 최백준은 오늘 M명의 승객을 태우는 것이 목표이다. 백준이 활동할 영역은 N×N 크기의 격자로 나타낼 수 있고, 각 칸은 비어 있거나 벽이 놓여 있다. 택시가 빈칸에 있을 때, 상하좌우로 인접한 빈칸 중 하나로 이동할 수 있다. 알고리즘 경력이 많은 백준은 특정 위치로 이동할 때 항상 최단경로로만 이동한다.

M명의 승객은 빈칸 중 하나에 서 있으며, 다른 빈칸 중 하나로 이동하려고 한다. 여러 승객이 같이 탑승하는 경우는 없다. 따라서 백준은 한 승객을 태워 목적지로 이동시키는 일을 M번 반복해야 한다. 각 승객은 스스로 움직이지 않으며, 출발지에서만 택시에 탈 수 있고, 목적지에서만 택시에서 내릴 수 있다.

백준이 태울 승객을 고를 때는 현재 위치에서 최단거리가 가장 짧은 승객을 고른다. 그런 승객이 여러 명이면 그중 행 번호가 가장 작은 승객을, 그런 승객도 여러 명이면 그중 열 번호가 가장 작은 승객을 고른다. 택시와 승객이 같은 위치에 서 있으면 그 승객까지의 최단거리는 0이다. 연료는 한 칸 이동할 때마다 1만큼 소모된다. 한 승객을 목적지로 성공적으로 이동시키면, 그 승객을 태워 이동하면서 소모한 연료 양의 두 배가 충전된다. 이동하는 도중에 연료가 바닥나면 이동에 실패하고, 그 날의 업무가 끝난다. 승객을 목적지로 이동시킨 동시에 연료가 바닥나는 경우는 실패한 것으로 간주하지 않는다.



<그림 1>

<그림 1>은 택시가 활동할 영역의 지도를 나타내며, 택시와 세 명의 승객의 출발지와 목적지가 표시되어 있다. 택시의 현재 연료 양은 15이다. 현재 택시에서 각 손님까지의 최단거리는 각각 9, 6, 7이므로, 택시는 2번 승객의 출발지로 이동한다.



<그림 2>



<그림 3>

<그림 2>는 택시가 2번 승객의 출발지로 가는 경로를, <그림 3>은 2번 승객의 출발지에서 목적지로 가는 경로를 나타낸다. 목적지로 이동할 때까지 소비한 연료는 6이고, 이동하고 나서 12가 충전되므로 남은 연료의 양은 15이다. 이제 택시에서 각 손님까지의 최단거리는 둘 다 7이므로, 택시는 둘 중 행 번호가 더 작은 1번 승객의 출발지로 이동한다.



<그림 4>



<그림 5>

<그림 4>와 <그림 5>는 택시가 1번 승객을 태워 목적지로 이동시키는 경로를 나타낸다. 남은 연료의 양은 15 - 7 - 7 + 7×2 = 15이다.



<그림 6>



<그림 7>

<그림 6>과 <그림 7>은 택시가 3번 승객을 태워 목적지로 이동시키는 경로를 나타낸다. 최종적으로 남은 연료의 양은 15 - 5 - 4 + 4×2 = 14이다.

모든 승객을 성공적으로 데려다줄 수 있는지 알아내고, 데려다줄 수 있을 경우 최종적으로 남는 연료의 양을 출력하는 프로그램을 작성하시오.

입력
첫 줄에 N, M, 그리고 초기 연료의 양이 주어진다. (2 ≤ N ≤ 20, 1 ≤ M ≤ N2, 1 ≤ 초기 연료 ≤ 500,000) 연료는 무한히 많이 담을 수 있기 때문에, 초기 연료의 양을 넘어서 충전될 수도 있다.

다음 줄부터 N개의 줄에 걸쳐 백준이 활동할 영역의 지도가 주어진다. 0은 빈칸, 1은 벽을 나타낸다.

다음 줄에는 백준이 운전을 시작하는 칸의 행 번호와 열 번호가 주어진다. 행과 열 번호는 1 이상 N 이하의 자연수이고, 운전을 시작하는 칸은 빈칸이다.

그다음 줄부터 M개의 줄에 걸쳐 각 승객의 출발지의 행과 열 번호, 그리고 목적지의 행과 열 번호가 주어진다. 모든 출발지와 목적지는 빈칸이고, 모든 출발지는 서로 다르며, 각 손님의 출발지와 목적지는 다르다.

출력
모든 손님을 이동시키고 연료를 충전했을 때 남은 연료의 양을 출력한다. 단, 이동 도중에 연료가 바닥나서 다음 출발지나 목적지로 이동할 수 없으면 -1을 출력한다. 모든 손님을 이동시킬 수 없는 경우에도 -1을 출력한다.*/
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var stt = StringTokenizer(br.readLine())
    val N = stt.nextToken().toInt()
    val M = stt.nextToken().toInt()
    val E = stt.nextToken().toInt()
    val map = Array(N + 1) { IntArray(N + 1) }
    for (i in 1..N) {
        stt = StringTokenizer(br.readLine())
        for (j in 1..N) {
            map[i][j] = stt.nextToken().toInt()
        }
    }
    stt = StringTokenizer(br.readLine())
    val y = stt.nextToken().toInt()
    val x = stt.nextToken().toInt()
    val taxi = Taxi(y, x, E)

    // 승객 번호 별 배열 관리
    val p_arr = arrayOfNulls<Passenger>(M + 2)
    for (m in 0 until M) {
        stt = StringTokenizer(br.readLine())
        val src_y = stt.nextToken().toInt()
        val src_x = stt.nextToken().toInt()
        val dest_y = stt.nextToken().toInt()
        val dest_x = stt.nextToken().toInt()
        p_arr[m + 2] = Passenger(src_y, src_x, dest_y, dest_x)
        map[src_y][src_x] = m + 2
    } // input end
    val res = process(map, p_arr, taxi, N, M)
    println(res)
}

private fun process(map: Array<IntArray>, p_arr: Array<Passenger?>, taxi: Taxi, n: Int, m: Int): Int {
    for (i in 0 until m) { // 총 승객 수만큼 반복
        // 거리가 가장 짧은 승객으로 BFS.
        // 택시 승객에게 이동
        if (bfs_to_passenger(map, p_arr, taxi, n)) {
            // 승객 목적지 이동
            if (bfs(map, p_arr, taxi, n)) {
            } else { // 승객 목적지 이동 불가
                return -1
            }
        } else { // 택시 승객에게 이동 불가
            return -1
        }
    }
    return taxi.energy
}

// 태울 승객을 가려내자
private fun bfs_to_passenger(map: Array<IntArray>, p_arr: Array<Passenger?>, taxi: Taxi, n: Int): Boolean {
    val dy = intArrayOf(-1, 1, 0, 0) // 상 하 좌 우
    val dx = intArrayOf(0, 0, -1, 1)
    val visited = Array(n + 1) {
        BooleanArray(n + 1)
    }
    val queue: Queue<IntArray> = LinkedList()
    // 현재 택시 위치
    queue.offer(intArrayOf(taxi.y, taxi.x, taxi.energy))
    visited[taxi.y][taxi.x] = true
    while (!queue.isEmpty()) {
        val size = queue.size
        // 가장 가까운 승객의 위치 정보
        var min_y = n + 1
        var min_x = n + 1
        var flag = false
        // 같은 거리의 승객이 여러명 있을 수 있으므로 사이즈 별로 반복
        for (s in 0 until size) {
            val pos = queue.poll()
            val y = pos[0]
            val x = pos[1]
            val energy = pos[2]

            // 승객 발견. 규칙에 따라 태울 승객을 가리자
            if (map[y][x] > 1) {
                if (min_y > y) {
                    min_y = y
                    min_x = x
                } else if (min_y == y) {
                    if (min_x > x) {
                        min_y = y
                        min_x = x
                    }
                }
                flag = true
                // 에너지 소모는 같으므로 여기서 할당
                taxi.energy = energy
                continue
            }

            // 에너지 다 씀
            if (energy <= 0) return false

            // 4방 탐색
            for (d in 0..3) {
                val next_y = y + dy[d]
                val next_x = x + dx[d]
                if (rangeCheck(next_y, next_x, n) || visited[next_y][next_x] || map[next_y][next_x] == 1) continue
                queue.offer(intArrayOf(next_y, next_x, energy - 1))
                visited[next_y][next_x] = true
            }
        } // 큐 사이즈 순회 end
        // 태울 승객이 있는 경우
        if (flag) {
            taxi.y = min_y
            taxi.x = min_x
            taxi.passNo = map[min_y][min_x]
            map[min_y][min_x] = 0
            return true
        }
    } // while end
    return false
}

// 승객의 목적지로 이동하자
private fun bfs(map: Array<IntArray>, p_arr: Array<Passenger?>, taxi: Taxi, n: Int): Boolean {
    val dy = intArrayOf(-1, 1, 0, 0)
    val dx = intArrayOf(0, 0, -1, 1)
    val visited = Array(n + 1) {
        BooleanArray(n + 1)
    }
    val queue: Queue<IntArray> = LinkedList()
    val cur_p = p_arr[taxi.passNo]
    queue.offer(intArrayOf(taxi.y, taxi.x, taxi.energy))
    visited[taxi.y][taxi.x] = true
    while (!queue.isEmpty()) {
        val size = queue.size
        val pos = queue.poll()
        val y = pos[0]
        val x = pos[1]
        val energy = pos[2]

        // 도착
        if (y == cur_p!!.dest_y && x == cur_p.dest_x) {
            // 원래 에너지 - 현재 에너지 -> 소모한 에너지
            taxi.y = y
            taxi.x = x
            taxi.energy = energy + 2 * (taxi.energy - energy)
            return true
        }

        // 에너지 다 씀
        if (energy <= 0) continue
        for (d in 0..3) {
            val next_y = y + dy[d]
            val next_x = x + dx[d]
            if (rangeCheck(next_y, next_x, n) || visited[next_y][next_x] || map[next_y][next_x] == 1) continue
            queue.offer(intArrayOf(next_y, next_x, energy - 1))
            visited[next_y][next_x] = true
        }
    }
    // 도착할 수 없는 경우
    return false
}

private fun rangeCheck(next_y: Int, next_x: Int, n: Int): Boolean {
    return next_y <= 0 || next_y >= n + 1 || next_x <= 0 || next_x >= n + 1
}

internal class Passenger(
// 승객 정보
    var src_y: Int, var src_x: Int, var dest_y: Int, var dest_x: Int,
) {
    var distance = 0
}

internal class Taxi(
// 택시 정보
    var y: Int, var x: Int, var energy: Int,
) {
    var passNo = 0
}
/*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

private var N = 0
private var M = 0
private var fuel = 0
private lateinit var array: Array<IntArray>
private val dx = arrayOf(-1, 0, 0, 1)
private val dy = arrayOf(0, -1, 1, 0)
private var nowX = 0
private var nowY = 0
private var nextX = 0
private var nextY = 0
private val order = ArrayList<Array<Int>>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val aa = readLine().split(" ").map { it.toInt() }
    N = aa[0]
    M = aa[1]
    fuel = aa[2]
    array = Array(N) { IntArray(N) }
    for (i in 0 until N) {
        array[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    val temp = readLine().split(" ").map { it.toInt() }
    nowX = temp[0] - 1
    nowY = temp[1] - 1
    for (i in 0 until M) {
        val temp = readLine().split(" ").map { it.toInt() }
        order.add(arrayOf(temp[0] - 1, temp[1] - 1, temp[2] - 1, temp[3] - 1))
    }


    repeat(M) {
        val remainFuel = findStart(fuel)
        if (remainFuel == -1) {
            println(-1)
            return@with
        }
        fuel = remainFuel
        val cost = findDest(0)

        if (cost == -1 || fuel - cost < 0) {
            println(-1)
            return@with
        }
        fuel += cost
    }
    println(fuel)

}

fun findDest(count: Int): Int {
    val q = LinkedList<Triple<Int, Int, Int>>()
    q.add(Triple(nowX, nowY, count))
    var visit = Array(N) { BooleanArray(N) { false } }
    visit[nowX][nowY] = true

    while (q.isNotEmpty()) {
        val tempQ = q.pop()
        for (i in 0 until 4) {
            val xx = dx[i] + tempQ.first
            val yy = dy[i] + tempQ.second
            if (!(xx in 0 until N && yy in 0 until N)) continue
            if (array[xx][yy] == 1) continue
            if (visit[xx][yy]) continue
            visit[xx][yy] = true
            if (xx == nextX && yy == nextY) {
                nowX = xx
                nowY = yy
                return tempQ.third + 1
            }
            q.add(Triple(xx, yy, tempQ.third + 1))
        }
    }
    return -1
}

private fun findStart(fuel: Int): Int {

    val q = LinkedList<Triple<Int, Int, Int>>()
    q.add(Triple(nowX, nowY, fuel))
    var visit = Array(N) { BooleanArray(N) { false } }
    visit[nowX][nowY] = true
    for (i in 0 until order.size) {
        if (nowX == order[i][0] && nowY == order[i][1]) {
            nextX = order[i][2]
            nextY = order[i][3]
            order.removeAt(i)
            return fuel
        }
    }
    while (q.isNotEmpty()) {
        val tempQ = q.pop()
        for (i in 0 until 4) {
            val xx = dx[i] + tempQ.first
            val yy = dy[i] + tempQ.second
            if (!(xx in 0 until N && yy in 0 until N)) continue
            if (array[xx][yy] == 1) continue
            if (visit[xx][yy]) continue
            visit[xx][yy] = true
            for (i in 0 until order.size) {
                if (xx == order[i][0] && yy == order[i][1]) {
                    nowX = xx
                    nowY = yy
                    nextX = order[i][2]
                    nextY = order[i][3]
                    order.removeAt(i)
                    return tempQ.third - 1
                }
            }
            if (tempQ.third > 0) {
                q.add(Triple(xx, yy, tempQ.third - 1))
            } else {
                return -1
            }
        }
    }
    return -1
}
*/