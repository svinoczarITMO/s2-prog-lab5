package commands

import utils.CollectionManager


class Info: Command {
    var collectionManager: CollectionManager = CollectionManager()
    var reflexVector = collectionManager.getVector()
    var type = reflexVector.returnType
    var accessability = reflexVector.isOpen

    //TODO: блин, а че делать-то ёлки-палки???
    fun info () {
        println(
            type.toString().split(".")[2] + ", "
                    + "Размер: " + collectionManager.getVector().size + ", "
                    + when { accessability.toString() == "false, " -> "close"
                else -> "open, " } + "Дата инициализации: " + collectionManager.getVector(). )
    }
}
