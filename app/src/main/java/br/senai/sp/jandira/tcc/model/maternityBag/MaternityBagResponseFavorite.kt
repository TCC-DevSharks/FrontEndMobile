package br.senai.sp.jandira.tcc.model.maternityBag

data class MaternityBagResponseFavorite(

    var id: Int,
    val item: String,
    val gestante: String,
    val descricao: String
)