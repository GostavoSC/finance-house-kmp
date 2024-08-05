package presentation.view.payments

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PaymentsScreen(
    onBackPressed: () -> Unit,
    onInsertPayment: () -> Unit
) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onInsertPayment
            ) {
                Icon(Icons.Default.Add, contentDescription = "")
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text("Pagamentos")
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackPressed
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "")
                    }
                }
            )
        }
    ) {
        PaymentsScreenContent()
    }
}

@Composable
private fun PaymentsScreenContent(modifier: Modifier = Modifier) {

}

