package codingtest.programmers

import kotlin.math.abs

fun main() {
    // TODO : BFS 사용해서 풀어보기
    class Solution {
        fun solution(places: Array<Array<String>>): IntArray {
            val answer = IntArray(5)

            places.forEachIndexed { index, place ->
                answer[index] = (check(place))
            }

            return answer
        }

        fun check(place: Array<String>): Int {
            val people = mutableListOf<Pair<Int, Int>>()
            val partitions = mutableSetOf<Pair<Int, Int>>()

            place.forEachIndexed { r, string ->
                string.forEachIndexed { c, letter ->
                    if (letter == 'P') {
                        people.add(Pair(r, c))
                    } else if (letter == 'X') {
                        partitions.add(Pair(r, c))
                    }
                }
            }

            people.forEachIndexed { index, pos ->
                for (i in index + 1 until people.size) {
                    val distance = abs(pos.first - people[i].first) + abs(pos.second - people[i].second)

                    if (distance > 2)
                        continue

                    if (distance == 1){
                        return 0
                    }

                    when {
                        pos.first == people[i].first -> {
                            if (!partitions.contains(Pair(pos.first, (pos.second + people[i].second) / 2))) {
                                return 0
                            }
                        }
                        pos.second == people[i].second -> {
                            if (!partitions.contains(Pair((pos.first + people[i].first) / 2, pos.second))) {
                                return 0
                            }
                        }
                        else -> {
                            if (!partitions.containsAll(
                                    listOf(
                                        Pair(pos.first, people[i].second),
                                        Pair(people[i].first, pos.second)
                                    )
                                )
                            ) {
                                return 0
                            }
                        }
                    }
                }
            }

            return 1
        }
    }

    val s = Solution()
    val result = s.solution(
        arrayOf(
            arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
            arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
            arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
            arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
            arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"),
        )
    )

    println(result.toList())
}
