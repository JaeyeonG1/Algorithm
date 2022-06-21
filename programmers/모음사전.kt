package programmers

import kotlin.math.pow

fun main() {
    class Solution {
        fun solution(word: String): Int {
            var answer = 0

            println(-1%7)
            println(hexagramToDecimal("AAAAA"))

            return answer
        }

        fun getStartPoint(start: Char): Int = when (start) {
            'A' -> hexagramToDecimal("AAAAA")
            'E' -> hexagramToDecimal("EAAAA")
            'I' -> hexagramToDecimal("IAAAA")
            'O' -> hexagramToDecimal("OAAAA")
            'U' -> hexagramToDecimal("UAAAA")
            else -> 0
        }

        fun word2hex(word: String): List<Int> {
            return word.map {
                when (it) {
                    'A' -> 1
                    'E' -> 2
                    'I' -> 3
                    'O' -> 4
                    'U' -> 5
                    else -> 0
                }
            }
        }

        fun hexagramToDecimal(hexWord: String): Int {
            return hexWord.reversed().foldIndexed(0) { idx, sum, now ->
                sum + 6.0.pow(idx).toInt() * word2hex(now.toString())[0]
            }
        }
    }

    val s = Solution()
    s.solution("AAAAA")
}