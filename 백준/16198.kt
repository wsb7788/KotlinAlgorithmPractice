/*문제
N개의 에너지 구슬이 일렬로 놓여져 있고, 에너지 구슬을 이용해서 에너지를 모으려고 한다.

i번째 에너지 구슬의 무게는 Wi이고, 에너지를 모으는 방법은 다음과 같으며, 반복해서 사용할 수 있다.

에너지 구슬 하나를 고른다. 고른 에너지 구슬의 번호를 x라고 한다. 단, 첫 번째와 마지막 에너지 구슬은 고를 수 없다.
x번째 에너지 구슬을 제거한다.
Wx-1 × Wx+1의 에너지를 모을 수 있다.
N을 1 감소시키고, 에너지 구슬을 1번부터 N번까지로 다시 번호를 매긴다. 번호는 첫 구슬이 1번, 다음 구슬이 2번, ... 과 같이 매겨야 한다.
N과 에너지 구슬의 무게가 주어졌을 때, 모을 수 있는 에너지 양의 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 에너지 구슬의 개수 N(3 ≤ N ≤ 10)이 주어진다.

둘째 줄에는 에너지 구슬의 무게 W1, W2, ..., WN을 공백으로 구분해 주어진다. (1 ≤ Wi ≤ 1,000)

출력
첫째 줄에 모을 수 있는 에너지의 최댓값을 출력한다.*/
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max


private val array = ArrayList<Int>()
private var n = 0
private var max = 1
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
     n = readLine().toInt()
    array.addAll(readLine().split(" ").map { it.toInt() })
    gogo(0,0,n)
    println(max)
}

private fun gogo(count:Int, value:Int, size:Int){
    if(array.size == 2){
        max = max(max, value)
        return
    }

    for(i in 1 .. size-2){
        val temp = array[i]
        val v = value + (array[i-1] * array[i+1])
        array.removeAt(i)
        gogo(count+1, v, size-1)
        array.add(i, temp)
    }
}