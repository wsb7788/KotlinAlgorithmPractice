/*문제
남규는 통나무를 세워 놓고 건너뛰기를 좋아한다. 그래서 N개의 통나무를 원형으로 세워 놓고 뛰어놀려고 한다. 남규는 원형으로 인접한 옆 통나무로 건너뛰는데, 이때 각 인접한 통나무의 높이 차가 최소가 되게 하려 한다.



통나무 건너뛰기의 난이도는 인접한 두 통나무 간의 높이의 차의 최댓값으로 결정된다. 높이가 {2, 4, 5, 7, 9}인 통나무들을 세우려 한다고 가정하자. 이를 [2, 9, 7, 4, 5]의 순서로 세웠다면, 가장 첫 통나무와 가장 마지막 통나무 역시 인접해 있다. 즉, 높이가 2인 것과 높이가 5인 것도 서로 인접해 있다. 배열 [2, 9, 7, 4, 5]의 난이도는 |2-9| = 7이다. 우리는 더 나은 배열 [2, 5, 9, 7, 4]를 만들 수 있으며 이 배열의 난이도는 |5-9| = 4이다. 이 배열보다 난이도가 낮은 배열은 만들 수 없으므로 이 배열이 남규가 찾는 답이 된다.

입력
입력은 T개의 테스트 케이스로 이루어져 있다. 첫 줄에 T가 주어진다.

이어지는 각 줄마다 첫 줄에 통나무의 개수를 나타내는 정수 N(5 ≤ N ≤ 10,000), 둘째 줄에 각 통나무의 높이를 나타내는 정수 Li가 주어진다. (1 ≤ Li ≤ 100,000)

출력
각 테스트 케이스마다 한 줄에 주어진 통나무들로 만들 수 있는 최소 난이도를 출력하시오.*/
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.abs

private var n = 0
private lateinit var tree : IntArray
private lateinit var sortedTree : IntArray
private var max = 0

fun main()= with(BufferedReader(InputStreamReader(System.`in`))){
    val t = readLine().toInt()

    for(i in 0 until t){

        n = readLine().toInt()
        tree = IntArray(n)
        sortedTree = IntArray(n)
        tree = readLine().split(" ").map { it.toInt() }.toIntArray()
        tree.sort()

        treeSort()
        checkMax()

        println(max)
    }
}

private fun checkMax() {
    max = 0
    var diff = 0
    for(j in 0 until n-1){
        diff = kotlin.math.abs(sortedTree[j] - sortedTree[j + 1])
        if(diff > max) max = diff
    }
    diff = kotlin.math.abs(sortedTree[0] - sortedTree[n-1])
    if(diff>max)  max = diff
}

private fun treeSort(){

    if(n%2==0){
        for( i in 0 until n/2){
            sortedTree[i] = tree[i*2]
            sortedTree[n-i-1] = tree[i*2+1]
        }
    }else{
        for( i in 0 until n/2){
            sortedTree[i] = tree[i*2]
            sortedTree[n-i-1] = tree[i*2+1]
        }
        sortedTree[n/2] = tree[n-1]
    }

}