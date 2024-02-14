package com.unitconverter.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.unitconverter.R
import com.unitconverter.components.DropDownMenuComponent
import com.unitconverter.components.InputField
import com.unitconverter.data.Conversion
import com.unitconverter.viewmodel.ConvertorViewModel

@Composable
fun ConversionMenu(
    modifier: Modifier = Modifier,
    viewModel: ConvertorViewModel = hiltViewModel(),
    conversionList: List<Conversion>,
    isLandsScape: Boolean
) {
    /*val selectedConversion: MutableState<Conversion?> = remember {
        mutableStateOf(null)
    }
    val convertFromInputBlock = remember {
        mutableStateOf("")
    }
    val inputTextInputBlock = remember {
        mutableStateOf("")
    }
    val convertToInputBlock = remember {
        mutableStateOf("")
    }
    val roundedResultInputBlock = remember {
        mutableStateOf("")
    }

    val displayingText = remember {
        mutableStateOf("Select Conversion Type")
    }
    val expanded = remember {
        mutableStateOf(false)
    }
    val emptyText = remember {
        mutableStateOf("")
    }*/
    val context = LocalContext.current
    if (isLandsScape){
        Column(modifier=modifier.verticalScroll(rememberScrollState())) {
            InputField(
                displayingText = viewModel.displayingText,
                isLandsScape = isLandsScape,
                labelValue = stringResource(
                    id = R.string.conversion_type
                ), enabledValue = true, onClick = {
                    viewModel.expanded.value = !viewModel.expanded.value
                }, icon = if (viewModel.expanded.value) Icons.Filled.KeyboardArrowUp
                else Icons.Filled.KeyboardArrowDown, readOnly = true, iconNeededOrNot = true
            )

            DropDownMenuComponent(
                modifier = modifier,
                expanded = viewModel.expanded,
                conversionList = conversionList,
                displayingText = viewModel.displayingText
            ) {
                viewModel.selectedConversion.value = it
            }

            viewModel.selectedConversion.value?.let {
                InputBlock(
                    modifier = modifier,
                    isLandsScape = isLandsScape,
                    viewModel = viewModel,
                    viewModel.emptyText,
                    viewModel.selectedConversion.value!!,
                ) { inputText, convertFrom, roundResult, convertTo ->
                    viewModel.convertFromInputBlock.value = convertFrom
                    viewModel.convertToInputBlock.value = convertTo
                    viewModel.roundedResultInputBlock.value = roundResult
                    viewModel.inputTextInputBlock.value = inputText
                }
            }
            if (viewModel.inputTextInputBlock.value.isNotEmpty()) {
                ResultBlock(
                    modifier = Modifier,
                    isLandsScape=isLandsScape,
                    viewModel.inputTextInputBlock.value,
                    viewModel.convertFromInputBlock.value,
                    viewModel.roundedResultInputBlock.value,
                    viewModel.convertToInputBlock.value,
                )
            }
        }
    }else{
        Column(modifier=modifier.verticalScroll(rememberScrollState())) {
            InputField(
                displayingText = viewModel.displayingText,
                isLandsScape = isLandsScape,
                labelValue = stringResource(
                    id = R.string.conversion_type
                ), enabledValue = true, onClick = {
                    viewModel.expanded.value = !viewModel.expanded.value
                }, icon = if (viewModel.expanded.value) Icons.Filled.KeyboardArrowUp
                else Icons.Filled.KeyboardArrowDown, readOnly = true, iconNeededOrNot = true
            )

            DropDownMenuComponent(
                modifier = modifier,
                expanded = viewModel.expanded,
                conversionList = conversionList,
                displayingText = viewModel.displayingText
            ) {
                viewModel.selectedConversion.value = it
            }

            viewModel.selectedConversion.value?.let {
                InputBlock(
                    modifier = modifier,
                    isLandsScape = isLandsScape,
                    viewModel = viewModel,
                    viewModel.emptyText,
                    viewModel.selectedConversion.value!!,
                ) { inputText, convertFrom, roundResult, convertTo ->
                    viewModel.convertFromInputBlock.value = convertFrom
                    viewModel.convertToInputBlock.value = convertTo
                    viewModel.roundedResultInputBlock.value = roundResult
                    viewModel.inputTextInputBlock.value = inputText
                }
            }
            if (viewModel.inputTextInputBlock.value.isNotEmpty()) {
                ResultBlock(
                    modifier = Modifier,
                    isLandsScape=isLandsScape,
                    viewModel.inputTextInputBlock.value,
                    viewModel.convertFromInputBlock.value,
                    viewModel.roundedResultInputBlock.value,
                    viewModel.convertToInputBlock.value,
                )
            }
        }
    }
}