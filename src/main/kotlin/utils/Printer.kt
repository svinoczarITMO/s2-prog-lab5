package utils

interface Printer {
    fun writeToConsole (message: Any?)

    fun writelnToConsole (message: Any?)

    fun writeToFile (message: Any?, pathToFile: String)
}