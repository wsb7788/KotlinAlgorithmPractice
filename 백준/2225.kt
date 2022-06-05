/*문제
0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.

덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.

입력
첫째 줄에 두 정수 N(1 ≤ N ≤ 200), K(1 ≤ K ≤ 200)가 주어진다.

출력
첫째 줄에 답을 1,000,000,000으로 나눈 나머지를 출력한다.*/
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (N,K) = readLine().split(" ").map { it.toInt() }
    val dp = Array(K+1){IntArray(N+1){1} }
    for(i in 2 .. K){
        for(j in 1 .. N){
            dp[i][j] = (dp[i-1][j]+dp[i][j-1])%1000000000
        }
    }
    println(dp[K][N])

}