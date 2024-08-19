package di

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import dev.gstv.fhouse.DatabaseHelper
import dev.gstv.fhouse.cache.CacheDataImpl
import domain.GetPaymentsUseCase
import domain.IRepository
import domain.InsertPaymentsUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import presentation.view.home.AppViewModel
import presentation.view.payments.insertion.PaymentInsertionViewModel
import repository.ICacheData
import repository.RepositoryImpl

fun initKoin(
    appDeclaration: KoinAppDeclaration = {}
) = startKoin {
    appDeclaration()
    modules(
        platformModule(),
        sqlDelightModule,
        dispatcherModule,
        repositoryModule,
        useCases,
        viewModelModule
    )
}


val viewModelModule = module {
    viewModelOf(::AppViewModel)
    viewModelOf(::PaymentInsertionViewModel)
}

val useCases = module {
    factory { GetPaymentsUseCase(get(), get()) }
    factory { InsertPaymentsUseCase(get(), get()) }
}

val repositoryModule = module {
    single<IRepository> { RepositoryImpl(get()) }
    single<ICacheData> { CacheDataImpl(get()) }
}
val sqlDelightModule = module {
    single { DatabaseHelper(get(), get()) }
}

val dispatcherModule = module {
    factory { Dispatchers.Default }
}

@OptIn(KoinExperimentalAPI::class)
@Composable
inline fun <reified T : ViewModel> getViewModel() = koinViewModel<T>()