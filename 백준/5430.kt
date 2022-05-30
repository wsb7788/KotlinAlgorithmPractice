/*문제
선영이는 주말에 할 일이 없어서 새로운 언어 AC를 만들었다. AC는 정수 배열에 연산을 하기 위해 만든 언어이다. 이 언어에는 두 가지 함수 R(뒤집기)과 D(버리기)가 있다.

함수 R은 배열에 있는 수의 순서를 뒤집는 함수이고, D는 첫 번째 수를 버리는 함수이다. 배열이 비어있는데 D를 사용한 경우에는 에러가 발생한다.

함수는 조합해서 한 번에 사용할 수 있다. 예를 들어, "AB"는 A를 수행한 다음에 바로 이어서 B를 수행하는 함수이다. 예를 들어, "RDD"는 배열을 뒤집은 다음 처음 두 수를 버리는 함수이다.

배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. T는 최대 100이다.

각 테스트 케이스의 첫째 줄에는 수행할 함수 p가 주어진다. p의 길이는 1보다 크거나 같고, 100,000보다 작거나 같다.

다음 줄에는 배열에 들어있는 수의 개수 n이 주어진다. (0 ≤ n ≤ 100,000)

다음 줄에는 [x1,...,xn]과 같은 형태로 배열에 들어있는 정수가 주어진다. (1 ≤ xi ≤ 100)

전체 테스트 케이스에 주어지는 p의 길이의 합과 n의 합은 70만을 넘지 않는다.

출력
각 테스트 케이스에 대해서, 입력으로 주어진 정수 배열에 함수를 수행한 결과를 출력한다. 만약, 에러가 발생한 경우에는 error를 출력한다.*/
/*
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


private var p = ""
private var n = 0
private var isReverse = false
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val array = ArrayList<Int>()
    for(k in 0 until readLine().toInt()){
        isReverse = false
        array.clear()
        p = readLine()
        n = readLine().toInt()
        val temp = readLine()
        if(temp.length != 2){
            array.addAll(temp.substring(1,temp.length-1).split(",").map { it.toInt() })
        }

        if(array.size<p.count { it=='D' }){
            bw.append("error\n")
            continue
        }
        for(i in p.indices){
            when(p[i]){
                'D' -> {
                    if(isReverse){
                        array.removeLast()
                    } else
                        array.removeFirst()
                }
                'R' -> isReverse = !isReverse
            }
        }
        bw.append("[")
        if(isReverse){
            for(i in array.size-1 downTo 0){
                if(i != 0)  bw.append("${array[i]},")
                else  bw.append("${array[i]}]\n")
            }
        }else{
            for(i in 0 until array.size){
                if(i != array.size-1)  bw.append("${array[i]},")
                else  bw.append("${array[i]}]\n")
            }
        }
    }

    bw.flush()
}*/
import java.util.*
import kotlin.collections.ArrayDeque

fun main() = with(System.`in`.bufferedReader()) { // AC
    val dq = ArrayDeque<Int>()
    val sb = StringBuilder()
    var st: StringTokenizer
    val T = readLine().toInt()

    repeat(T) { _ ->
        run block@{
            val p = readLine().toCharArray()
            val n = readLine().toInt()
            var r = false
            st = StringTokenizer(readLine(), "[],")
            repeat(n) { dq.add(st.nextToken().toInt()) }
            repeat(p.size) { i -> when (p[i]) {
                'R' -> r = !r else -> {
                    if (dq.isEmpty()) { sb.appendLine("error"); return@block }
                    else if (r) dq.removeLast()
                    else dq.removeFirst()
                }
            }
            }
            if (dq.isEmpty()) sb.appendLine("[]")
            else {
                sb.append("[").append(if (r) dq.removeLast() else dq.removeFirst())
                repeat(dq.size) { sb.append(",").append(if (r) dq.removeLast() else dq.removeFirst()) }
                sb.appendLine("]")
            }
        }
    }
    print(sb)
}