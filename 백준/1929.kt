/*
문제
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.*/
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val st = readLine().split(" ").map{it.toInt()}
    val m = st[0]
    val n = st[1]
    val arr = BooleanArray(n+1){false}

    for(i in 2 .. n){
        if(!arr[i]){
            if(i>=m)
                println("$i")
            for(k in i .. n step i){
                arr[k] = true
            }
        }
    }

}