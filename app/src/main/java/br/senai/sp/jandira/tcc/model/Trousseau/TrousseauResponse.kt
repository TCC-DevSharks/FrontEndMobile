package br.senai.sp.jandira.tcc.model.Trousseau

data class TrousseauResponse(

    val id: Int,
    val item: String,
    val checkbox: Int,
    val quantidade: Int,
    val categoria: String
)
