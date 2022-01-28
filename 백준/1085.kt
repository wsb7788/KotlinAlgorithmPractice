import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val x = st.nextToken().toInt()
    val y = st.nextToken().toInt()
    val w = st.nextToken().toInt()
    val h = st.nextToken().toInt()
    var min = 1000

    if(1<=w && h<=1000 && 1<=x && x<=w-1 && 1<=y && y<=h-1){

        if(x>w-x){
            if(min>w-x) min=w-x
        }
        else{
            if(min>x) min=x
        }
        if(y<h-y){
            if(min>y) min=y
            }
        else{
            if(min>h-y) min=h-y

            }

    }
    println(min)


}