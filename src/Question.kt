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


interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}


class QuizWithInterface : ProgressPrintable {
    companion object StudentProgress {
        var answered: Int = 3
        var total: Int = 10
    }

    override val progressText: String
        get() = "${answered} of ${total} answered"

    override fun printProgressBar() {
        repeat(answered) { print("▓") }
        repeat(total - answered) { print("▒") }
        println()
        println(progressText)
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


    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
            println()
        }

        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
            println()
        }

        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
            println()
        }
    }
}


fun main() {
    println(" ШАГ 10")


    println("До переноса: ${StudentProgress.answered} of ${StudentProgress.total} answered.")


    println("После переноса: ${Quiz.answered} of ${Quiz.total} answered.")


    val quiz = Quiz()
    println("Первый вопрос: ${quiz.question1.questionText}")

    println("ШАГ 11")

    println("Прогресс (extension): ${Quiz.progressText}")


    println("Прогресс-бар (extension):")
    Quiz.printProgressBar()

    println("ШАГ 12")


    val quizWithInterface = QuizWithInterface()
    println("Прогресс через интерфейс:")
    quizWithInterface.printProgressBar()

    println(" ШАГ 13")


    println("Вопросы викторины (с let()):")
    quizWithInterface.printQuiz()


    println("Использование apply():")
    QuizWithInterface().apply {
        printProgressBar()
        printQuiz()
    }
}