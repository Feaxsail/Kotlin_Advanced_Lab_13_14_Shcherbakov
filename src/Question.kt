class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: String
)

fun main() {
    val question1 = Question<String>(
        "Речка спятила с ума – По домам пошла сама. ___",
        "водопровод",
        "medium"
    )

    val question2 = Question<Boolean>(
        "Солнце встаёт на востоке.",
        true,
        "easy"
    )

    val question3 = Question<Int>(
        "Сколько будет 2 + 2?",
        4,
        "easy"
    )

    println("Вопрос 1: ${question1.questionText}")
    println("Вопрос 2: ${question2.questionText}")
    println("Вопрос 3: ${question3.questionText}")
}