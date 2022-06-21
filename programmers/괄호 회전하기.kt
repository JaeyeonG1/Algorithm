package programmers

import java.util.Stack

fun main() {
    class Solution {
        fun solution(s: String): Int {
            var answer = 0

            for (i in s.indices) {
                val str = s.substring(i + 1 until s.length) + s.substring(0..i)
                println(str)
                val tempStack = Stack<Char>()

                for (j in str.indices) {
                    if ((str[j] == ')' || str[j] == '}' || str[j] == ']') && tempStack.size == 0)
                        break
                    when (str[j]) {
                        ')' -> if (tempStack.pop() != '(') break
                        '}' -> if (tempStack.pop() != '{') break
                        ']' -> if (tempStack.pop() != '[') break
                        else -> tempStack.push(str[j])
                    }
                    if (j == s.length - 1 && tempStack.isEmpty())
                        answer++
                }
            }

            return answer
        }
    }

    val s = Solution()
    println(s.solution("[](){}"))
}