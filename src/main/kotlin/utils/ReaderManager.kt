package utils

import java.io.File

class ReaderManager: Reader {
    override fun readFromConsole(): String {
        return readln()
    }

    override fun readFromFile(pathToFile: String): List<String> {
        return File(pathToFile).readLines()
    }

}