package presentation.view.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.tween
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import presentation.view.payments.PaymentsScreen

fun NavGraphBuilder.paymentsNav(navController: NavHostController) {
    composable(
        FinanceRoutes.PaymentsScreen.route,
        enterTransition = {
            when (
                initialState.destination.route
            ) {
                FinanceRoutes.HomeScreen.route -> {
                    slideIntoContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Start,
                        animationSpec = tween(durationMillis = 300)
                    )
                }

                else -> EnterTransition.None
            }


        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.End,
                animationSpec = tween(durationMillis = 300)
            )
        },
    ) {
        PaymentsScreen(
            onBackPressed = {
                navController.popBackStack()
            },
            onInsertPayment = {
                navController.navigate(FinanceRoutes.PaymentsInsertionScreen.route)
            }
        )
    }
}