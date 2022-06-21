package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

const val errorMsg = "error"

fun main() {
    val solution = Solution5430()
    val testCountStr = solution.br.readLine()
    val testCount = testCountStr?.toIntOrNull()

    val result = mutableListOf<String>()

    if (testCount is Int && testCount > 0)
        repeat(testCount) {
            solution.isReversed = false
            result.add(solution.acMain())
        }
    else
        println(errorMsg)

    result.forEach {
        solution.bw.write(it+"\n")
    }

    solution.bw.flush()
    solution.bw.close()
}

class Solution5430 {
    var isReversed = false
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    fun acMain(): String {
        val func = getFunc()
        getNumCount()
        val numArray = getNumArray()

        func.forEach { if (ac(it, numArray) == -1) return errorMsg }

        return buildResultStr(numArray)
    }

    private fun getFunc(): List<Char> = br.readLine().orEmpty().toCharArray().toList()

    private fun getNumCount(): Int = br.readLine()!!.toInt()

    private fun getNumArray(): MutableList<Int> {
        var arrayString = br.readLine().orEmpty()
        arrayString = arrayString.substring(1, arrayString.length - 1)

        if (arrayString.isEmpty())
            return mutableListOf()

        return arrayString.split(",").map { it.toInt() }.toMutableList()
    }

    private fun ac(char: Char, numArray: MutableList<Int>): Int {
        if (char == 'R')
            isReversed = !isReversed

        if (char == 'D') {
            if (numArray.isNullOrEmpty())
                return -1

            when (isReversed) {
                true -> numArray.removeLast()
                false -> numArray.removeFirst()
            }
        }

        return 0
    }

    private fun buildResultStr(numArray: MutableList<Int>): String {
        val sb = StringBuilder()
        sb.append("[")

        if (isReversed)
            numArray.reverse()

        numArray.forEach {
            sb.append("$it,")
        }

        if (sb.length != 1)
            sb.setLength(sb.length - 1)
        sb.append("]")

        return sb.toString()
    }
}