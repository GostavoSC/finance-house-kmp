package presentation.view.payments.insertion

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PaymentInsertionViewModel : ViewModel() {

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


}