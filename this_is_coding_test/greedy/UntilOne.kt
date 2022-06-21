package thisiscodingtest.greedy

fun main() {
    class Solution { // 단순 풀이
        fun solution() {
            var answer = 0

            val input = readLine()!!.split(" ").map { it.toInt() }
            var n = input[0]
            val k = input[1]

            while (n != 1) {
                if (n % k == 0)
                    n /= k
                else
                    n -= 1

                answer++
            }

            println(answer)
        }
    }

    class Solution1 { // 반복문 최대한 적게 돌게 구현
        fun solution() {
            var answer = 0

            val input = readLine()!!.split(" ").map { it.toInt() }
            var n = input[0]
            val k = input[1]

            while (true) {
                answer += n - (n / k * k) + 1
                n /= k

                if (n < k)
                    break
            }
            answer += n - 1

            println(answer)
        }
    }

    val s = Solution1()
    s.solution()
}