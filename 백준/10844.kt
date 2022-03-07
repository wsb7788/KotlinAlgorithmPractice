/*문제
45656이란 수를 보자.

이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.

N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.

입력
첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.

출력
첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.*/
import java.util.*

fun main() = with(Scanner(System.`in`)){
    val n = nextInt()
    // dp[i][j] => 길이가 i일때 마지막 숫자가 j인 수의 갯수
    val dp = Array(n+1){ Array(10){0} }

    // 0
    dp[1][0] = 0

    // 1 ~ 9
    for(j in 1 until 10){
        dp[1][j] = 1
    }

    for(i in 2 until n+1){
        for(j in 0 until 10){
            when(j){
                0 -> dp[i][j] = dp[i-1][1] // 0은 1 뒤에만 추가할 수 있음
                9 -> dp[i][j] = dp[i-1][8] // 9는 8 뒤에만 추가할 수 있음
                else -> dp[i][j] = (dp[i-1][j+1] + dp[i-1][j-1]) % 1000000000
            }
        }
    }

    var sum = 0L
    dp[n].forEach { sum += it }
    sum %= 1000000000
    println(sum)
}