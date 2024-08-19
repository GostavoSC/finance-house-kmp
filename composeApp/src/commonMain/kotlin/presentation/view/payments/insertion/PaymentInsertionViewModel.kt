package presentation.view.payments.insertion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.IRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PaymentInsertionViewModel(
    private val repository: IRepository
) : ViewModel() {

    private val _state = MutableStateFlow(
        InsertionState()
    )

    val state = _state.asStateFlow()


    fun updateName(name: String) {
        _state.update {
            it.withName(name)
        }
    }

    fun updateValue(value: String) {
        _state.update {
            it.withValue(value)
        }
    }

    fun updateDescription(description: String) {
        _state.update {
            it.withDescription(description)
        }
    }

    fun updateDate(date: String) {
        _state.update {
            it.withDate(date)
        }
    }

    fun insertPayment() {
        viewModelScope.launch {
            showLoading()
            repository.insertPayment(
                state.value.toPayment()
            )
            hideLoading()
            _state.update {
                it.withDone(true)
            }
        }
    }

    private fun showLoading(){
        _state.update {
            it.withLoading(true)
        }
    }

    private fun hideLoading(){
        _state.update {
            it.withLoading(false)
        }
    }
}