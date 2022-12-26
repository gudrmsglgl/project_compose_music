package com.example.data.di

import com.example.data.repository.MusicRemoteRepository
import com.example.data.repository.MusicRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindMusicRepository(musicRemoteRepository: MusicRemoteRepository) : MusicRepository

}