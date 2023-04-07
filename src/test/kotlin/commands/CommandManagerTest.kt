package commands

import exceptions.CommandException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import utils.CommandManager
import kotlin.test.assertEquals

class CommandManagerTest {
    @Test
    fun `Get existing command`() {


        val commandManager = CommandManager()

        val commandName = "help"
        val packageName = "commands"
        val interfaceName = "Command"

        val expectedCommand = Help()

        val actualCommand = commandManager.getCommand(packageName, commandName, interfaceName)

        assertEquals(expectedCommand::class, actualCommand!!::class)
    }

    @Test
    fun `CommandManager throws Exception if command doesn't exist`() {
        val commandManager = CommandManager()

        val packageName = "commands"
        val interfaceName = "Command"
        val commandName = "make_a_tea"

        assertThrows<CommandException> { commandManager.getCommand(packageName, commandName, interfaceName) }
    }
}