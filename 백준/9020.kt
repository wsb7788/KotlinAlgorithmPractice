import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){

    // 에라토스테네스의 체
    val sosu = Array<Boolean>(10000){true}
    sosu[0] = false
    sosu[1] = false
    for(i in 2..100){
        for(k in i*2 .. 9999 step i)
            if(sosu[k])
                sosu[k] = false
    }
    val realSosu = ArrayList<Int>()
    for(i in 3..9999){
        if(sosu[i])
            realSosu.add(i)
    }


    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val input = ArrayList<Int>()
    for(i in 0 until n){
        val stInput = StringTokenizer(br.readLine())
        input.add(stInput.nextToken().toInt())
    }
    for(i in 0 until input.size){
        for(k in 0 until realSosu.size-1){
            for(h in k+1 until realSosu.size){
                if(realSosu[k]+realSosu[h] == input[i]){
                    println("${realSosu[k]} ${realSosu[h]}")
                }

            }
        }

    }


}