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

    println("РАЗМЕР МАССИВА")
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

    println("\n" + "=".repeat(50))
    println("=".repeat(50))

    println("Создание списка с помощью listOf()")
    val solarSystemList = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    println("Список планет: $solarSystemList")
    println("Размер списка: ${solarSystemList.size}")

    println("\n15.3: Доступ к элементам списка")
    println("Второй элемент (по индексу): ${solarSystemList[1]}")
    println("Третий элемент (по индексу): ${solarSystemList[2]}")
    println("Первый элемент (метод first()): ${solarSystemList.first()}")
    println("Последний элемент (метод last()): ${solarSystemList.last()}")

    val earthIndex = solarSystemList.indexOf("Earth")
    println("Индекс Земли в списке: $earthIndex")

    val plutoIndex = solarSystemList.indexOf("Pluto")
    println("Индекс Плутона (не найден): $plutoIndex")

    println("Перебор элементов списка с помощью цикла for")
    println("Все планеты солнечной системы:")
    for (planet in solarSystemList) {
        println("  - $planet")
    }

    println("Перебор с помощью forEach:")
    solarSystemList.forEach { planet ->
        println("  - $planet")
    }

    println("MutableList - изменяемый список")
    val mutableSolarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    println("Исходный изменяемый список: $mutableSolarSystem")

    mutableSolarSystem.add("Pluto")
    println("После добавления Pluto в конец: $mutableSolarSystem")

    mutableSolarSystem.add(3, "Future Moon")
    println("После вставки Future Moon на позицию 3: $mutableSolarSystem")

    println(" Обновление элементов списка")
    mutableSolarSystem[3] = "Future Moon Updated"
    println("После обновления элемента на позиции 3: $mutableSolarSystem")

    println("Удаление элементов из списка")

    mutableSolarSystem.removeAt(9)
    println("После удаления элемента по индексу 9: $mutableSolarSystem")

    mutableSolarSystem.remove("Future Moon Updated")
    println("После удаления элемента 'Future Moon Updated': $mutableSolarSystem")

    println("Проверка наличия элементов:")
    println("Содержит ли список 'Pluto'? ${mutableSolarSystem.contains("Pluto")}")
    println("Содержит ли список 'Future Moon'? ${mutableSolarSystem.contains("Future Moon")}")

    println("Есть ли 'Earth' в списке? ${"Earth" in mutableSolarSystem}")
    println("Есть ли 'Mars' в списке? ${"Mars" in mutableSolarSystem}")
}