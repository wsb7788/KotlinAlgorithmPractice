import java.io.BufferedReader
import java.io.InputStreamReader

private val dx = arrayListOf(0, 1, 0, -1)
private val dy = arrayListOf(1, 0, -1, 0)
private var answer = mutableListOf<Int>()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val size = readLine().toInt()
    val map = Array(size) { Array(size, { 0 }) }

    for (i in 0 until size) {
        val line = readLine()
        for (j in 0 until size) {
            map[i][j] = line[j].toInt() - 48
        }
    }

    for (i in 0 until size) {
        for (j in 0 until size) {
            if (map[i][j] == 1) {
                bfs(size, i, j, map)
            }
        }
    }
//정답출력
    println(answer.size)
    answer.sorted().forEach { println(it) }
}

fun bfs(size: Int, N: Int, M: Int, map: Array<Array<Int>>) {
    val queue = mutableListOf<Pair<Int, Int>>()  //큐를 저장하기 위한 페어 리스트
    var count = 0 //단지의 집 개수 카운트 변수
    val visited = Array(size) { Array(size, { 0 }) } //방문 확인용 0이면 미방문 1이면 방문

    queue.add(Pair(N, M)) //큐에 좌표추가
    visited[N][M] = 1    //들어온 좌표 방문표시

    while (!queue.isEmpty()) { //큐가 빌 때까지
        var temp = queue.removeAt(0) //큐내용 저장 후 큐 헤드 삭제

        for (i in 0 until 4) {
            val move_x = temp.first + dx[i]
            val move_y = temp.second + dy[i]

            if (move_x in 0 until size &&   //맵크기를 벗어나지 않고
                move_y in 0 until size &&
                map[move_x][move_y] == 1 &&  //집이면서
                visited[move_x][move_y] == 0 //아직 방문을 안했으면
            ) {
                queue.add(Pair(move_x, move_y))  //큐에 좌표 추가
                visited[move_x][move_y] = 1      //방문표시
                map[move_x][move_y] = 0          //집표시 삭제( main의 이중for문에서 bfs호출 중복방지을 위해)
            }
        }
        count++  //집 개수 증가
    }
    answer.add(count)  //정답리스트에 집 개수 추가
}