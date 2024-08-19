package presentation.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import presentation.view.components.visualTransformation.MaskTypes
import presentation.view.components.visualTransformation.MaskVisualTransformation


@Composable
fun PaymentField(
    value: String,
    title: String,
    label: String,
    maskTypes: MaskTypes? = null,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType,
    visualTransformation: VisualTransformation? = null
) {

    var text by remember { mutableStateOf(value) }

    Column(
        modifier = Modifier.padding(vertical = 6.dp)
    ) {
        Text(title)
        OutlinedTextField(
            value = text,
            onValueChange = { value ->
                if (maskTypes != null) {
                    if (value.length <= maskTypes.mask.count { it == '#' }) {
                        text = value.filter { it.isDigit() }
                    }
                } else {
                    text = value
                }

                onValueChange(value)
            },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            visualTransformation = if (maskTypes != null) MaskVisualTransformation(
                mask = maskTypes.mask

            ) else visualTransformation ?: VisualTransformation.None,
            placeholder = {
                Text(label)
            },
            modifier = Modifier.fillMaxWidth(),
        )
    }

}


