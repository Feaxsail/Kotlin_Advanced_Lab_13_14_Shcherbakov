fun main() {
    val planets = arrayOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    println("Первый элемент: ${planets[0]}")
    println("Второй элемент: ${planets[1]}")
    println("Третий элемент: ${planets[2]}")

    println("\nВсе планеты солнечной системы:")
    for (i in planets.indices) {
        println("${i + 1}. ${planets[i]}")
    }

    println("\nДо изменения: ${planets[3]}")
    planets[3] = "Red Planet"
    println("После изменения: ${planets[3]}")

    println("\nРазмер массива: ${planets.size}")

    try {
        println("Попытка доступа к индексу 8: ${planets[8]}")
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("Ошибка: ${e.message}")
    }

    val dwarfPlanets = arrayOf("Pluto", "Ceres", "Eris")
    val allPlanets = planets + dwarfPlanets
    println("\nВсе планеты после объединения:")
    allPlanets.forEachIndexed { index, planet ->
        println("${index + 1}. $planet")
    }

    println("\n" + "=".repeat(50))
    println("ШАГ 15: СПИСКИ (LISTS)")
    println("=".repeat(50))

    val solarSystemList = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    println("\nСписок планет: $solarSystemList")
    println("Размер списка: ${solarSystemList.size}")

    println("\nВторой элемент: ${solarSystemList[1]}")
    println("Третий элемент: ${solarSystemList[2]}")
    println("Первый элемент: ${solarSystemList.first()}")
    println("Последний элемент: ${solarSystemList.last()}")

    val earthIndex = solarSystemList.indexOf("Earth")
    println("Индекс Земли в списке: $earthIndex")

    val plutoIndex = solarSystemList.indexOf("Pluto")
    println("Индекс Плутона: $plutoIndex")

    println("\nВсе планеты солнечной системы:")
    for (planet in solarSystemList) {
        println("  - $planet")
    }

    println("\nПеребор с помощью forEach:")
    solarSystemList.forEach { planet ->
        println("  - $planet")
    }

    val mutableSolarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    println("\nИсходный изменяемый список: $mutableSolarSystem")

    mutableSolarSystem.add("Pluto")
    println("После добавления Pluto в конец: $mutableSolarSystem")

    mutableSolarSystem.add(3, "Future Moon")
    println("После вставки Future Moon на позицию 3: $mutableSolarSystem")

    mutableSolarSystem[3] = "Future Moon Updated"
    println("После обновления элемента на позиции 3: $mutableSolarSystem")

    mutableSolarSystem.removeAt(9)
    println("После удаления элемента по индексу 9: $mutableSolarSystem")

    mutableSolarSystem.remove("Future Moon Updated")
    println("После удаления элемента 'Future Moon Updated': $mutableSolarSystem")

    println("\nСодержит ли список 'Pluto'? ${mutableSolarSystem.contains("Pluto")}")
    println("Содержит ли список 'Future Moon'? ${mutableSolarSystem.contains("Future Moon")}")
    println("Есть ли 'Earth' в списке? ${"Earth" in mutableSolarSystem}")
    println("Есть ли 'Mars' в списке? ${"Mars" in mutableSolarSystem}")

    println("\n" + "=".repeat(50))
    println("ШАГ 16: МНОЖЕСТВА (SETS)")
    println("=".repeat(50))

    val solarSystemSet = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    println("\nИсходное множество: $solarSystemSet")
    println("Размер множества: ${solarSystemSet.size}")

    solarSystemSet.add("Pluto")
    println("\nПосле добавления Pluto: $solarSystemSet")
    println("Размер после добавления: ${solarSystemSet.size}")

    println("\nЕсть ли 'Earth' в множестве? ${solarSystemSet.contains("Earth")}")
    println("Есть ли 'Pluto' в множестве? ${"Pluto" in solarSystemSet}")

    println("\nПробуем добавить 'Pluto' ещё раз...")
    solarSystemSet.add("Pluto")
    println("Множество после повторной попытки: $solarSystemSet")
    println("Размер остался: ${solarSystemSet.size}")

    solarSystemSet.remove("Pluto")
    println("\nПосле удаления Pluto: $solarSystemSet")
    println("Размер после удаления: ${solarSystemSet.size}")

    val numbers = setOf(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
    println("\nИсходный список чисел: [1, 2, 3, 4, 5, 1, 2, 3, 4, 5]")
    println("Множество: $numbers")
    println("Размер множества: ${numbers.size}")

    val mixedSet = mutableSetOf("Яблоко", 42, 3.14, true, "Яблоко")
    println("\nСмешанное множество: $mixedSet")
    println("Размер: ${mixedSet.size}")

    val set1 = setOf(1, 2, 3, 4, 5)
    val set2 = setOf(4, 5, 6, 7, 8)

    println("\nМножество 1: $set1")
    println("Множество 2: $set2")
    println("Объединение: ${set1.union(set2)}")
    println("Пересечение: ${set1.intersect(set2)}")
    println("Разность: ${set1.subtract(set2)}")

    println("\n" + "=".repeat(50))
    println("ШАГ 17: КАРТЫ (MAPS)")
    println("=".repeat(50))

    val solarSystem = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )

    println("\nКоличество планет в карте: ${solarSystem.size}")

    solarSystem["Pluto"] = 5
    println("После добавления Pluto: ${solarSystem.size}")

    println("\nСпутников у Земли: ${solarSystem["Earth"]}")
    println("Спутников у Pluto: ${solarSystem["Pluto"]}")

    println("Спутников у Цереры: ${solarSystem["Ceres"]}")

    val removedValue = solarSystem.remove("Pluto")
    println("\nУдалено значение: $removedValue")
    println("После удаления Pluto: ${solarSystem.size}")

    solarSystem["Jupiter"] = 80
    println("\nОбновлённое количество спутников Юпитера: ${solarSystem["Jupiter"]}")

    println("\nВсе планеты и их спутники:")
    for ((planet, moons) in solarSystem) {
        println("$planet: $moons спутников")
    }

    println("\nКлючи (планеты): ${solarSystem.keys}")
    println("Значения (спутники): ${solarSystem.values}")

    println("\nСодержит ключ 'Earth'? ${solarSystem.containsKey("Earth")}")
    println("Содержит значение 1? ${solarSystem.containsValue(1)}")

    solarSystem.putIfAbsent("Earth", 2)
    println("\nПосле putIfAbsent 'Earth' с 2: ${solarSystem["Earth"]}")

    solarSystem.putIfAbsent("New Planet", 10)
    println("После putIfAbsent 'New Planet' с 10: ${solarSystem["New Planet"]}")
}