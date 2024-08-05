package presentation.view.home

import entity.Payments

data class HomeState(
    val isLoading: Boolean = false,
    val payments: List<Payments> = emptyList(),
    val error: String? = null
) {
    fun withPayments(payments: List<Payments>) = copy(
        payments = payments
    )

    fun withError(error: Throwable) = copy(
        error = error.message
    )
}