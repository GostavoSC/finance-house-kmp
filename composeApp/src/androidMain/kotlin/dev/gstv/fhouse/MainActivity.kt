package dev.gstv.fhouse

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.koin.android.ext.android.inject
import presentation.view.AppViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: AppViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App(viewModel = viewModel)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
//    App()
}