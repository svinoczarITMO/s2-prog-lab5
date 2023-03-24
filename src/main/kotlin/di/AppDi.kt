package di

import data.Messages
import org.koin.dsl.module
import utils.*


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