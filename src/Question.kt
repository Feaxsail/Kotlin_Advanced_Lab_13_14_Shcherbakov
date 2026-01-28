enum class Difficulty {
    EASY, MEDIUM, HARD
}

class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

fun main() {
    val question1 = Question<String>(
        "Речка спятила с ума – По домам пошла сама. ___",
        "водопровод",
        Difficulty.MEDIUM  // Используем enum константы
    )

    val question2 = Question<Boolean>(
        "Солнце встаёт на востоке.",
        true,
        Difficulty.EASY
    )

    val question3 = Question<Int>(
        "Сколько будет 2 + 2?",
        4,
        Difficulty.EASY
    )

    println("Вопрос 1 сложность: ${question1.difficulty}")
    println("Вопрос 2 сложность: ${question2.difficulty}")
    println("Вопрос 3 сложность: ${question3.difficulty}")
}