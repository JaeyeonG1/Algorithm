package thisiscodingtest.greedy

fun main() {
    class Solution {
        fun solution() {
            var answer = 0

            val input = readLine()!!.split("").toMutableList().mapNotNull { it.toIntOrNull() }

            input.forEach {
                if (answer + it > answer * it)
                    answer += it
                else
                    answer *= it
            }

            println(answer)
        }
    }

    val s = Solution()
    s.solution()
}