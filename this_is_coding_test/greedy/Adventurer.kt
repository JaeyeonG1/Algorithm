package thisiscodingtest.greedy

fun main() {
    class Solution {
        fun solution() {
            var answer = 0

            val numAdv = readLine()!!.toInt()
            val advMap = readLine()!!.split(" ").map { it.toInt() }.toList().sorted()

            var count = 0
            advMap.forEach {
                count++
                if (count == it){
                    answer++
                    count = 0
                }
            }

            print(answer)
        }
    }

    val s = Solution()
    s.solution()
}