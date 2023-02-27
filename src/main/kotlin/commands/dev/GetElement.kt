package commands.dev

import commands.Command
import data.Person
import utils.CollectionManager
import utils.PrinterManager

class GetElement: Command {
    private val writeToConsole = PrinterManager()

    override fun execute(arg: Array<*>, collectionManager: CollectionManager) {
        var obj: Person? = null
        for (element in collectionManager.getVector()) {
            if (element.id == arg[0]) {
                obj = element
                break
            }
        }
        obj?.let {
            writeToConsole.writelnToConsole(
                "Объект ${it.id}:\n"
                        + "Дата создания: \"" + it.creationDate + "\" \n"
                        + "Координаты: x = " + it.coordinates.x + " y = " + it.coordinates.y + "\n"
                        + "Имя: " + it.name + "\n"
                        + "Рост: " + it.height + "\n"
                        + "Вес: " + it.weight + "\n"
                        + "Цвет волос: " + it.hairColor + "\n"
                        + "Национальность: " + it.nationality + "\n"
                        + "Местоположение: x = " + it.location.x + "; y = " + it.location.y + "; z = " + it.location.z
            )
        } ?: writeToConsole.writelnToConsole("Объект с указанным id не найден")
    }
}