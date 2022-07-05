/*문제
n × n의 크기의 대나무 숲이 있다. 욕심쟁이 판다는 어떤 지역에서 대나무를 먹기 시작한다. 그리고 그 곳의 대나무를 다 먹어 치우면 상, 하, 좌, 우 중 한 곳으로 이동을 한다. 그리고 또 그곳에서 대나무를 먹는다. 그런데 단 조건이 있다. 이 판다는 매우 욕심이 많아서 대나무를 먹고 자리를 옮기면 그 옮긴 지역에 그 전 지역보다 대나무가 많이 있어야 한다.

이 판다의 사육사는 이런 판다를 대나무 숲에 풀어 놓아야 하는데, 어떤 지점에 처음에 풀어 놓아야 하고, 어떤 곳으로 이동을 시켜야 판다가 최대한 많은 칸을 방문할 수 있는지 고민에 빠져 있다. 우리의 임무는 이 사육사를 도와주는 것이다. n × n 크기의 대나무 숲이 주어져 있을 때, 이 판다가 최대한 많은 칸을 이동하려면 어떤 경로를 통하여 움직여야 하는지 구하여라.

입력
첫째 줄에 대나무 숲의 크기 n(1 ≤ n ≤ 500)이 주어진다. 그리고 둘째 줄부터 n+1번째 줄까지 대나무 숲의 정보가 주어진다. 대나무 숲의 정보는 공백을 사이로 두고 각 지역의 대나무의 양이 정수 값으로 주어진다. 대나무의 양은 1,000,000보다 작거나 같은 자연수이다.

출력
첫째 줄에는 판다가 이동할 수 있는 칸의 수의 최댓값을 출력한다.*/
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max


private var n = 0
private lateinit var map:Array<IntArray>
private lateinit var count:Array<IntArray>
private val dx = arrayOf(0,0,1,-1)
private val dy = arrayOf(1,-1,0,0)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    n = readLine().toInt()

    map = Array(n){IntArray(n)}
    count = Array(n){IntArray(n)}
    for(i in 0 until n){
        map[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    var max = Int.MIN_VALUE
    for(i in 0 until n){
        for(k in 0 until n){
           max = max(max, gogo(i,k))
        }
    }
    println(max)
}
private fun gogo(row:Int, col:Int):Int{

    if(count[row][col] != 0){
        return count[row][col]
    }
    count[row][col] =1

    for(i in 0 until 4){
        val xx = row + dx[i]
        val yy = col + dy[i]
        if(!(xx in 0 until n && yy in 0 until n)) continue
        if(map[row][col]<map[xx][yy]){
            count[row][col] = max(count[row][col],gogo(xx,yy)+1)
        }
    }
    return count[row][col]
}