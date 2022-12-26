package com.example.data.model

import com.example.network.model.NetworkMusicInfoEntity

data class MusicInfoEntity(
    val singer: String,
    val album: String,
    val title: String,
    val duration: Int,
    val image: String,
    val file: String,
    val lyrics: String
)

fun NetworkMusicInfoEntity.asEntity() = MusicInfoEntity(
    singer = this.singer,
    album = this.album,
    title = this.title,
    duration =  this.duration,
    image =  this.image,
    file =  this.file,
    lyrics = this.lyrics
)