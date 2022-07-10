package codingtest.programmers

fun main() {
    class Solution {
        fun solution(orders: Array<String>, course: IntArray): Array<String> {
            val answer = mutableListOf<String>()

            val courseMap = mutableMapOf<String, Int>()

            orders.forEach { order ->
                course.forEach { count ->
                    val courses = mutableListOf<List<String>>()
                    combination(
                        courses, order.map { it.toString() }.sorted(), Array(order.length) { false }, 0, count
                    )
                    courses.forEach {
                        val nowCourse = it.fold("") { res, letter -> res + letter }
                        if (!courseMap.containsKey(nowCourse))
                            courseMap[nowCourse] = 1
                        else
                            courseMap[nowCourse] = courseMap[nowCourse]!! + 1
                    }
                }
            }

            course.forEach { count ->
                courseMap.filter { it.key.length == count && it.value > 1 }.run {
                    answer.addAll(this.filter {
                        it.value == this.maxOfOrNull { course -> course.value }
                    }.keys)
                }
            }
            answer.sort()

            println(answer)
            return answer.toTypedArray()
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
    assert(
        s.solution(arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"), intArrayOf(2, 3, 4))
            .contentEquals(arrayOf("AC", "ACDE", "BCFG", "CDE"))
    )
    assert(
        s.solution(arrayOf("ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"), intArrayOf(2, 3, 5))
            .contentEquals(arrayOf("ACD", "AD", "ADE", "CD", "XYZ"))
    )
    assert(
        s.solution(arrayOf("XYZ", "XWY", "WXA"), intArrayOf(2, 3, 4))
            .contentEquals(arrayOf("WX", "XY"))
    )
}

