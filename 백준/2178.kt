import java.io.*
import java.util.*

private var arr: Array<IntArray> = arrayOf()
private var visited: Array<BooleanArray> = arrayOf()
private var dx: IntArray = intArrayOf(-1,0,1,0)
private var dy: IntArray = intArrayOf(0,-1,0,1)
private var N: Int = 0
private var M: Int = 0

data class Dot(var x: Int, var y: Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val input = readLine().split(" ")
    N = input[0].toInt()
    M = input[1].toInt()

    arr = Array(N) { IntArray(M) }
    visited = Array(N) { BooleanArray(M) }

    for ( i in 0 until N ) {
        val str = readLine()
        for ( j in 0 until M ) {
            arr[i][j] = (str[j]+"").toInt()
            visited[i][j] = false
        }
    }

    visited[0][0] = true
    bfs(0, 0)
    println(arr[N-1][M-1])

}

fun bfs(x: Int, y: Int) {
    val queue: Queue<Dot> = LinkedList<Dot>()
    queue.add(Dot(x, y))

    while ( !queue.isEmpty() ) {
        val d: Dot = queue.poll()

        for ( i in 0 until 4 ) {
            val nX = d.x + dx[i]
            val nY = d.y + dy[i]

            if ( nX < 0 || nY < 0 || nX >= N || nY >= M )
                continue
            if ( visited[nX][nY] || arr[nX][nY] == 0 )
                continue

            queue.add(Dot(nX, nY))
            arr[nX][nY] = arr[d.x][d.y] + 1
            visited[nX][nY] = true
        }
    }
}