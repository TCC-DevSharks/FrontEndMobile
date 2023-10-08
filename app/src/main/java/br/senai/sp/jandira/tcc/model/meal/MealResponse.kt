package br.senai.sp.jandira.tcc.model.meal

data class MealResponse(
    var nome: String,
    var idAlimento: Int,
    var imagem: String,
    var peso: String,
    var categoria: String,
    var refeicao: String,
    var id: Int,
)
