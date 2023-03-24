package commands.dev

import commands.Command
import data.Person

/**
 * Gets element of collection by id.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class GetElement: Command() {
    /**
     *
     * @param Int id of getting element.
     */
    override fun execute(args: Map<String, Any>) {
        var obj: Person? = null
        val getId = args.get("id")
        try {
            for (element in collectionManager.getVector()) {
                if (element.id == getId) {
                    obj = element
                    break
                }
            }
        } catch (e: ArrayIndexOutOfBoundsException) {
            write.linesInConsole(message.getMessage("invalid_id"))
        }
        obj?.let {
            write.linesInConsole(
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
        } ?:write.linesInConsole(message.getMessage("invalid_id"))
    }
}