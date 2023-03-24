package commands

/**
 * Saves collection in Collection.json file.
 *
 * @author svinoczar
 * @since 1.0.0
 */
//class Save: Command <Empty>{
//    private val pathToFile = System.getenv("COLLECTION_VAR")
//    private val write = PrinterManager()
//    private val message = Messages()
//
//    override fun execute(args: Array<Any>, collectionManager: CollectionManager) {
//        val bufferVector = Vector<Person>()
//        bufferVector.addAll(collectionManager.getVector())
//        val jsonString = Json.encodeToString(bufferVector)
//        write.toFile(pathToFile, jsonString)
//
//    }
//}

class Save: Command() {
    private val pathToFile = System.getenv("COLLECTION_VAR")
    override fun execute(args: Map<String, Any>) {
        TODO("Not yet implemented")
    }
}