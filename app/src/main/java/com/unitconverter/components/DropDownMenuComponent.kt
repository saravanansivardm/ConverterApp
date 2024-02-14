package com.unitconverter.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unitconverter.data.Conversion

@Composable
fun DropDownMenuComponent(
    modifier: Modifier = Modifier,
    expanded: MutableState<Boolean>,
    conversionList: List<Conversion>,
    displayingText: MutableState<String>,
    convert: (Conversion) -> Unit
) {
    val textFieldSize by remember { mutableStateOf(Size.Zero) } //To assign the dropdown the same width as TextField.

    DropdownMenu(
        expanded = expanded.value,
        onDismissRequest = { expanded.value = false },
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
    ) {
        conversionList.forEach { conversion ->
            DropdownMenuItem(onClick = {
                displayingText.value = conversion.description
                expanded.value = false
                convert(conversion)
            }, text = {
                Text(
                    text = conversion.description,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            })
        }
    }
}