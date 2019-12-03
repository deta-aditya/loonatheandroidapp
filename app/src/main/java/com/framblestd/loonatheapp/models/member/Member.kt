package com.framblestd.loonatheapp.models.member

import android.graphics.Color
import com.framblestd.loonatheapp.models.discography.Artist

data class Member(
    override val name: String = "",
    val id: Int = 0,
    val realName: String = "",
    val birthDate: String = "",
    val debutDate: String = "",
    val subUnit: String = "",
    val officialColor: Int = Color.WHITE,
    val animalRepresentation: String = "",
    val picture: Int = 0
) : Artist