package commands.dev

import commands.Command
import utils.CollectionManager
import utils.PrinterManager

class GetElement: Command {
    private val writeToConsole = PrinterManager()

    override fun execute(args: Array<String>, collectionManager: CollectionManager) {
        val id = args[0].toInt()
        val obj = collectionManager.getVector()[id-1]
        writeToConsole.writelnToConsole("Объект ${obj.id}:\n"
                + "Дата создания: \"" + obj.creationDate + "\" \n"
                + "Координаты: x = " + obj.coordinates.x + " y = " + obj.coordinates.y + "\n"
                + "Имя: " + obj.name + "\n"
                + "Рост: " + obj.height + "\n"
                + "Вес: " + obj.weight + "\n"
                + "Цвет волос: " + obj.hairColor + "\n"
                + "Национальность: " + obj.nationality + "\n"
                + "Местоположение: x = " + obj.location.x + "; y = " + obj.location.y + "; z = " + obj.location.z)
    }
}