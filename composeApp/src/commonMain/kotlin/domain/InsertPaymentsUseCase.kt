package domain

import entity.Payments
import domain.type.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher

class InsertPaymentsUseCase(
    private val repository: IRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase<Payments, Unit>(dispatcher) {
    override suspend fun block(param: Payments) = repository.insertPayment(param)
}