/*문제
10,000 이하의 자연수로 이루어진 길이 N짜리 수열이 주어진다. 이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N (10 ≤ N < 100,000)과 S (0 < S ≤ 100,000,000)가 주어진다. 둘째 줄에는 수열이 주어진다. 수열의 각 원소는 공백으로 구분되어져 있으며, 10,000이하의 자연수이다.

출력
첫째 줄에 구하고자 하는 최소의 길이를 출력한다. 만일 그러한 합을 만드는 것이 불가능하다면 0을 출력하면 된다.*/
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min


private var n = 0
private var s = 0
private var right = 0
private var left = 0
private var answer = 100001
private var sum = 0
private lateinit var array : IntArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val aa = readLine().split(" ").map{it.toInt()}
    n = aa[0]
    s = aa[1]
    array = readLine().split(" ").map { it.toInt() }.toIntArray()

    while(true){
        if(sum >= s) {
            sum -= array[left]
            answer = min(answer, right - left)
            left++
        }
        else if (right == n) break
        else sum += array[right++]
    }
    if(answer == 100001){
        println(0)
    }else
        println(answer)
}
