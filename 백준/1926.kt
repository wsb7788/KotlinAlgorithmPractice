/*문제
어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라. 단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자. 가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다. 그림의 넓이란 그림에 포함된 1의 개수이다.

입력
첫째 줄에 도화지의 세로 크기 n(1 ≤ n ≤ 500)과 가로 크기 m(1 ≤ m ≤ 500)이 차례로 주어진다. 두 번째 줄부터 n+1 줄 까지 그림의 정보가 주어진다. (단 그림의 정보는 0과 1이 공백을 두고 주어지며, 0은 색칠이 안된 부분, 1은 색칠이 된 부분을 의미한다)

출력
첫째 줄에는 그림의 개수, 둘째 줄에는 그 중 가장 넓은 그림의 넓이를 출력하여라. 단, 그림이 하나도 없는 경우에는 가장 넓은 그림의 넓이는 0이다.*/
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

private var n = 0
private var m = 0
private lateinit var array : Array<IntArray>
private var max = 0
private val dx = arrayOf(0,0,1,-1)
private val dy = arrayOf(1,-1,0,0)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val temp = readLine().split(" ").map { it.toInt() }
    m = temp[0]
    n = temp[1]
    array = Array(m){IntArray(n)}
    for(i in 0 until m){
        array[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    var count = 0
    for(i in 0 until m){
        for(j in 0 until n){
            if(array[i][j]!=0){
                array[i][j] = 0
                dfs(i,j)
                count++
            }
        }
    }
    println(count)
    println(max)

}
private fun dfs(low:Int, col:Int){
    var mount = 1
    val queue:Queue<Pair<Int,Int>> = LinkedList()

    queue.add(Pair(low,col))

    while(!queue.isEmpty()){
        val temp = queue.poll()
        for(i in 0 until 4){
            val y = temp.first + dy[i]
            val x = temp.second + dx[i]
            if(y<0||y>=m||x<0||x>=n) continue
            if( array[y][x]!=0){
                array[y][x] = 0
                queue.add(Pair(y,x))
                mount ++
            }
        }
    }
    max = max(max,mount)
}