package presentation.view.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import presentation.theme.FinanceHouseTheme
import presentation.view.home.HomeScreen
import presentation.view.payments.PaymentsScreen

@Composable
fun FinanceNavigation(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    FinanceHouseTheme {
        NavHost(
            navController = navController,
            startDestination = FinanceRoutes.HomeScreen.route,
        ) {
            composable(
                FinanceRoutes.HomeScreen.route,
                enterTransition = null
            ) {
                HomeScreen {
                    navController.navigate(FinanceRoutes.PaymentsScreen.route)
                }
            }
            composable(
                FinanceRoutes.PaymentsScreen.route,
                enterTransition = {
                    slideInHorizontally(
                        initialOffsetX = { 1000 },
                        animationSpec = tween(durationMillis = 300)
                    )
                },
                exitTransition = {
                    slideOutHorizontally(
                        targetOffsetX = { 1000 },
                        animationSpec = tween(durationMillis = 300)
                    )
                },
            ) {
                PaymentsScreen(
                    onBackPressed = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}

sealed class FinanceRoutes(val route: String) {
    data object HomeScreen : FinanceRoutes("home-screen")
    data object PaymentsScreen : FinanceRoutes("payments-screen")
}