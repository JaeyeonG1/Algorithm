package thisiscodingtest.etc

import kotlin.math.abs

fun main() {
    class Solution {
        fun solution() {
            val n = readLine()!!.toInt()
            val list = mutableListOf<Pair<Int, Int>>()
            for (i in 0 until n) {
                readLine()!!.split(" ").map { it.toInt() }.also {
                    list.add(Pair(it.minOrNull(), it.maxOrNull()) as Pair<Int, Int>)
                }
            }
            val length = readLine()!!.toInt()

            list.removeIf { it.diff() > length }
        }

        fun Pair<Int, Int>.diff() = abs(first - second)
    }

    val s = Solution()
    s.solution()
}