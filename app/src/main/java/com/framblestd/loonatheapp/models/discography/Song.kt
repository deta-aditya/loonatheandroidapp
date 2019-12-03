package com.framblestd.loonatheapp.models.discography

data class Song(
    val id: Int = 0,
    val title: String = "",
    val artists: List<Artist>,
    val album: String = "",
    val lyricists: String = "",
    val composers: String = "",
    val arrangers: String = "",
    val genres: String = "",
    val lengthInSeconds: Int = 0,
    val coverArt: Int = 0,
    val musicLink: String = "",
    val musicVideoLink: String? = null,
    val description: String = ""
)