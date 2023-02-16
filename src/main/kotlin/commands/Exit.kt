package commands

import kotlin.system.exitProcess

class Exit: Command {
    override fun execute(argument: String) {
        exitProcess(1)
    }
}