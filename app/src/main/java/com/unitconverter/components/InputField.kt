package com.unitconverter.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(
    modifier: Modifier = Modifier,
    isLandsScape: Boolean,
    displayingText: MutableState<String>,
    onValueChange: (String) -> Unit = {},
    labelValue: String,
    enabledValue: Boolean,
    icon: ImageVector,
    onClick: () -> Unit = {},
    readOnly: Boolean,
    iconNeededOrNot: Boolean,
) {
    var textFieldSize by remember { mutableStateOf(Size.Zero) } //To assign the dropdown the same width as TextField.
    if (isLandsScape) {
        OutlinedTextField(
            modifier = modifier
                .onGloballyPositioned {
                    textFieldSize = it.size.toSize()
                }
                .padding(start = 16.dp, end = 16.dp),
            value = displayingText.value,
            onValueChange = {
                displayingText.value = it
            },
            label = {
                Text(
                    text = labelValue, style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                )
            },
            enabled = enabledValue,
            textStyle = TextStyle(
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            ),
            trailingIcon = {
                if (iconNeededOrNot) {
                    IconButton(onClick = {
                        onClick.invoke()
                    }) {
                        Icon(icon, contentDescription = "trail Icon", tint = Color.Black)
                    }
                    modifier.clickable {
                    }
                }
            },
            readOnly = readOnly,
            keyboardOptions = KeyboardOptions(
                autoCorrect = true,
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )
        )
    } else {
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .onGloballyPositioned {
                    textFieldSize = it.size.toSize()
                }
                .padding(start = 16.dp, end = 16.dp),
            value = displayingText.value,
            onValueChange = {
                displayingText.value = it
            },
            label = {
                Text(
                    text = labelValue, style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                )
            },
            enabled = enabledValue,
            textStyle = TextStyle(
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            ),
            trailingIcon = {
                if (iconNeededOrNot) {
                    IconButton(onClick = {
                        onClick.invoke()
                    }) {
                        Icon(icon, contentDescription = "trail Icon", tint = Color.Black)
                    }
                    modifier.clickable {
                    }
                }
            },
            readOnly = readOnly,
            keyboardOptions = KeyboardOptions(
                autoCorrect = true,
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )
        )
    }

}