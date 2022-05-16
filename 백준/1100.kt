import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    var map: Array<CharArray> = Array(8) { CharArray(8) }

    var cnt: Int = 0

    for ( i in 0 until 8 ) {
        val str= readLine().toCharArray()
        for ( j in 0 until 8 ) {
            map[i][j] = str[j]

        }
    }

    for ( i in 0 until 8 ) {
        for ( j in 0 until 8 ) {
            if ( i % 2 == 0 && j % 2 == 0 && map[i][j] == 'F')
                cnt += 1
            if ( i % 2 == 1 && j % 2 == 1 && map[i][j] == 'F')
                cnt += 1
        }
    }

    println(cnt)

}