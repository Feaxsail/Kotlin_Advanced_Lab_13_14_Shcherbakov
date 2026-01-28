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


val Quiz.StudentProgress.progressText: String
    get() = "$answered of $total answered"

fun Quiz.StudentProgress.printProgressBar() {
    repeat(answered) { print("▓") }
    repeat(total - answered) { print("▒") }
    println()
    println(progressText)
}





fun main() {


    println(" ШАГ 11")

    println("Прогресс (extension): ${Quiz.progressText}")


    println("Прогресс-бар (extension):")
    Quiz.printProgressBar()


}