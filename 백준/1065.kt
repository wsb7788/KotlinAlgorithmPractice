

import java.io.*
import kotlin.math.*


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    // 한수 판별 함수
    fun ariSeq(x: Int): Int {
        var num = log10(x.toDouble()).toInt()+1
        // 두자리수 까지는 모두 한수로 판별
        if (num < 3) {
            return 1
        } else {
            // 각 자리수 배열에 넣기
            var d = x
            val arr = ArrayList<Int>()
            while (d > 0) {
                var remain = d%10
                d /= 10
                arr.add(remain)
            }
            // 각 자리수의 차를 비교하여 한수 판별
            for (i in 0..arr.size-3) {
                if ((arr[i] - arr[i+1]) != (arr[i+1] - arr[i+2])) {
                    return 0
                }
            }
            return 1
        }
    }


    var cnt = 0    // 한수 총 개수
    for (x in 1..N) {
        cnt += ariSeq(x)
    }
    println(cnt)

    br.close()

}