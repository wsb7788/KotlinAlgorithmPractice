/*문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.
입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.*/
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private var n = 0
private var m = 0
private lateinit var arr:IntArray
private lateinit var visit:BooleanArray
fun main()= with(BufferedReader(InputStreamReader(System.`in`))){
    val p = readLine().split(" ").map { it.toInt() }
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    n = p[0]
    m = p[1]

    arr = IntArray(m)
    visit = BooleanArray(n)
    dfs(0,bw)
    bw.flush()
}

private fun dfs(depth:Int,bw: BufferedWriter){
    if(depth == m){
        arr.forEach { bw.write("$it ") }
        bw.newLine()
        return
    }

    for(i in 0 until n){
        arr[depth] = i+1
        visit[i] = true
        dfs(depth+1,bw)
        visit[i] = false
    }
}