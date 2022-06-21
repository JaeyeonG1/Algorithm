package programmers

fun main() {
    class Solution {
        fun solution(line: Array<IntArray>): Array<String> {
            val points = mutableListOf<Pair<Int, Int>>()

            var maxX = Int.MIN_VALUE
            var minX = Int.MAX_VALUE
            var maxY = Int.MIN_VALUE
            var minY = Int.MAX_VALUE

            for (i in line.indices) {
                for (j in i + 1 until line.size) {
                    val (A, B, E) = line[i].map { it.toLong() }
                    val (C, D, F) = line[j].map { it.toLong() }

                    val adbc = A * D - B * C
                    val bfed = B * F - E * D
                    val ecaf = E * C - A * F

                    if (adbc == 0L)
                        continue

                    if (bfed % adbc != 0L || ecaf % adbc != 0L)
                        continue

                    val x = (bfed / adbc).toInt()
                    val y = (ecaf / adbc).toInt()

                    points.add(Pair(x, y))

                    maxX = maxX.coerceAtLeast(x)
                    minX = minX.coerceAtMost(x)
                    maxY = maxY.coerceAtLeast(y)
                    minY = minY.coerceAtMost(y)
                }
            }

            val result = Array(maxY - minY + 1) { CharArray(maxX - minX + 1) { '.' } }

            for (point in points) {
                val vertical = maxY - point.second
                val horizontal = point.first - minX
                result[vertical][horizontal] = '*'
            }

            return result.map { String(it) }.toTypedArray()
        }
    }

    val s = Solution()
    s.solution(
        arrayOf(
            intArrayOf(2, -1, 4),
            intArrayOf(-2, -1, 4),
            intArrayOf(0, -1, 1),
            intArrayOf(5, -8, -12),
            intArrayOf(5, 8, 12),
        )
    )
    s.solution(
        arrayOf(
            intArrayOf(1, -1, 0),
            intArrayOf(2, -1, 0),
            intArrayOf(4, -1, 1)
        )
    )
}

