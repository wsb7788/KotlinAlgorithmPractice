private fun main() {

    val n = readLine()!!.toInt()

    var arr = Array<Pair<Int, Int>>(n) { Pair(0, 0) }
    var rank = IntArray(n){1}

    for (i in 0 until n) {
        val s = readLine()!!.split(' ').map(String::toInt)
        arr[i] = Pair(s[0], s[1])
    }
    for (i in 0 until n ){
        for (j in 0 until n){
            if (arr[i].first > arr[j].first && arr[i].second>arr[j].second)
                rank[j]++
        }
    }
    rank.forEach {
        print("$it ")
    }

}