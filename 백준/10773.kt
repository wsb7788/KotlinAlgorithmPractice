import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val n  = br.readLine().toInt()
    val su = ArrayList<Int>()
    for(i in 0 until n){
        val temp = br.readLine().toInt()
        if(temp == 0){
            su.removeLast()
        }else
            su.add(temp)
    }
    var sum = 0
    for(i in su.indices ){
        sum+=su[i]
    }
    print(sum)
}