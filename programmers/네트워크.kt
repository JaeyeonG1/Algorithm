package codingtest.programmers

import java.util.LinkedList
import java.util.Queue

fun main() {
    class Solution {
        fun solution(n: Int, computers: Array<IntArray>): Int {
            val visited = BooleanArray(n) { false }
            var count = 0

            while (visited.contains(false)) {
                val queue: Queue<IntArray> = LinkedList()
                println("First No Visited : ${visited.indexOf(false)}")
                queue.add(computers[visited.indexOf(false)])
                visited[visited.indexOf(false)] = true

                while (queue.isNotEmpty()) {
                    queue.poll().forEachIndexed { index, linked ->
                        if (!visited[index] && linked == 1) {
                            queue.add(computers[index])
                            visited[index] = true
                        }
                    }
                }
                count++
            }

            println(count)
            return count
        }
    }

    val s = Solution()
    s.solution(3, arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1)))
}

class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        val visited = BooleanArray(n) { false }
        var count = 0

        while (visited.contains(false)) {
            val queue: Queue<IntArray> = LinkedList()
            println("First No Visited : ${visited.indexOf(false)}")
            queue.add(computers[visited.indexOf(false)])
            visited[visited.indexOf(false)] = true

            while (queue.isNotEmpty()) {
                queue.poll().forEachIndexed { index, linked ->
                    if (!visited[index] && linked == 1) {
                        queue.add(computers[index])
                        visited[index] = true
                    }
                }
            }
            count++
        }

        println(count)
        return count
    }
}