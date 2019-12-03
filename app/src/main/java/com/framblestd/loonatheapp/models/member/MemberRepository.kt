package com.framblestd.loonatheapp.models.member

import android.graphics.Color
import com.framblestd.loonatheapp.R

@Suppress("UNCHECKED_CAST")
object MemberRepository {
    private val names = arrayOf(
        "HeeJin",
        "HyunJin",
        "HaSeul",
        "YeoJin",
        "ViVi",
        "Kim Lip",
        "JinSoul",
        "Choerry",
        "Yves",
        "Chuu",
        "Go Won",
        "Olivia Hye"
    )

    private val realNames = arrayOf(
        "전희진 (Jeon Heejin)",
        "김현진 (Kim Hyunjin)",
        "조하슬 (Jo Haseul)",
        "임여진 (Im Yeojin)",
        "黃珈熙 (Wong Ka Hei)",
        "김정은 (Kim Jungeun)",
        "정진솔 (Jung Jinsol)",
        "최예림 (Choi Yerim)",
        "하수영 (Ha Sooyoung)",
        "김지우 (Kim Jiwoo)",
        "박채원 (Park Chaewon)",
        "손혜주 (Son Hyejoo)"
    )

    private val birthDates = arrayOf(
        "19 October 2000",
        "15 November 2000",
        "18 August 1997",
        "11 November 2002",
        "9 December 1996",
        "10 February 1999",
        "13 June 1997",
        "4 June 2001",
        "24 May 1997",
        "20 October 1999",
        "19 November 2000",
        "13 November 2001"
    )

    private val debutDates = arrayOf(
        "26 September 2016",
        "28 October 2016",
        "8 December 2016",
        "4 January 2017",
        "14 February 2017",
        "15 May 2017",
        "13 June 2017",
        "12 July 2017",
        "14 November 2017",
        "14 December 2017",
        "15 January 2018",
        "17 March 2018"
    )

    private val subUnits = arrayOf(
        "LOOΠΔ 1/3",
        "LOOΠΔ 1/3",
        "LOOΠΔ 1/3",
        "None",
        "LOOΠΔ 1/3",
        "LOOΠΔ Odd Eye Circle",
        "LOOΠΔ Odd Eye Circle",
        "LOOΠΔ Odd Eye Circle",
        "LOOΠΔ yyxy",
        "LOOΠΔ yyxy",
        "LOOΠΔ yyxy",
        "LOOΠΔ yyxy"
    )

    private val officialColors = arrayOf(
        Color.rgb(237,0,144),
        Color.rgb(253,204,3),
        Color.rgb(0,166,82),
        Color.rgb(243, 112,32),
        Color.rgb(255,164,181),
        Color.rgb(239,24,65),
        Color.rgb(23,36,167),
        Color.rgb(90,43,146),
        Color.rgb(123,1,52),
        Color.rgb(246,145,125),
        Color.rgb(57,188,157),
        Color.rgb(123,130,138)
    )

    private val animalRepresentations = arrayOf(
        "Rabbit",
        "Cat",
        "White Bird",
        "Frog",
        "Deer",
        "Owl",
        "Blue Betta",
        "Fruit Bat",
        "Swan",
        "Penguin",
        "Butterfly",
        "Wolf"
    )

    private val pictures = arrayOf(
        R.drawable.xx_heejin,
        R.drawable.xx_hyunjin,
        R.drawable.xx_haseul,
        R.drawable.xx_yeojin,
        R.drawable.xx_vivi,
        R.drawable.xx_kimlip,
        R.drawable.xx_jinsoul,
        R.drawable.xx_choerry,
        R.drawable.xx_yves,
        R.drawable.xx_chuu,
        R.drawable.xx_gowon,
        R.drawable.xx_olivia_hye
    )

    fun all(): List<Member> = names.indices.map {
        Member(
            id = it + 1,
            name = names[it],
            realName = realNames[it],
            birthDate = birthDates[it],
            debutDate = debutDates[it],
            subUnit = subUnits[it],
            animalRepresentation = animalRepresentations[it],
            officialColor = officialColors[it],
            picture = pictures[it]
        )
    }

    fun findById(id: Int): Member? {
        if (id <= 0) {
            return null
        }

        return Member(
            id = id,
            name = names[id - 1],
            realName = realNames[id - 1],
            birthDate = birthDates[id - 1],
            debutDate = debutDates[id - 1],
            subUnit = subUnits[id - 1],
            animalRepresentation = animalRepresentations[id - 1],
            officialColor = officialColors[id - 1],
            picture = pictures[id - 1]
        )
    }

    fun getSubUnit(name: String): SubUnit = SubUnit(name, when (name) {
        "LOOΠΔ 1/3" -> listOf(
            findById(1), findById(2), findById(3), findById(5)
        )
        "LOOΠΔ Odd Eye Circle" -> listOf(
            findById(6), findById(7), findById(8)
        )
        "LOOΠΔ yyxy" -> listOf(
            findById(9), findById(10), findById(11), findById(12)
        )
        else -> listOf()
    } as List<Member>)
}