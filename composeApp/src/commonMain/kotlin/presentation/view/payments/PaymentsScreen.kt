package presentation.view.payments

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import di.getViewModel
import entity.Payments
import presentation.view.components.FinanceTopAppBar
import presentation.view.home.AppViewModel
import presentation.view.home.HomeState

@Composable
fun PaymentsScreen(
    onBackPressed: () -> Unit,
    onInsertPayment: () -> Unit,
    viewModel: AppViewModel = getViewModel()
) {
    val state = viewModel.state.collectAsState().value

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onInsertPayment
            ) {
                Icon(Icons.Default.Add, contentDescription = "")
            }
        },
        topBar = {
            FinanceTopAppBar(title = "Pagamentos", onBackPressed = {
                onBackPressed()
            })
        }
    ) {
        PaymentsScreenContent(state)
    }

    LaunchedEffect(Unit) {
        viewModel.fetchPayments()
    }
}


@Composable
private fun PaymentsScreenContent(state: HomeState) {
    LazyColumn {
        items(state.payments.size) {
            PaymentItem(state.payments[it])
        }
    }
}

@Composable
private fun PaymentItem(payment: Payments) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(
            horizontal = 22.dp,
            vertical = 12.dp
        )
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(8.dp)
            )

    ) {
        Column {
            Text("Nome do pagamento", style = MaterialTheme.typography.overline)
            Text(payment.name, style = MaterialTheme.typography.subtitle1)
        }

        Column {
            Text("Valor", style = MaterialTheme.typography.overline)
            Text(payment.value.toString(), style = MaterialTheme.typography.subtitle1)
        }
    }
}