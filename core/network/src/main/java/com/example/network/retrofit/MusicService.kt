package com.example.network.retrofit

import com.example.network.model.MusicInfoEntity
import retrofit2.http.GET

interface MusicService {
    @GET("song.json")
    suspend fun getMusicInfo(): MusicInfoEntity
}