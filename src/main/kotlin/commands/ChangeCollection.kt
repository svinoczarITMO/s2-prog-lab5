package commands

class ChangeCollection: Command() {
    override fun getName(): String {
        return "change_collection"
    }

    override fun getDescription(): String {
        return getName() + " - изменяет тип коллекции.)\n"
    }

    override fun execute(args: Map<String, Any?>) {
        val type: String by args
        try {
            collectionManager.changeType(type.toString())
        } catch (e: NullPointerException) {
            write.linesInConsole(message.getMessage("NoSuchType"))
            write.linesInConsole(printSupportedTypes())
        }
    }

    private fun printSupportedTypes() : String? {
        var output = message.getMessage("supported_types")
        for (type in collectionManager.getSupportedCollectionTypes()) {
            output += type.key + "\n"
        }
        return output
    }
}