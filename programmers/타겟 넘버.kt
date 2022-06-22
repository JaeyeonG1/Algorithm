package codingtest.programmers

fun main() {
    class Solution {
        fun solution(numbers: IntArray, target: Int): Int {
            val results = mutableListOf<Int>()
            var temp = listOf(0)

            for (i in numbers.indices) {
                results.clear()
                temp.forEach {
                    results.add(it + numbers[i])
                    results.add(it - numbers[i])
                }

                temp = results.toList()
            }
            numbers.fold(listOf(0)) { list, num ->
                list.run {
                    map { it + num } + map { it - num }
                }
            }.count { it == target }

            return results.count { it == target }
        }

        fun solution2(numbers: IntArray, target: Int): Int {
            return numbers.fold(listOf(0)) { list, num ->
                list.run {
                    map { it + num } + map { it - num }
                }
            }.count { it == target }
        }
    }

    val s = Solution()
    println(s.solution(intArrayOf(1, 1, 1, 1, 1), 3))
}

