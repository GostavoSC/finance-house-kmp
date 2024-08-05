package presentation.view.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.GetPaymentsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class AppViewModel(
    private val getPaymentsUseCase: GetPaymentsUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    fun fetchPayments() {
        viewModelScope.launch {
            getPaymentsUseCase(Unit)
                .onSuccess { result ->
                    _state.update {
                        it.withPayments(result)
                    }
                }
                .onFailure { error ->
                    _state.update {
                        it.withError(error)
                    }
                }

        }
    }

}