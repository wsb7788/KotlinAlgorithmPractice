/*문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.*/
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()

    val a = ArrayList<Int>()
    for(i in 0 until n){
        val st = StringTokenizer(br.readLine())
        a.add(st.nextToken().toInt())
    }
    var min = 1001
    while(a.size>0){
        for(i in 0 until a.size){
            if(min>a[i]){
                min = a[i]
            }
        }
        println(min)
        a.remove(min)
        min=1001
    }

}