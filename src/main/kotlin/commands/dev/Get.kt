package commands.dev

import commands.Command
import data.Messages
import utils.CollectionManager
import utils.PrinterManager

class Get: Command {
    private var collectionManager: CollectionManager = CollectionManager()
    private val writeToConsole = PrinterManager()
    private val message = Messages()

    override fun execute(command: String) {
        val id = command.toInt()
        val obj = collectionManager.getVector()[id]
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