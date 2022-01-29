import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/*문제
0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.

출력
첫째 줄에 N!을 출력한다.*/

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))

    val st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()

    val k = factorial(n,1)
    print("$k")
}

fun factorial(n: Int,fac:Int): Int {
    if (n==0){
        return fac
    }
    return n * factorial(n-1,fac)
}
