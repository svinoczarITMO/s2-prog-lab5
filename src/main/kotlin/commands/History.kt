package commands

/**
 * Prints last 7 commands.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class History: Command() {
    override fun execute(args: Map<String, Any>) {
        val commandBuffer = args.get("buffer") as Array<*>
        write.linesInConsole(message.getMessage("last_commands"))
        for (command in commandBuffer) {
            write.linesInConsole(command)
        }
        write.linesInConsole("")
    }


}