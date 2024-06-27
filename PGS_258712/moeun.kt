class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        var answer: Int = 0
        val n = friends.size

        val gp = mutableMapOf<Int, Int>()
        val idx = mutableMapOf<String, Int>()
        val boa = Array(n) { IntArray(n) { 0 } }

        var x = 0
        friends.forEach { i ->
            // println(i)
            idx[i] = x
            gp[x] = 0
            x++
        }

    //    println(gp)

        for (i in gifts) {
            val gift = i.split(" ")
            val a = idx[gift[0]]
            val b = idx[gift[1]]

            if (a != null && b != null) {
                gp[a] = gp[a]!!.plus(1)
                gp[b] = gp[b]!!.minus(1)

                boa[a][b] += 1
            }
        }

        val gresult = IntArray(n) { 0 }
        for (i in 0..n-1) {
            for (j in i+1..n-1) {
                if (boa[i][j] > boa[j][i]) {
                    gresult[i] += 1
                }
                else if (boa[i][j] < boa[j][i]) {
                    gresult[j] += 1
                }
                else {
                    if (gp[i]!! > gp[j]!!) {
                        gresult[i] += 1
                    }
                    else if (gp[i]!! < gp[j]!!) {
                        gresult[j] += 1
                    }
                }
            }
        }

        for (i in 0..n-1) {
            if (gresult[i] > answer){
                answer = gresult[i]
            }
        }
    //    println(gp)

        return answer
    }
}
