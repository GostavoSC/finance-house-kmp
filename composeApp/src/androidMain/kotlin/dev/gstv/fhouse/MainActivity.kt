package dev.gstv.fhouse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import presentation.theme.FinanceHouseTheme
import presentation.view.navigation.FinanceNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FinanceHouseTheme {
                FinanceNavigation()
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    FinanceNavigation()
}