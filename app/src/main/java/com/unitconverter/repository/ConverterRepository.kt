package com.unitconverter.repository

import com.unitconverter.db.ConverterDAO
import com.unitconverter.db.ConversionResultEntity
import javax.inject.Inject

class ConverterRepository @Inject constructor(
    private val dao: ConverterDAO
) {
    suspend fun insertResult(loginEntity: ConversionResultEntity) = dao.insertResult(loginEntity)
    suspend fun deleteAll(loginEntity: ConversionResultEntity) = dao.deleteAll()
    suspend fun deleteResult(loginEntity: ConversionResultEntity) = dao.deleteResult(loginEntity)
    fun getResults() = dao.getResults()
}