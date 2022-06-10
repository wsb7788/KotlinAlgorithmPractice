/*문제
초기에 {0}, {1}, {2}, ... {n} 이 각각 n+1개의 집합을 이루고 있다. 여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.

집합을 표현하는 프로그램을 작성하시오.

입력
첫째 줄에 n(1 ≤ n ≤ 1,000,000), m(1 ≤ m ≤ 100,000)이 주어진다. m은 입력으로 주어지는 연산의 개수이다. 다음 m개의 줄에는 각각의 연산이 주어진다. 합집합은 0 a b의 형태로 입력이 주어진다. 이는 a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미이다. 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태로 입력이 주어진다. 이는 a와 b가 같은 집합에 포함되어 있는지를 확인하는 연산이다. a와 b는 n 이하의 자연수 또는 0이며 같을 수도 있다.

출력
1로 시작하는 입력에 대해서 한 줄에 하나씩 YES/NO로 결과를 출력한다. (yes/no 를 출력해도 된다)*/
import java.lang.StringBuilder

private lateinit var parent : Array<Int>
fun main(args: Array<String>) = with(System.`in`.bufferedReader()){
    val(n, m) = readLine().split(" ").map { it.toInt() }
    parent = Array(n + 1) {i -> i}
    val sb = StringBuilder()
    repeat(m) {
        val(cmd, a, b) = readLine().split(" ").map { it.toInt() }
        when(cmd) {
            0 -> union(a, b)
            1 -> if(isUnion(a, b)) {sb.append("YES \n")} else {sb.append("NO \n")}
        }
    }
    print(sb.toString())


}
private fun find(x : Int) : Int {
    if (parent[x] == x) return x
    parent[x] = find(parent[x])
    return parent[x]
}
private fun union(a : Int, b : Int) {
    val A = find(a)
    val B = find(b)

    if (A == B) return
    parent[B] = A
}
private fun isUnion(a : Int, b : Int) : Boolean {
    val A = find(a)
    val B = find(b)

    if (A == B) return true
    return false
}