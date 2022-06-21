package thisiscodingtest.greedy

fun main() {
    class Solution {
        fun solution() {
            var answer = 0

            var count = readLine()!!
            val input = readLine()!!.split(" ").map { it.toInt() }.toList()
            var moneySet = mutableSetOf<Int>()

            for (i in 1 until input.size) {
                val ans = mutableListOf<List<Int>>()
                combination(ans, input, Array(input.size) { false }, 0, i)
                ans.forEach { moneySet.add(it.sum()) }
            }

            for (i in 1 until moneySet.maxOf { it }){
                if (!moneySet.contains(i)){
                    print(i)
                    return
                }
            }
        }

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
    }

    val s = Solution()
    s.solution()
}