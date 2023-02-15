package data

class Messages {
    private val messages = mapOf<String, String>(
        "name" to "Введите имя: ",
        "coordinateX" to "Введите координату X места рождения: ",
        "coordinateY" to "Введите координату Y места рождения: ",
        "height" to "Введите рост: ",
        "weight" to "Введите вес: ",
        "hairColor" to "Выберите цвет волос из предложенных: ",
        "nationality" to "Выберите страну рождения из предложенных: ",
        "locationX" to "Введите координату X примерного текущего местоположения: ",
        "locationY" to "Введите координату Y примерного текущего местоположения: ",
        "locationZ" to "Введите координату Z примерного текущего местоположения: "
    )

    fun getMessage (key: String): String? {
        return messages.get(key)
    }
}