import androidx.compose.ui.window.ComposeUIViewController
import di.KotlinDependencies

fun MainViewController() = ComposeUIViewController { App(KotlinDependencies.getBreedViewModel()) }