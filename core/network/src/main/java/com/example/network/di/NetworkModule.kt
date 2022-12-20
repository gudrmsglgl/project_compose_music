package com.example.network.di

import com.example.network.MusicNetworkDataSource
import com.example.network.MusicNetworkDataSourceImpl
import com.example.network.retrofit.MusicService
import com.example.network.retrofit.MusicServiceFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {


    companion object {
        @Provides
        @Singleton
        fun providesNetworkJson(): Json = Json {
            ignoreUnknownKeys = true
        }

        @Provides
        @Singleton
        fun provideMusicService(json: Json): MusicService {
            return MusicServiceFactory.makeApiService(json)
        }
    }

    @Binds
    abstract fun bindDataSource(sourceImpl: MusicNetworkDataSourceImpl) : MusicNetworkDataSource

}