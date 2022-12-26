package com.example.data.repository

import com.example.data.model.MusicInfoEntity
import com.example.data.model.asEntity
import com.example.network.MusicNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MusicRemoteRepository
@Inject constructor(private val networkDataSource: MusicNetworkDataSource) : MusicRepository {

    override fun getMusicInfo(): Flow<MusicInfoEntity> = flow {
        emit(networkDataSource.getMusicInfo().asEntity())
    }

}