import java.io.File


class Save {
    companion object {
        val pathToFile = "D:\\ITMO\\2nd-semester\\prog-labs\\s2-prog-lab5\\src\\main\\kotlin\\Collection.xml"

        fun readFromFile(){
            var readerBuffer: String = File(pathToFile).readText()
            val pattern = Regex("""<.*?>(.*)<.*?>""")
            val tags: MutableList<String> = mutableListOf<String>()

            while (pattern.find(readerBuffer)!=null) {
                val tagsCouple = pattern.find(readerBuffer)?.groupValues
                val tagName = tagsCouple?.get(0)
                val tagValue = tagsCouple?.get(1).toString()

                readerBuffer = readerBuffer.replaceFirst("$tagName", "")
                tags.add(tagValue)
                if (tagName?.contains("location") == true){
                    CollectionController.addElement(Person(
                        tags[0].toInt(),
                        tags[1],
                        Coordinates(tags[2].split(";")[0].toFloat(), tags[2].split(";")[1].toFloat()),
                        tags[3],
                        tags[4].toInt(),
                        tags[5].toLong(),
                        Color.valueOf(tags[6].uppercase()),
                        Country.valueOf(tags[7].uppercase()),
                        Location(tags[8].split(";")[0].toInt(), tags[8].split(";")[1].toLong(), tags[8].split(";")[2].toInt())
                    ))
                    tags.clear()
                }
            }

            println(tags)
        }
    }
}