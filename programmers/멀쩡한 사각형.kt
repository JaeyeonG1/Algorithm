package codingtest.programmers

import kotlin.math.max
import kotlin.math.min

fun main() {
    class Solution {
        fun solution(w: Int, h: Int): Long {
            val min = min(w, h).toLong()
            val max = max(w, h).toLong()

            val temp = min / gcd(max, min)
            return min * max - (min + max - min / temp)
        }

        fun gcd(a: Long, b: Long): Long {
            return if (b == 0L)
                a
            else
                gcd(b, a % b)
        }
    }

    val s = Solution()
    println(s.solution(8, 12))
}
