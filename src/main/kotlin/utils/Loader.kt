package utils

import data.*
import java.io.File
import java.util.*

class Loader {
    //private val pathToFile = System.getenv("D:\\ITMO\\2nd-semester\\prog-labs\\s2-prog-lab5\\src\\main\\kotlin\\data\\Collection.xml")
    private val pathToFile = "D:\\\\ITMO\\\\2nd-semester\\\\prog-labs\\\\s2-prog-lab5\\\\src\\\\main\\\\kotlin\\\\data\\\\Collection.xml"
    private val collectionManager: CollectionManager = CollectionManager()
    private var readerBuffer: String = File(pathToFile).readText()
    private val pattern = Regex("""<.*?>(.*)<.*?>""")
    private val tagsList: MutableList<String> = mutableListOf()

    fun loadFromFile () {
        while (pattern.find(readerBuffer) != null) {
            val tagsCouple = pattern.find(readerBuffer)?.groupValues
            val tagName = tagsCouple?.get(0)
            val tagValue = tagsCouple?.get(1).toString()
            readerBuffer = readerBuffer.replaceFirst("$tagName", "")
            tagsList.add(tagValue)
            if (tagName?.contains("location") == true) {
                collectionManager.addObject(
                    Person(
                        tagsList[0].toInt(),
                        tagsList[1],
                        Coordinates(tagsList[2].split(";")[0].toFloat(), tagsList[2].split(";")[1].toFloat()),
                        Date(),
                        tagsList[4].toInt(),
                        tagsList[5].toLong(),
                        Color.valueOf(tagsList[6].uppercase()),
                        Country.valueOf(tagsList[7].uppercase()),
                        Location(
                            tagsList[8].split(";")[0].toInt(),
                            tagsList[8].split(";")[1].toLong(),
                            tagsList[8].split(";")[2].toInt()
                        )
                    )
                )
                tagsList.clear()
            }
        }
    }
}