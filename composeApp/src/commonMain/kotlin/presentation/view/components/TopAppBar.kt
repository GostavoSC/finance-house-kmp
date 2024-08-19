package presentation.view.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FinanceTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    onBackPressed: (() -> Unit)? = null
) {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = modifier
            .graphicsLayer(1.99F)
            .drawWithCache {
                val brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF0D88E1),
                        Color(0xFF06406A)
                    )
                )
                onDrawWithContent {
                    drawContent()
                    drawRect(brush, blendMode = BlendMode.SrcAtop)
                }
            }
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            onBackPressed?.let {
                IconButton(
                    onClick = onBackPressed,
                    content = {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                )
            }
            Text(
                title,
                style = MaterialTheme.typography.subtitle1.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                ),
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}

fun oscillateNumber(startNumber: Float) {

}