package week1

import kotlin.math.pow

fun main() {
    val solution1339 = Solution1339()

    print(solution1339.run())
}

class Solution1339 {
    fun run(): Int {
        val alphaList = mutableListOf<String>()
        val countSet = mutableMapOf<Char, Int>()
        val count = readLine()!!.toInt()

        repeat(count) {
            alphaList.add(readLine()!!)
        }

        alphaList.forEach {
            val arr = it.toCharArray()
            arr.forEachIndexed { index, char ->
                val weight = 10f.pow(arr.size - index - 1).toInt()
                countSet[char] = countSet[char]?.plus(weight) ?: weight
            }
        }

        var number = 10

        return countSet.toList().sortedByDescending { it.second }.fold(0) { sum, now ->
            number--
            sum + (number * now.second)
        }
    }
}