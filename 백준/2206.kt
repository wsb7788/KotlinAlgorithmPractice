/*문제
N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.

만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 한 개 까지 부수고 이동하여도 된다.

한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.

맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다. (1, 1)과 (N, M)은 항상 0이라고 가정하자.

출력
첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.*/
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

private var N = 0
private var M = 0
private lateinit var map : Array<IntArray>
private lateinit var check : Array<Array<IntArray>>
private val dx = arrayOf(0,0,1,-1)
private val dy = arrayOf(1,-1,0,0)
private var result = -1

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val temp = readLine().split(" ").map { it.toInt() }
    N = temp[0]
    M = temp[1]
    map = Array(N){IntArray(M)}
    check = Array(N){Array(M){IntArray(2)} }

    for(i in 0 until N){
        val str = readLine()
        for( j in 0 until M){
            map[i][j] = str[j] - '0'
        }
    }
    val queue = LinkedList<Triple<Int,Int,Int>>()
    queue.add(Triple(0,0,1))
    check[0][0][1] = 1
    while(queue.isNotEmpty()){
        val (row,col,chance) = queue.pop()
        if(row+1==N&&col+1==M){
            result = check[row][col][chance]
            break
        }
        for(i in 0 until 4){
            val xx = row + dx[i]
            val yy = col + dy[i]
            if(xx<0||yy<0||xx>=N||yy>=M) continue
            if(map[xx][yy] == 1 && chance ==1){
                queue.add(Triple(xx,yy,0))
                check[xx][yy][0] = check[row][col][1] + 1
            }
            if(map[xx][yy] == 0 && check[xx][yy][chance]==0){
                queue.add(Triple(xx,yy,chance))
                check[xx][yy][chance] = check[row][col][chance]+1
            }

        }
    }
    println(result)


}
