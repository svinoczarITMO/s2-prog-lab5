package di

import data.Messages
import org.koin.dsl.module
import utils.*

/**
 * Koin Module with all needed objects.
 *
 * @author svinoczar
 * @since 1.0.0
 */
val notKoinModule = module {
    single {
        PrinterManager()
    }

    single {
        ReaderManager()
    }

    single {
        Messages()
    }

    single {
        Validator()
    }

    single {
        CommandManager()
    }

    single {
        CollectionManager()
    }

    single {
        Serializer()
    }
}