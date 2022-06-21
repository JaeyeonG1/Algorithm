package thisiscodingtest.greedy

fun main() {
    class Solution {
        fun solution() {
            var answer = 1

            val input = readLine()!!
            var now = input[0]

            input.forEach {
                if (now != it) {
                    answer++
                    now = it
                }
            }

            print(answer / 2)
        }
    }

    val s = Solution()
    s.solution()
}