package utils

import java.io.File

class ReaderManager: Reader {
    override fun readFromConsole() {
        val string = readln()
    }

    override fun readFromFile(pathToFile: String) {
        val strings = File(pathToFile).readLines()
    }

}