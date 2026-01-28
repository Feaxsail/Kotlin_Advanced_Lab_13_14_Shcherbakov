data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {
    EASY, MEDIUM, HARD
}

fun main() {
    val question1 = Question<String>(
        "Речка спятила с ума – По домам пошла сама. ___",
        "водопровод",
        Difficulty.MEDIUM
    )

    println(question1.toString())

    val question1Copy = Question<String>(
        "Речка спятила с ума – По домам пошла сама. ___",
        "водопровод",
        Difficulty.MEDIUM
    )

    println("Равны ли объекты? ${question1 == question1Copy}")
}