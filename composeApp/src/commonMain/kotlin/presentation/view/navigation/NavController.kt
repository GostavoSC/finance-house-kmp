package presentation.view.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import presentation.theme.FinanceHouseTheme
import presentation.view.home.HomeScreen
import presentation.view.payments.insertion.PaymentsInsertionScreen
import presentation.view.payments.PaymentsScreen

@Composable
fun FinanceNavigation(
    navController: NavHostController = rememberNavController(),
) {

    FinanceHouseTheme {

        NavHost(
            navController = navController,
            startDestination = FinanceRoutes.HomeScreen.route,
        ) {
            composable(
                FinanceRoutes.HomeScreen.route,
                enterTransition = { EnterTransition.None }
            ) {
                HomeScreen {
                    navController.navigate(FinanceRoutes.PaymentsScreen.route)
                }
            }

            paymentsNav(navController)

            composable(
                FinanceRoutes.PaymentsInsertionScreen.route,
                enterTransition = {
                    slideIntoContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Start,
                        animationSpec = tween(durationMillis = 300)
                    )
                },
                popExitTransition = {
                    slideOutOfContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.End,
                        animationSpec = tween(durationMillis = 300)
                    )
                },
            ) {
                PaymentsInsertionScreen(
                    onBackPressed = { isDone ->
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
    data object PaymentsInsertionScreen : FinanceRoutes("payment-insertion-screen")
}