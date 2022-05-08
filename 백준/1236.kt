import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = System.out.bufferedWriter()

    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val guardL = BooleanArray(n)
    val guardW = BooleanArray(m)
    var length = n
    var width = m

    repeat(n) { l ->
        val chars = br.readLine().toCharArray()
        repeat(m) { w ->
            // 경비원이 있는 칸
            // 세로칸 체크
            if (chars[w] == 'X' && !guardL[l]) {
                guardL[l] = true
                length--
            }
            // 가로칸 체크
            if (chars[w] == 'X' && !guardW[w]) {
                guardW[w] = true
                width--
            }
        }
    }

    val answer = if (length > width) length else width
    bw.write("${answer}\n")
    bw.flush()
    bw.close()
    br.close()
}