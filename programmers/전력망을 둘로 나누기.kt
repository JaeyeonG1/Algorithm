package programmers

import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs

fun main() {
    class Solution {
        fun solution(n: Int, wires: Array<IntArray>): Int {
            val graph = MutableList(n + 1) { MutableList(n + 1) { false } }

            wires.forEach {
                graph[it[0]][it[1]] = true
                graph[it[1]][it[0]] = true
            }

            var min = n

            for (it in wires) {
                graph[it[0]][it[1]] = false
                graph[it[1]][it[0]] = false

                val count = bfs(graph)

                if (abs(n - 2 * count) < min)
                    min = abs(n - 2 * count)

                graph[it[0]][it[1]] = true
                graph[it[1]][it[0]] = true

                if (min == 0)
                    break
            }

            return min
        }

        fun bfs(graph: List<List<Boolean>>): Int {
            val queue: Queue<List<Boolean>> = LinkedList()

            var count = 0
            val visited = BooleanArray(graph.size) { false }
            queue.add(graph[1])
            visited[1] = true

            while (queue.isNotEmpty()) {
                count++
                queue.poll().forEachIndexed { index, isLinked ->
                    if (!visited[index] && isLinked) {
                        queue.add(graph[index])
                        visited[index] = true
                    }
                }
            }

            return count
        }
    }

    val s = Solution()
    println(
        s.solution(
            6,
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 5),
                intArrayOf(2, 6),
                intArrayOf(3, 4),
                intArrayOf(4, 5)
            )
        )
    )
}
