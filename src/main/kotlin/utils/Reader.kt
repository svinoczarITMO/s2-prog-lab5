package utils

/**
 * Base interface for reader implementation. You should implement it before applying readers in ReaderManager.
 *
 * @author svinoczar
 * @since 1.0.0
 */
interface Reader {
    /**
     * Reads message from console.
     */
    fun readFromConsole (): String

    /**
     * Reads message from file.
     *
     * @param pathToFile path to reading file.
     */
    fun readFromFile (pathToFile: String): List<String>
}