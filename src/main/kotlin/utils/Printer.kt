package utils

/**
 * Base interface for printer implementation. You should implement it before applying printers in PrinterManager.
 *
 * @author svinoczar
 * @since 1.0.0
 */
interface Printer {
    /**
     * Prints message in console.
     *
     * @param message printed message.
     */
    fun writeInConsole (message: Any?)

    /**
     * Prints message line by line in console.
     *
     * @param message printed message.
     */
    fun writelnInConsole (message: Any?)

    /**
     * Prints message in file.
     *
     * @param message printed message.
     * @param pathToFile path to writing file.
     */
    fun writeToFile (message: Any?, pathToFile: String)
}