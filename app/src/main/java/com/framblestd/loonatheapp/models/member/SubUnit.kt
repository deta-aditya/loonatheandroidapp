package com.framblestd.loonatheapp.models.member

import com.framblestd.loonatheapp.models.discography.Artist

data class SubUnit(
    override val name: String,
    val members: List<Member>
) : Artist