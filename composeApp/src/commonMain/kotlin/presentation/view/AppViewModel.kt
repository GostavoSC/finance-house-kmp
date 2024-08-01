package presentation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.GetPaymentsUseCase
import domain.InsertPaymentsUseCase
import entity.Payments
import kotlinx.coroutines.launch


class AppViewModel(
    private val getPaymentsUseCase: GetPaymentsUseCase,
    private val insertPaymentsUseCase: InsertPaymentsUseCase,

    ) : ViewModel() {

    init {
        fetchPayments()
    }

    fun fetchPayments() {
        viewModelScope.launch {
            getPaymentsUseCase(Unit)
                .onSuccess {

                }
                .onFailure {

                }

        }
    }

    fun insertPayment() {
        viewModelScope.launch {
            insertPaymentsUseCase(
                Payments(
                    name = "Teste"
                )
            ).onSuccess {
                //test

            }.onFailure {

            }
        }
    }
}