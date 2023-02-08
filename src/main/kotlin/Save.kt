import java.io.File


class Save {
    companion object {
        val pathToFile = "D:\\ITMO\\2nd-semester\\prog-labs\\s2-prog-lab5\\src\\main\\kotlin\\Collection.xml"

        fun readFromFile(){
            var readerBuffer: String = File(pathToFile).readText()
            val pattern = Regex("""<.*?>(.*)<.*?>""")
            val tag = pattern.find(readerBuffer)?.value
            readerBuffer.replace("<id>1</id>", "fsasaf ")
            println(tag)
            println(readerBuffer)
//            while (pattern.find(readerBuffer)!=null) {
//                val tag = pattern.find(readerBuffer)?.value
//                readerBuffer.replace("$tag", "")
//                println(tag)
//            }


        }

//            sortedTags.add("asd")
//
//            for (asd in tags) {
//                sortedTags = sortedTags.add(asd)
//            }
//            for (element in tags) {
//                println(element)
//                CollectionController.addElement(Person(element.))
//            }

    }
}