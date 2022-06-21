package codingtest.Templates

// 순열 - permutation 구현
fun <T> permutation(elements: List<T>, fin: List<T> = listOf(), sub: List<T> = elements): List<List<T>> {
    return if (sub.isEmpty())
        listOf(fin)
    else sub.flatMap {
        permutation(elements, fin + it, sub - it)
    }
}

// 조합 - Combination 구현
fun <T> combination(
    answer: MutableList<List<T>>,
    elements: List<T>,
    checkArr: Array<Boolean>,
    start: Int,
    target: Int
) {
    if (target == 0) {
        answer.addAll(listOf(elements.filterIndexed { index, t -> checkArr[index] }))
    } else {
        for (i in start until elements.size) {
            checkArr[i] = true
            combination(answer, elements, checkArr, i + 1, target - 1)
            checkArr[i] = false
        }
    }
}
