package programmers

fun main() {
    val s = Solution2Of3()
    s.solution(
        arrayOf(
            "java backend junior pizza 150",
            "python frontend senior chicken 210",
            "python frontend senior chicken 150",
            "cpp backend senior pizza 260",
            "java backend junior chicken 80",
            "python backend senior chicken 50"
        ),
        arrayOf(
            "java and backend and junior and pizza 100",
            "python and frontend and senior and chicken 200",
            "cpp and - and senior and pizza 250",
            "- and backend and senior and - 150",
            "- and - and - and chicken 100",
            "- and - and - and - 150"
        )
    )
}

class Solution2Of3 {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val answer = IntArray(query.size) { 0 }

        val groups = buildGroups()
        info.map { it.split(" ") }.forEach { infoList ->
            groups.forEach {
                it.insertScore(infoList[0], infoList[1], infoList[2], infoList[3], infoList[4].toInt())
            }
        }
        groups.forEach { it.sortScores() }

        query.forEachIndexed { index, queryStr ->
            val conditions = queryStr.split(" and ", " ")
            val score = conditions[4].toInt()

            val group = groups.find { group ->
                group.lang == conditions[0] && group.position == conditions[1] && group.career == conditions[2] && group.food == conditions[3]
            }
            answer[index] = group!!.scoreList.size - lowerBound(group.scoreList, score)
        }

        return answer
    }

    fun buildGroups(): List<Group> {
        val langSet = setOf("cpp", "java", "python", "-")
        val positionSet = setOf("backend", "frontend", "-")
        val careerSet = setOf("junior", "senior", "-")
        val foodSet = setOf("pizza", "chicken", "-")

        val groupList = mutableListOf<Group>()

        langSet.forEach { lang ->
            positionSet.forEach { position ->
                careerSet.forEach { career ->
                    foodSet.forEach { food ->
                        groupList.add(Group(lang, position, career, food))
                    }
                }
            }
        }

        return groupList
    }

    fun lowerBound(list: MutableList<Int>, value: Int): Int {
        var low = 0
        var high = list.size

        while (low < high) {
            val mid = low + (high - low) / 2

            if (value <= list[mid])
                high = mid
            else
                low = mid + 1
        }
        return low
    }

    data class Group(
        val lang: String,
        val position: String,
        val career: String,
        val food: String,
        val scoreList: MutableList<Int> = mutableListOf()
    ) {
        fun insertScore(
            lang: String,
            position: String,
            career: String,
            food: String,
            score: Int
        ) {
            if ((this.lang == "-" || this.lang == lang)
                && (this.position == "-" || this.position == position)
                && (this.career == "-" || this.career == career)
                && (this.food == "-" || this.food == food)
            )
                scoreList.add(score)
        }

        fun sortScores() {
            scoreList.sort()
        }
    }
}
