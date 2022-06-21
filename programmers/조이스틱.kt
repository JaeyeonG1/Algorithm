package programmers

fun main() {
    class Solution {
        fun solution(name: String): Int {
            val checker = BooleanArray(name.length) { name[it] == 'A' || it == 0 }
            println(checker.map { it.toString() })

            val moveCount = findMoveCount(name, 0, 0, checker)
            println("moveCount : $moveCount")

            val moveCountBfs = findMoveCountBfs()

            var charChangeCount = 0
            name.forEachIndexed { index, char ->
                println("Change A to ${name[index]}")
                println("Z to $char : ${'Z' + 1 - char}")
                println("A to $char : ${char - 'A'}")
                charChangeCount += minOf('Z' + 1 - char, char - 'A')
            }
            println("charChangeCount : $charChangeCount")

            return moveCount + charChangeCount
        }

        fun findMoveCount(name: String, index: Int, times: Int, checker: BooleanArray): Int {
            val nowChecker = checker.copyOf()
            nowChecker[index] = true
            println("Index : $index, Checker : ${nowChecker.map { it.toString() }}")

            return if (nowChecker.all { it } || times > name.length - 1) {
                0
            } else {
                val left = findMoveCount(name, if (index == 0) name.length - 1 else index - 1, times + 1, nowChecker)
                val right = findMoveCount(name, if (index == name.length - 1) 0 else index + 1, times + 1, nowChecker)
                minOf(left, right) + 1
            }
        }

        fun findMoveCountBfs(){

        }
    }

    val s = Solution()
    println("Result: ${s.solution("ABABAABA")}")
}
