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
        "script_end" to "Выполнение скрипта завершено...",
        "script_file_not_found" to "Файл не найден.",

        "last_commands" to "Последние 7 комманд: ",
        "min_weight" to "Объект коллекции с минимальным весом:",
        "NumberFormatException" to "Введенное значение должно быть числом! Попробуйте ещё раз.",
        "di" to "Введенное число выходит за диапозон допустимых значений! Попробуйте ещё раз.",
        "IllegalColor" to "Введенный цвет не соответствует ни одному из предложенных! Попробуйте ещё раз.",
        "IllegalCountry" to "Введенная страна не соответствует ни одной из предложенных! Попробуйте ещё раз."
    )

    fun getMessage (key: String): String? {
        return messages[key]
    }
}