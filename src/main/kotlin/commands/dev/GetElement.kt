package commands.dev

import commands.Command
import data.Person
import utils.CollectionManager
import utils.PrinterManager

class GetElement: Command {
    private val writeToConsole = PrinterManager()

    override fun execute(arg: Array<*>, collectionManager: CollectionManager) {
        var obj: Person? = null
        collectionManager.getVector().forEach {
            if (it.id == arg[0]) {
                obj = it
            }
        }
        obj!!.let {
            writeToConsole.writelnToConsole(
                "Объект ${obj?.id}:\n"
                        + "Дата создания: \"" + obj?.creationDate + "\" \n"
                        + "Координаты: x = " + obj?.coordinates?.x + " y = " + obj?.coordinates?.y + "\n"
                        + "Имя: " + obj?.name + "\n"
                        + "Рост: " + obj?.height + "\n"
                        + "Вес: " + obj?.weight + "\n"
                        + "Цвет волос: " + obj?.hairColor + "\n"
                        + "Национальность: " + obj?.nationality + "\n"
                        + "Местоположение: x = " + obj?.location?.x + "; y = " + obj?.location?.y + "; z = " + obj?.location?.z
            )
        }
    }
}