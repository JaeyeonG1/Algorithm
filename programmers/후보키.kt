package codingtest.programmers

fun main() {
    class Solution {
        fun solution(relation: Array<Array<String>>): Int {
            var answer = 0

            val combination = mutableListOf<List<Int>>()
            val candidateKey = mutableSetOf<List<Int>>()

            for (i in 1..relation[0].size)
                combination(combination, (relation[0].indices).toList(), Array(relation[0].size) { false }, 0, i)

            combination.forEach { com ->
                if (relation.size == relation.map { com.map { idx -> it[idx] } }.distinct().size
                    && !candidateKey.containsSubset(com)
                ) {
                    candidateKey.add(com)
                    answer++
                }
            }

            return answer
        }

        fun MutableSet<List<Int>>.containsSubset(combination: List<Int>): Boolean {
            return this.fold(false) { result, now -> result || combination.containsAll(now) }
        }

        fun <T> combination(
            answer: MutableList<List<T>>,
            elements: List<T>,
            checkArr: Array<Boolean>,
            start: Int,
            target: Int
        ) {
            if (target == 0) {
                answer.addAll(listOf(elements.filterIndexed { index, _ -> checkArr[index] }))
            } else {
                for (i in start until elements.size) {
                    checkArr[i] = true
                    combination(answer, elements, checkArr, i + 1, target - 1)
                    checkArr[i] = false
                }
            }
        }
    }

    val s = Solution()
    s.solution(
        arrayOf(
            arrayOf("100", "ryan", "music", "2"),
            arrayOf("200", "apeach", "math", "2"),
            arrayOf("300", "tube", "computer", "3"),
            arrayOf("400", "con", "computer", "4"),
            arrayOf("500", "muzi", "music", "3"),
            arrayOf("600", "apeach", "music", "2"),
        )
    )
}
