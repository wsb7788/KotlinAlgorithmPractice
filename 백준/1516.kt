/*문제
숌 회사에서 이번에 새로운 전략 시뮬레이션 게임 세준 크래프트를 개발하기로 하였다. 핵심적인 부분은 개발이 끝난 상태고, 종족별 균형과 전체 게임 시간 등을 조절하는 부분만 남아 있었다.

게임 플레이에 들어가는 시간은 상황에 따라 다를 수 있기 때문에, 모든 건물을 짓는데 걸리는 최소의 시간을 이용하여 근사하기로 하였다. 물론, 어떤 건물을 짓기 위해서 다른 건물을 먼저 지어야 할 수도 있기 때문에 문제가 단순하지만은 않을 수도 있다. 예를 들면 스타크래프트에서 벙커를 짓기 위해서는 배럭을 먼저 지어야 하기 때문에, 배럭을 먼저 지은 뒤 벙커를 지어야 한다. 여러 개의 건물을 동시에 지을 수 있다.

편의상 자원은 무한히 많이 가지고 있고, 건물을 짓는 명령을 내리기까지는 시간이 걸리지 않는다고 가정하자.

입력
첫째 줄에 건물의 종류 수 N(1 ≤ N ≤ 500)이 주어진다. 다음 N개의 줄에는 각 건물을 짓는데 걸리는 시간과 그 건물을 짓기 위해 먼저 지어져야 하는 건물들의 번호가 주어진다. 건물의 번호는 1부터 N까지로 하고, 각 줄은 -1로 끝난다고 하자. 각 건물을 짓는데 걸리는 시간은 100,000보다 작거나 같은 자연수이다. 모든 건물을 짓는 것이 가능한 입력만 주어진다.

출력
N개의 각 건물이 완성되기까지 걸리는 최소 시간을 출력한다.*/
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

private data class Node1516(val number:Int, val time:Int, var degree:Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val n = readLine().toInt()
    val nodes = mutableListOf(Node1516(0,0,0))
    val graph = Array(n+1){ mutableListOf<Node1516>()}

    for(i in 1 .. n){
        val nums = readLine().split(" ").map { it.toInt() }
        nodes.add(Node1516(i, nums[0], 0))
        for(j in 1 until nums.size){
            if(nums[j] != -1){
                graph[nums[j]].add(nodes[i])
                nodes[i].degree ++
            }
        }
    }

    val results = IntArray(n+1)
    val q = LinkedList<Node1516>()
    for(i in 1 .. n){
        if(nodes[i].degree == 0){
            q.add(nodes[i])
            results[i] = nodes[i].time
        }
    }

    while(q.isNotEmpty()){
        val tempNode = q.poll()
        for( cNode in graph[tempNode.number]){
            cNode.degree --
            results[cNode.number] =
                max(results[cNode.number], results[tempNode.number] + cNode.time)
            if(cNode.degree == 0){
                q.add(cNode)
            }
        }
    }
    for( i in 1 ..n){
        println(results[i])
    }
}