fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = HashMap<String, String>()

    repeat(n) {
        val poketmon = readLine()
        map[poketmon] = "${it + 1}"
        map["${it + 1}"] = poketmon
    }

    repeat(m) {
        println(map[readLine()])
    }
}