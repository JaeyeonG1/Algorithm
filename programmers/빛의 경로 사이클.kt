package programmers

fun main() {
    class Solution {
        val directions = listOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))

        fun solution(grid: Array<String>): IntArray {
            val gridList = grid.map {
                it.toList()
            }
            val gridChecker = grid.map {
                it.toList().map {
                    MutableList(4) { false }
                }
            }

            val cycleList = mutableListOf<Int>()

            for (i in gridList.indices) {
                for (j in gridList[i].indices) {
                    for (direction in directions.indices) {
                        var cycleLength = 0

                        var idxFirst = i
                        var idxSecond = j
                        var pairDir = directions[direction]

                        if (gridChecker[idxFirst][idxSecond][directions.indexOf(pairDir)])
                            continue

                        var next = move(idxFirst, idxSecond, pairDir, gridList, gridChecker)
                        idxFirst = next.first
                        idxSecond = next.second

                        while (true) {
                            cycleLength++

                            when (gridList[idxFirst][idxSecond]) {
                                'L' -> {
                                    pairDir = left(pairDir)
                                }
                                'R' -> {
                                    pairDir = right(pairDir)
                                }
                            }
                            if (gridChecker[idxFirst][idxSecond][directions.indexOf(pairDir)])
                                break

                            next = move(idxFirst, idxSecond, pairDir, gridList, gridChecker)
                            idxFirst = next.first
                            idxSecond = next.second
                        }

                        if (idxFirst == i && idxSecond == j)
                            cycleList.add(cycleLength)
                    }
                }
            }

            return cycleList.sorted().toIntArray()
        }

        fun move(
            idxFirst: Int,
            idxSecond: Int,
            direction: Pair<Int, Int>,
            gridList: List<List<Char>>,
            gridChecker: List<List<MutableList<Boolean>>>
        ): Pair<Int, Int> {
            gridChecker[idxFirst][idxSecond][directions.indexOf(direction)] = true

            val nextFirst =
                if (idxFirst + direction.first < 0) gridList.size - 1 else (idxFirst + direction.first) % gridList.size
            val nextSecond =
                if (idxSecond + direction.second < 0) gridList[0].size - 1 else (idxSecond + direction.second) % gridList[0].size

            return Pair(nextFirst, nextSecond)
        }

        fun right(pair: Pair<Int, Int>): Pair<Int, Int> {
            return if (pair.first != 0)
                Pair(pair.second, -1 * pair.first)
            else
                Pair(pair.second, pair.first)
        }

        fun left(pair: Pair<Int, Int>): Pair<Int, Int> {
            return if (pair.second != 0)
                Pair(-1 * pair.second, pair.first)
            else
                Pair(pair.second, pair.first)
        }
    }

    val s = Solution()
    println(s.solution(arrayOf("SL", "LR")).toList())
}