import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


private var n = 0
private var m = 0
private lateinit var array: Array<IntArray>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val temp = readLine().split(" ").map { it.toInt() }
    n = temp[0]
    m = temp[1]
    array = Array(n){IntArray(m)}
    var robot = readLine().split(" ").map { it.toInt() }

    for(i in 0 until n){
        array[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    var count = 0

    val queue = LinkedList<Triple<Int,Int,Int>>()
    queue.add(Triple(robot[0],robot[1],robot[2]))
    var nocount = 0
    while(queue.isNotEmpty()){
        count++
        val temp = queue.pop()
        if(nocount == 4){
            when(temp.third){
                0 -> {
                    if(temp.first+1<n&& array[temp.first+1][temp.second]!=1 ){
                        if(array[temp.first+1][temp.second]==2) count--
                        queue.add(Triple(temp.first+1,temp.second,0))
                        nocount = 0
                        continue
                    }else break
                }
                1 -> {
                    if(temp.second+1<m&&array[temp.first][temp.second+1]!=1){
                        if(array[temp.first][temp.second+1]==2) count--
                        queue.add(Triple(temp.first,temp.second+1,1))
                        nocount = 0
                        continue
                    }else break
                }
                2 -> {
                    if(temp.first-1>=0&&array[temp.first-1][temp.second]!=1){
                        if(array[temp.first-1][temp.second]==2) count--
                        queue.add(Triple(temp.first-1,temp.second,2))
                        nocount = 0
                        continue
                    }else break
                }
                3 -> {
                    if(temp.second-1>=0&&array[temp.first][temp.second-1]!=1){
                        if(array[temp.first][temp.second-1]==2) count--
                        queue.add(Triple(temp.first,temp.second-1,3))
                        nocount = 0
                        continue
                    }else break
                }
            }
        }

        array[temp.first][temp.second] = 2
        when(temp.third){
            0 ->{
                if(temp.second-1>=0 && array[temp.first][temp.second-1]==0){
                    queue.add(Triple(temp.first, temp.second-1, 1))
                    nocount = 0
                } else{
                    count--
                    queue.add(Triple(temp.first, temp.second, 1))
                    nocount++
                }
            }
            1 ->{
                if(temp.first+1<n && array[temp.first+1][temp.second]==0){
                    queue.add(Triple(temp.first+1, temp.second, 2))
                    nocount = 0
                } else{
                    count--
                    queue.add(Triple(temp.first, temp.second, 2))
                    nocount++
                }
            }
            2 ->{
                if(temp.second+1<m && array[temp.first][temp.second+1]==0){
                    queue.add(Triple(temp.first, temp.second+1, 3))
                    nocount = 0
                } else{
                    count--
                    queue.add(Triple(temp.first, temp.second, 3))
                    nocount++
                }
            }
            3 ->{
                if(temp.first-1>=0 && array[temp.first-1][temp.second]==0){
                    queue.add(Triple(temp.first-1, temp.second, 0))
                    nocount = 0
                } else{
                    count--
                    queue.add(Triple(temp.first, temp.second, 0))
                    nocount++
                }
            }
            else -> break
        }
    }
    println(count)


}