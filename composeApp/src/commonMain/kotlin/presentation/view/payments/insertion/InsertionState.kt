package presentation.view.payments.insertion

import entity.Payments

data class InsertionState(
    val name: String = "",
    val value: String = "",
    val description: String = "",
    val date: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val isButtonEnabled: Boolean = false,
    val isDone: Boolean = false
) {
    fun withName(name: String) = copy(name = name).checkButton()

    fun withValue(value: String) = copy(value = value).checkButton()

    fun withDescription(description: String) = copy(description = description).checkButton()

    fun withDate(date: String) = copy(date = date).checkButton()

    fun withLoading(isLoading: Boolean) = copy(isLoading = isLoading)

    fun withDone(isDone: Boolean) = copy(isDone = isDone)

    fun withError(error: String?) = copy(error = error)

    private fun checkButton() =
        copy(isButtonEnabled = name.isNotEmpty() && value.isNotEmpty() && description.isNotEmpty() && date.isNotEmpty())

    fun toPayment() = Payments(
        name = name,
        value = value.toDouble(),
        description = description,
        date = date
    )
}
