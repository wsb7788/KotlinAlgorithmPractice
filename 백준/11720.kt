import kotlin.math.pow

fun main(){
    val key = readLine()!!.toInt()
    val num = readLine().toString()
    var sum = 0
    for(i in num){
        sum += (i-'0')
    }
    println(sum)
}
