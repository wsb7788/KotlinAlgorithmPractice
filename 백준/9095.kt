/*문제
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.

1+1+1+1
1+1+2
1+2+1
2+1+1
2+2
1+3
3+1
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.

출력
각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.

*/

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val su = ArrayList<Int>()
    for(i in 0 until n){
        su.add(br.readLine().toInt())
    }
    val arr = IntArray(12)
    arr[0] = 0
    arr[1] = 1
    arr[2] = 2
    arr[3] = 4
    for (i in 4 until arr.size) {
        arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3]
    }
    for(i in 0 until su.size){
        println(arr[su[i]])
    }


}