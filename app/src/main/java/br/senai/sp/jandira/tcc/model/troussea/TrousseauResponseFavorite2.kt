package br.senai.sp.jandira.tcc.model.troussea

data class TrousseauResponseFavorite2(
    val id: Int,
    val item: String,
    val gestante: String,
    val quantidade: Int,
    val categoria: String
)
