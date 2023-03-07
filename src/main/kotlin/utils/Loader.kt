package utils

import data.*
import java.io.File
import java.util.*

/**
 * Loads actual collection from Collection.xml.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class Loader {
    private val pathToFile = System.getenv("COLLECTION_VAR")

    private var readerBuffer: String = File(pathToFile).readText()
    private val pattern = Regex("""<.*?>(.*)<.*?>""")
    private val tagsList: MutableList<String> = mutableListOf()

    /**
     * Loads collection from xml file.
     *
     * @param collectionManager CollectionManager object.
     */
    fun loadFromFile (collectionManager: CollectionManager) {
        val bufferVector = Vector<Person>()
        while (pattern.find(readerBuffer) != null) {
            val tagsCouple = pattern.find(readerBuffer)?.groupValues
            val tagName = tagsCouple?.get(0)
            val tagValue = tagsCouple?.get(1).toString()
            readerBuffer = readerBuffer.replaceFirst("$tagName", "")
            tagsList.add(tagValue)
            if (tagName?.contains("location") == true) {
                bufferVector.add(
                    Person(
                        tagsList[0].toInt(),
                        tagsList[1],
                        Coordinates(tagsList[2].split(";")[0].toFloat(), tagsList[2].split(";")[1].toFloat()),
                        collectionManager.parseDate(tagsList[3]),
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
        collectionManager.setVector(bufferVector)
    }
}