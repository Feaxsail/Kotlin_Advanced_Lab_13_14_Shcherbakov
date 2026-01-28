fun main() {
    val solarSystem: Array<String> = arrayOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    val planets = arrayOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    println("ДОСТУП К ЭЛЕМЕНТАМ")
    println("Первый элемент: ${planets[0]}")
    println("Второй элемент: ${planets[1]}")
    println("Третий элемент: ${planets[2]}")

    println("Все планеты солнечной системы:")
    for (i in planets.indices) {
        println("${i + 1}. ${planets[i]}")
    }

    println("ИЗМЕНЕНИЕ ЭЛЕМЕНТА")
    println("До изменения: ${planets[3]}")
    planets[3] = "Red Planet"
    println("После изменения: ${planets[3]}")

    println("РАЗМЕР МАССИВА ")
    println("Размер массива: ${planets.size}")


    try {
        println("Попытка доступа к индексу 8: ${planets[8]}")
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("Ошибка: ${e.message}")
    }

    println("ОБЪЕДИНЕНИЕ МАССИВОВ")
    val dwarfPlanets = arrayOf("Pluto", "Ceres", "Eris")
    val allPlanets = planets + dwarfPlanets
    println("Все планеты после объединения:")
    allPlanets.forEachIndexed { index, planet ->
        println("${index + 1}. $planet")
    }
}