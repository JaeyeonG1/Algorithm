package programmers.skillcheck

class Solution1Of1 {
    fun solution(n: Int): Int {
        return n.toString().fold(0) { sum, now -> sum + now.digitToInt()}
    }
}