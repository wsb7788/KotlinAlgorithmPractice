import java.io.BufferedReader
import java.io.InputStreamReader

private var N = 0
private var L = 0
private lateinit var road: Array<IntArray>
private lateinit var check: Array<BooleanArray>
private var count = 0
private val checkroad = ArrayList<IntArray>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val aa = readLine().split(" ").map { it.toInt() }
    N = aa[0]
    L = aa[1]
    road = Array(N) { IntArray(N) }
    check = Array(N) { BooleanArray(N) }

    for (i in 0 until N) {
        road[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }




    for(i in 0 until N){
        checkroad.add(road[i])
        if(!road[i].contentEquals(road[i].reversedArray())){
            checkroad.add(road[i].reversedArray())
        }

    }

    val tempArray = IntArray(N)
    for(i in 0 until N){
        for(k in 0 until N){
            tempArray[i] = road[k][i]
        }
        checkroad.add(tempArray)
        checkroad.add(tempArray.reversedArray())

    }

    for(i in 0 until checkroad.size){
        checking(checkroad[i])
    }

    println(count)
}
private fun checking(array:IntArray){
    var isStair = 1
    var isFirst = true
    var isIng = false
    for(i in 1 until N){
        if(array[i-1] - array[i] == 1){
            isFirst = false
            if(isIng){
                if(isStair<L){
                    break
                }else{
                    isStair = 1
                }
            }else {
                isIng = true
                isStair ++
            }
        }else if( array[i-1] - array[i] == 0){
            if(isIng) {
                isStair++
            }
        }else return
    }
        count ++


}