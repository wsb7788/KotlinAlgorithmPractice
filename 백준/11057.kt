/*문제
오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다. 이때, 인접한 수가 같아도 오름차순으로 친다.

예를 들어, 2234와 3678, 11119는 오르막 수이지만, 2232, 3676, 91111은 오르막 수가 아니다.

수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.

입력
첫째 줄에 N (1 ≤ N ≤ 1,000)이 주어진다.

출력
첫째 줄에 길이가 N인 오르막 수의 개수를 10,007로 나눈 나머지를 출력한다.

 */
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val dp = Array(n+1){ IntArray(10){1} }
    val result = IntArray(n+1)
    result[1] = 10
    if(n == 1){
        println(10)
        return
    }
    for(i in 2 .. n){
        for(j in 0 until 10){
            if(j == 0){
                dp[i][j] = dp[i-1][j]
            }else{
                dp[i][j] = dp[i][j-1] + dp[i-1][j]
                dp[i][j] %= 10007
            }
            result[i] += dp[i][j]
        }
    }
    println(result[n] % 10007)


}