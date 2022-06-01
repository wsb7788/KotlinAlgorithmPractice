/*문제
3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.

입력
첫째 줄에 N(1 ≤ N ≤ 30)이 주어진다.

출력
첫째 줄에 경우의 수를 출력한다.

*/
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val dp = IntArray(31)
    dp[0] = 1
    dp[2] = 3
    dp[4] = 11
    for(i in 6 .. 30 step 2){
        dp[i] = dp[i-2] * 3
        for(k in 4 .. i step 2){
            dp[i] += dp[i-k]*2
        }
    }
    println(dp[n])

}