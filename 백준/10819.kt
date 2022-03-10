/*문제
N개의 정수로 이루어진 배열 A가 주어진다. 이때, 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램을 작성하시오.

|A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|

입력
첫째 줄에 N (3 ≤ N ≤ 8)이 주어진다. 둘째 줄에는 배열 A에 들어있는 정수가 주어진다. 배열에 들어있는 정수는 -100보다 크거나 같고, 100보다 작거나 같다.

출력
첫째 줄에 배열에 들어있는 수의 순서를 적절히 바꿔서 얻을 수 있는 식의 최댓값을 출력한다.*/
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs


private var max = Int.MIN_VALUE
private var n = 0
private val arr = ArrayList<Int>()
private val visit = ArrayList<Boolean>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
     n = readLine().toInt()
    val temp = readLine().split(" ").map { it.toInt() }
    for(i in 0 until n){
        arr.add(temp[i])
        visit.add(false)
    }

    for(i in 0 until n){
        visit[i] = true
        getMax(0,i,0)
        visit[i] = false
    }
    print(max)


}

private fun getMax(len:Int, index:Int,sum:Int){

    if(len == n-1){
        if(sum > max){
            max = sum
            return
        }
    }

    for(i in 0 until n){
        if(visit[i])
            continue
        visit[i] = true
        var v = sum
        v += abs(arr[index]-arr[i])
        getMax(len+1,i,v)
        visit[i] = false
    }

}