/*문제
수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.

예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만,  {1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.

수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수열 A의 크기 N이 주어지고, 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ N ≤ 1,000, 1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 부분 수열 중에서 가장 긴 바이토닉 수열의 길이를 출력한다.*/
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

private var n =0
private lateinit var array : IntArray
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    n = readLine().toInt()
    array = readLine().split(" ").map { it.toInt() }.toIntArray()
    val leftDp = IntArray(n){1}
    val rightDp = IntArray(n){1}

    for(i in 1 until n){
        for(k in 0 until i){
            if(array[i]>array[k]) leftDp[i] = max(leftDp[i], leftDp[k] + 1)
        }
    }
    for(i in n-2 downTo 0){
        for(k in n-1 downTo i){
            if(array[i]>array[k]) rightDp[i] = max(rightDp[i], rightDp[k] + 1)
        }
    }

    var result = 0
    for(i in 0 until n){
        result = max(result, leftDp[i] + rightDp[i])
    }
    println(result-1)
}