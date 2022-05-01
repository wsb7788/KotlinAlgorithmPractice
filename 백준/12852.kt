/*문제
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

입력
첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 자연수 N이 주어진다.

출력
첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.

둘째 줄에는 N을 1로 만드는 방법에 포함되어 있는 수를 공백으로 구분해서 순서대로 출력한다. 정답이 여러 가지인 경우에는 아무거나 출력한다.*/
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

private lateinit var dp: IntArray
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()

    val array = ArrayList<Int>()
    dp = IntArray(n+1)

    dp[1] = 0
    dp[0] = 0

    for(i in 2 .. n){
        dp[i] = dp[i-1]+1
        if(i%3==0) dp[i] = min(dp[i/3]+1,dp[i])
        if(i%2==0) dp[i] = min(dp[i/2]+1,dp[i])
    }

    println(dp[n])
    printAll(n)

}
private fun printAll(num:Int){
    if(num == 0) return
    print("$num ")

    if(num-1 >= 0 && dp[num-1]==dp[num]-1) printAll(num -1)
    else if (num % 3 == 0 && dp[num/3]==dp[num]-1) printAll(num/3)
    else if (num% 2 == 0 && dp[num/2] == dp[num] -1) printAll(num/2)
}