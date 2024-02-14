package com.unitconverter.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unitconverter.data.Conversion
import com.unitconverter.db.ConversionResultEntity
import com.unitconverter.repository.ConverterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConvertorViewModel @Inject constructor(
    private val converterRepository: ConverterRepository
) : ViewModel() {
    val selectedConversion: MutableState<Conversion?> = mutableStateOf(null)

    val convertFromInputBlock = mutableStateOf("")
    val inputTextInputBlock = mutableStateOf("")
    val convertToInputBlock = mutableStateOf("")
    val roundedResultInputBlock = mutableStateOf("")

    val displayingText = mutableStateOf("Select Conversion Type")
    val expanded = mutableStateOf(false)
    val emptyText = mutableStateOf("")
    private val _converterEntity = ConversionResultEntity()
    var converterEntity: ConversionResultEntity = _converterEntity

    fun getConversionList() = listOf(
        Conversion(1, "Pounds to Kilograms", "lbs", "kg", 0.453592),
        Conversion(2, "Kilograms to Pounds", "kg", "lbs", 2.20462),
        Conversion(3, "Yards to Meters", "yd", "m", 0.9144),
        Conversion(4, "Meters to Yards", "m", "yd", 1.09361),
        Conversion(5, "Miles to Kilometers", "mi", "km", 1.60934),
        Conversion(6, "Kilometers to Miles", "km", "mi", 0.621371),
    )

    suspend fun saveConverterValue(converterEntity: ConversionResultEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            converterRepository.insertResult(converterEntity)
        }
    }

    suspend fun deleteResult(converterEntity: ConversionResultEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            converterRepository.deleteResult(converterEntity)
        }
    }

    suspend fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            converterRepository.deleteAll(converterEntity)
        }
    }

    val resultList = converterRepository.getResults()
}
