package commands

/**
 * Counts elements by hair color.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class CountByHairColor: Command() {
    override fun execute(args: Map<String, Any?>) {
        val color by args
        val copyVector = collectionManager.getVector()
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