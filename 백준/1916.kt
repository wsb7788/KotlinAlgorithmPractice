/*문제
N개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다. 우리는 A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다. A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 출력하여라. 도시의 번호는 1부터 N까지이다.

입력
첫째 줄에 도시의 개수 N(1 ≤ N ≤ 1,000)이 주어지고 둘째 줄에는 버스의 개수 M(1 ≤ M ≤ 100,000)이 주어진다. 그리고 셋째 줄부터 M+2줄까지 다음과 같은 버스의 정보가 주어진다. 먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다. 그리고 그 다음에는 도착지의 도시 번호가 주어지고 또 그 버스 비용이 주어진다. 버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수이다.

그리고 M+3째 줄에는 우리가 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호가 주어진다. 출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다.

출력
첫째 줄에 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력한다.*/
import java.util.*;
import java.io.*;

// 인접리스트 생성
private lateinit var list: MutableList<MutableList<Node1916>>
private lateinit var dist: IntArray
private const val INF = Integer.MAX_VALUE / 4 // 오버플로우 방지
private var N = 0;
private var M = 0;

private class Node1916(var nodeNum : Int, var weight: Int) : Comparable<Node1916> {
    // 우선순위 큐에서 가중치 비교를 위한 메소드 override
    override fun compareTo(other: Node1916): Int {
        return weight - other.weight;
    }
} // End of Node class

fun main() {
    var br = BufferedReader( InputStreamReader(System.`in`) )
    N = br.readLine().toInt()
    M = br.readLine().toInt()

    dist = IntArray(N+1){INF};
    // 노드의 개수 만큼 인접리스트 생성
    list = ArrayList()
    for(i in 0..N) {
        list.add(ArrayList())
    }

    for(i in 1..M) {
        var st = StringTokenizer(br.readLine());
        var start = st.nextToken().toInt()
        var end = st.nextToken().toInt()
        var weight = st.nextToken().toInt()
        list[start].add(Node1916(end, weight));
    }

    var st = StringTokenizer(br.readLine())
    val start = st.nextToken().toInt()
    val end = st.nextToken().toInt()

    println(dijkstra(start, end))

} // End of main

fun dijkstra(start : Int, end : Int) : Int {
    var que : PriorityQueue<Node1916> = PriorityQueue();
    var visit : BooleanArray = BooleanArray(N + 1);
    dist[start] = 0;
    que.offer(Node1916(start, 0))

    while( !que.isEmpty() ) {
        var queNode1916 : Node1916 = que.poll();
        var start_nodeNum = queNode1916.nodeNum;

        if( !visit[start_nodeNum] ) {
            visit[start_nodeNum] = true;

            list.get(start_nodeNum).forEach {

                if( !visit[it.nodeNum] && dist[it.nodeNum] > (dist[start_nodeNum] + it.weight)) {
                    dist[it.nodeNum] = dist[start_nodeNum] + it.weight
                    que.offer(Node1916(it.nodeNum, dist[it.nodeNum]))
                }

            }
        }
    }

    return dist[end];
} // End of dijkstras