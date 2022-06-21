package programmers

import java.util.Stack
import kotlin.math.abs

class Solution {
    fun solution(expression: String): Long {
        val numbers = mutableListOf<Long>()
        val operators = mutableListOf<Char>()

        separateExpression(expression, numbers, operators)

        return getBiggest(numbers, operators)
    }

    fun separateExpression(expression: String, numbers: MutableList<Long>, operators: MutableList<Char>) {
        val numberStr = StringBuilder()
        expression.forEach {
            if (it.isDigit()) {
                numberStr.append(it)
            } else {
                numbers.add(numberStr.toString().toLong())
                numberStr.clear()
                operators.add(it)
            }
        }
        numbers.add(numberStr.toString().toLong())
    }

    fun getBiggest(numbers: List<Long>, operators: List<Char>): Long {
        val cases: List<List<Char>> = permutation(listOf('*', '-', '+'))

        return cases.map {
            calculate(numbers, operators, it)
        }.maxOf { abs(it) }
    }

    fun calculate(numbers: List<Long>, operators: List<Char>, sequence: List<Char>): Long {
        var tempNumbers = numbers
        var tempOperators = operators

        sequence.forEach { operatorSelected ->
            if (!tempOperators.contains(operatorSelected))
                return@forEach

            val seqNumbers = Stack<Long>()
            val seqOperators = Stack<Char>()
            var numberIdx = 0

            tempOperators.forEachIndexed { index, operator ->

                seqOperators.push(tempOperators[index])
                while (seqNumbers.size <= seqOperators.size && numberIdx < tempNumbers.size) {
                    seqNumbers.push(tempNumbers[numberIdx])
                    numberIdx++
                }

                if (operatorSelected == operator) {
                    val numAfter = seqNumbers.pop()
                    val numBefore = seqNumbers.pop()
                    seqNumbers.push(operate(seqOperators.pop(), numBefore, numAfter))
                }
            }

            tempNumbers = seqNumbers
            tempOperators = seqOperators
        }

        return tempNumbers[0]
    }

    fun operate(operator: Char, num1: Long, num2: Long): Long {
        return when (operator) {
            '*' -> num1 * num2
            '+' -> num1 + num2
            '-' -> num1 - num2
            else -> throw IllegalArgumentException()
        }
    }

    fun <T> permutation(elements: List<T>, fin: List<T> = listOf(), sub: List<T> = elements): List<List<T>> {
        return if (sub.isEmpty())
            listOf(fin)
        else sub.flatMap {
            permutation(elements, fin + it, sub - it)
        }
    }
}

fun main() {
    class Solution {
        fun solution(expression: String): Long {
            val numbers = mutableListOf<Long>()
            val operators = mutableListOf<Char>()

            separateExpression(expression, numbers, operators)

            return getBiggest(numbers, operators)
        }

        fun separateExpression(expression: String, numbers: MutableList<Long>, operators: MutableList<Char>) {
            val numberStr = StringBuilder()
            expression.forEach {
                if (it.isDigit()) {
                    numberStr.append(it)
                } else {
                    numbers.add(numberStr.toString().toLong())
                    numberStr.clear()
                    operators.add(it)
                }
            }
            numbers.add(numberStr.toString().toLong())
        }

        fun getBiggest(numbers: List<Long>, operators: List<Char>): Long {
            val cases: List<List<Char>> = permutation(listOf('*', '-', '+'))

            return cases.map {
                calculate(numbers, operators, it)
            }.maxOf { abs(it) }
        }

        fun calculate(numbers: List<Long>, operators: List<Char>, sequence: List<Char>): Long {
            var tempNumbers = numbers
            var tempOperators = operators

            sequence.forEach { operatorSelected ->
                if (!tempOperators.contains(operatorSelected))
                    return@forEach

                val seqNumbers = Stack<Long>()
                val seqOperators = Stack<Char>()
                var numberIdx = 0

                tempOperators.forEachIndexed { index, operator ->
                    seqOperators.push(tempOperators[index])

                    while (seqNumbers.size <= seqOperators.size && numberIdx < tempNumbers.size) {
                        seqNumbers.push(tempNumbers[numberIdx])
                        numberIdx++
                    }

                    if (operatorSelected == operator) {
                        val numAfter = seqNumbers.pop()
                        val numBefore = seqNumbers.pop()
                        seqNumbers.push(operate(seqOperators.pop(), numBefore, numAfter))
                    }
                }

                tempNumbers = seqNumbers
                tempOperators = seqOperators
            }

            return tempNumbers[0]
        }

        fun operate(operator: Char, num1: Long, num2: Long): Long {
            return when (operator) {
                '*' -> num1 * num2
                '+' -> num1 + num2
                '-' -> num1 - num2
                else -> throw IllegalArgumentException()
            }
        }

        fun <T> permutation(elements: List<T>, fin: List<T> = listOf(), sub: List<T> = elements): List<List<T>> {
            return if (sub.isEmpty())
                listOf(fin)
            else sub.flatMap {
                permutation(elements, fin + it, sub - it)
            }
        }
    }

    val s = Solution()
    println(s.solution("100-200*300-500+20"))
}