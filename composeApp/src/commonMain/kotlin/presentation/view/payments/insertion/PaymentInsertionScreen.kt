package presentation.view.payments.insertion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import di.getViewModel

@Composable
fun PaymentsInsertionScreen(
    onBackPressed: () -> Unit,
    viewModel: PaymentInsertionViewModel = getViewModel<PaymentInsertionViewModel>(),
) {
    val state = viewModel.state.collectAsState().value

    Scaffold {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Inserir")
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = onBackPressed
                        ) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "")
                        }
                    }
                )
            },
            bottomBar = {
                Button(
                    onClick = {},
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
            keyboardType = KeyboardType.Number
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
            title = "Data",
            label = "Ex.: 01/01/2023",
            onValueChange = onDateChange,
            keyboardType = KeyboardType.Number
        )

    }
}

@Composable
private fun PaymentField(
    value: String,
    title: String,
    label: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType
) {
    Column(
        modifier = Modifier.padding(vertical = 6.dp)
    ) {
        Text(title)
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            placeholder = {
                Text(label)
            },
            modifier = Modifier.fillMaxWidth(),
        )
    }

}