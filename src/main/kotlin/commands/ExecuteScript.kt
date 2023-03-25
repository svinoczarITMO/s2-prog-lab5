package commands

import org.jetbrains.kotlin.konan.file.File

/**
 * Executes script from inputed path to file.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class ExecuteScript: Command() {
    // глубина рекурсии
    private val maxDepth = 8
    private var depth = 0
    private var scriptFile = File("")

    override fun execute(args: Map<String, Any?>) {
        val flag = ::execute.name
        val path: String by args
        var arguments: ArrayList<Any?> = arrayListOf()
        if (File(path).exists) {
            scriptFile = File(path)
            validator.explorer(path)
        } else {
            return
        }
        try {
            if (depth <= maxDepth) {
                val strings = scriptFile.readStrings()
                write.linesInConsole(message.getMessage("script_start"))
                for (string in strings) {
                    var newArgs = string.split(" ").toMutableList()
                    val commandName = newArgs[0]
                    if (commandName == "execute_script") {
                        depth += 1
                        newArgs.add(flag)
                        newArgs.add(path)
                        validator.validate(newArgs.toTypedArray())
                    } else {
                        newArgs.add(flag)
                        newArgs.add(path)
                        validator.validate(newArgs.toTypedArray())
                    }
                }
            } else {
                write.linesInConsole(message.getMessage("recurision"))
            }
        } catch (e: NoSuchFileException) {
            write.linesInConsole(message.getMessage("NoSuchFileException"))
            return
        }
        depth -= 1
        if (depth == 0) {
            write.linesInConsole(message.getMessage("script_end"))
        }
    }
}