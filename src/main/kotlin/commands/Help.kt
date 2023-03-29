package commands

/**
 * Prints all commands and their descriptions.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class Help: Command() {
    override fun getName(): String {
        return "help"
    }

    override fun getDescription(): String {
        return getName() + " - выводит справку по доступным командам\n"
    }

    override fun execute(args: Map<String, Any?>) {
        write.linesInConsole(message.getMessage("="))
        val classes = commandManager.parsePackage("commands", "Command")
            .filter { klass -> !klass.simpleName.equals("FastAdd") && !klass.simpleName.equals("PrintCollection") && !klass.simpleName.equals("GetElement") }
        for (klass in classes) {
            try {
                val command = klass.getConstructor().newInstance() as Command
                write.inConsole(command.getDescription())
            } catch (e: Exception) {
                println(e.message)
            }
        }
        write.linesInConsole(message.getMessage("="))
    }
}