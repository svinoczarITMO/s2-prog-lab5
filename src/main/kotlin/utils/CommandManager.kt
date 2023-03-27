package utils

import commands.Command
import org.reflections.Reflections
import org.reflections.scanners.SubTypesScanner

/**
 * Manages commands.
 *
 * @author svinoczar
 * @since 1.0.0
 */
class CommandManager {
        /**
         * Parses specified package and filters classes by specified name of Interface.
         *
         * @param packageName name of parsed package.
         * @param commandInterfaceName name of Interface.
         * @return Set<Class<*>>
         */
        private fun parsePackage(packageName: String, commandInterfaceName: String): Set<Class<*>> {
                val reflections = Reflections(packageName, SubTypesScanner(false))

                return reflections.getSubTypesOf(Object::class.java)
                        .filter { klass -> !klass.simpleName.equals(commandInterfaceName, ignoreCase = true) }
                        .toSet()
        }

        /**
         * Returns command as Command from specified package by name.
         *
         * @param packageName name of package.
         * @param commandInterfaceName name of Interface.
         * @param commandName command's name.
         * @return Command?
         */
        fun getCommand(packageName: String, commandName: String, commandInterfaceName: String): Command? {
                val classes = parsePackage(packageName, commandInterfaceName)

                for (klass in classes) {
                        try {
                                val command = klass.getConstructor().newInstance() as Command

                                if (command.getName() == commandName) {
                                        return command
                                }
                        } catch (e: Exception) {
                                println(e.message)
                        }
                }

                return null
        }
}
