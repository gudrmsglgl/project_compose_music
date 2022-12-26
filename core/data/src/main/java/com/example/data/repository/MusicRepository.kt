package com.example.data.repository

import com.example.data.model.MusicInfoEntity
import kotlinx.coroutines.flow.Flow

interface MusicRepository {
    fun getMusicInfo(): Flow<MusicInfoEntity>
}