/*문제
루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.

출력
첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.*/
import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var array: Array<ArrayList<Int>>
private var n = 0
private lateinit var parents: IntArray
private lateinit var check: BooleanArray
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    array = Array(n) { ArrayList() }
    check = BooleanArray(n)
    parents = IntArray(n)
    for (i in 0 until n - 1) {
        val temp = readLine().split(" ").map { it.toInt() }
        array[temp[0] - 1].add(temp[1] - 1)
        array[temp[1] - 1].add(temp[0] - 1)
    }

    for (i in 0 until n) {
        if (!check[i]) find(i)
    }
    for (i in 1 until n) {
        println(parents[i])
    }
}

private fun find(index: Int) {
    if (check[index]) return
    check[index] = true
    for (i in array[index]) {
        if (!check[i]) {
            parents[i] = index + 1
            find(i)

        }
    }
}