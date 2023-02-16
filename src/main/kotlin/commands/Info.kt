package commands

import data.Messages
import utils.CollectionManager
import utils.PrinterManager


class Info: Command {
    private val collectionManager: CollectionManager = CollectionManager()
    private val writeToConsole = PrinterManager()
    private val message = Messages()
    override fun execute(argument: String) {
        TODO("Not yet implemented")
    }
//    var type = reflexVector.returnType
//    var accessability = reflexVector.isOpen
//
//    //TODO: блин, а че делать-то ёлки-палки???
//    fun info () {
//        println(
//            type.toString().split(".")[2] + ", "
//                    + "Размер: " + collectionManager.getVector().size + ", "
//                    + when { accessability.toString() == "false, " -> "close"
//                else -> "open, " } + "Дата инициализации: " + collectionManager.getVector(). )
//    }
}
