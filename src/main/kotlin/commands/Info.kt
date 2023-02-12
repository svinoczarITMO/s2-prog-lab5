package commands

import utils.CollectionController


class Info: Command {
    var collectionController: CollectionController = CollectionController()
    var reflexVector = collectionController.getVector()
    var type = reflexVector.returnType
    var accessability = reflexVector.isOpen

    //TODO: блин, а че делать-то ёлки-палки???
    fun info () {
        println(
            type.toString().split(".")[2] + ", "
                    + "Размер: " + collectionController.getVector().size + ", "
                    + when { accessability.toString() == "false, " -> "close"
                else -> "open, " } + "Дата инициализации: " + collectionController.getVector(). )
    }
}
