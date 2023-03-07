package utils

import java.io.File

/**
 * Manages readers.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class ReaderManager: Reader {
    override fun readFromConsole(): String {
        return readln()
    }

    override fun readFromFile(pathToFile: String): List<String> {
        return File(pathToFile).readLines()
    }

}