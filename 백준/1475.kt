/*문제
다솜이는 은진이의 옆집에 새로 이사왔다. 다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.

다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다. 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다. 다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오. (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)

입력
첫째 줄에 다솜이의 방 번호 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 필요한 세트의 개수를 출력한다.*/
import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toInt()
    val count = Array(10){0}
    var max = 0

    while(n!=0){
        count[n%10]++
        n/=10
    }
    for(i in 0 until 10){
        if(i == 6 || i == 9)
            continue
        if(max<count[i])
            max = count[i]
    }
    var sn = count[6] + count[9]

    if(sn%2==0) {
        if (max < (sn / 2)) max = sn / 2
    }
    else {
        if (max < (sn / 2) + 1) max = sn / 2 + 1
    }
    print(max)
}