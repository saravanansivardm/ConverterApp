package com.unitconverter.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.unitconverter.data.Conversion
import com.unitconverter.viewmodel.ConvertorViewModel

@Composable
fun TopScreen(
    conversionList: List<Conversion>,
    viewModel: ConvertorViewModel = hiltViewModel(),
    isLandsScape: Boolean,
) {
    ConversionMenu(
        conversionList = conversionList,
        viewModel = viewModel,
        isLandsScape = isLandsScape
    )
}