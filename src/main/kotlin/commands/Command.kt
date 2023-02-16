package commands

interface Command {
    fun execute (argument: String)
}