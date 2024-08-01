package di

import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import dev.gstv.fhouse.cache.PaymentsDb
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single<SqlDriver> {
        AndroidSqliteDriver(
            PaymentsDb.Schema,
            get(),
            "PaymentsDb"
        )
    }
}