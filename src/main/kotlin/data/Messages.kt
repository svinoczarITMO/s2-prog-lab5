package data

class Messages {
    private val messages = mapOf(
        "enter_name" to "Введите имя: ",
        "enter_coordinateX" to "Введите координату X места рождения: ",
        "enter_coordinateY" to "Введите координату Y места рождения: ",
        "enter_height" to "Введите рост: ",
        "enter_weight" to "Введите вес: ",
        "enter_hairColor" to "Выберите цвет волос из предложенных: ",
        "enter_nationality" to "Выберите страну рождения из предложенных: ",
        "enter_locationX" to "Введите координату X примерного текущего местоположения: ",
        "enter_locationY" to "Введите координату Y примерного текущего местоположения: ",
        "enter_locationZ" to "Введите координату Z примерного текущего местоположения: ",
        "clear" to "Коллекция успешно очищена!",
        "by_id" to "Элемент с id = ",
        "first_element" to "Первый элемент коллекции ",
        "removed" to " успешно удалён!",
        "recurision" to "Превышена глубина рекурсии! Выполнение прекращено!",
        "script_start" to "Скрипт выполняется...",
        "script_end" to "Выполнение скрипта завершено..."
    )

    fun getMessage (key: String): String? {
        return messages[key]
    }
}