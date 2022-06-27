package codingtest.programmers

import java.util.LinkedList
import java.util.Queue

fun main() {
    class Solution {
        fun solution(progresses: IntArray, speeds: IntArray): IntArray {
            val answer = mutableListOf<Int>()
            val queue: Queue<Int> = LinkedList()

            progresses.forEachIndexed { index, progress ->
                val amount = (100 - progress)
                queue.offer(amount / speeds[index] + (if (amount % speeds[index] == 0) 0 else 1))
            }

            while (queue.isNotEmpty()) {
                var count = 1
                val start = queue.poll()

                if (queue.isNotEmpty()) {
                    while (queue.peek() <= start) {
                        queue.poll()
                        count++
                        if (queue.isEmpty())
                            break
                    }
                }

                answer.add(count)
            }

            return answer.toIntArray()
        }
    }

    val s = Solution()
    s.solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5))
}
