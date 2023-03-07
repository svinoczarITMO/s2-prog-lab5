package utils

import org.jetbrains.kotlin.konan.file.File

/**
 * Saves initialization date to data.log file.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class PrinterManager: Printer{
    override fun writeToConsole(message: Any?) {
        print(message)
    }

    override fun writelnToConsole (message: Any?) {
        println(message)
    }

    override fun writeToFile(message: Any?, pathToFile: String) {
        when (message) {
            is String -> File(pathToFile).writeText(message)
            is Array<*> -> File(pathToFile).writeLines(message as Iterable<String>)
            is List<*> -> File(pathToFile).writeLines(message as Iterable<String>)
        }
    }
}