package commands

/**
 * Prints element of collection with minimal weight.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class MinByWeight: Command() {
    override fun execute(args: Map<String, Any?>) {
        val flag = ::execute.name
        val vector = collectionManager.getVector()
        var minWeight: Long = Long.MAX_VALUE
        var minWeightId: String = "0"
        for (element in vector) {
            if (element.weight < minWeight) {
                minWeight = element.weight
                minWeightId = element.id.toString()
            }
        }
        write.linesInConsole(message.getMessage("min_weight_id") + minWeightId)
        write.linesInConsole(message.getMessage("weight") + minWeight)
    }
}