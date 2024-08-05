package presentation.view.payments.insertion

data class InsertionState(
    val name: String = "",
    val value: String = "",
    val description: String = "",
    val date: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
) {
    fun withName(name: String) = copy(name = name)

    fun withValue(value: String) = copy(value = value)

    fun withDescription(description: String) = copy(description = description)

    fun withDate(date: String) = copy(date = date)

    fun withLoading(isLoading: Boolean) = copy(isLoading = isLoading)

    fun withError(error: String?) = copy(error = error)
}
