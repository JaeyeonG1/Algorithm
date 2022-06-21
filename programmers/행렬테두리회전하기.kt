package programmers

fun main() {
    class Solution {
        fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
            val answer = mutableListOf<Int>()

            var matrix = Array(rows) { i -> Array(columns) { j -> i * columns + j + 1 } }

            for (query in queries) {
                rotate(matrix, query, answer)
                printMatrix(matrix)
            }

            return answer.toIntArray()
        }

        fun rotate(matrix: Array<Array<Int>>, query: IntArray, answer: MutableList<Int>) {
            val idxTop = query[0] - 1
            val idxLeft = query[1] - 1
            val idxBottom = query[2] - 1
            val idxRight = query[3] - 1

            val idxNow = intArrayOf(idxTop, idxLeft)
            var rowDirection = 0
            var colDirection = 1
            var temp = matrix[idxNow[0]][idxNow[1]]
            var min = temp

            while (true) {
                val target = matrix[idxNow[0] + rowDirection][idxNow[1] + colDirection]
                matrix[idxNow[0] + rowDirection][idxNow[1] + colDirection] = temp

                min = minOf(min, target)

                temp = target

                idxNow[0] += rowDirection
                idxNow[1] += colDirection

                if (idxNow[1] == idxRight) {
                    rowDirection = 1
                    colDirection = 0
                }
                if (idxNow[0] == idxBottom) {
                    rowDirection = 0
                    colDirection = -1
                }
                if (idxNow[1] == idxLeft) {
                    rowDirection = -1
                    colDirection = 0
                }

                if (idxNow[0] == idxTop && idxNow[1] == idxLeft)
                    break
            }

            answer.add(min)
        }

        fun printMatrix(matrix: Array<Array<Int>>) {
            for (row in matrix) {
                for (element in row) {
                    print("$element\t")
                }
                println()
            }
            println()
        }
    }

    val s = Solution()
    s.solution(6, 6, arrayOf(intArrayOf(2, 2, 5, 4), intArrayOf(3, 3, 6, 6), intArrayOf(5, 1, 6, 3))).forEach { print("$it ") }
}

// 조합 - Combination 구현
fun <T> combination(
    answer: MutableList<List<T>>,
    elements: List<T>,
    checkArr: Array<Boolean>,
    start: Int,
    target: Int
) {
    if (target == 0) {
        answer.addAll(listOf(elements.filterIndexed { index, t -> checkArr[index] }))
    } else {
        for (i in start until elements.size) {
            checkArr[i] = true
            combination(answer, elements, checkArr, i + 1, target - 1)
            checkArr[i] = false
        }
    }
}