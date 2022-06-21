package week4

fun main() {
    class Solution {
        fun solution() {
            var answer = 0

            val n = readLine()!!.toInt()
            val k = readLine()!!.toInt()
            val pos = readLine()!!.split(" ").map { it.toInt() }.sorted()
            val distance = mutableListOf<Int>()

            pos.forEachIndexed { index, i ->
                if (index + 1 == pos.size)
                    return@forEachIndexed
                distance.add(pos[index + 1] - i)
            }
            if (k >= n)
                print(0)
            else
                print(distance.sortedDescending().subList(k - 1, n - 1).sum())
        }
    }

    val s = Solution()
    s.solution()
}