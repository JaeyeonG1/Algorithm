package programmers

fun main() {
    class Solution {
        fun solution(n: Int): IntArray {
            val array: Array<IntArray> = Array(n) { intArrayOf(0) }

            for (i in 1..n) {
                array[i - 1] = IntArray(i) { 0 }
            }

            val numberLimit = (1..n).sum()
            var numberNow = 1

            var limitTop = 0
            var limitBottom = n - 1
            var limitRight = n - 1
            var shapeCount = 0

            var dirVertical = 1
            var dirHorizontal = 0

            var vertical = 0
            var horizontal = 0

            while (numberNow <= numberLimit) {
                array[vertical][horizontal] = numberNow

                if (vertical == limitTop && dirVertical < 0) {
                    shapeCount++
                    limitRight = array[n - 1 - shapeCount].indexOfLast { it == 0 }
                    limitBottom--
                    dirVertical = 1
                    dirHorizontal = 0
                }

                if (vertical == limitBottom && dirVertical > 0) {
                    dirVertical = 0
                    dirHorizontal = 1
                }

                if (horizontal == limitRight && dirHorizontal > 0) {
                    limitTop = array.indexOfFirst { it.contains(0) }
                    dirVertical = -1
                    dirHorizontal = -1
                }

                vertical += dirVertical
                horizontal += dirHorizontal
                numberNow++
            }

            return array.flatMap { it.toList() }.toIntArray()
        }
    }

    val s = Solution()
    s.solution(3)
}