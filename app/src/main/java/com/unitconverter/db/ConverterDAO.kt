package com.unitconverter.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.unitconverter.utils.ConverterConstants
import kotlinx.coroutines.flow.Flow

@Dao
interface ConverterDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResult(converterEntity: ConversionResultEntity)

    @Delete
    suspend fun deleteResult(converterEntity: ConversionResultEntity)

    @Query("DELETE FROM ${ConverterConstants.CONVERTER_TABLE}")
    suspend fun deleteAll()

    @Query("SELECT * FROM ${ConverterConstants.CONVERTER_TABLE}")
    fun getResults(): Flow<List<ConversionResultEntity>>

}