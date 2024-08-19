package presentation.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import theme.Blue
import theme.BlueDark

@Composable
fun BlushedFilledButton(title: String, onClick: () -> Unit = {}, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxWidth()
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(20))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Blue,
                        BlueDark,
                    )
                ),
                shape = RoundedCornerShape(20)
            )
            .clickable {
                onClick()
            }
    ) {
        Text(
            title,
            modifier = Modifier.padding(vertical = 18.dp),
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.button
        )
    }
}