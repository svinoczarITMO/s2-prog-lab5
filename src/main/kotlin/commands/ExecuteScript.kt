package commands

import org.jetbrains.kotlin.konan.file.File

/**
 * Executes script from inputed path to file.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class ExecuteScript: Command() {
    private var scriptFile = File("")

    override fun getName(): String {
        return "execute_script"
    }

    override fun getDescription(): String {
        return getName() + " --file_name - считывает и исполняет скрипт из указанного файла\n"
    }

    override fun execute(args: Map<String, Any?>) {
        // глубина рекурсии
        val maxDepth = 8
        val depth: Int by args
        var actDepth = depth
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
            if (actDepth <= maxDepth) {
                val strings = scriptFile.readStrings()
                write.linesInConsole(message.getMessage("script_start"))
                for (string in strings) {
                    val newArgs = string.split(" ").toMutableList()
                    val commandName = newArgs[0]
                    if (commandName == "execute_script") {
                        actDepth += 1
                        newArgs.add(flag)
                        newArgs.add(path)
                        newArgs.add(actDepth.toString())
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
        actDepth -= 1
        if (actDepth == 0) {
            write.linesInConsole(message.getMessage("script_end"))
        }
    }
}