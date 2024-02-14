package com.unitconverter.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.unitconverter.components.InputField
import com.unitconverter.components.RoundedButtons
import com.unitconverter.data.Conversion
import com.unitconverter.db.ConversionResultEntity
import com.unitconverter.utils.toastMessage
import com.unitconverter.viewmodel.ConvertorViewModel
import kotlinx.coroutines.launch
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun InputBlock(
    modifier: Modifier = Modifier,
    isLandsScape: Boolean,
    viewModel: ConvertorViewModel = hiltViewModel(),
    emptyText: MutableState<String>,
    conversion: Conversion,
    convertFromRoundResult: (String, String, String, String) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val inputValue = remember {
        mutableStateOf("")
    }
    if (isLandsScape) {
        Column(
            modifier = modifier.padding(0.dp, 12.dp, 0.dp, 0.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row {
                InputField(
                    isLandsScape = isLandsScape,
                    displayingText = emptyText,
                    labelValue = "",
                    icon = Icons.Rounded.Add,
                    enabledValue = true,
                    readOnly = false,
                    iconNeededOrNot = false,
                    onValueChange = {
                        inputValue.value = it
                    }
                )
                Spacer(modifier = modifier.width(16.dp))
                Text(
                    modifier = modifier
                        .padding(10.dp, 30.dp, 0.dp, 0.dp),
                    text = conversion.convertFrom,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
            }

            RoundedButtons(
                modifier = modifier.height(60.dp),
                isLandsScape = isLandsScape,
                buttonText = "Convert",
                onClick = {
                    if (emptyText.value.isNotEmpty()) {
                        val s2 = emptyText.value.toInt() * conversion.multiplyBy
                        val df = DecimalFormat("#.####")
                        df.roundingMode = RoundingMode.DOWN
                        val roundedResult = df.format(s2)
                        convertFromRoundResult(
                            emptyText.value,
                            conversion.convertFrom,
                            roundedResult,
                            conversion.convertTo,
                        ).toString()
                        viewModel.converterEntity = ConversionResultEntity(
                            0,
                            conversion.convertFrom,
                            conversion.convertTo,
                            roundedResult,
                            emptyText.value
                        )
                        coroutineScope.launch {
                            viewModel.saveConverterValue(viewModel.converterEntity)
                        }
                    } else {
                        toastMessage("Please Enter Input Value", context = context)
                    }
                }
            )
        }
    } else {
        Column(
            modifier = modifier.padding(0.dp, 12.dp, 0.dp, 0.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row {
                InputField(
                    modifier = modifier.fillMaxWidth(0.65f),
                    isLandsScape = isLandsScape,
                    displayingText = emptyText,
                    labelValue = "",
                    icon = Icons.Rounded.Add,
                    enabledValue = true,
                    readOnly = false,
                    iconNeededOrNot = false,
                    onValueChange = {
                        inputValue.value = it
                    }
                )
                Spacer(modifier = modifier.width(16.dp))
                Text(
                    modifier = modifier
                        .fillMaxWidth(0.35f)
                        .padding(10.dp, 30.dp, 0.dp, 0.dp),
                    text = conversion.convertFrom,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
            }

            RoundedButtons(
                modifier = modifier.height(60.dp),
                isLandsScape = isLandsScape,
                buttonText = "Convert",
                onClick = {
                    if (emptyText.value.isNotEmpty()) {
                        val s2 = emptyText.value.toInt() * conversion.multiplyBy
                        val df = DecimalFormat("#.####")
                        df.roundingMode = RoundingMode.DOWN
                        val roundedResult = df.format(s2)
                        convertFromRoundResult(
                            emptyText.value,
                            conversion.convertFrom,
                            roundedResult,
                            conversion.convertTo,
                        ).toString()
                        viewModel.converterEntity = ConversionResultEntity(
                            0,
                            conversion.convertFrom,
                            conversion.convertTo,
                            roundedResult,
                            emptyText.value
                        )
                        coroutineScope.launch {
                            viewModel.saveConverterValue(viewModel.converterEntity)
                        }
                    } else {
                        toastMessage("Please Enter Input Value", context = context)
                    }
                }
            )
        }
    }

}