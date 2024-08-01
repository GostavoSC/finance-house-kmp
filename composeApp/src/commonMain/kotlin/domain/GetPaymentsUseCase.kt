package domain

import entity.Payments
import domain.type.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher

class GetPaymentsUseCase(
    private val repository: IRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase<Unit, List<Payments>>(dispatcher) {
    override suspend fun block(param: Unit): List<Payments> = repository.getAllPayments()
}