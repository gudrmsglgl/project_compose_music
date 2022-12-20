package com.example.network

import com.example.network.model.MusicInfoEntity

interface MusicNetworkDataSource {
    suspend fun getMusicInfo(): MusicInfoEntity
}