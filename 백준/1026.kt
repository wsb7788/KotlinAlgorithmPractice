/*문제
옛날 옛적에 수학이 항상 큰 골칫거리였던 나라가 있었다. 이 나라의 국왕 김지민은 다음과 같은 문제를 내고 큰 상금을 걸었다.

길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.

S = A[0] × B[0] + ... + A[N-1] × B[N-1]

S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.

S의 최솟값을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. 둘째 줄에는 A에 있는 N개의 수가 순서대로 주어지고, 셋째 줄에는 B에 있는 수가 순서대로 주어진다. N은 50보다 작거나 같은 자연수이고, A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수이다.*/
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val a = ArrayList<Int>()
    val b = ArrayList<Int>()
    val aSet = StringTokenizer(br.readLine())
    val aOrder = ArrayList<Int>()
    val bSet = StringTokenizer(br.readLine())
    for(i in 0 until n){
        a.add(aSet.nextToken().toInt())
        b.add(bSet.nextToken().toInt())
    }
    a.sort()
    var sum = 0
    while(a.size>0){
        var max = -1
        var minIndex = 51
        for(i in 0 until b.size){
            if(b[i]>=max) {
                max = b[i]
                minIndex = i
            }
        }
        sum+=max * a[0]
        a.removeFirst()
        b.removeAt(minIndex)
    }
    println(sum)
}