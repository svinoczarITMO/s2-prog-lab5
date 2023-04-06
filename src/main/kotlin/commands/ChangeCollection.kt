package commands

class ChangeCollection: Command() {
    override fun getName(): String {
        return "change_collection"
    }

    override fun getDescription(): String {
        return getName() + " - изменяет тип коллекции.)\n"
    }

    override fun execute(args: Map<String, Any?>): String? {
        val type: String by args
        var result: String? = ""
        try {
            collectionManager.changeType(type.toString())
        } catch (e: NullPointerException) {
            result = (message.getMessage("NoSuchType"))
            result += printSupportedTypes()
            return result
        }
        result = message.getMessage("type_changed") + collectionManager.getType()
        return result
    }

    private fun printSupportedTypes() : String? {
        var output = message.getMessage("supported_types")
        for (type in collectionManager.getSupportedCollectionTypes()) {
            output += type.key + "\n"
        }
        return output
    }
}