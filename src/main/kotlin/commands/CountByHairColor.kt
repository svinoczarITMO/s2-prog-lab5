package commands

/**
 * Counts elements by hair color.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class CountByHairColor: Command() {
    override fun getName(): String {
        return "count_by_hair_color"
    }

    override fun getDescription(): String {
        return getName() + " --hairColor - выводит количество элементов, значение поля hairColor которых равно заданному\n"
    }

    override fun execute(args: Map<String, Any?>) {
        val color by args
        val copyVector = collectionManager.collection
        var counter = 0
        try {
            for (element in copyVector) {
                if (element.hairColor == color) {
                    counter += 1
                }
            }
            write.linesInConsole("Количество людей с цветом волос \"${color.toString().capitalize()}\": $counter")
        } catch (e: IllegalArgumentException) {
            write.linesInConsole(message.getMessage("IllegalColor"))
        }
    }
}