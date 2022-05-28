/*문제
폴리오미노란 크기가 1×1인 정사각형을 여러 개 이어서 붙인 도형이며, 다음과 같은 조건을 만족해야 한다.

정사각형은 서로 겹치면 안 된다.
도형은 모두 연결되어 있어야 한다.
정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.
정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고 하며, 다음과 같은 5가지가 있다.



아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.

테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.

테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.

입력
첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)

둘째 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다. i번째 줄의 j번째 수는 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 쓰여 있는 수이다. 입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.

출력
첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력한다.*/
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

private var n = 0
private var m = 0
private lateinit var array:Array<IntArray>
private lateinit var check:Array<BooleanArray>
private var max = Int.MIN_VALUE
private var dx = intArrayOf(-1, 1, 0, 0)
private var dy = intArrayOf(0, 0, -1, 1)

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    val a = readLine().split(" ").map{ it.toInt()}
    n = a[0]
    m = a[1]
    array = Array(n){IntArray(m)}
    check = Array(n){BooleanArray(m)}
    for(i in 0 until n){
        array[i] = readLine().split(" ").map{it.toInt()}.toIntArray()
    }
    for(i in 0 until n){
        for(k in 0 until m){
            check.forEach { it.fill(false) }
            check[i][k] = true
            bruteForce(i,k,1,array[i][k])
        }
    }
    println(max)
}
private fun bruteForce(row:Int,col:Int,depth:Int, sum:Int){

    if(depth == 4){
        max = max(max, sum)
        return
    }

    for (i in 0..3) {
        val curRow: Int = row + dx[i]
        val curCol: Int = col + dy[i]

        if (curRow < 0 || curRow >= n || curCol < 0 || curCol >= m) continue

        if (!check[curRow][curCol]) {
            if (depth == 2) {
                check[curRow][curCol]= true
                bruteForce(row, col,depth+1, sum+array[curRow][curCol])
                check[curRow][curCol] = false
            }
            check[curRow][curCol] = true
            bruteForce(curRow, curCol, depth+1, sum+array[curRow][curCol])
            check[curRow][curCol] = false
        }
    }



}