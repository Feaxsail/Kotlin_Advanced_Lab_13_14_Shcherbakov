class Library<T> {
    private val items = mutableListOf<T>()

    fun addItem(item: T) {
        items.add(item)
    }

    fun removeItem(item: T) {
        items.remove(item)
    }

    fun getAllItems(): List<T> {
        return items.toList()
    }

    fun getItem(index: Int): T? {
        return items.getOrNull(index)
    }

    fun size(): Int {
        return items.size
    }

    fun isEmpty(): Boolean {
        return items.isEmpty()
    }

    fun clear() {
        items.clear()
    }
}

data class Book(
    val title: String,
    val author: String,
    val year: Int,
    val isbn: String
)

data class Magazine(
    val title: String,
    val issue: Int,
    val month: String
)

data class DVD(
    val title: String,
    val director: String,
    val duration: Int
)

sealed class LibraryItem {
    data class BookItem(val book: Book) : LibraryItem()
    data class MagazineItem(val magazine: Magazine) : LibraryItem()
    data class DVDItem(val dvd: DVD) : LibraryItem()
}

fun filterByYear(items: List<LibraryItem>, year: Int): List<LibraryItem> {
    return items.filter { item ->
        when (item) {
            is LibraryItem.BookItem -> item.book.year == year
            is LibraryItem.MagazineItem -> false // У журналов нет года, только месяц
            is LibraryItem.DVDItem -> false // У DVD нет года
        }
    }
}

fun sortByTitle(items: List<LibraryItem>): List<LibraryItem> {
    return items.sortedBy { item ->
        when (item) {
            is LibraryItem.BookItem -> item.book.title
            is LibraryItem.MagazineItem -> item.magazine.title
            is LibraryItem.DVDItem -> item.dvd.title
        }
    }
}

fun groupByAuthor(items: List<LibraryItem>): Map<String, List<LibraryItem.BookItem>> {
    return items.filterIsInstance<LibraryItem.BookItem>()
        .groupBy { it.book.author }
}

fun calculateTotalDuration(items: List<LibraryItem>): Int {
    return items.filterIsInstance<LibraryItem.DVDItem>()
        .sumOf { it.dvd.duration }
}

fun printLibraryItems(items: List<LibraryItem>) {
    items.forEachIndexed { index, item ->
        when (item) {
            is LibraryItem.BookItem -> {
                println("${index + 1}. КНИГА: ${item.book.title} - ${item.book.author} (${item.book.year})")
            }
            is LibraryItem.MagazineItem -> {
                println("${index + 1}. ЖУРНАЛ: ${item.magazine.title} - Выпуск ${item.magazine.issue} (${item.magazine.month})")
            }
            is LibraryItem.DVDItem -> {
                println("${index + 1}. DVD: ${item.dvd.title} - Режиссёр: ${item.dvd.director} (${item.dvd.duration} мин.)")
            }
        }
    }
}

fun main() {
    println("БИБЛИОТЕЧНАЯ СИСТЕМА")

    // Создаем книги
    val book1 = Book("Дота 2", "Пашок Пужинский", 1869, "978-5-389-00000-1")
    val book2 = Book("Преступление и наказание", "Тётя Зина", 1866, "978-5-389-00000-2")
    val book3 = Book("Мастер и Маргарита", "Фартовый Вася", 1967, "978-5-389-00000-3")
    val book4 = Book("1984", "Джорджик Пипик", 1949, "978-5-389-00000-4")

    // Создаем журналы
    val magazine1 = Magazine("National Geographic", 256, "Январь")
    val magazine2 = Magazine("Forbes", 123, "Март")

    // Создаем DVD
    val dvd1 = DVD("В паутине страха(чёктий фильм)", "Ну автор реально крутой", 175)
    val dvd2 = DVD("Побег из Шоушенка", "Фрэнк Дарабонт", 142)
    val dvd3 = DVD("Зеленая миля", "Фрэнк Дарабонт", 189)

    // Создаем библиотеку
    val library = Library<LibraryItem>()

    // Добавляем элементы в библиотеку
    library.addItem(LibraryItem.BookItem(book1))
    library.addItem(LibraryItem.BookItem(book2))
    library.addItem(LibraryItem.BookItem(book3))
    library.addItem(LibraryItem.BookItem(book4))
    library.addItem(LibraryItem.MagazineItem(magazine1))
    library.addItem(LibraryItem.MagazineItem(magazine2))
    library.addItem(LibraryItem.DVDItem(dvd1))
    library.addItem(LibraryItem.DVDItem(dvd2))
    library.addItem(LibraryItem.DVDItem(dvd3))

    println("\n1. Все элементы библиотеки (${library.size()} шт.):")
    printLibraryItems(library.getAllItems())

    println("\n2. Книги, изданные в 1869 году:")
    val books1869 = filterByYear(library.getAllItems(), 1869)
    printLibraryItems(books1869)

    println("\n3. Элементы, отсортированные по названию:")
    val sortedItems = sortByTitle(library.getAllItems())
    printLibraryItems(sortedItems)

    println("\n4. Книги, сгруппированные по авторам:")
    val booksByAuthor = groupByAuthor(library.getAllItems())
    booksByAuthor.forEach { (author, books) ->
        println("Автор: $author")
        books.forEach { book ->
            println("  - ${book.book.title} (${book.book.year})")
        }
    }

    println("\n5. Общая продолжительность всех DVD:")
    val totalDuration = calculateTotalDuration(library.getAllItems())
    println("Общая продолжительность: $totalDuration минут")

    println("\n6. Поиск по автору (Пашок Пужинский):")
    val dostoevskyBooks = booksByAuthor["Пашок Пужинский"] ?: emptyList()
    dostoevskyBooks.forEach {
        println("  - ${it.book.title} (ISBN: ${it.book.isbn})")
    }

    println("\n7. Удаление одного элемента и проверка:")
    val itemToRemove = library.getItem(0)
    if (itemToRemove != null) {
        library.removeItem(itemToRemove)
        println("Элемент удален. Осталось элементов: ${library.size()}")
    }

    println("\n8. Фильтрация DVD с продолжительностью больше 150 минут:")
    val longDVDs = library.getAllItems()
        .filterIsInstance<LibraryItem.DVDItem>()
        .filter { it.dvd.duration > 150 }
    println("DVD длительностью более 150 минут:")
    longDVDs.forEach {
        println("  - ${it.dvd.title} (${it.dvd.duration} мин.)")
    }

    println("\n9. Очистка библиотеки:")
    library.clear()
    println("Библиотека очищена. Пуста ли библиотека? ${library.isEmpty()}")
}