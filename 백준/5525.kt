/*문제
N+1개의 I와 N개의 O로 이루어져 있으면, I와 O이 교대로 나오는 문자열을 PN이라고 한다.

P1 IOI
P2 IOIOI
P3 IOIOIOI
PN IOIOI...OI (O가 N개)
I와 O로만 이루어진 문자열 S와 정수 N이 주어졌을 때, S안에 PN이 몇 군데 포함되어 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. 둘째 줄에는 S의 길이 M이 주어지며, 셋째 줄에 S가 주어진다.

출력
S에 PN이 몇 군데 포함되어 있는지 출력한다.

제한
1 ≤ N ≤ 1,000,000
2N+1 ≤ M ≤ 1,000,000
S는 I와 O로만 이루어져 있다.*/
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main()=with(br){
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    val parent = readLine()
    var pattern = 0
    var ans = 0
    var i = 0
    while(i<m-2){
        if(parent[i]=='I' && parent[i+1] == 'O' && parent[i+2] == 'I') {
            pattern++
            if(pattern == n){
                pattern--
                ans++
            }
            i++
        }
        else{
            pattern = 0
        }
        i++
    }
    bw.write("$ans")
    bw.flush()
    bw.close()
}

