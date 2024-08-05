package presentation.view.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import di.getViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    viewModel: AppViewModel = getViewModel<AppViewModel>(),
    onNavigateToPayments: () -> Unit
) {
    val state = viewModel.state.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Finance house")
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(
                horizontal = 20.dp,
                vertical = 18.dp
            )
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Card(
                    border = BorderStroke(color = MaterialTheme.colors.primary, width = 1.dp),
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onNavigateToPayments
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(
                            horizontal = 22.dp,
                            vertical = 12.dp
                        )
                    ) {
                        Column {
                            Text("Current month", style = MaterialTheme.typography.body2)
                            Text("R$200,00", style = MaterialTheme.typography.subtitle2)
                        }
                        Icon(
                            imageVector = Icons.Filled.ArrowForward,
                            tint = MaterialTheme.colors.primary,
                            contentDescription = ""
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview(modifier: Modifier = Modifier) {

}