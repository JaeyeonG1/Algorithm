package codingtest.programmers

fun main() {
    class Solution {
        fun solution(record: Array<String>): Array<String> {
            val userMap = mutableMapOf<String, String>()
            val log = mutableListOf<Pair<String, String>>()

            record.map { it.split(" ") }.forEach {
                if (it[0] == "Enter" || it[0] == "Change")
                    userMap[it[1]] = it[2]
                if (it[0] != "Change")
                    log.add(Pair(it[0], it[1]))
            }

            return log.map {
                val sb = StringBuilder()
                sb.append(userMap[it.second])
                when (it.first) {
                    "Enter" -> sb.append("님이 들어왔습니다.")
                    "Leave" -> sb.append("님이 나갔습니다.")
                }
                sb.toString()
            }.toTypedArray()
        }
    }

    val s = Solution()
    println(
        s.solution(
            arrayOf(
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
            )
        ).toList()
    )
}
