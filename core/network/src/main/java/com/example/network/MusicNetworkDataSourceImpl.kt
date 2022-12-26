package com.example.network

import com.example.network.model.NetworkMusicInfoEntity
import com.example.network.retrofit.MusicService
import javax.inject.Inject

class MusicNetworkDataSourceImpl @Inject constructor(private val service: MusicService) : MusicNetworkDataSource {
    override suspend fun getMusicInfo(): NetworkMusicInfoEntity {
        return service.getMusicInfo()
    }
}