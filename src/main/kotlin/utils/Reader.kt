package utils

interface Reader {
    fun readFromConsole ()

    fun readFromFile (pathToFile: String)
}