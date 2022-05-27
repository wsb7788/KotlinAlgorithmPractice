/*문제
로봇 청소기가 주어졌을 때, 청소하는 영역의 개수를 구하는 프로그램을 작성하시오.

로봇 청소기가 있는 장소는 N×M 크기의 직사각형으로 나타낼 수 있으며, 1×1크기의 정사각형 칸으로 나누어져 있다. 각각의 칸은 벽 또는 빈 칸이다. 청소기는 바라보는 방향이 있으며, 이 방향은 동, 서, 남, 북중 하나이다. 지도의 북쪽에서부터 r번째, 서쪽에서부터 c번째로 위치한 칸은 (r, c)로 나타낼 수 있다.

로봇 청소기는 다음과 같이 작동한다.

현재 위치를 청소한다.
현재 위치에서 다음을 반복하면서 인접한 칸을 탐색한다.
현재 위치의 바로 왼쪽에 아직 청소하지 않은 빈 공간이 존재한다면, 왼쪽 방향으로 회전한 다음 한 칸을 전진하고 1번으로 돌아간다. 그렇지 않을 경우, 왼쪽 방향으로 회전한다. 이때, 왼쪽은 현재 바라보는 방향을 기준으로 한다.
1번으로 돌아가거나 후진하지 않고 2a번 단계가 연속으로 네 번 실행되었을 경우, 바로 뒤쪽이 벽이라면 작동을 멈춘다. 그렇지 않다면 한 칸 후진한다.
입력
첫째 줄에 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 50)

둘째 줄에 로봇 청소기가 있는 칸의 좌표 (r, c)와 바라보는 방향 d가 주어진다. d가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽을 바라보고 있는 것이다.

셋째 줄부터 N개의 줄에 장소의 상태가 북쪽부터 남쪽 순서대로, 각 줄은 서쪽부터 동쪽 순서대로 주어진다. 빈 칸은 0, 벽은 1로 주어진다. 지도의 첫 행, 마지막 행, 첫 열, 마지막 열에 있는 모든 칸은 벽이다.

로봇 청소기가 있는 칸의 상태는 항상 빈 칸이다.

출력
로봇 청소기가 청소하는 칸의 개수를 출력한다.*/
/*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


private var n = 0
private var m = 0
private lateinit var array: Array<IntArray>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val tempp = readLine().split(" ").map { it.toInt() }
    n = tempp[0]
    m = tempp[1]
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


}*/

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
var m = 0
lateinit var map: Array<Array<MapState>>
lateinit var cleaner: Cleaner

fun main() {
    init()
    cleaner.clean(map)
    println(cleaner.cntOfClean)
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    with(StringTokenizer(readLine())) {
        cleaner = Cleaner(nextToken().toInt(), nextToken().toInt(), nextToken().toInt())
    }
    map = Array(n) {
        with(StringTokenizer(readLine())) {
            Array(m) {
                MapState.fromId(nextToken().toInt())
            }
        }
    }
    close()
}

enum class MapState(private val id: Int) {
    CLEANED(-1),
    DIRTY(0),
    WALL(1);

    companion object {
        fun fromId(id: Int): MapState {
            return values().first { it.id == id }
        }
    }
}

class Cleaner(r: Int, c: Int, directionId: Int) {
    var cntOfClean = 0
    private var position: Position
    private var direction: Direction

    init {
        position = Position(r, c)
        direction = Direction.fromId(directionId)
    }

    fun clean(map: Array<Array<MapState>>) {
        while (true) {
            if (map[position.r][position.c] == MapState.DIRTY) {
                map[position.r][position.c] = MapState.CLEANED
                cntOfClean++
            }

            val left = position.getLeft(direction)
            if (map[left.r][left.c] == MapState.DIRTY) {
                direction = direction.rotate()
                position = left
            } else if (!position.getAdjustPositions().any { map[it.r][it.c] == MapState.DIRTY }) {
                val back = position.getBack(direction)
                if (map[back.r][back.c] == MapState.WALL) {
                    return
                } else {
                    position = back
                }
            } else {
                direction = direction.rotate()
            }
        }
    }

    class Position(var r: Int, var c: Int) {
        private fun fromDifference(dr: Int, dc: Int): Position {
            return Position(r + dr, c + dc)
        }

        fun getLeft(direction: Direction): Position {
            return when (direction) {
                Direction.NORTH -> fromDifference(0, -1)
                Direction.EAST -> fromDifference(-1, 0)
                Direction.SOUTH -> fromDifference(0, 1)
                Direction.WEST -> fromDifference(1, 0)
            }
        }

        fun getBack(direction: Direction): Position {
            return when (direction) {
                Direction.NORTH -> fromDifference(1, 0)
                Direction.EAST -> fromDifference(0, -1)
                Direction.SOUTH -> fromDifference(-1, 0)
                Direction.WEST -> fromDifference(0, 1)
            }
        }

        fun getAdjustPositions(): Array<Position> {
            return arrayOf(
                fromDifference(0, 1),
                fromDifference(0, -1),
                fromDifference(1, 0),
                fromDifference(-1, 0)
            )
        }
    }

    enum class Direction(private val id: Int) {
        NORTH(0),
        EAST(1),
        SOUTH(2),
        WEST(3);

        companion object {
            fun fromId(id: Int): Direction {
                return values().first { it.id == id }
            }
        }

        fun rotate(): Direction {
            return fromId(if (id == 0) 3 else id - 1)
        }
    }
}