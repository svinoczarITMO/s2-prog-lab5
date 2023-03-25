package commands

import kotlin.system.exitProcess

/**
 * Terminates the programm.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class Exit: Command() {
    override fun execute(args: Map<String, Any?>) {
        exitProcess(1)
    }
}