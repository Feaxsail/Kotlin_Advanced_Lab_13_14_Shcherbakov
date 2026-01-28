fun displayMessage(mes: () -> Unit) {
    mes()
}

fun morning() {
    println("Доброе утро!")
}

fun action(a: Int, b: Int, operation: (Int, Int) -> Int) {
    val result = operation(a, b)
    println(result)
}

fun sum(x: Int, y: Int) = x + y
fun multiply(x: Int, y: Int) = x * y
fun subtract(x: Int, y: Int) = x - y

fun selectAction(key: Int): (Int, Int) -> Int {
    return when (key) {
        1 -> ::sum
        2 -> ::multiply
        else -> ::subtract
    }
}

fun main() {

    displayMessage(::morning)

    action(5, 3, ::sum) // 8
    action(5, 3, ::multiply) // 15
    action(5, 3, ::subtract) // 2

    val action1 = selectAction(1)
    println(action1(10, 5))

    val action2 = selectAction(2)
    println(action2(10, 5))

    val action3 = selectAction(3)
    println(action3(10, 5))
}