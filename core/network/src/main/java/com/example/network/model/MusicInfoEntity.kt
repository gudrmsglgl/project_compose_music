package com.example.network.model

import kotlinx.serialization.Serializable

@Serializable
data class MusicInfoEntity(
    val singer: String,
    val album: String,
    val title: String,
    val duration: Int,
    val image: String,
    val file: String,
    val lyrics: String
)