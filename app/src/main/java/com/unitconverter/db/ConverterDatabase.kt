package com.unitconverter.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ConversionResultEntity::class], version = 1)
abstract class ConverterDatabase : RoomDatabase() {
    abstract fun converterDao(): ConverterDAO
}