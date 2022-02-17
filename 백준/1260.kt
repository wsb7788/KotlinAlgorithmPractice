/*문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

https://jason-api.tistory.com/133
*/
import java.util.*

private var visited = booleanArrayOf()
private var array : Array<IntArray> = arrayOf()
private var strArray :List<String> = listOf()
fun main(){

    var str = readLine()

    strArray = str!!.split(" ")
    array = Array(strArray[0].toInt()){ IntArray(strArray[0].toInt()) }
    visited = BooleanArray(strArray[0].toInt())
    for(i in 0 until strArray[1].toInt()){
        var input = readLine()
        var temp = input!!.split(" ")

        array[temp[0].toInt()-1][temp[1].toInt()-1]= 1
        array[temp[1].toInt()-1][temp[0].toInt()-1]= 1

    }
    visited.fill(false)
    dfs(strArray[2].toInt()-1)
    println("")
    visited.fill(false)
    bfs(strArray[2].toInt()-1)

}
private fun dfs(v : Int){
    print("${v+1} ")
    visited[v] =true

    for(i in 0 until strArray[0].toInt()){
        if(array[v][i]!=0 && !visited[i]){
            dfs(i)
        }
    }

}

private fun bfs(v : Int){
    val list : LinkedList<Int> = LinkedList()
    list.add(v)
    visited[v]=true
    print("${v+1} ")
    while (list.isNotEmpty()){
        val now = list.poll()

        for(i in 0 until strArray[0].toInt()){
            if(!visited[i] && array[now][i]!=0){
                list.add(i)
                visited[i]=true
                print("${i+1} ")
            }
        }
    }

}