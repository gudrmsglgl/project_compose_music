package com.example.network

import com.example.network.model.NetworkMusicInfoEntity

interface MusicNetworkDataSource {
    suspend fun getMusicInfo(): NetworkMusicInfoEntity
}