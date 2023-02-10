package commands

import CollectionController

import Color
import Coordinates
import Country
import Location
import Person
import java.io.File
import java.util.*


class Save {
    companion object {
        private val pathToFile = "D:\\ITMO\\2nd-semester\\prog-labs\\s2-prog-lab5\\src\\main\\kotlin\\Collection.xml"
        private var readerBuffer: String = File(pathToFile).readText()
        private val pattern = Regex("""<.*?>(.*)<.*?>""")
        private val tagsList: MutableList<String> = mutableListOf()
        private var copyVector: Vector<Person> = CollectionController.vector

        fun readFromFile() {
            while (pattern.find(readerBuffer) != null) {
                val tagsCouple = pattern.find(readerBuffer)?.groupValues
                val tagName = tagsCouple?.get(0)
                val tagValue = tagsCouple?.get(1).toString()

                readerBuffer = readerBuffer.replaceFirst("$tagName", "")
                tagsList.add(tagValue)
                if (tagName?.contains("location") == true) {
                    CollectionController.addElement(
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

//      Old tagsString:  val tagsStart: String = "<collection id = \"Person-Vector\">\n\t<vector-elements>\n"
//      Old tagsEnd: val tagsEnd: String = "\t</vector-elements>\n" + "</collection>"
        fun writeInFile() {
            var tags: String = ""
            val tagsStart: String = "<vector-elements>\n"
            val tagsEnd: String = "</vector-elements>"

            if (copyVector.isNotEmpty()) {
                tags += tagsCompilations(tagsStart+tags)
                tags += tagsEnd
                File(pathToFile).writeText(tags)
            } else {
                File(pathToFile).writeText("")
            }
        }

        fun tagsCompilations (rawString: String): String {
            var string: String = rawString
            val elements = copyVector.elements()
            for (element in elements) {
                string += "\t<element>\n"
                string += "\t\t<id>${element.id}</id>\n" +
                        "\t\t<name>${element.name}</name>\n" +
                        "\t\t<coordinates>${element.coordinates.x};${element.coordinates.y}</coordinates>\n" +
                        "\t\t<creationDate>${element.creationDate}</creationDate>\n" +
                        "\t\t<height>${element.height}</height>\n" +
                        "\t\t<weight>${element.weight}</weight>\n" +
                        "\t\t<hairColor>${element.hairColor}</hairColor>\n" +
                        "\t\t<nationality>${element.nationality}</nationality>\n" +
                        "\t\t<location>${element.location.x};${element.location.y};${element.location.z}</location>\n" +
                        "\t</element>\n"
            }
            return string
        }
    }
}