package commands

import data.Messages
import data.Person
import utils.CollectionManager
import utils.PrinterManager
import java.util.*
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex.Empty

class Reorder: Command <Empty> {
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(arg: Array<Any>, collectionManager: CollectionManager) {
        val bufferVector: Vector<Person> = Vector()
        for (element in collectionManager.getVector()) {
            bufferVector.insertElementAt(element,0)
        }
        collectionManager.setVector(bufferVector)
        writeToConsole.writelnToConsole(collectionManager.getVector().toString())
    }
}