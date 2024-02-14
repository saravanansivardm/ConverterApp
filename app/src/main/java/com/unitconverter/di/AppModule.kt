package com.unitconverter.di

import android.content.Context
import androidx.room.Room
import com.unitconverter.db.ConverterDatabase
import com.unitconverter.db.ConversionResultEntity
import com.unitconverter.utils.ConverterConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, ConverterDatabase::class.java, ConverterConstants.CONVERTER_DATABASE
    ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideDao(db: ConverterDatabase) = db.converterDao()

    @Provides
    @Singleton
    fun provideEntity() = ConversionResultEntity()
}