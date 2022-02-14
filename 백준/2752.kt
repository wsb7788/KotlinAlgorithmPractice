/*문제
동규는 세수를 하다가 정렬이 하고싶어졌다.

숫자 세 개를 생각한 뒤에, 이를 오름차순으로 정렬하고 싶어 졌다.

숫자 세 개가 주어졌을 때, 가장 작은 수, 그 다음 수, 가장 큰 수를 출력하는 프로그램을 작성하시오.

입력
숫자 세 개가 주어진다. 이 숫자는 1보다 크거나 같고, 1,000,000보다 작거나 같다. 이 숫자는 모두 다르다.

출력
제일 작은 수, 그 다음 수, 제일 큰 수를 차례대로 출력한다.*/

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))


    var min = 1000001
    var minIndex = 3
    var max = 0
    var maxIndex = 3

    val su = br.readLine().split(" ").map{it.toInt()}

    for(i in su.indices){
        if(su[i]<=min){
            min = su[i]
            minIndex = i
        }
        if(su[i]>=max){
            max = su[i]
            maxIndex = i
        }
    }

    print("${su[minIndex]} ${su[3-(maxIndex+minIndex)]} ${su[maxIndex]}")
}