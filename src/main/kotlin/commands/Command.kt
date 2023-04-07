package commands


import data.Messages
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.*

/**
 * A basic interface for implementing commands. You must implement it before applying a command in the CommandManager.
 *
 * @author svinoczar
 * @since 1.0.0
 */
abstract class Command: KoinComponent {
    val collectionManager: CollectionManager by inject()
    val commandManager: CommandManager by inject()
    val write: PrinterManager by inject()
    val read: ReaderManager by inject()
    val message: Messages by inject()
    val validator: Validator by inject()
    val serializer: Serializer by inject()

    /**
     * Returns command's name.
     */
    abstract fun getName(): String

    /**
     * Returns command's description.
     */
    abstract fun getDescription(): String

    /**
     * Executes command with "arg" as arguments and "collectionManager" as Collection Manager.
     *
     * @param args map of command's arguments.
     */
    abstract fun execute(args: Map<String, Any?>): String?
}

