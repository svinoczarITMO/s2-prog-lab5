package commands

import data.Person
import java.util.*

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
    override fun getName(): String {
        return "save"
    }

    override fun getDescription(): String {
        return getName() + " - сохраняет коллекцию в файл\n"
    }

    /**
     * execute method. Save collection to file
     */
    override fun execute(args: Map<String, Any?>) {
        val collection = Vector<Person>()
        collection.addAll(collectionManager.collection)
        val list = collectionManager.collectionToList()
        val jsonString = serializer.serialize(list)
        write.toFile(jsonString, pathToFile)
        write.linesInConsole(message.getMessage("saved"))
    }
}