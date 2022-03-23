/*문제
요세푸스 문제는 다음과 같다.

1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 1,000)

출력
예제와 같이 요세푸스 순열을 출력한다.*/
import java.util.*

fun main() = with(System.`in`.bufferedReader()){
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val queue : Queue<Int> = LinkedList()
    val sb = StringBuffer("<")

    for(i in 1 .. n){
        queue.add(i)
    }

    while(queue.isNotEmpty()){
        // 맨 앞의 원소를 맨 뒤로 보냄
        for(i in 0 until k-1){
            queue.offer(queue.poll())
        }

        // k번째 원소는 뺌
        if(queue.size == 1) sb.append("${queue.poll()}>")
        else sb.append("${queue.poll()}, ")
    }

    println(sb)
}