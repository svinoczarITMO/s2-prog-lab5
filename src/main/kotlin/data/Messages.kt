package data

/**
 * Contains messages for print.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class Messages {
    private val messages = mapOf(
        //reading data
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

        //successes
        "added" to "Эллемент успешно добавлен.",
        "clear" to "Коллекция успешно очищена!",
        "removed" to " успешно удалён!",

        //warnings
        "recurision" to "Превышена глубина рекурсии! Выполнение прекращено!",
        "not_enough_args" to "Не хватает параметров в скрипте для добавления новой команды!",
        "weird_command" to "Введена неверная команда. Используйте help для вывода списка команд.",
        "invalid_id" to "Объект с указанным id не найден",

        //info
        "script_start" to "Скрипт выполняется...",
        "script_end" to "Выполнение скрипта завершено...",
        "last_commands" to "Последние 7 комманд: ",
        "min_weight_id" to "Id объекта коллекции с минимальным весом: ",
        "weight" to "Вес: ",
        "first_element" to "Первый элемент коллекции ",
        "by_id" to "Элемент с id = ",
        "clean_collection" to "В коллекции не содержится элементов.",

        //extra
        "=" to "=========================================================================================================================================",

        //exceptions
        "NumberFormatException" to "Введенное значение должно быть числом! Попробуйте ещё раз.",
        "IndexOutOfRange" to "Введенное число выходит за диапозон допустимых значений! Попробуйте ещё раз.",
        "IllegalColor" to "Введенный цвет не соответствует ни одному из предложенных! Попробуйте ещё раз.",
        "IllegalCountry" to "Введенная страна не соответствует ни одной из предложенных! Попробуйте ещё раз.",
        "InvalidArgument" to "Введенно недопустимое значение аргумента.",
        "NoSuchFile" to "Указанный файл не найден."
    )

    /**
     * Returns message from map of messages by inputed key.
     *
     * @param key key of message
     * @return message as String?
     */
    fun getMessage (key: String): String? {
        return messages[key]
    }
}