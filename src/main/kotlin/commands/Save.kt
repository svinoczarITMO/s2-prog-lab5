package commands

import utils.CollectionManager
import java.io.File
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex.Empty

/**
 * Saves collection in Collection.xml file.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class Save: Command <Empty>{
    private val pathToFile = System.getenv("COLLECTION_VAR")

    private fun tagsCompilations (rawString: String, collectionManager: CollectionManager): String {
        val bufferVector = collectionManager.getVector()
        var string: String = rawString
        val elements = bufferVector.elements()
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

    override fun execute(args: Array<Any>, collectionManager: CollectionManager) {
        val bufferVector = collectionManager.getVector()
        var tags = ""
        val tagsStart = "<vector-elements>\n"
        val tagsEnd = "</vector-elements>"
        if (bufferVector.isNotEmpty()) {
            tags += tagsCompilations(tagsStart+tags, collectionManager)
            tags += tagsEnd
            File(pathToFile).writeText(tags)
        } else {
            File(pathToFile).writeText("")
        }
    }
}