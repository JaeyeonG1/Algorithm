package codingtest.programmers

fun main() {
    class Solution {
        fun solution(price: Int, money: Int, count: Int): Long {
            val minus = money.toLong() - (1..count).sum() * price.toLong()

            return if (minus >= 0)
                0
            else
                minus * -1
        }
    }

    val s = Solution()
    println(s.solution(3, 20, 4))
}
