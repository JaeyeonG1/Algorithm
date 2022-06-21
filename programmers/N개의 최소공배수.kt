package programmers

fun main() {
    class Solution {
        fun solution(arr: IntArray): Int {
            var lcmNow = arr[0]
            for (i in 1..arr.lastIndex) {
                lcmNow = lcmNow * arr[i] / gcd(lcmNow, arr[i])
            }
            return lcmNow
        }

        fun gcd(a: Int, b: Int): Int {
            return if (b == 0)
                a
            else
                gcd(b, a % b)
        }
    }

    val s = Solution()
    s.solution(intArrayOf(2, 6, 8, 14))
}
