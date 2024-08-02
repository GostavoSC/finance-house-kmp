package di

import androidx.lifecycle.viewmodel.compose.viewModel
import dev.gstv.fhouse.DatabaseHelper
import dev.gstv.fhouse.cache.CacheDataImpl
import domain.GetPaymentsUseCase
import domain.IRepository
import domain.InsertPaymentsUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import presentation.view.AppViewModel
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
    single { DatabaseHelper(get(), Dispatchers.Default) }
}

val dispatcherModule = module {
    factory { Dispatchers.Default }
}

object KotlinDependencies : KoinComponent {
    fun getBreedViewModel() = getKoin().get<AppViewModel>()
}