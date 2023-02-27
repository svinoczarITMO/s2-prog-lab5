package utils

import java.io.File
import java.util.*

class Logger {
    private val pathToFile = "D:\\ITMO\\2nd-semester\\prog-labs\\s2-prog-lab5\\src\\main\\kotlin\\data\\data.log"

    fun initDate(collectionManager: CollectionManager): String {
        val vector = collectionManager.getVector()
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