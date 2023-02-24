package commands

//import com.sun.org.apache.xml.internal.security.c14n.implementations.CanonicalizerBase.XML
//import kotlinx.serialization.Serializable
//import kotlinx.serialization.encodeToString
//import kotlinx.serialization.json.Json
//import kotlinx.serialization.json.JsonObject
import data.Person
import utils.CollectionManager
import java.io.File
import java.util.*

class Save: Command {

    //private val pathToFile = System.getenv("D:\\ITMO\\2nd-semester\\prog-labs\\s2-prog-lab5\\src\\main\\kotlin\\data\\Collection.xml")
    private val pathToFile = "D:\\\\ITMO\\\\2nd-semester\\\\prog-labs\\\\s2-prog-lab5\\\\src\\\\main\\\\kotlin\\\\data\\\\Collection.xml"

    private fun tagsCompilations (rawString: String): String {
        val bufferVector: Vector<Person> = CollectionManager().getVector()
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

    override fun execute(argument: String) {
        val bufferVector: Vector<Person> = CollectionManager().getVector()
        var tags = ""
        val tagsStart = "<vector-elements>\n"
        val tagsEnd = "</vector-elements>"
        if (bufferVector.isNotEmpty()) {
            tags += tagsCompilations(tagsStart+tags)
            tags += tagsEnd
            File(pathToFile).writeText(tags)
        } else {
            File(pathToFile).writeText("")
        }
    }
}