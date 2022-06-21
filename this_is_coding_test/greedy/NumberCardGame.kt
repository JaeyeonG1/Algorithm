package thisiscodingtest.greedy

fun main() {
    class Solution {
        fun solution() {
            var answer = 0

            val inputSetting = readLine()!!.split(" ").map { it.toInt() }
            val n = inputSetting[0]
            val m = inputSetting[1]

            val cards = mutableListOf<Int>()
            for (i in 0 until n){
               cards.add(readLine()!!.split(" ").map { it.toInt() }.minOf { it })
            }
            answer = cards.maxOf { it }

            println(answer)
        }
    }

    val s = Solution()
    s.solution()
}