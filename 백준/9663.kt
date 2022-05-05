/*문제
N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (1 ≤ N < 15)

출력
첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.*/
import java.lang.Math.abs
import java.util.*

private var n = 0
private var sum = 0
private var col = Array(15){0}

fun main(args : Array<String>) = with(Scanner(System.`in`)){
    n = nextInt()
    dfs(0)
    println(sum)
}

private fun dfs(x : Int){
    if(x == n) sum++
    else{
        for(i in 0 until n){
            col[x] = i // x 번째 열의 i 번째 행
            if(check(x))
                dfs(x+1) // 퀸을 놓았다면 다음열로 (열체크 필요 X)
        }
    }
}

private fun check(level : Int) : Boolean{
    for(i in 0 until level)
        if(col[i] == col[level] || abs(col[level] - col[i]) == level - i) return false
    // 같은 행에 있거나 대각선에 있으면 false
    return true
}