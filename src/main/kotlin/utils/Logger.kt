package utils

import java.io.File
import java.util.*

/**
 * Saves initialization date to data.log file.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class Logger {
    private val pathToFile = "D:\\ITMO\\2nd-semester\\prog-labs\\s2-prog-lab5\\src\\main\\kotlin\\data\\data.log"

    /**
     * Saves initialization date to data.log file or returns initialization date from data.log file as String.
     *
     * @param collectionManager CollectionManager object.
     * @return initDate as String.
     */
    fun initDate(collectionManager: CollectionManager): String {
        val vector = collectionManager.collection
        val initDate = Date().toString()
        return if (vector.isNotEmpty()) {
            File(pathToFile).readText().substring(10, initDate.length - 1)
        } else {
            (vector.isEmpty())
            File(pathToFile).writeText("InitDate: $initDate")
            return initDate
        }
    }
}