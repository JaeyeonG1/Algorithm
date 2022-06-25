package codingtest.programmers

import kotlin.math.min

fun main() {
    class Solution {
        fun solution(s: String): Int {
            var answer = s.length

            for (size in 1..s.length / 2) {
                val list = mutableListOf<Pair<String, Int>>()
                var before = "-1"
                var idx = -1

                s.chunked(size).forEach {
                    if (before == it)
                        list[idx] = Pair(list[idx].first, list[idx].second + 1)
                    else {
                        list.add(Pair(it, 1))
                        before = it
                        idx++
                    }
                }

                answer = min(answer, list.fold(0) { sum, now ->
                    sum + now.first.length + (if (now.second == 1) 0 else now.second.toString().length)
                })
            }

            return answer
        }
    }

    val s = Solution()
    s.solution("ababcdcdababcdcd")
}

