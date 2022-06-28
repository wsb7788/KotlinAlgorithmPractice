/*문제
N×N 크기의 공간에 물고기 M마리와 아기 상어 1마리가 있다. 공간은 1×1 크기의 정사각형 칸으로 나누어져 있다. 한 칸에는 물고기가 최대 1마리 존재한다.

아기 상어와 물고기는 모두 크기를 가지고 있고, 이 크기는 자연수이다. 가장 처음에 아기 상어의 크기는 2이고, 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.

아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다. 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다. 따라서, 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.

아기 상어가 어디로 이동할지 결정하는 방법은 아래와 같다.

더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
아기 상어의 이동은 1초 걸리고, 물고기를 먹는데 걸리는 시간은 없다고 가정한다. 즉, 아기 상어가 먹을 수 있는 물고기가 있는 칸으로 이동했다면, 이동과 동시에 물고기를 먹는다. 물고기를 먹으면, 그 칸은 빈 칸이 된다.

아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다. 예를 들어, 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다.

공간의 상태가 주어졌을 때, 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 공간의 크기 N(2 ≤ N ≤ 20)이 주어진다.

둘째 줄부터 N개의 줄에 공간의 상태가 주어진다. 공간의 상태는 0, 1, 2, 3, 4, 5, 6, 9로 이루어져 있고, 아래와 같은 의미를 가진다.

0: 빈 칸
1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
9: 아기 상어의 위치
아기 상어는 공간에 한 마리 있다.

출력
첫째 줄에 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간을 출력한다.*/
import java.util.*

//2<=n<=20
private const val INF = 987654321
private val dir = arrayOf(arrayOf(0,1),arrayOf(1,0),arrayOf(0,-1),arrayOf(-1,0))
private var answer=0
private var sharkSize=2
fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    var shark =Shark(0,0,0)
    val n = br.readLine().toInt()
    val graph = Array<IntArray>(n){ r->
        val tk = StringTokenizer(br.readLine())
        IntArray(n){ c->
            var node = tk.nextToken().toInt()
            if(node ==9){
                shark=Shark(r,c,0)
                node=0
            }
            node
        }
    }
    write("${solve(n,shark,graph)}")
    close()
}
private fun bfs( n : Int, shark : Shark, graph : Array<IntArray>, visited : Array<BooleanArray>) : Shark{
    val q : Queue<Pair<Int,Int>> = LinkedList<Pair<Int,Int>>()
    visited[shark.r][shark.c]=true
    q.add(Pair(shark.r,shark.c))
    var fr = INF
    var fc = INF
    var dis=0

    while(q.isNotEmpty()) {
        val size=q.size
        dis++
        for(i in 0 until size) {
            val cur = q.poll()
            for (dir in dir) {
                val nr = cur.first + dir[0]
                val nc = cur.second + dir[1]
                if (nr !in 0 until n || nc !in 0 until n) continue
                if (visited[nr][nc]) continue
                //상어크기랑 같거나 작으면 이동 가능
                if (graph[nr][nc] <= sharkSize) {
                    //상어 크기보다 작고, 0이 아닌 경우 먹을 수 있음
                    //for문 내에선 거리가 모두 같기 때문에 이 중 가장 위, 가장 왼쪽 찾아서 반환
                    if(graph[nr][nc]<sharkSize && graph[nr][nc]!=0){
                        if(fr>nr){
                            fr = nr
                            fc = nc
                        }
                        else if(fr==nr){
                            if(fc>nc) {
                                fc = nc
                            }
                        }
                    }
                    visited[nr][nc]=true
                    q.add(Pair(nr,nc))
                }
            }
        }
        //물고기 좌표 구했다면 반환
        if(fr!=INF && fc!=INF){
            return Shark(fr,fc,dis)
        }
    }
    //물고기 좌표 못 구했다면 상어좌표 그대로 반환
    return shark
}

private fun solve(n : Int, shark : Shark, graph : Array<IntArray>) : Int{
    var cur = shark
    var cnt=0
    while(true){
        //상어가 다음 먹을 물고기 위치, 거리 찾기
        val visited = Array<BooleanArray>(n){BooleanArray(n)}
        val next = bfs(n,shark,graph,visited)
        //다음 먹을 물고기 없으면 stop
        if(next==cur){
            break
        }
        //다음 먹을 물고기 있을 때
        else{
            cur.time +=next.time
            graph[next.r][next.c]=0
            cur.r = next.r
            cur.c = next.c
            cnt++
            if(cnt == sharkSize){
                sharkSize++
                cnt=0
            }
        }
    }
    //최종 이동 시간 반환
    return cur.time
}



private data class Shark(var r : Int, var c : Int,var time : Int){
}