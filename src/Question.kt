
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {
    EASY, MEDIUM, HARD
}

object StudentProgress {
    var answered: Int = 0
    var total: Int = 10
}

class Quiz1 {
    val question1 = Question<String>(
        "Речка спятила с ума – По домам пошла сама. ___",
        "водопровод",
        Difficulty.MEDIUM
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
}


class Quiz {
    companion object StudentProgress {
        var answered: Int = 3
        var total: Int = 10
    }

    val question1 = Question<String>(
        "Речка спятила с ума – По домам пошла сама. ___",
        "водопровод",
        Difficulty.MEDIUM
    )

    val question2 = Question<Boolean>(
        "Сколько будет 2 + 2?",
        true,
        Difficulty.EASY
    )

    val question3 = Question<Int>(
        "Солнце встаёт на востоке.",
        4,
        Difficulty.EASY
    )
}

fun main() {
    println("=== ШАГ 10: Singleton и companion object ===")

    println("До переноса: ${StudentProgress.answered} of ${StudentProgress.total} answered.")

    println("После переноса: ${Quiz.answered} of ${Quiz.total} answered.")

    val quiz = Quiz()
    println("Первый вопрос: ${quiz.question1.questionText}")


}