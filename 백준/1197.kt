/*문제
그래프가 주어졌을 때, 그 그래프의 최소 스패닝 트리를 구하는 프로그램을 작성하시오.

최소 스패닝 트리는, 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리를 말한다.

입력
첫째 줄에 정점의 개수 V(1 ≤ V ≤ 10,000)와 간선의 개수 E(1 ≤ E ≤ 100,000)가 주어진다. 다음 E개의 줄에는 각 간선에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다. 이는 A번 정점과 B번 정점이 가중치 C인 간선으로 연결되어 있다는 의미이다. C는 음수일 수도 있으며, 절댓값이 1,000,000을 넘지 않는다.

그래프의 정점은 1번부터 V번까지 번호가 매겨져 있고, 임의의 두 정점 사이에 경로가 있다. 최소 스패닝 트리의 가중치가 -2,147,483,648보다 크거나 같고, 2,147,483,647보다 작거나 같은 데이터만 입력으로 주어진다.

출력
첫째 줄에 최소 스패닝 트리의 가중치를 출력한다.*/
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*


private var total = 0
private lateinit var list: Array<ArrayList<Node1197>>
private lateinit var visited: BooleanArray
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val v = st.nextToken().toInt()
    val e = st.nextToken().toInt()
    list = Array(v+1){ArrayList<Node1197>()}
    visited = BooleanArray(v + 1)
    for (i in 1 until v + 1) {
        list[i] = ArrayList<Node1197>()
    }
    for (i in 0 until e) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val w = st.nextToken().toInt()
        list[a].add(Node1197(b, w))
        list[b].add(Node1197(a, w))
    }
    prim(1)
    println(total)
}

private fun prim(start: Int) {
    val pq: Queue<Node1197> = PriorityQueue()
    pq.add(Node1197(start, 0))
    while (!pq.isEmpty()) {
        val p = pq.poll()
        val node = p.to
        val weight = p.value
        if (visited[node]) continue
        // 선택한 간선의 정점으로부터 가장 낮은 가중치 갖는 정점 선택
        visited[node] = true
        total += weight
        for (next in list[node]) {
            if (!visited[next.to]) {
                pq.add(next)
            }
        }
    }
}

internal class Node1197(var to: Int, var value: Int) : Comparable<Node1197?> {

    override fun compareTo(o: Node1197?): Int {
         return value - o!!.value
    }
}