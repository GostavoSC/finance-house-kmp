package dev.gstv.fhouse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import presentation.theme.FinanceHouseTheme
import presentation.view.navigation.FinanceNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinanceHouseTheme {
                SetStatusBarColor(Color(0xFF06406A))
                FinanceNavigation()
            }
        }
    }
}

@Composable
fun SetStatusBarColor(color: Color) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(color)
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    FinanceNavigation()
}
