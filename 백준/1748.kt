/*문제
1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.

1234567891011121314151617181920212223...

이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 100,000,000)이 주어진다.

출력
첫째 줄에 새로운 수의 자릿수를 출력한다.

 */
import java.util.*
fun main(){
    val scan = Scanner(System.`in`)
    val n = scan.nextInt()

    var answer = 0

    for(i in 1..n){
        when(i){
            in 1..9 -> answer++
            in 10..99 -> answer+=2
            in 100..999 -> answer+=3
            in 1000..9999 -> answer+=4
            in 10000..99999 -> answer +=5
            in 100000..999999 -> answer += 6
            in 1000000..9999999 -> answer += 7
            in 10000000..99999999 -> answer += 8
            else -> answer += 9
        }
    }
    println(answer)
}