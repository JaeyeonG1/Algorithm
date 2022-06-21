package thisiscodingtest.greedy

fun main() {
    class Solution1 { // 단순 풀이
        fun solution() {
            var answer = 0

            val inputRule = readLine()!!.split(" ")
            val n: Int = inputRule[0].toInt()
            var m: Int = inputRule[1].toInt()
            val k: Int = inputRule[2].toInt()
            val inputNumber = readLine()!!.split(" ").map { it.toInt() }.sortedDescending()
            var count = 0

            while (m != 0) {
                if (count == k) {
                    answer += inputNumber[1]
                    count = 0
                } else {
                    answer += inputNumber[0]
                    count++
                }
                m--
            }

            println(answer)
        }
    }

    class Solution2 { // 수열 식으로 변환
        fun solution() {
            var answer = 0

            val inputRule = readLine()!!.split(" ")
            val n: Int = inputRule[0].toInt()
            var m: Int = inputRule[1].toInt()
            val k: Int = inputRule[2].toInt()
            val inputNumber = readLine()!!.split(" ").map { it.toInt() }.sortedDescending()

            answer = (inputNumber[0] * (3 * (m / (k + 1)) + m % (k + 1))) + (inputNumber[1] * (m / (k + 1)))

            println(answer)
        }
    }

    Solution2().solution()
}