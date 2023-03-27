package commands

import java.util.*

/**
 * Prints last 7 commands.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class History: Command() {
    override fun getName(): String {
        return "history"
    }

    override fun getDescription(): String {
        return getName() + " - выводит последние 7 команд (без их аргумента)\n"
    }

    override fun execute(args: Map<String, Any?>) {
        val buffer: LinkedList<String> by args
        write.linesInConsole(message.getMessage("last_commands"))
        for (command in buffer) {
            write.linesInConsole(command)
        }
        write.linesInConsole("")
    }
}