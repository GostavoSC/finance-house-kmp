package di

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import dev.gstv.fhouse.cache.PaymentsDb
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single<SqlDriver> { NativeSqliteDriver(PaymentsDb.Schema, "PaymentsDb") }
}