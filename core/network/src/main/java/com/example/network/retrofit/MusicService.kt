package com.example.network.retrofit

import com.example.network.model.NetworkMusicInfoEntity
import retrofit2.http.GET

interface MusicService {
    @GET("song.json")
    suspend fun getMusicInfo(): NetworkMusicInfoEntity
}