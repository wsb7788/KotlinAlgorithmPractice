/*문제
하나 이상의 연속된 소수의 합으로 나타낼 수 있는 자연수들이 있다. 몇 가지 자연수의 예를 들어 보면 다음과 같다.

3 : 3 (한 가지)
41 : 2+3+5+7+11+13 = 11+13+17 = 41 (세 가지)
53 : 5+7+11+13+17 = 53 (두 가지)
하지만 연속된 소수의 합으로 나타낼 수 없는 자연수들도 있는데, 20이 그 예이다. 7+13을 계산하면 20이 되기는 하나 7과 13이 연속이 아니기에 적합한 표현이 아니다. 또한 한 소수는 반드시 한 번만 덧셈에 사용될 수 있기 때문에, 3+5+5+7과 같은 표현도 적합하지 않다.

자연수가 주어졌을 때, 이 자연수를 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 4,000,000)

출력
첫째 줄에 자연수 N을 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 출력한다.*/
import java.io.BufferedReader
import java.io.InputStreamReader

private var N = 0
private var start = 0
private var end = 1
private var count = 0
private lateinit var sosu :BooleanArray
private val checked = ArrayList<Int>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    N = readLine().toInt()
    sosu = BooleanArray(4000001){true}
    sosu[0] = false
    sosu[1] = false
    if(N == 2){
        println(1)
        return@with
    }
    getSosu()
    var sum = checked[0] + checked[1]
    while(checked[start]<=N) {
        if(sum > N){
            sum -= checked[start++]
        }else if( sum < N){
            if(end+1 == checked.size) break
            sum += checked[++end]
        }else {
            count++
            if(end+1 == checked.size) break
            sum = sum - checked[start++] + checked[++end]
        }
    }
    println(count)
}
fun getSosu(){
    checked.add(2)
    for(i in 3 .. 4000000 step 2){
        if(sosu[i]){
            checked.add(i)
            for(k in i*2 .. 4000000 step i){
                sosu[k] = false
            }
        }
    }
}
