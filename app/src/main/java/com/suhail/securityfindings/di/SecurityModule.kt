package com.suhail.securityfindings.di

import android.content.Context
import com.suhail.securityfindings.dataStore.DataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SecurityModule {
    @Provides
    @Singleton
    fun providesDataStore(@ApplicationContext appContext: Context) = DataStoreFile(appContext)

}