package codingtest.programmers

import java.util.*

fun main() {
    class Solution {
        fun solution(n: Int, edge: Array<IntArray>): Int {
            var answer = 0

            var graph = MutableList(n + 1) { mutableListOf<Int>() }
            edge.forEach {
                graph[it[0]].add(it[1])
                graph[it[1]].add(it[0])
            }
            var lambda = { a: Int, b: Int ->
                when {
                    a < b -> 1
                    a > b -> -1
                    else -> 0
                }
            }

            var pq = PriorityQueue { a: Pair<Int, Int>, b: Pair<Int, Int> ->
                when {
                    a.first != b.first -> lambda(a.first, b.first)
                    else -> lambda(a.second, b.second)
                }
            }

            val visited = BooleanArray(n + 1) { false }

            var dist = IntArray(n + 1) { Int.MAX_VALUE }
            dist[0] = 0
            dist[1] = 0

            pq.add(Pair(0, 1))

            while (pq.isNotEmpty()) {
                val current = pq.poll()
                val distance = current.first
                val node = current.second

                if (distance > dist[node]) {
                    continue
                }

                graph[node].forEach {
                    if (dist[it] > distance + 1){
                        dist[it] = distance + 1
                        pq.add(Pair(distance + 1, it))
                    }
                }
            }

            val maxValue = dist.maxOf { it }
            dist.forEach { if (it == maxValue) answer++ }

            print(answer)
            return answer
        }
    }

    val s = Solution()
    s.solution(
        6,
        arrayOf(
            intArrayOf(3, 6),
            intArrayOf(4, 3),
            intArrayOf(3, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 2),
            intArrayOf(2, 4),
            intArrayOf(5, 2)
        )
    )
}
