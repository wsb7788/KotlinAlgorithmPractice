/*문제
방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 단, 모든 간선의 가중치는 10 이하의 자연수이다.

입력
첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000) 모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다. 둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)가 주어진다. 셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다. 이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다. 서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.

출력
첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다. 시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.*/
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


data class Node(val index: Int, val distance: Int): Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return this.distance - other.distance
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (vertex, edge) = readLine().split(" ").map { it.toInt() }
    val start = readLine().toInt() - 1

    val adjList = MutableList(vertex) {PriorityQueue<Node>()}
    var distance = IntArray(vertex) { Int.MAX_VALUE}
    val queue = PriorityQueue<Node>()

    repeat(edge){
        val (u,v,w) = readLine().split(" ").map { it.toInt() }
        adjList[u-1].add(Node(v-1,w))
    }

    distance[start] = 0
    queue.add(Node(start,0))

    while(queue.isNotEmpty()){

        val now = queue.poll().index

        for(next in adjList[now]){
            if(distance[next.index]> distance[now] + next.distance){
                distance[next.index] = distance[now] + next.distance
                queue.add(Node(next.index, distance[next.index]))
            }
        }

    }

    distance.forEach {
        if(it == Int.MAX_VALUE)
            println("INF")
        else
            println(it)
    }

}