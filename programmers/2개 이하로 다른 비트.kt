package programmers

import kotlin.math.pow

fun main() {
    class Solution {
        fun solution(numbers: LongArray): LongArray {
            return numbers.map { it ->
                if (it % 2 == 0L)
                    it + 1
                else {
                    val radixNum = it.toString(2).reversed()

                    var firstIdxZero = radixNum.indexOfFirst { it == '0' } - 1
                    if (firstIdxZero < 0)
                        firstIdxZero = radixNum.length - 1

                    it + 2.0.pow(firstIdxZero).toLong()
                }
            }.toLongArray()
        }
    }

    val s = Solution()
    println(s.solution(longArrayOf(2, 7)).toList())
}

