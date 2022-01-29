import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/*문제
세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.

입력
세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.

출력
직사각형의 네 번째 점의 좌표를 출력한다.*/

fun main(){

    val x = ArrayList<Int>()
    val y = ArrayList<Int>()
    val br = BufferedReader(InputStreamReader(System.`in`))

    for(i in 0 ..2){
        val st = StringTokenizer(br.readLine())
        x.add(st.nextToken().toInt())
        y.add(st.nextToken().toInt())
    }



    val Ax:Int = if(x[0]==x[1])
        x[2]
    else if(x[1]==x[2])
        x[0]
    else
        x[1]

    val Ay:Int = if(y[0]==y[1])
        y[2]
    else if(y[1]==y[2])
        y[0]
    else
        y[1]

    print("$Ax $Ay")
    br.close()
}