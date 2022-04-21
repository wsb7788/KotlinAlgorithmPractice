/*문제
해커 김지민은 잘 알려진 어느 회사를 해킹하려고 한다. 이 회사는 N개의 컴퓨터로 이루어져 있다. 김지민은 귀찮기 때문에, 한 번의 해킹으로 여러 개의 컴퓨터를 해킹 할 수 있는 컴퓨터를 해킹하려고 한다.

이 회사의 컴퓨터는 신뢰하는 관계와, 신뢰하지 않는 관계로 이루어져 있는데, A가 B를 신뢰하는 경우에는 B를 해킹하면, A도 해킹할 수 있다는 소리다.

이 회사의 컴퓨터의 신뢰하는 관계가 주어졌을 때, 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에, N과 M이 들어온다. N은 10,000보다 작거나 같은 자연수, M은 100,000보다 작거나 같은 자연수이다. 둘째 줄부터 M개의 줄에 신뢰하는 관계가 A B와 같은 형식으로 들어오며, "A가 B를 신뢰한다"를 의미한다. 컴퓨터는 1번부터 N번까지 번호가 하나씩 매겨져 있다.

출력
첫째 줄에, 김지민이 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 오름차순으로 출력한다.*/
import java.io.*
import java.util.*

private var n = 0
private lateinit var rank: IntArray
private lateinit var list: Array<ArrayList<Int>>
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())
    n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    list = Array(n + 1){ArrayList<Int>()}
    rank = IntArray(n + 1)
    for (i in 0 until m) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        list[a].add(b)
    }

    for (i in 1 until n + 1) {
        bfs(i)
    }
    val max = rank.maxOf { it }
    for (i in 1 until n + 1) {
        if (max == rank[i]) {
            bw.write("$i ")
        }
    }
    bw.flush()
    bw.close()
}

private fun bfs(start: Int) {
    val q: Queue<Int> = LinkedList()
    val check = BooleanArray(n + 1)
    q.add(start)
    check[start] = true
    while (!q.isEmpty()) {
        val pos = q.poll()
        for (next in list[pos]) {
            if (!check[next]) {
                check[next] = true
                rank[next]++
                q.add(next)
            }
        }
    }
}
/*
import java.io.BufferedReader
import java.io.InputStreamReader

private var n = 0
private var m = 0
private lateinit var array:Array<BooleanArray>
private lateinit var visit:BooleanArray
private lateinit var nope:BooleanArray
private lateinit var check:IntArray
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var temp = readLine().split(" ").map{it.toInt()}
    n = temp[0]
    m = temp[1]
    array = Array(n+1){BooleanArray(n+1)}
    visit = BooleanArray(n+1)
    nope = BooleanArray(n+1)
    check = IntArray(n+1)
    for(i in 0 until m){
        temp = readLine().split(" ").map{it.toInt()}
        array[temp[0]][temp[1]] = true
        nope[temp[0]] = true
    }

    for(i in 1 .. n){
        if(nope[i]) continue
        check[i] = dfs(i)
    }
    val max = check.maxOf { it }
    for(i in 1 .. n ){
        if(max == check[i]) print("$i ")
    }
}

private fun dfs(num: Int):Int{
    visit[num] = true
    var count = 1
    for(i in 1 .. n ){
        if(!visit[i] && array[i][num]){
                 count += dfs(i)
        }
    }
    visit[num] = false
    return count
}*/
