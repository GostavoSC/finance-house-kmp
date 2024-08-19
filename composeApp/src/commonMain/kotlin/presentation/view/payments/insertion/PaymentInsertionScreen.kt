package presentation.view.payments.insertion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import di.getViewModel
import presentation.view.components.FinanceTopAppBar
import presentation.view.components.PaymentField
import presentation.view.components.visualTransformation.DecimalFormatter
import presentation.view.components.visualTransformation.DecimalInputVisualTransformation
import presentation.view.components.visualTransformation.MaskTypes

@Composable
fun PaymentsInsertionScreen(
    onBackPressed: (isDone: Boolean) -> Unit,
    viewModel: PaymentInsertionViewModel = getViewModel<PaymentInsertionViewModel>(),
) {
    val state = viewModel.state.collectAsState().value

    Scaffold {
        Scaffold(
            topBar = {
                FinanceTopAppBar(title = "Inserir", onBackPressed = {
                    onBackPressed(false)
                })
            },
            bottomBar = {
                Button(
                    enabled = state.isButtonEnabled,
                    onClick = viewModel::insertPayment,
                    modifier = Modifier.fillMaxWidth()
                        .padding(12.dp)
                ) {
                    Text("Cadastrar", modifier = Modifier.padding(vertical = 8.dp))
                }
            }
        ) {
            PaymentInsertionContent(
                state = state,
                onValueChange = viewModel::updateValue,
                onNameChange = viewModel::updateName,
                onDescriptionChange = viewModel::updateDescription,
                onDateChange = viewModel::updateDate
            )
        }
    }

    LaunchedEffect(state.isDone) {
        if (state.isDone) {
            onBackPressed(true)
        }
    }
}

@Composable
private fun PaymentInsertionContent(
    state: InsertionState,
    onValueChange: (String) -> Unit = {},
    onNameChange: (String) -> Unit = {},
    onDescriptionChange: (String) -> Unit = {},
    onDateChange: (String) -> Unit = {}
) {
    Column(
        modifier = Modifier.padding(
            horizontal = 20.dp,
            vertical = 16.dp
        )
    ) {
        PaymentField(
            value = state.name,
            title = "Nome do pagamento",
            label = "Ex.: Aluguel",
            onValueChange = onNameChange,
            keyboardType = KeyboardType.Text
        )

        PaymentField(
            value = state.value,
            title = "Valor",
            label = "Ex.: R$100,00",
            onValueChange = onValueChange,
            keyboardType = KeyboardType.Number,
            visualTransformation = DecimalInputVisualTransformation(DecimalFormatter())
        )

        PaymentField(
            value = state.description,
            title = "Descrição",
            label = "Ex.: Aluguel do apartamento",
            onValueChange = onDescriptionChange,
            keyboardType = KeyboardType.Text
        )

        PaymentField(
            value = state.date,
            maskTypes = MaskTypes.DATE,
            title = "Dia de vencimento",
            label = "Ex.: 01/01/2023",
            onValueChange = onDateChange,
            keyboardType = KeyboardType.Decimal
        )

    }

    if (state.isLoading) {
        CircularProgressIndicator(
            modifier = Modifier.fillMaxSize()
        )
    }
}