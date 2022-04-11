/*문제
상근이는 어렸을 적에 "봄보니 (Bomboni)" 게임을 즐겨했다.

가장 처음에 N×N크기에 사탕을 채워 놓는다. 사탕의 색은 모두 같지 않을 수도 있다. 상근이는 사탕의 색이 다른 인접한 두 칸을 고른다. 그 다음 고른 칸에 들어있는 사탕을 서로 교환한다. 이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.

사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 보드의 크기 N이 주어진다. (3 ≤ N ≤ 50)

다음 N개 줄에는 보드에 채워져 있는 사탕의 색상이 주어진다. 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y로 주어진다.

사탕의 색이 다른 인접한 두 칸이 존재하는 입력만 주어진다.

출력
첫째 줄에 상근이가 먹을 수 있는 사탕의 최대 개수를 출력한다.*/
private val br = System.`in`.bufferedReader()
private val dirXY : Array<IntArray> = arrayOf(intArrayOf(0,1),intArrayOf(1,0),intArrayOf(-1,0),intArrayOf(0,-1))

//1<=n<=50
private var answer =0
private var max=0
private lateinit var graph : Array<CharArray>

fun findMax(n : Int){
    for(r in 0 until n){
        var curC = graph[r][0]
        var cCnt = 0
        var curR = graph[0][r]
        var rCnt = 0
        for(c in 0 until n){
            //가로 탐색
            if(curC==graph[r][c]){
                cCnt++
                max = max.coerceAtLeast(cCnt)
            }
            else{
                curC=graph[r][c]
                cCnt=1
            }
            //세로 탐색
            if(curR==graph[c][r]){
                rCnt++
                max = max.coerceAtLeast(rCnt)
            }
            else{
                curR = graph[c][r]
                rCnt=1
            }
        }
    }
}

fun choiceSwap(n : Int, r: Int, c : Int){

    for(dir in 0 until 4){
        val nr = r + dirXY[dir][0]
        val nc = c + dirXY[dir][1]
        if(nr !in 0 until n || nc !in 0 until n) continue
        if(graph[r][c] == graph[nr][nc]) continue

        graph[r][c] = graph[nr][nc].also{graph[nr][nc] = graph[r][c]}
        findMax(n)
        answer= answer.coerceAtLeast(max)
        max = 0
        graph[r][c] = graph[nr][nc].also{graph[nr][nc] = graph[r][c]}
    }

}


fun main() = with(System.out.bufferedWriter()){

    val n = br.readLine().toInt()
    graph = Array(n){br.readLine().toCharArray()}

    findMax(n)
    answer= answer.coerceAtLeast(max)
    max = 0

    for(i in 0 until n){
        for(j in 0 until n){
            choiceSwap(n,i,j)
        }
    }

    write("$answer")

    close()
}