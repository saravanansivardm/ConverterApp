package com.unitconverter.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.unitconverter.utils.ConverterConstants

@Entity(tableName = ConverterConstants.CONVERTER_TABLE)
data class ConversionResultEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "convertFrom")
    val convertFrom: String = "",
    @ColumnInfo(name = "convertTo")
    val convertTo: String = "",
    @ColumnInfo(name = "roundedResult")
    val roundedResult: String = "",
    @ColumnInfo(name = "inputText")
    val inputText: String = "",
)
