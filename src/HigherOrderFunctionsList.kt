class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Печенье с шоколадом",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Нуга ореховая",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Ванильный крем",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Черничный пирог",
        softBaked = true,
        hasFilling = false,
        price = 1.79
    ),
    Cookie(
        name = "Шоколадно-арахисовое масло",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Сахар и посыпка",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main() {
    println("1. forEach() - все печенья:")
    cookies.forEach {
        println(it)
    }

    println("\n2. forEach() с форматированием:")
    cookies.forEach {
        println("${it.name} - $${it.price}")
    }

    val menuItems = cookies.map { cookie ->
        "${cookie.name} - $${cookie.price}"
    }
    println("\n3. map() - меню:")
    menuItems.forEach { println(it) }

    val softCookies = cookies.filter { it.softBaked }
    println("\n4. filter() - мягкое печенье:")
    softCookies.forEach {
        println("${it.name} - $${it.price}")
    }

    val groupedMenu = cookies.groupBy { it.softBaked }
    val softBakedMenu = groupedMenu[true] ?: emptyList()
    val crunchyMenu = groupedMenu[false] ?: emptyList()
    println("\n5. groupBy() - мягкое печенье:")
    softBakedMenu.forEach { println("${it.name} - $${it.price}") }
    println("Хрустящее печенье:")
    crunchyMenu.forEach { println("${it.name} - $${it.price}") }

    val totalPrice = cookies.fold(0.0) { total, cookie ->
        total + cookie.price
    }
    println("\n6. fold() - общая цена: $${"%.2f".format(totalPrice)}")

    val alphabeticalMenu = cookies.sortedBy { it.name }
    println("\n7. sortedBy() - в алфавитном порядке:")
    alphabeticalMenu.forEach { println(it.name) }
}