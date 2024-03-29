package commands.dev

import commands.Command
import data.Person

/**
 * Gets the collection item by its identifier.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class GetElement: Command() {
    override fun getName(): String {
        return "get"
    }

    override fun getDescription(): String {
        return getName() + " - выводит в терминал объект коллекции с указанным id\n"
    }
    /**
     *
     * @param Int id of getting element.
     */
    override fun execute(args: Map<String, Any?>): String? {
        var result: String? = ""
        var obj: Person? = null
        val id: Int by args
        try {
            for (element in collectionManager.collection) {
                if (element.id == id) {
                    obj = element
                    break
                }
            }
        } catch (e: ArrayIndexOutOfBoundsException) {
            result = (message.getMessage("invalid_id"))
        }
        obj?.let {
            result = (
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
        } ?:(message.getMessage("invalid_id"))
        return result
    }
}