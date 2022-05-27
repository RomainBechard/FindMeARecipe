package com.romainbechard.findmearecipe.di

import android.content.Context
import com.romainbechard.findmearecipe.FindMeARecipeApplication
import com.romainbechard.findmearecipe.data.source.DataSource
import com.romainbechard.findmearecipe.data.source.local.LocalDataSource
import com.romainbechard.findmearecipe.data.source.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class DataRemoteSource

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class DataLocalSource

    @Singleton
    @DataRemoteSource
    @Provides
    fun provideRemoteDataSource(): DataSource {
        return RemoteDataSource()
    }

    @Singleton
    @DataLocalSource
    @Provides
    fun provideLocalDataSource(): DataSource {
        return LocalDataSource()
    }

    @Singleton
    @Provides
    fun provideApplication(
        @ApplicationContext appContext: Context
    ): FindMeARecipeApplication {
        return appContext as FindMeARecipeApplication
    }

    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO
}