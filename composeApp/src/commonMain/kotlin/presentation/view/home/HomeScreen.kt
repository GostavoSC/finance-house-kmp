package presentation.view.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import di.getViewModel
import entity.Payments
import presentation.view.components.BlushedFilledButton
import presentation.view.components.PieChart
import theme.BlueDark
import theme.Blue


@Composable
fun HomeScreen(
    viewModel: AppViewModel = getViewModel<AppViewModel>(),
    onNavigateToPayments: () -> Unit
) {
    val state = viewModel.state.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.fetchPayments()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 0.dp)
            .windowInsetsPadding(WindowInsets.systemBars)
            .drawWithCache {
                val brush = Brush.horizontalGradient(
                    colors = listOf(
                        Blue,
                        BlueDark
                    )
                )
                onDrawWithContent {
                    drawRect(brush, blendMode = BlendMode.SrcAtop)
                    drawContent()
                }
            }
    ) {
        Text(
            "Finance house",
            style = MaterialTheme.typography.h6,
            color = Color.White,
            modifier = Modifier.padding(20.dp)
        )
        HomeScreenContent(state)
    }

    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier.fillMaxSize()
    ) {
        BlushedFilledButton(
            title = "Ver pagamentos",
            modifier = Modifier.padding(20.dp),
            onClick = onNavigateToPayments
        )
    }
}

@Composable
private fun HomeScreenContent(state: HomeState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            )
            .padding(horizontal = 20.dp)
    ) {
        PieChart(
            radiusOuter = 44.dp,
            chartBarWidth = 14.dp,
            data = mapOf(
                "Fixas" to 50,
                "Parceladas" to 150
            ),
            totalValue = "R$ 200,00",
            modifier = Modifier.padding(
                horizontal = 8.dp,
            )
                .padding(top = 40.dp)
        )

        Text(
            "Próximos pagamentos",
            modifier = Modifier.padding(top = 48.dp, bottom = 8.dp),
            color = BlueDark,
            fontWeight = FontWeight.SemiBold
        )
        Divider()
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 6.dp)
        ) {
            Text("Nome", style = MaterialTheme.typography.caption)
            Text("Vencimento", style = MaterialTheme.typography.caption)
        }

        LazyColumn {
            items(state.payments) {
                PaymentItem(it)
            }
        }
    }
}


@Composable
private fun PaymentItem(payments: Payments) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .padding(
                vertical = 6.dp
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = if (true) BlueDark else Blue,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .size(15.dp)
            )

            Text(
                payments.name,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Text(payments.date, style = MaterialTheme.typography.h6)

    }
}