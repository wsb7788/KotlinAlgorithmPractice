/*문제
모든 자리가 1로만 이루어져있는 두 자연수 A와 B가 주어진다. 이때, A와 B의 최대 공약수를 구하는 프로그램을 작성하시오.

예를 들어, A가 111이고, B가 1111인 경우에 A와 B의 최대공약수는 1이고, A가 111이고, B가 111111인 경우에는 최대공약수가 111이다.

입력
첫째 줄에 두 자연수 A와 B를 이루는 1의 개수가 주어진다. 입력되는 수는 263보다 작은 자연수이다.

출력
첫째 줄에 A와 B의 최대공약수를 출력한다. 정답은 천만 자리를 넘지 않는다.*/
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main()=with(BufferedReader(InputStreamReader(System.`in`))){

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val temp  = readLine().split(" ").map { it.toLong() }
    val a = temp[0]
    val b = temp[1]
    var result = check(a,b)
    for(i in 0 until result){
        bw.write("1")
    }
    bw.flush()
}

private fun check(a:Long,b:Long):Long{
    if(a%b==0L){
        return b
    }
    return(check(b,a%b))
}