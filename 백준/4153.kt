import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max
import kotlin.math.pow

/*입력
입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다. 각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 각 입력은 변의 길이를 의미한다.

출력
각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.*/

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true){
        val st = StringTokenizer(br.readLine())
        var max = 0
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        if(a==b||b==c||a==0){
            break
        }
        max = maxOf(a,b,c)
        var check:Boolean
        if(a==max){
            if(max.toFloat().pow(2) == b.toFloat().pow(2)+c.toFloat().pow(2)){
                println("right")
                continue
            }else{
                println("wrong")
                continue
            }

        }else if(b==max){
            if(max.toFloat().pow(2) == a.toFloat().pow(2)+c.toFloat().pow(2)){
                println("right")
                continue
            }else{
                println("wrong")
                continue
            }
        }else{
            if(max.toFloat().pow(2) == a.toFloat().pow(2)+b.toFloat().pow(2)){
                println("right")
                continue
            }else{
                println("wrong")
                continue
            }
        }
    }
    br.close()

}