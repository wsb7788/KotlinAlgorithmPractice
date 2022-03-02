/*문제
RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.

집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

1번 집의 색은 2번 집의 색과 같지 않아야 한다.
N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
입력
첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.*/
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val n = readLine().toInt()
    val dp = Array(n){IntArray(3)}

    for(i in 0 until n){
        val temp = readLine().split(" ").map { it.toInt() }

        dp[i][0] = temp[0]
        dp[i][1] = temp[1]
        dp[i][2] = temp[2]

    }
    for(i in 1 until n){
        dp[i][0] += min(dp[i-1][1], dp[i-1][2])
        dp[i][1] += min(dp[i-1][0], dp[i-1][2])
        dp[i][2] += min(dp[i-1][1], dp[i-1][0])
    }
    print(minOf(dp[n-1][0],dp[n-1][1],dp[n-1][2]))


}