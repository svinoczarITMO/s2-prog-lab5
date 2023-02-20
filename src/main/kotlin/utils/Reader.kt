package utils

interface Reader {
    fun readFromConsole (): String

    fun readFromFile (pathToFile: String): List<String>
}