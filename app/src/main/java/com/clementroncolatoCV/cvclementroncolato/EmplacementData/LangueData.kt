package com.clementroncolatoCV.cvclementroncolato.EmplacementData

data class LangueParle(
    val title : String,
    val description : String,
    val maitrise : Float
)

val LangueList = listOf(
    LangueParle (
        "Français",
        "Langue maternelle",
        5f
    ),
    LangueParle (
        "Anglais",
        "Compétent",
        4f
    ),
    LangueParle(
        "Espagnol",
        "Intermédiaire",
        2f
    )
)