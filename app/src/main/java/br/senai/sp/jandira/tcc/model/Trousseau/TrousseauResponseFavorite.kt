package br.senai.sp.jandira.tcc.model.Trousseau

data class TrousseauResponseFavorite(
    val id: Int,
    val item: String,
    val gestante: String,
    val quantidade: Int,
    val categoria: String
)
