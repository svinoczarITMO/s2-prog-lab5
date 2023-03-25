package commands

import java.util.*

/**
 * Prints last 7 commands.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class History: Command() {
    override fun execute(args: Map<String, Any?>) {
        val buffer: LinkedList<String> by args
        write.linesInConsole(message.getMessage("last_commands"))
        for (command in buffer) {
            write.linesInConsole(command)
        }
        write.linesInConsole("")
    }
}